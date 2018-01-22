package com.zl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.zl.dao.PayBackDao;
import com.zl.pojo.PayBackCard;
import com.zl.service.BankCardService;

@Service(version="1.0.0")
public class BankCardServiceImpl implements BankCardService{
	
	@Autowired
	private PayBackDao pbd;
	
	@Override
	public int updatePayBackCard(PayBackCard pbc) {
		// TODO Auto-generated method stub
		return pbd.updatePayBackCard(pbc);
	}

}
