package com.zl.provider;

import org.apache.ibatis.jdbc.SQL;

import com.zl.beans.RefundMoney;
import com.zl.beans.UpdateUserInfo;
import com.zl.pojo.User;


public class CardManagerProvider {
	/**
	 * @author 吕攀
	 * @Time 下午5:15:512018年1月10日
	 
	 */
	public String updateinfo(final User ui){
		return new SQL(){
			{
				UPDATE("carduser");
					SET("username=#{username}");
					SET("idcard=#{idCard}");
				if(ui.getFamilyadd()!=null){
					SET("companyadd=#{companyAdd}");
				}
				if(ui.getLinkman()!=null){
					SET("linkman=#{linkman}");
				}
				if(ui.getLinkphone()!=null){
					SET("linkphone=#{linkphone}");
				}
				if(ui.getPhone()!=null){
					SET("phone=#{phone}");
				}
				if(ui.getFamilyadd()!=null){
					SET("familyadd=#{familyadd}");
				}
				if(ui.getCompanyName()!=null){
					SET("companyName=#{companyName}");
				}
				WHERE("userid=#{userid}");
			}
		}.toString();
	}

	
	/**
	 * @title:updateRefund
	 * @author:黄超
	 * @Description:更新账单信息及额度信息	
	 */
	public String updateRefund(final RefundMoney rm){
		return new SQL(){
			{		//可以修改部分，已还金额，未还金额，可用余额以及溢出额度
				UPDATE("carduser u,bills b");
				if(rm.getNotRefundNow()!=null){
					SET("b.notRefundNow=notRefundNow-#{notRefundNow}");	//未还金额修改
				}
				if(rm.getOverline()!=null){
					SET("u.overline=u.overline+#{overline}");  		//更改溢出金额 
				}
				if(rm.getAvabalance()!=null){
					SET("u.avabalance=u.avabalance+#{avabalance}");	//更改可用余额
				}
				WHERE("u.idcard=(SELECT idcard from cardmessage where cardnum=#{cardNum}) "
						+ "and b.idcard=(SELECT idcard from cardmessage where cardnum=#{cardNum})"); 
			}
		}.toString();
	}
	
	
	public String updateUser(final User user){
		return new SQL(){
			{
				UPDATE("carduser");
				SET("username=#{username}");
				if(user.getPhone()!=null&&user.getPhone()!=""){
					SET("phone=#{phone}");
				}
				if(user.getCompanyAdd()!=null&&user.getCompanyAdd()!=""){
					SET("companyAdd=#{companyAdd}");
				}
				if(user.getFamilyadd()!=null&&user.getFamilyadd()!=""){
					SET("familyadd=#{familyadd}");
				}
				if(user.getLinkman()!=null&&user.getLinkman()!=""){
					SET("linkman=#{linkman}");
				}
				if(user.getLinkphone()!=null&&user.getLinkphone()!=""){
					SET("linkphone=#{linkphone}");
				}
				WHERE("idcard=#{idCard}");
			}
		}.toString();
	}
	
}
