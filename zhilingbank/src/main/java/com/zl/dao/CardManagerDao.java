package com.zl.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import com.zl.beans.BillsAndLine;
import com.zl.beans.CardCost;
import com.zl.beans.QueryInfo;
import com.zl.beans.RedisNeed;
import com.zl.beans.RefundMoney;
import com.zl.beans.UnFreeze;
import com.zl.pojo.Bills;
import com.zl.pojo.CardMessage;
import com.zl.pojo.CustomerInfo;
import com.zl.pojo.MessageInfo;
import com.zl.pojo.Referee;
import com.zl.pojo.TradeRecord;
import com.zl.pojo.User;
import com.zl.provider.CardManagerProvider;
@Mapper
public interface CardManagerDao {
	
	/**
	 * @title:cardUserLogin
	 * @author:黄超
	 * @Description:登录查询，根据登录信息查询卡片信息	
	 */
	@Select("select idcard,cardnum,cardtype,password,"
			+ "backcode,deaddate,billdate,repaydate,"
			+ "cardstatus from cardmessage "
			+ "where cardnum=#{cardNum} and password=#{password} and cardstatus in (1,2)")
	CardMessage cardUserLogin(CardMessage cm);
	
	
	
	/**
	 * @title:queryLoginInfo
	 * @author:黄超
	 * @Description:根据登录查询User用户信息	
	 */
	@Select("select userid,username,idcard,phone,companyname,companyadd,comphone,ismarry,familyadd,linkman,"
			+ "linksex,linkrelationship,linkphone,creditline,avabalance,usedbalance,overline from carduser where"
			+ " idcard=#{idcard}")
	public User queryUserInfo(String idcard);
	
	/**
	 * @title:queryBillsInfo
	 * @author:黄超
	 * @Description:根据登录查询bills账单信息	
	 */
	@Select("select idcard,billdate,payback,qishu,currentqs,alreadybill,notreadybill,refundnow,notrefundnow,nextbilldate,restqishu"
			+ " from bills where idcard=#{idcard}")
	public Bills queryBillsInfo(String idcard);
	
	/**   
	 * @Title: cardUnfreeze   
	 * @author：汪泽轩
	 * @Description: 信用卡解冻               
	 */
	@Update("update cardmessage set cardStatus='NORMAL' "
			+ "where idCard=#{idCard} and Mobile=#{Mobile} "
			+ "and cardnum=#{cardnum}")
	int cardUnfreeze(UnFreeze uf);
	
	/**   
	 * @Title: cardFreeze   
	 * @author：汪泽轩
	 * @Description: 信用卡冻结               
	 */
	@Update("update cardmessage set cardStatus='FREEZE' "
			+ "where cardnum=#{cardnum}")
	int cardFreeze(String cardNum);
	
	/**   
	 * @Title: cardLogout   
	 * @author：汪泽轩
	 * @Description: 信用卡注销               
	 */
	@Update("update cardmessage set cardStatus='LOGOUT' "
			+ "where cardnum=#{cardnum}")
	int cardLogout(String cardNum);
	
	/**   
	 * @Title: cardApplication   
	 * @author：汪泽轩
	 * @Description: 用户页面申卡               
	 */
	@Insert("insert into customerInfo(uuid,name,sex,age,mobile,applyarea,cardtype,"
			+ "idcard,applystatus,addman,applyMethod,applyDate,edu,jobType,zc,zw,"
			+ "jobAddress,companyName,companyphone,homeAddress,marryed,linkman,"
			+ "linkmobile,linknexus,salary,asset,remark,house,receipts,idcardcopy) "
			+ "VALUES(#{uuid},#{name},#{sex},"
			+ "#{age},#{mobile},#{applyArea},#{cardType},#{idCard},1,"
			+ "#{addMan},#{applyMethod},CURRENT_DATE(),#{edu},#{jobType},#{zc},"
			+ "#{zw},#{jobAddress},#{companyName},#{companyPhone},#{homeAddress},"
			+ "#{marryed},#{linkMan},#{linkMobile},#{linkNexus},#{salary},#{asset},"
			+ "#{remark},#{house},#{receipts},#{idCardCopy})")
	int cardApplication(CustomerInfo ci);
	
	/**   
	 * @Title: searchMobile   
	 * @author：汪泽轩
	 * @Description: 通过身份证查询有无60天内重复申卡用户              
	 */
	@Select("select mobile from customerInfo where datediff(CURRENT_DATE(),applyDate)<=60 "
			+ "and idcard=#{idCard}")
	List<String> searchMobile(String idCard);
	
	/**
	 * @author 吕攀
	 * @Time 下午5:35:232018年1月10日
	 
	 */
	@UpdateProvider(type=CardManagerProvider.class,method="updateinfo")
	int updateUserInfo(User ui);
	
	/**   
	 * @Title: queryCardUserByCardNum   
	 * @author：汪泽轩
	 * @Description: 根据卡号级联查询出用户的详细信息
	 */
	@Select("select cu.userid,cu.username,cu.idcard,cu.phone,cu.companyname,"
			+ "cu.companyadd,cu.comphone,cu.ismarry,cu.familyadd,cu.linkman,"
			+ "cu.linksex,cu.linkrelationship,cu.linkphone,cu.creditline,"
			+ "cu.avabalance,cu.usedbalance,cu.overline from"
			+ "carduser cu,cardmessage cm where cm.cardnum=#{cardnum} and "
			+ "cu.idcard=cm.idcard")
	User queryCardUserByCardNum(CardCost cc);

	
	
	/**
	 * @title:cardRefund
	 * @author:黄超
	 * @Description:还款功能	
	 */
	@UpdateProvider(type=CardManagerProvider.class,method="updateRefund")
	public int cardRefund(RefundMoney fm);
	
	
	
	
	/**
	 * @title:queryAlreadyBill
	 * @author:黄超
	 * @Description:还款方法调用，查询未还款金额
	 */
	@Select("select b.notrefundnow from bills b where b.idcard=(select c.idcard from cardmessage c where c.cardnum=#{cardNum})")
	public Double queryAlreadyBill(String cardNum);
	
	/**
	 * @title:queryCardNumIsExist
	 * @author:黄超
	 * @Description:查询还款账户是否存在	
	 */
	@Select("select count(1) from carduser u,cardmessage c where  c.cardnum=#{cardNum} and u.username=#{username} and u.idcard=c.idcard")
	public int queryCardNumIsExist(QueryInfo qi);
	


	/**
	 * @param 信用卡号
	 * @return 手机号
	 * @description 根据信用卡号查询未开卡客户信息中的手机号
	 * 黄超修改
	 */
	@Select("select phone from carduser where CONVERT(idcard USING utf8) COLLATE utf8_unicode_ci="+
			"(select idcard from cardmessage where cardnum=#{cardNum} and cardstatus=0)")
	String getPhoneNum(CardMessage cm);
	
	/**
	 * @param 信用卡号
	 * @return 手机号
	 * @description 根据信用卡号查询登录客户信息中的手机号
	 * 黄超
	 */
	@Select("select phone from carduser where CONVERT(idcard USING utf8) COLLATE utf8_unicode_ci="+
			"(select idcard from cardmessage where cardnum=#{cardNum} and cardstatus in (1,2))")
	String getOpenPhoneNum(CardMessage cm);
	
	/**
	 * @author 吕攀
	 * @Time 下午3:54:14 2018年1月9日
	 * @context 通过身份信息验证推荐人是否存在
	 */
	@Select("select count(1) from carduser where idcard=#{idcard}")
	int regUserByIdcard(String idcard);
	/**
	 * 添加推荐信息
	 * @author 吕攀
	 * @Time 下午3:54:14 2018年1月9日
	 */
	@Insert("insert into customerinfo(uuid,refereename,ridcard,name,mobile,applyarea,companyname) "
			+ "values(#{id},#{name},#{ridcard},#{rname},#{rphone},#{raddress},#{rcompany})")
	int addRefereeInfo(Referee rf);

	
	/**
	 * @title:insertCardMessage
	 * @author:姚彬彬
	 * @Description:添加审批通过用户sql语句	
	 */
	@Insert("insert into cardmessage(idcard,cardNum,cardType,backCode,deadDate,billDate,repayDate,cardStatus)values(#{idCard},#{cardNum},#{cardType},#{backCode},#{deadDate},#{billDate},#{repayDate},#{cardStatus})")
	boolean insertCardMessage(CardMessage cm);





	/**
	 * @param 信用卡的支付密码，可用状态。可用状态：0.未激活，1.正常，2.挂失，3.冻结，4.注销
	 * @return 数据库影响条数
	 * @description 修改信用卡数据表
	 * @author 谢文奇
	 */
	@Update("update cardmessage set password=#{password},salt=#{salt},billdate=#{billDate},repaydate=#{repayDate},cardstatus=1 where cardnum=#{cardNum} and cardstatus=0")
	int activationCard(CardMessage cm);

	/**
	 * @param 客户填写的身份证
	 * @return 手机号、申卡状态
	 * @description 根据可户填写的身份证号查询绑定的手机号和申请信用卡的状态
	 * @author 谢文奇
	 */ 
	@Select("select mobile,applystatus from customerinfo where idcard=#{idCard}")
	CustomerInfo getPhoneNumByIdCard(CustomerInfo ci);


	/**
	 * @param 卡号
	 * @return 身份证号
	 * @description 根据卡号，从cardmessage表查询绑定的身份证号
	 * @author 谢文奇
	 */
	@Select("select idcard from cardmessage where cardnum=#{cardNum}")
	String getIdCardBycardNum(CardMessage cm);


	/**
	 * @param 卡号
	 * @return 数据库受影响条数
	 * @description 根据卡号修改卡状态为挂失，并且只有当卡状态为正常时才能挂失
	 * @author 谢文奇
	 * @param cardstatus 
	 */
	@Update("update cardmessage set cardstatus=#{0.cardStatus} where cardnum=#{0.cardNum} and cardstatus=#{1}")
	int cardLoss(CardMessage cm, String cardstatus1);

	
	/**
	 * @title:updateBillByStages
	 * @author:黄超
	 * @Description:账单分期dao层
	 */
	@Update("update bills set qishu=#{qishu},currentqs=#{currentqs},notrefundnow=#{notRefundNow},refundByStages=#{refundByStages},restqishu=#{qishu} where idcard=#{idCard}")
	public int updateBillByStages(Bills bills);
	
	
	/**
	 * @title:updateUser
	 * @author:黄超
	 * @Description:根据用户身份证更新用户信息	
	 */
	@UpdateProvider(type=CardManagerProvider.class,method="updateUser")
	public int updateUser(User user);
	
	
	/**
	 * @title:queryIdCardForAlready
	 * @author:黄超
	 * @Description:定时查询出账单日到期的所有数据	
	 */
	@Select("select * from bills where DATEDIFF(nextbilldate,NOW())=0")
	public List<Bills> queryIdCardForAlready();
	
	/**
	 * @title:queryOverline
	 * @author:黄超
	 * @Description:查询出溢出金额，在账单产生时用于抵消账单金额	
	 */
	@Select("select overline from carduser where idcard=#{idCard}")
	public double queryOverline(String idCard);
	
	/**
	 * @title:updateBillsByAlready
	 * @author:黄超
	 * @Description:根据定时器，账单到期的账单表	
	 */
	@Update("update bills b,carduser u set b.billdate=#{billDate},b.payback=#{payBack},"
			+ "b.qishu=#{qishu},b.alreadybill=#{alreadyBill},b.currentqs=#{currentqs},"
			+ "b.notreadybill=0,refundnow=0,notrefundnow=0,nextbilldate=#{nextBillDate},"
			+ "refundByStages=#{refundByStages},restqishu=#{restqishu}"
			+ " where b.idcard=#{idCard} and u.idcard=#{idCard}")
	public int updateBillsByAlready(BillsAndLine bal);
	
	
	/**
	 * @title:queryBalance
	 * @author:黄超
	 * @Description:根据用户名卡号，密码，卡背后三位数验证卡片是否存在，如果存在则返回余额	
	 */
	@Select("select avabalance from carduser where idcard=(select idcard from cardmessage where cardNum=#{cardNum} and password=#{password} and backcode=#{backCode})")
	public Double queryBalance(MessageInfo mi);
	
	
	
	/**
	 * @title:insertTlog
	 * @author:黄超
	 * @Description:消费成功，添加消费记录	
	 */
	@Insert("insert into tlog (SwiftNumber,cardNum,TradeType,Money,EnterDate,TradeShop,PosNum) "
		+ "values (#{tradeNum},#{cardNum},#{tradeType},#{price},#{tradeDate},#{storeName},#{posNum})")
	public int insertTlog(MessageInfo mi);

	
	/**
	 * @title:insertIntoRedis
	 * @author:黄超
	 * @Description:查询需要的交易记录集合	
	 */
	@Select("select cardNum,SwiftNumber,TradeType,Money,EnterDate from tlog where EnterDate between #{startDate} and #{endDate}")
	@Results({
		@Result(column="cardNum",property="cardNum"),
		@Result(column="SwiftNumber",property="tradeUUID"),
		@Result(column="TradeType",property="tradeType"),
		@Result(column="Money",property="trade"),
		@Result(column="EnterDate",property="tradeDate")
	})
	List<TradeRecord> insertIntoRedis(RedisNeed rn); 
	




	/**
	 * @param 账单信息
	 * @return 插入条数
	 * @description 向数据库添加一条随激活信用卡生成的账单记录
	 * @Author 谢文奇
	 */
	@Insert("insert into bills (idcard,billdate,payback,nextbilldate) "
			+ "values (#{idCard},#{billDate},#{payBack},#{nextBillDate})")
	int addBills(Bills b);

}























