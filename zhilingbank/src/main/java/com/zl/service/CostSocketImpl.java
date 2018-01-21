package com.zl.service;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zl.beans.CardCost;
import com.zl.dao.CardManagerDao;
import com.zl.dao.UserDao;
import com.zl.pojo.MessageInfo;
import com.zl.pojo.User;
import com.zl.service.inter.CostSocket;
import com.zl.service.inter.IUserService;
import com.zl.util.MD5Util;

@Transactional
@Service
public class CostSocketImpl{
	@Autowired
	private UserDao ud;
	@Autowired
	private IUserService ius;
	@Autowired
	private CardManagerDao cmd;

	public Map<String, Object> trade(CardCost cc, double price) {
		Map<String,Object> json=new HashMap<String, Object>();
		String pwd = cc.getPassWord();
		String dbsalt = ud.querySaltByCardNum(cc.getCardNum());                                 
		cc.setPassWord(MD5Util.inputToDataBases(pwd, dbsalt));
		User costUser =  ud.tradeByCardCost(cc);
		cc.setIdcard(costUser.getIdCard());
		cc.setPrice(price);
		if(costUser != null){
			System.out.println("查询到user");
			if(costUser.getOverline()==0.0 || "".equals(costUser.getOverline())){//溢出金=0
				System.out.println("溢出金=0");
				if(costUser.getAvabalance()>price){
					System.out.println("可用额度足够支付");
					boolean flag = ius.cost(cc);
					if(flag){
						System.out.println("支付成功");
						json.put("mes", 100);
					}
				}else{
					System.out.println("余额不足");
					json.put("mes", 101);
					return json;
				}
			}else if(costUser.getOverline()>=price){//溢出金>=消费金额
				System.out.println("溢出金>=消费金额");
				boolean flag = ius.costOverline(cc);
				if(flag){
					System.out.println("溢出金支付成功");
					json.put("mes", 100);
				}
			}else {//溢出金<消费金额
				if(costUser.getAvabalance()>(price-costUser.getOverline())){//如果额度够消费
					System.out.println("溢出金不够消费金额，但是可用额度足够支付减去溢出金的消费金额");
					boolean flag = ius.costOffOverline(cc);
					if(flag){
						System.out.println("支付成功");
						json.put("mes", 100);
					}
				}else{
					System.out.println("溢出金，可用额度均不足支付");
					json.put("mes", 101);
				}
			}
		}else{
			System.out.println("账户信息有误");
			json.put("mes", 102);
		}
		return json;
	}
	
	public int insertTlog(MessageInfo mi) {
		// TODO Auto-generated method stub
		return cmd.insertTlog(mi);
	}
	
	/**
	 * @title:tradeAndTlog
	 * @author:黄超
	 * @Description:处理交易和插入交易记录	
	 */
	public int tradeAndTlog(CardCost cc, double price,MessageInfo mi){
		
		Map<String,Object> json = trade(cc, price);		//处理交易 
		
		int bool=(int) json.get("mes");
		if(bool==100){				//如果交易成功，插入交易记录
			int flag=insertTlog(mi);
			if(flag>0){				//如果数据插入成功，返回true;
				System.out.println("数据插入成功");
				return 100;
			}else{
				System.out.println("数据插入失败");
				return 103;		//如果数据插入失败，返回false;
			}
		}else if(bool==101){
			System.out.println("余额不足");
			return 101;			//如果交易不成功，返回false;
		}else if(bool==102){
			System.out.println("账户信息有误");
			return 102;
		}else{
			System.out.println("系统异常");
			return 103;
		}
		

	} 	

	
}
