package com.zl.service.inter;

import java.util.List;

import com.zl.pojo.CustomerInfo;

/**
 * @author admin
 * 一级审核员业务需求
 */
public interface FirstApprovaler {
	/**
	 * @title:firstApprovalerQueryCustomer
	 * @author:黄超
	 * @Description:一级审核员可以筛选用户资料	
	 */
	public List<CustomerInfo> firstApprovalerQueryCustomer(String cupage,String fuzzy,Integer applystatus);
	
	
	/**
	 * @title:queryCount
	 * @author:姚彬彬
	 * @Description:获取页码
	 */
	public List queryCount(String fuzzy,Integer type);
	/**
	 * @title:firstApprovalerShowInfo
	 * @author:黄超
	 * @Description:一级审核员可以查看用户详细资料	
	 */
	public CustomerInfo firstApprovalerShowInfo(String uuid);
	
	
	/**
	 * @title:firstApprovalerSubmitCustomer
	 * @author:黄超
	 * @Description:一级审核员可以提交用户至二级审核员，并添加建议	
	 */
	public void firstApprovalerSubmitCustomer(String uuid);
	
	/**
	 * @title:firstApprovalerDiscardCustomer
	 * @author:黄超
	 * @Description:一级审核员可以废弃用户至废弃数据库，并添加备注	
	 */
	public void firstApprovalerDiscardCustomer(String uuid,String rejectedText);
	
}
