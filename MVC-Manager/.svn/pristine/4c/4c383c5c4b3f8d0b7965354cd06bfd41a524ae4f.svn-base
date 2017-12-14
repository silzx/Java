package com.wzx.dao;

import java.util.List;
import java.util.Map;

import com.wzx.dto.empDto;
import com.wzx.util.FenYe;

public interface InfoDao {
	List<empDto> emps(FenYe fy);
	List<Map<String, Object>> emm(FenYe fy);
	int rowCount(Map<String, Object> map);
	int del(String[] ids);
	empDto queryById(String id);
	int update(empDto emp);
	int add(empDto emp);
}
