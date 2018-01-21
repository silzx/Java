package com.zl.service.inter;

import java.util.List;

import com.zl.pojo.CustomerInfo;

/**
 * @author admin
 * 二级审核员功能需求
 */
public interface SecondApprovaler {
	
	/**
	 * @title:callPhoneInterface
	 * @author:黄超
	 * @Description:二级审核员调用征信接口	
	 */
	public void callCreditInterface();
	
	/**
	 * @title:callIdCardInterface
	 * @author:黄超
	 * @Description:二级深科源调用身份证接口	
	 */
	public void callIdCardInterface();
	
	
	/**
	 * @title:callEducationInterface
	 * @author:黄超
	 * @Description:二级审核员调用学历查询接口	
	 */
	public void callEducationInterface();
	
	/**
	 * @title:callAntiFraudInterface
	 * @author:黄超
	 * @Description:二级审核员调用反诈骗接口	
	 */
	public void callAntiFraudInterface();
	
	/**
	 * @title:secondApprovalerQueryCustomer
	 * @author:黄超
	 * @Description:二级审核员可以筛选用户	
	 */
	public List<CustomerInfo> secondApprovalerQueryCustomer(String page,String fuzzy);
	
	
	/**
	 * @title:secondApprovalerShowInfo
	 * @author:黄超
	 * @Description:二级审核员可以查看用户详情	
	 */
	public CustomerInfo secondApprovalerShowInfo(String uuid);
	
	/**
	 * @title:secondApprovalerSubmitCustomer
	 * @author:黄超
	 * @Description:二级审核员通过审核
	 */
	public void secondApprovalerSubmitCustomer(CustomerInfo customer);
	
	/**
	 * @title:SubmitCustomerDiscardCustomer
	 * @author:黄超
	 * @Description:二级审核员废弃用户并填写备注添加到废弃用户数据库	
	 */
	public void secondApprovalerDiscardCustomer();
	
	
	
}
