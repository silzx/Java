package com.wzx.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.wzx.dto.empDto;
import com.wzx.service.IFenYeService;
import com.wzx.service.IInfoService;
import com.wzx.util.FenYe;

@Controller
@Scope("prototype")
@RequestMapping("info")
public class InfoController implements HandlerExceptionResolver{
	@Autowired
	private IInfoService fs;
	@Autowired
	private IFenYeService fenye;
	@RequestMapping("query")
	public ModelAndView query(String page,String ename,String dept,String minAge,String maxAge,HttpServletRequest req){
		ModelAndView mv=new ModelAndView();
		List<empDto> emps=new ArrayList<>();
		//List<Map<String, Object>> emm=new ArrayList<>();
		FenYe.fy=fenye.getFenYe(page, ename, dept, minAge, maxAge, req);
		empDto e=(empDto) req.getSession().getAttribute("emp");
		if("1".equals(e.getPid())){
			emps.add(e);
		}else{
			emps=fs.emps(FenYe.fy);
		}
		mv.addObject("emps",emps);
		mv.setViewName("main");
		/*if("1".equals(e.getPid())){
			emps.add(e);
		}else{
			emm=fs.emm(FenYe.fy);
		}
		mv.addObject("emps",emm);
		mv.setViewName("main");*/
		return mv;
	}
	
	@RequestMapping("del")
	public String del(String[] ids){
		boolean flag=fs.del(ids);
		return "redirect:query";
	}
	
	@RequestMapping("toUpdate")
	public ModelAndView toUpdate(String[] ids){
		ModelAndView mv=new ModelAndView();
		String id=ids[0];
		empDto emp=fs.queryById(id);
		mv.addObject("emp",emp);
		mv.setViewName("update");
		return mv;
	}
	
	@RequestMapping("update")
	public String update(empDto emp,MultipartFile img,HttpServletRequest req){
		boolean flag=fs.update(emp, req, img);
		if(flag){
			return "redirect:query";
		}else{
			return "update";
		}
		
	}
	
	@RequestMapping("add")
	public String add(empDto emp,HttpServletRequest req,MultipartFile img){
		boolean flag=fs.add(emp, req, img);
		if(flag){
			return "redirect:query";
		}else{
			return "add";
		}
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3) {
		ModelAndView mv = new ModelAndView();
		if(arg3 instanceof MaxUploadSizeExceededException){
			mv.setViewName("add");
			return mv;
		}else{
			return null;
		}
	}
	
	
}
