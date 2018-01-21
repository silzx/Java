package com.zl.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import com.zl.pojo.CustomerInfo;
import com.zl.pojo.Dept;
import com.zl.pojo.Emp;
import com.zl.pojo.Info;
import com.zl.pojo.Pos;
import com.zl.pojo.User;
import com.zl.provider.CardManagerProvider;

@Mapper
public interface CardAuditSystemDao{
	//部门和权限查询
		@Select("select * from dept where did=#{did} ")
		public Dept QueryDept(@Param("did")Integer did);
		@Select("select * from pos  where pid=#{pid} ")
		public Pos QueryPos(@Param("pid")Integer pid);
		
	/**
	 * @title:queryuser
	 * @author:陈强
	 * @Description:员工登录时验证账户是否存在
	 * 
	 */
	@Select("select * from emp where state=0")
	@Results({
		@Result(property="dept",column="did",one=@One(select="com.zl.dao.CardAuditSystemDao.QueryDept")),
		@Result(property="pos",column="pid",one=@One(select="com.zl.dao.CardAuditSystemDao.QueryPos"))
	})
	List<Emp> queryuser();
	
	/**
	 * @title:empLogin
	 * @author:黄超
	 * @Description:员工登录
	 * 用户名，密码，密码进行加密处理	
	 */
	
	@Select("select * from emp where account=#{account} and pwd=#{pwd} and state=0")
	@Results({
		@Result(property="dept",column="did",one=@One(select="com.zl.dao.CardAuditSystemDao.QueryDept")),
		@Result(property="pos",column="pid",one=@One(select="com.zl.dao.CardAuditSystemDao.QueryPos"))
	})	
	Emp empLogin(@Param("account")String account,@Param("pwd")String pwd);
	
	
	/**
	 * @title:empUpdateInfo
	 * @author:黄超
	 * @Description:员工可以查看个人资料并进行修改	
	 */
	@Update("")
	int empUpdateInfo(String name);

	
	/**
	 * @title:customerNo
	 * @author:黄超
	 * @Description:产生客户编号
	 * 客户编号为15位前四位为：zlyh+年+月+日+不重复编号，可以为字母数字	
	 */
	@Select("select current_date() from dual")
	String customerNo();
	
	
	/**
	 * @title:salesmanAddInfo
	 * @author:陈强
	 * @Description:业务员添加申卡用户
	 * 按照表字段依次添加  客户编号自动产生，申办日期自动产生，
	 * 申办方式为人工申请，资料不全保存，资料齐全提交	
	 */
	@Insert("insert into customerinfo values(#{uuid},#{name},#{sex},#{age},#{mobile},#{applyArea},#{cardType},#{idCard},"
			+ "#{applyStatus},#{addMan},#{applyMethod},#{applyDate},#{firstAudit},"
			+ "#{secondAudit},#{firstAuditDate},#{secondAuditDate},"
			+ "#{edu},#{jobType},#{zc},#{zw},#{jobAddress},#{companyName},#{companyPhone},#{homeAddress},"
			+ "#{marryed},#{linkMan},#{linkMobile},#{linkNexus},#{salary},#{asset},#{remark},#{house},#{refereename},#{ridcard},"
			+ "#{idCardCopy},#{receipts})")
	public int salesmanAddInfo(CustomerInfo in);
	
	
	/**
	 * @title:salesmanCheckInfo
	 * @author:陈强
	 * @Description:业务员可以批量查询未提交业务	
	 */
	@Select("select * from customerinfo where applyStatus=5 limit #{pageno},#{count}")
	@Results({
		@Result(property="dept",column="did",one=@One(select="com.zl.dao.CardAuditSystemDao.QueryDept")),
		@Result(property="pos",column="pid",one=@One(select="com.zl.dao.CardAuditSystemDao.QueryPos")),
		@Result(property="cardtypeObject",column="cardtype",one=@One(select="com.zl.dao.FirstApprovalerDao.queryCardType")),
		@Result(property="applyStatusType",column="applyStatus",one=@One(select="com.zl.dao.FirstApprovalerDao.queryApplyStatusType"))
	})
	public List<CustomerInfo> salesmanQueryInfo(@Param("pageno")int pageno,@Param("count")int count);
	/**
	 * @title:getcountinfo
	 * @author:陈强
	 * @Description:获取未提交业务条数	
	 */
	@Select("select count(*) from customerinfo where applyStatus=5")
	public int getcountinfo();
	
	/**
	 * @title:salesmanShowInfo
	 * @author:陈强
	 * @Description:业务员可以查看用户详情	
	 */
	@Select("select * from customerinfo where uuid=#{uuid} and applyStatus=5")
	public CustomerInfo salesmanShowInfo(@Param("uuid")String uuid);
	
	/**
	 * @title:salesmanUpdateCustomer
	 * @author:黄超
	 * @Description:业务员可以更新用户详情	
	 */
	public void salesmanUpdateCustomer();
	
	/**
	 * @title:salesmanSubmitCustomer
	 * @author:陈强
	 * @Description:业务员可以更新用户详情并提交给一级审批员	
	 */
	@Update("UPDATE customerinfo SET idcardcopy=#{idcardcopy},receipts=#{receipts},applyStatus=0 where uuid=#{uuid}")
	public int salesmanSubmitCustomer(@Param("uuid")String uuid,
			@Param("idcardcopy")String idcardcopy,@Param("receipts")String receipts);
	
	/**
	 * @title:adminAddEmp
	 * @author:陈强
	 * @Description:管理员添加员工	
	 */
	@Insert("insert into emp values(#{account},#{pwd},#{mobile},"
			+ "#{name},#{idCard},#{empid},#{age},#{did},#{pid},"
			+ "#{joindate},#{sex},#{address},#{linkman},#{linkMobile},#{state},#{eva},#{salt})")
	public int adminAddEmp(Emp e);
	
	
	/**
	 * @title:adminDeleteEmp
	 * @author:黄超
	 * @Description:管理员逻辑删除员工	
	 */
	@Update("UPDATE emp SET state=1 where empid=#{empid}")
	public int adminDeleteEmp(@Param("empid")String empid);
	
	
	/**
	 * @title:adminUpdateEmp
	 * @author:陈强
	 * @Description:管理员更新员工信息	
	 */
	@Update("UPDATE emp SET mobile=#{mobile},address=#{address},linkman=#{linkman},linkMobile=#{linkMobile} where empid=#{empid} and state=0")
	@Results({
		@Result(property="dept",column="did",one=@One(select="com.zl.dao.CardAuditSystemDao.QueryDept")),
		@Result(property="pos",column="pid",one=@One(select="com.zl.dao.CardAuditSystemDao.QueryPos"))
	})
	public int adminUpdateEmp(Emp e);
	@Update("UPDATE emp SET pwd=#{pwd} where empid=#{empid} and state=0")
	public int adminUpdatePwd(@Param("empid")String empid,@Param("pwd")String pwd);
	/**
	 * @title:adminShowInfo
	 * @author:陈强
	 * @Description:管理员查看员工详细信息	
	 */
	@Select("select * from emp where empid=#{empid} and state=0")
	@Results({
		@Result(property="dept",column="did",one=@One(select="com.zl.dao.CardAuditSystemDao.QueryDept")),
		@Result(property="pos",column="pid",one=@One(select="com.zl.dao.CardAuditSystemDao.QueryPos"))
	})
	public Emp adminShowInfo(@Param("empid")String empid);
	
	/**
	 * @title:QuerySalt
	 * @author:陈强
	 * @Description:查找盐值	
	 */
	@Select("select salt from emp where account=#{account}")
	public String QuerySalt(@Param("account")String account);	
	/**
	 * @title:QuerySaltByempid
	 * @author:陈强
	 * @Description:查找盐值	
	 */
	@Select("select salt from emp where empid=#{empid}")
	public String QuerySaltByempid(@Param("empid")String empid);
	/**
	 * @title:adminQueryEmp
	 * @author:陈强
	 * @Description:管理员可以筛选员工进行显示	
	 */
	@Select("select * from emp where account like #{account} and state=0 limit #{pageno},#{count}")
	@Results({
		@Result(property="dept",column="did",one=@One(select="com.zl.dao.CardAuditSystemDao.QueryDept")),
		@Result(property="pos",column="pid",one=@One(select="com.zl.dao.CardAuditSystemDao.QueryPos"))
	})
	public List<Emp> adminQueryEmp(@Param("account")String account,@Param("pageno")int pageno,@Param("count")int count);
	
	/**
	 * @title:adminQueryDiscardCustomer
	 * @author:黄超
	 * @Description:管理员可以查看筛选被废弃的用户信息	
	 */
	public void adminQueryDiscardCustomer();
	/**
	 * @title:getcount
	 * @author:陈强
	 * @Description:得到总行数
	 */
	@Select("select count(1) from emp where account like #{account} and state=0")
	public int getcount(@Param("account")String account);
	
}
