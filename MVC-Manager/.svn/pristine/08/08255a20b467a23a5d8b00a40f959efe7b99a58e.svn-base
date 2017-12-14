package com.wzx.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wzx.dto.deptDto;
import com.wzx.dto.empDto;
import com.wzx.dto.powerDto;
import com.wzx.service.IDeptService;
import com.wzx.service.IEmpService;
import com.wzx.service.IPowerService;

@Controller
@Scope("prototype")
@RequestMapping("emp")
public class EmpController {
	@Autowired
	private IEmpService es;
	@Autowired
	private IPowerService ps;
	@Autowired
	private IDeptService ds;
	@RequestMapping("login")
	public @ResponseBody Map login(empDto emp,HttpServletRequest req,HttpServletResponse res) throws Exception{
		emp=es.login(emp);
		List<deptDto> depts=ds.depts();
		List<powerDto> powers=ps.powers();
		Map<String, Object> session=new HashMap<String, Object>();
		if(emp!=null){
			Cookie nameC = new Cookie("nameC", URLEncoder.encode(
					emp.getEname(), "utf-8"));
			Cookie pwdC = new Cookie("pwdC", emp.getEpwd());
			// 设置cookie失效时间
			nameC.setMaxAge(24 * 60 * 60);
			pwdC.setMaxAge(24 * 60 * 60);
			// 设置cookie保存路径
			nameC.setPath("/MVC-Manager");
			pwdC.setPath("/MVC-Manager");
			// 放到相应对象中
			res.addCookie(nameC);
			res.addCookie(pwdC);
			req.getSession().setAttribute("emp", emp);
			req.getSession().setAttribute("depts", depts);
			req.getSession().setAttribute("powers", powers);
			session.put("mes", true);
		}else{
			session.put("mes", false);
		}
		return session;
	}

	@RequestMapping("exit")
	public String exit(HttpServletRequest req){
		req.getSession().invalidate();
		return "redirect:/index.jsp";
	}
}
