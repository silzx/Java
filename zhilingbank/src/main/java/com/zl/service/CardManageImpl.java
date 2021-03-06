package com.zl.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.beans.BillsAndLine;
import com.zl.beans.CardCost;
import com.zl.beans.QueryInfo;
import com.zl.beans.RedisNeed;
import com.zl.beans.RefundMoney;
import com.zl.beans.UnFreeze;
import com.zl.beans.UpdateUserInfo;
import com.zl.dao.CardManagerDao;
import com.zl.pojo.Bills;
import com.zl.pojo.CardMessage;
import com.zl.pojo.CustomerInfo;
import com.zl.pojo.MessageInfo;
import com.zl.pojo.Referee;
import com.zl.pojo.TradeRecord;
import com.zl.pojo.User;
import com.zl.service.inter.CardManageInter;
import com.zl.service.inter.IUserService;

@Service
public class CardManageImpl implements CardManageInter{
	@Autowired
	private CardManagerDao cmd;
	@Autowired
	private IUserService ius;

	/**     
	 * @author：汪泽轩
	 * @Description: 根据卡号，支付密码登录               
	 */
	@Override
	public CardMessage cardUserLogin(CardMessage cm) {
		CardMessage card = cmd.cardUserLogin(cm);
		return card;
	}



	/**     
	 * @author：汪泽轩
	 * @Description: 用户通过网站手动申请信用卡               
	 */
	@Override
	public boolean cardApplication(CustomerInfo ci) {
		int flag = cmd.cardApplication(ci);
		return flag>0?true:false;
	}

	/**     
	 * @author：汪泽轩
	 * @Description: 消费功能;
	 * 先根据输入的卡号，支付密码，CCV2码查找cardMessage
	 * 再根据cardMessage中的身份证查询cardUser
	 * 消费采用密码加密传输，账号密码核对无误，额度足够， 卡状态正常 卡信息校验正确  
	 * 有效期正确  背面三位数正确 短信校验正确情况下能正常消费，消费后额度正常减少。
	 * 额度不足情况下提示“余额不足”。消费成功，记录下消费详情。       
	 */
	@Override
	public String cardCost(CardCost cc) {
		User u = cmd.queryCardUserByCardNum(cc);
		return null;
	}

	@Override
	public void cardBill() {
		// TODO Auto-generated constructor stub
		
		
	}

	/**
	 * @title:cardRefund
	 * @author:黄超
	 * @Description:还款功能  卡号无误且已出账单，客户可以还款，还款分为全额，不足额，最低
	 * 还款额多种情况	
	 */
	@Autowired
	private RefundMoney fm; //自动注入还款金额
	
	@Override
	public int cardRefund(String cardNum,Double refundMoney){
		//信用卡还款，还款之前先查询账单  调用查询账单方法
		Double notRefundNow=queryAlreadyBill(cardNum);
		fm.setCardNum(cardNum);
		System.out.println("当前欠款额："+notRefundNow);
		System.out.println("还款金额:"+refundMoney);
		if(notRefundNow>0){
			if(notRefundNow>refundMoney){
				//如果未还部分大于还款金额
				fm.setAvabalance(refundMoney);
				fm.setNotRefundNow(refundMoney);	  //未还部分
			}else{
				//如果未还部分小于还款金额
				fm.setAvabalance(refundMoney);
				fm.setNotRefundNow(notRefundNow);	//未还部分
				fm.setOverline(refundMoney-notRefundNow);	//溢出部分
			}
		}else{			//如果账单为0，则只变更溢出额度
			fm.setOverline(refundMoney);
		}
		return cmd.cardRefund(fm);
	}
	

	@Override
	public void cardRecord() {
		// TODO Auto-generated constructor stub
		
		
	}

	@Override
	public int updateBillByStages(Bills bills) {
		return cmd.updateBillByStages(bills);	//分期方法  黄超
	}

	@Override
	public void cardBillHistory() {
		// TODO Auto-generated constructor stub
		
		
	}

	@Override
	public void cardBillOverdue() {
		// TODO Auto-generated constructor stub
		
		
	}

	@Override
	public void cardCash() {
		// TODO Auto-generated constructor stub
		
		
	}

	@Override
	/**
	 * @author 谢文奇
	 * @Description 信用卡激活
	 */
	public void cardActivation() {
		
		
	}

	@Override
	public void cardLoss() {
		// TODO Auto-generated constructor stub
		
		
	}

	@Override
	public boolean cardLoginout(String cardNum) {
		return false;
		// TODO Auto-generated constructor stub
		
		
	}

	@Override
	public boolean cardFreeze(String cardNum) {
		return false;
		// TODO Auto-generated constructor stub
		
		
	}

	@Override
	public boolean cardUnfreeze(UnFreeze uf) {
		return false;
		// TODO Auto-generated constructor stub
		
		
	}

	@Override
	public Double queryAlreadyBill(String cardNum) {
		// 还款方法调用，查询账单金额    黄超
		return cmd.queryAlreadyBill(cardNum);
	}


	/**
	 * 根据信用卡号查询手机号
	 */
	public String getPhoneNum(CardMessage cm) {
		return cmd.getPhoneNum(cm);
	}

	@Override
	public String getOpenPhoneNum(CardMessage cm) {
		// TODO Auto-generated method stub
		return cmd.getOpenPhoneNum(cm);
	}
	
	@Override
	public int regUserByIdcard(String idcard) {
	
		return cmd.regUserByIdcard(idcard);
	}

	@Override
	public int addRefereeInfo(Referee rf) {
		
		return cmd.addRefereeInfo(rf);
	}


	/**
	 * 激活信用卡
	 */
	public int activationCard(CardMessage cm) {
		return cmd.activationCard(cm);
	}

	@Override
	public int queryCardNumIsExist(QueryInfo qi) {
		// TODO Auto-generated method stub
		return cmd.queryCardNumIsExist(qi);
	}

	/**
	 * 黄超   查询用户user资料，用于存入session
	 */
	@Override
	public User queryUserInfo(String idcard) {
		// TODO Auto-generated method stub
		return cmd.queryUserInfo(idcard);
	}


	/**
	 * 根据身份证号查询手机号
	 */
	public CustomerInfo getPhoneNumByIdCard(CustomerInfo ci) {
		return cmd.getPhoneNumByIdCard(ci);
	}

	
	/**
	 * 黄超   查询用户bills账单资料，用于存入session
	 */
	@Override
	public Bills queryBillsInfo(String idcard) {
		// TODO Auto-generated method stub
		return cmd.queryBillsInfo(idcard);
	}


	/**
	 * 根据卡号查身份证号
	 */
	public String getIdCardcardNum(CardMessage cm) {
		return cmd.getIdCardBycardNum(cm);
	}

	/**
	 * 挂失信用卡
	 */
	public int cardLoss(CardMessage cm, String cardstatus) {
		return cmd.cardLoss(cm, cardstatus);
	}

	/**
	 * @author 吕攀
	 * @Time 下午5:35:232018年1月10日
	 
	 */
	@Override
	public int updateUserInfo(User ui) {
		
		return cmd.updateUserInfo(ui);
	}

	@Override		//更新信用卡用户基本信息方法  黄超
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return cmd.updateUser(user);
	}



	@Override		
	public List<Bills> queryIdCardForAlready() {
		// TODO Auto-generated method stub
		return cmd.queryIdCardForAlready();		//查询所有到账单日的账单
	}



	/**
	 * 定时出账单功能，编写中... 黄超
	 */
	@Override
	public int updateBillsByAlready(BillsAndLine bal) {
		List<Bills> bills=new ArrayList<Bills>();	//调用查询到账日期所有账单的方法
		bills=this.queryIdCardForAlready();
		System.out.println(bills.size()+"这个是我的长度");
		int flag=0;
		if(bills!=null){
			for (Bills bill : bills) {		//查询出到期账单，进行修改
				String idCard=bill.getIdCard();
				double overline=cmd.queryOverline(idCard);
				bal.setIdCard(idCard);
				//所有账单信息进行调整
				bal.setBillDate(bill.getNextBillDate());
				Date payBack=bill.getNextBillDate();	//最后还款日+20天
				Calendar cl=Calendar.getInstance();
				cl.setTime(payBack);
				cl.add(Calendar.DAY_OF_YEAR,20);
				payBack=cl.getTime();		//设置最后还款日
				bal.setPayBack(payBack);
				//设置分期数
				bal.setQishu(bill.getQishu());
				double alreadybill=bill.getNotreadyBill()+bill.getNotRefundNow()+bill.getRefundByStages();
				if(alreadybill>=overline){
					bal.setAlreadyBill(alreadybill-overline);
					bal.setOverline(0);
				}else{
					bal.setAlreadyBill(0);
					bal.setOverline(overline-alreadybill);
				}
				bal.setCurrentqs(bill.getCurrentqs()+1>bill.getQishu()?0:bill.getCurrentqs()+1);
				Date nextbilldate=bill.getNextBillDate();
				cl.setTime(nextbilldate);
				cl.add(Calendar.MONTH, 1);
				nextbilldate=cl.getTime();
				bal.setNextBillDate(nextbilldate); 	//设置下次出账时间
				bal.setRefundByStages(bill.getCurrentqs()+1>bill.getQishu()?0:bill.getRefundByStages());
				
				bal.setRestqishu(bal.getQishu()-bal.getCurrentqs());
				flag=cmd.updateBillsByAlready(bal);
				flag++;
			}	
		}
		System.out.println(flag);
		return flag;
	}
	
	@Override
	public Double queryBalance(MessageInfo mi) {
		// TODO Auto-generated method stub
		return cmd.queryBalance(mi);
	}




	//查询需要的数据放入redis    黄超
	@Override
	public List<TradeRecord> insertIntoRedis(RedisNeed rn) {
		// TODO Auto-generated method stub
		return cmd.insertIntoRedis(rn);
	}




	/**
	 * 添加账单记录
	 */
	public int insertBillInfo(Bills b) {
		return cmd.addBills(b);
	}



	@Override
	public List<String> searchMobile(String idCard) {
		List<String> mobs = cmd.searchMobile(idCard);
		return mobs;
	}

}
