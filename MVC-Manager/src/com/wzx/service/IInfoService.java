package com.wzx.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.wzx.dto.empDto;
import com.wzx.util.FenYe;

public interface IInfoService {
	List<empDto> emps(FenYe fy);
	List<Map<String, Object>> emm(FenYe fy);
	int rowCount(Map<String, Object> map);
	boolean del(String[] ids);
	empDto queryById(String ids);
	boolean update(empDto emp,HttpServletRequest req,MultipartFile img);
	boolean add(empDto emp,HttpServletRequest req,MultipartFile img);
}
