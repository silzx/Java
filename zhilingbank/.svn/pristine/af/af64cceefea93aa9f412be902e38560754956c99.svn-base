package com.zl.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.FirstApprovalerDao;
import com.zl.pojo.CustomerInfo;
import com.zl.service.inter.FirstApprovaler;

/** * 
@author    姚彬彬 
@date      2018年1月8日 下午7:23:35   
@describe  
 */
@Service
public class FirstApprovalerImpl implements FirstApprovaler{

	
	@Autowired 
	private FirstApprovalerDao faDao;
	/** * 
	@author    姚彬彬 
	@date      2018年1月8日 下午7:24:18   
	@describe  一级审核员可以筛选用户资料	
	*/
	@Override
	public List<CustomerInfo> firstApprovalerQueryCustomer(String page,String fuzzy,Integer applystatus) {
		Integer length=10;
		page = page == null ? "1" : page;
		Integer cupage = Integer.valueOf(page);
		fuzzy = fuzzy == null ? "" : fuzzy;
		List<CustomerInfo> customer_list= faDao.QueryCustomerList((cupage-1)*length,length,fuzzy,applystatus);
		
		
		return customer_list;
	}
	/** * 
	@author    姚彬彬 
	@date      2018年1月8日 下午7:24:18   
	@describe  一级审核员可以查看用户详细资料	
	*/
	
	@Override
	public CustomerInfo firstApprovalerShowInfo(String uuid) {
		uuid = uuid == null ? "" : uuid;
		CustomerInfo customer= faDao.QueryCustomer(uuid);
		
		return customer;
	}
	/** * 
	@author    姚彬彬 
	@date      2018年1月8日 下午7:24:18   
	@describe  一级审核员可以提交用户至二级审核员，并添加建议	
	*/	
	@Override
	public void firstApprovalerSubmitCustomer(String uuid) {
		boolean uct = faDao.UpdateCustomerType(uuid);
		
		
	}

	@Override
	public void firstApprovalerDiscardCustomer(String uuid,String rejectedText) {
		uuid = uuid == null ? "":uuid;
		rejectedText = rejectedText == null ? "":rejectedText;
		System.out.println(uuid+rejectedText);
		System.out.println(11);
		faDao.UpdateCustomerRejected(uuid,rejectedText);
		
	}
	/** * 
	@author    姚彬彬 
	@date      2018年1月10日 下午3:13:23   
	@describe  获取页码
	*/
	@Override
	public List queryCount(String fuzzy,Integer type) {
		fuzzy = fuzzy == null ? "" : fuzzy;
		Integer count = faDao.queryCount(fuzzy,type);
		Integer pages = (int) Math.ceil(count / Double.valueOf(10.0));
		List page_list = new ArrayList();
		page_list.add(count);
		page_list.add(pages);		
		return page_list;
	}

}
