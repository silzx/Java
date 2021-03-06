package com.zl.service.inter;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zl.beans.BillsAndLine;
import com.zl.beans.CardCost;
import com.zl.beans.QueryInfo;
import com.zl.beans.RedisNeed;
import com.zl.beans.UnFreeze;
import com.zl.beans.UpdateUserInfo;
import com.zl.pojo.Bills;
import com.zl.pojo.CardMessage;
import com.zl.pojo.CustomerInfo;
import com.zl.pojo.MessageInfo;
import com.zl.pojo.Referee;
import com.zl.pojo.TradeRecord;
import com.zl.pojo.User;


/**
 * @author admin
 *	信用卡管理功能需求，待补充
 */

public interface CardManageInter {
	
	
	/**
	 * @title:cardUserLogin
	 * @author:黄超
	 * @Description:已开卡用户可以使用信用卡进行网站登录
	 * 需要  卡号，密码，手机验证码进行验证
	 */
	 CardMessage cardUserLogin(CardMessage cm);
	 /**
		 * @author 吕攀
		 * @Time 下午5:35:232018年1月10日
		 */
	int updateUserInfo(User ui);

	
	/**
	 * @title:cardApplication
	 * @author:黄超
	 * @Description:用户通过网站手动申请信用卡
	 * 资料上传到一级审核员数据库客户编号自动产生 申办日期自动产生 申办方式为网络申请
	 */
	boolean cardApplication(CustomerInfo ci);
	
	
	/**
	 * @title:cardCost
	 * @author:黄超
	 * @Description:消费功能
	 * 消费采用密码加密传输，账号密码核对无误，额度足够， 卡状态正常 卡信息校验正确  
	 * 有效期正确  背面三位数正确 短信校验正确情况下能正常消费，消费后额度正常减少。
	 * 额度不足情况下提示“余额不足”。消费成功，记录下消费详情。	
	 */
	public String cardCost(CardCost cc);
	
	/**
	 * @title:cardBill
	 * @author:黄超
	 * @Description:统计账单
	 * 每个月20号统计账单，账单产生后20天可以还款，20天以内不产生利息	
	 */
	public void cardBill();
	
	/**
	 * @title:cardRefund
	 * @author:黄超
	 * @Description:还款功能  卡号无误且已出账单，客户可以还款，还款分为全额，不足额，最低
	 * 还款额多种情况	
	 */
	public int cardRefund(String cardNum,Double refundMoney);
	
	
	/**
	 * @title:cardRecord
	 * @author:黄超
	 * @Description:记录交易记录详情，交易编号  交易方式  交易金额  交易日期+具体时间	
	 */
	public void cardRecord();
	
	
	/**
	 * @title:cardBillByStages
	 * @author:黄超
	 * @Description:分期功能
	 * 分3/6/12/24个月进行分期，分期利率不同	
	 */
	public int updateBillByStages(Bills bills);
	
	/**
	 * @title:cardBillHistory
	 * @author:黄超
	 * @Description:出账单记录
	 * 已出账单，未出账单等信息	
	 */
	public void cardBillHistory();
	
	/**
	 * @title:cardBillOverdue
	 * @author:黄超
	 * @Description:账单逾期
	 * 产生滞纳金，并且滞纳金日累加，复利计息未还款部分产生利息，复利计息
	 */

	public void cardBillOverdue();
	
	/**
	 * @title:cardCash
	 * @author:黄超
	 * @Description:信用卡取现
	 * 取现立即开始计算利息，数据库中额度正常减少，取现最多金额为总额度一半	
	 */
	public void cardCash();
	
	
	/**
	 * @title:cardActivation
	 * @author:黄超
	 * @Description:信用卡激活功能
	 *  卡号
	 *	身份证号
	 *	手机验证码
	 *	支付密码
	 *  确认支付密码
	 *  确认一致才能激活
	 *  数据库卡状态处于激活状态	
	 */
	public void cardActivation();
	
	/**
	 * @title:cardLoss
	 * @author:黄超
	 * @Description:挂失功能
	 * 客户挂失后，不能进行消费操作，可以使用信用卡进行系统登录。数据库卡状态处于挂失状态
	 * 身份证号
	       手机验证码
	 */
	public void cardLoss();
	
	/**
	 * @title:cardLoginout
	 * @author:黄超
	 * @Description:注销账户
	 * 客户注销后，不能进行消费操作，不能使用信用卡登录。数据库卡状态处于注销状态	
	 * 身份证号
	       手机验证码
	 */
	boolean cardLoginout(String cardNum);
	
	
	/**
	 * @title:cardFreeze
	 * @author:黄超
	 * @Description:信用卡冻结
	 * 客户操作冻结后，不能进行消费操作，可以使用信用卡进行系统登录手动解冻。	数据库卡状态处于冻结状态
	 * 身份证号
	       手机验证
	       由银行员工操作     
	 */
	boolean cardFreeze(String cardNum);
	
	/**
	 * @title:cardUnfreeze
	 * @author:黄超
	 * @Description:信用卡解冻
	 * 	身份证号
	          手机验证 验证通过进行解冻
	 */
	boolean cardUnfreeze(UnFreeze uf);


	/**
	 * @param 卡号
	 * @return 手机号
	 * @description 根据传入的信用卡号查询客户信息中的手机号
	 */
	String getPhoneNum(CardMessage cm);
	
	/**
	 * @param 信用卡号
	 * @return 手机号
	 * @description 根据信用卡号查询登录客户信息中的手机号
	 * 黄超
	 */
	String getOpenPhoneNum(CardMessage cm);
	
	
	
	public Double queryAlreadyBill(String cardNum);

	/**
	 * @author 吕攀
	 * @Time 下午7:49:332018年1月9日
	 * 身份证验证（用于验证推荐人是否持有本行的卡）
	 */
	
	int regUserByIdcard(String idcard);
	
	/**   
	 *@author 吕攀
	 * @Time 下午7:49:332018年1月9日
	 *添加推荐信息
	 */
	int addRefereeInfo(Referee rf);


	/**
	 * @param 信用卡激活信息
	 * @return 插入操作影响数据库记录条数
	 * @description 调用dao修改信用卡激活状态，返回操作信息
	 */
	int activationCard(CardMessage cm1);
	
	/**
	 * @title:queryCardNumIsExist
	 * @author:黄超
	 * @Description:查询还款账户是否存在	
	 */
	public int queryCardNumIsExist(QueryInfo qi);
	
	/**
	 * @title:queryLoginInfo
	 * @author:黄超
	 * @Description:根据登录查询User用户信息	
	 */
	public User queryUserInfo(String idcard);
	
	/**
	 * @title:queryBillsInfo
	 * @author:黄超
	 * @Description:根据登录查询bills账单信息	
	 */
	public Bills queryBillsInfo(String idcard);



	CustomerInfo getPhoneNumByIdCard(CustomerInfo ci);


	String getIdCardcardNum(CardMessage cm1);


	/**
	 * @param 卡号
	 * @return 数据库受影响记录数
	 * @description 根据卡号修改卡状态为挂失
	 * @author 谢文奇
	 * @param cardstatus 
	 */
	int cardLoss(CardMessage cm1, String cardstatus);

	
	/**
	 * @title:updateUser
	 * @author:黄超
	 * @Description:根据登录客户身份证更改信用卡用户基本信息	
	 */
	public int updateUser(User user);
	
	
	/**
	 * @title:queryIdCardForAlready
	 * @author:黄超
	 * @Description:定时查询出账单日到期的所有数据	
	 */
	public List<Bills> queryIdCardForAlready();
	
	/**
	 * @title:updateBillsByAlready
	 * @author:黄超
	 * @Description:根据定时器，账单到期的账单表	
	 */
	public int updateBillsByAlready(BillsAndLine bal);
	
	/**
	 * @title:queryBalance
	 * @author:黄超
	 * @Description:根据用户名卡号，密码，卡背后三位数验证卡片是否存在，如果存在则返回余额	
	 */
	public Double queryBalance(MessageInfo mi);
	

	/**
	 * @title:insertIntoRedis
	 * @author:黄超
	 * @Description:查询需要的交易记录集合	
	 */
	List<TradeRecord> insertIntoRedis(RedisNeed rn); 
	

	/**
	 * @param 身份证号、账单时间、还款时间、下一个账单时间，cardmessage中的卡号
	 * @return 数据库插入条数
	 * @description 向数据库添加账单记录
	 * @Author 谢文奇
	 */
	int insertBillInfo(Bills b);
	
	/**   
	 * @Title: searchMobile   
	 * @author：汪泽轩
	 * @Description:根据身份证查询手机号，判断有无60天内多个申卡的用户              
	 */
	List<String> searchMobile(String idCard);
	

}
