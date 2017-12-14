package com.wzx.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.wzx.dto.empDto;
import com.wzx.service.IFenYeService;
import com.wzx.service.IInfoService;
import com.wzx.util.FenYe;
@Service
public class FenYeService implements IFenYeService{
	@Autowired
	private IInfoService fs;
	@Override
	public FenYe getFenYe(String page, String ename, String dept,
			String minAge, String maxAge, HttpServletRequest req) {
		Map<String, Object> search = new HashMap<>();
		if(page==null){
			FenYe.page=1;
		}else{
			FenYe.page=Integer.parseInt(page);
		}
		if("--请选择--".equals(dept)){
			dept="";
		}
		search.put("ename", ename);
		req.setAttribute("ename", ename);
		search.put("dept", dept);
		req.setAttribute("dept", dept);
		search.put("minAge", minAge);
		req.setAttribute("minAge", minAge);
		search.put("maxAge", maxAge);
		req.setAttribute("maxAge", maxAge);
		empDto emp=(empDto) req.getSession().getAttribute("emp");
		search.put("emp", emp);
		FenYe.search=search;
		req.getSession().setAttribute("search", search);
		FenYe.rowCount=fs.rowCount(search);
		FenYe.init();
		return FenYe.fy;
	}

	

}
