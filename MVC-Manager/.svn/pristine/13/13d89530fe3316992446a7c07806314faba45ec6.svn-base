package com.wzx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzx.dao.DeptDao;
import com.wzx.dto.deptDto;
import com.wzx.service.IDeptService;
@Service
public class DeptService implements IDeptService{
	@Autowired
	private DeptDao da;
	@Override
	public List<deptDto> depts() {
		return da.depts();
	}
}
