package com.zl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zl.pojo.Dept;
import com.zl.pojo.Emp;
import com.zl.pojo.Erecord;
import com.zl.pojo.Pos;

/**
* @author 作者 :陈强
* @version 创建时间：2018年1月12日 下午3:19:14
* 类说明
*/
public interface ErecordDao {
	//部门和权限 以及员工 表
	@Select("select * from emp  where empid=#{empid} ")
	public Emp QueryEmp(@Param("empid")String empid);
	//添加员工登录 和退出记录
	@Insert("insert into erecord values(#{id},#{empid},#{logintime},#{logintime},#{did},#{pid})")
	public int addLogintime(Erecord e);
	//查询所有员工最近一次记录
	@Select("SELECT a.*  FROM erecord a WHERE NOT EXISTS"
			+ "(SELECT 1 FROM erecord b WHERE b.empid=a.empid AND b.logintime>a.logintime) "
			+ "limit #{pageno},#{count}")
	@Results({
		@Result(property="dept",column="did",one=@One(select="com.zl.dao.CardAuditSystemDao.QueryDept")),
		@Result(property="pos",column="pid",one=@One(select="com.zl.dao.CardAuditSystemDao.QueryPos")),
		@Result(property="emp",column="empid",one=@One(select="com.zl.dao.ErecordDao.QueryEmp"))
	})
	public List<Erecord> QueryRecord(@Param("pageno")Integer pageno,@Param("count")Integer count);
	//查询总记录
	@Select("SELECT count(1)  FROM erecord a WHERE NOT EXISTS" + 
		   "(SELECT 1 FROM erecord b WHERE b.empid=a.empid AND b.logintime>a.logintime)")
	public int getCount();
	//查询某人员工的所有记录 按时间降序
	@Select("SELECT * FROM erecord WHERE empid=#{empid} ORDER BY logouttime DESC limit 0,7")
	@Results({
		@Result(property="dept",column="did",one=@One(select="com.zl.dao.CardAuditSystemDao.QueryDept")),
		@Result(property="pos",column="pid",one=@One(select="com.zl.dao.CardAuditSystemDao.QueryPos")),
		@Result(property="emp",column="empid",one=@One(select="com.zl.dao.ErecordDao.QueryEmp"))
	})	
	public List<Erecord> QueryRecordById(@Param("empid")String empid);
	//查询员工第几次登录和最后登录时间
		@Select("select count(1) from erecord where empid=#{empid}")
		public int gettotal(@Param("empid")String empid);
		@Select("SELECT * FROM erecord WHERE empid=#{empid} ORDER BY logintime DESC LIMIT 0,1")
		public Erecord getere(@Param("empid")String empid);
	//查询某人最近一条记录
	@Select("SELECT a.*  FROM erecord a WHERE NOT EXISTS"
			+ "(SELECT 1 FROM erecord b WHERE b.empid=a.empid AND "
			+ "b.logintime>a.logintime) and empid=#{empid}")
	@Results({
		@Result(property="dept",column="did",one=@One(select="com.zl.dao.CardAuditSystemDao.QueryDept")),
		@Result(property="pos",column="pid",one=@One(select="com.zl.dao.CardAuditSystemDao.QueryPos")),
		@Result(property="emp",column="empid",one=@One(select="com.zl.dao.ErecordDao.QueryEmp"))
	})	
	public Erecord QueryRecordByEmpid(@Param("empid")String empid);
	//修改某人的退出记录
	@Update("UPDATE erecord SET logouttime =#{logouttime} WHERE id=#{id}")
	public int UpdateLogout(Erecord ere);
}
