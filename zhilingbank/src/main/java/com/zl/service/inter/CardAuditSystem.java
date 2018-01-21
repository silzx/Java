package com.zl.service.inter;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zl.pojo.CustomerInfo;
import com.zl.pojo.Emp;
import com.zl.pojo.Info;
import com.zl.pojo.User;

/**
 * @author admin
 *	信用卡审批系统功能
 *	以及管理员功能需求
 */
public interface CardAuditSystem {
	/**
	 * @title:queryuser
	 * @author:陈强
	 * @Description:员工登录时验证账户是否存在
	 * 
	 */
	public boolean queryuser(String account);
	public String QuerySalt(String account);
	/**
	 * @title:empLogin
	 * @author:黄超
	 * @Description:员工登录
	 * 用户名，密码，密码进行加密处理	
	 */
	public Emp empLogin(String account,String pwd);
	
	
	/**
	 * @title:empUpdateInfo
	 * @author:黄超
	 * @Description:员工可以查看个人资料并进行修改	
	 */
	public void empUpdateInfo();
	
	
	/**
	 * @title:salesmanAddInfo
	 * @author:陈强
	 * @Description:业务员添加申卡用户
	 * 按照表字段依次添加  客户编号自动产生，申办日期自动产生，
	 * 申办方式为人工申请，资料不全保存，资料齐全提交	
	 */
	public int salesmanAddInfo(CustomerInfo in);
	
	
	/**
	 * @title:salesmanCheckInfo
	 * @author:陈强
	 * @Description:业务员可以批量查询未提交业务
	 */
	public List<CustomerInfo> salesmanQueryInfo(int pageno,int count);
	/**
	 * @title:getcountinfo
	 * @author:陈强
	 * @Description:获取未提交业务条数	
	 */
	public int getcountinfo();
	
	/**
	 * @title:salesmanShowInfo
	 * @author:陈强
	 * @Description:业务员可以查看用户详情	
	 */
	public CustomerInfo salesmanShowInfo(String uuid);
	
	/**
	 * @title:salesmanSubmitCustomer
	 * @author:陈强
	 * @Description:业务员可以更新用户详情并提交给一级审批员	
	 */
	public int salesmanSubmitCustomer(String uuid,String idcardcopy,String receipts);
	
	/**
	 * @title:adminAddEmp
	 * @author:黄超
	 * @Description:管理员添加员工	
	 */
	public int adminAddEmp(Emp e);
	
	
	/**
	 * @title:adminDeleteEmp
	 * @author:陈强
	 * @Description:管理员逻辑删除员工	
	 */
	public int adminDeleteEmp(String empid);
	
	
	/**
	 * @title:adminUpdateEmp
	 * @author:黄超
	 * @Description:管理员更新员工信息	
	 */
	public int adminUpdateEmp(Emp e);
	
	public int adminUpdatePwd(String empid,String pwd);
	/**
	 * @title:adminShowInfo
	 * @author:黄超
	 * @Description:管理员查看员工详细信息	
	 */
	public Emp adminShowInfo(String empid);
	
	/**
	 * @title:adminQueryEmp
	 * @author:黄超
	 * @Description:管理员可以筛选员工进行显示	
	 */
	public List<Emp> adminQueryEmp(String account,int pageno,int count);
	
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
	public int getcount(String account,int count);
	
}
