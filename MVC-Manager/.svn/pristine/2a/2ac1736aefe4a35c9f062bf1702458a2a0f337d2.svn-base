package com.wzx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzx.dao.EmpDao;
import com.wzx.dto.empDto;
import com.wzx.service.IEmpService;
@Service
public class EmpService implements IEmpService{
	@Autowired
	private EmpDao ed;
	@Override
	public empDto login(empDto emp) {
		return ed.login(emp);
	}
	
}
