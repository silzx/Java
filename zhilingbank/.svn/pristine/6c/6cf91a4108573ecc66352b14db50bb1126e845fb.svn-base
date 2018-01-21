package com.zl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.zl.pojo.Emp;
import com.zl.pojo.Erecord;
import com.zl.service.inter.CardAuditSystem;
import com.zl.service.inter.ErecordService;
import com.zl.tool.Idcard;
import com.zl.util.CustomerInfoUtil;
import com.zl.util.EmployeeNumUtil;
import com.zl.util.MD5Util;

@Controller
@RequestMapping("/after")
public class EmpController {
	@Autowired
	private CardAuditSystem cs;
	@Autowired
	private ErecordService er;

	/**
	 * *
	 * 
	 * @author 姚彬彬
	 * @date 2018年1月12日 下午9:26:46
	 * @describe 启始页面
	 */

	@RequestMapping("af")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/after/login");
		return mv;
	}

	/**
	 * *
	 * 
	 * @author 姚彬彬
	 * @date 2018年1月12日 下午9:26:46
	 * @describe 传值emp
	 */
	@RequestMapping("emp")
	public void emp(HttpServletRequest request, HttpServletResponse response) {
		try {

			Emp emp = (Emp) request.getSession().getAttribute("loginemp");

			String str = JSONObject.toJSONString(emp);
			response.getWriter().write(str);
		} catch (Exception e) {

		}

	}

	/**
	 * *
	 * 
	 * @author 姚彬彬
	 * @date 2018年1月12日 下午9:26:46
	 * @describe 注销用户
	 */
	@RequestMapping("cancellation")
	public ModelAndView cancellation(HttpSession sess) {
		ModelAndView mv = new ModelAndView();
		Emp emp = (Emp) sess.getAttribute("loginemp");
		if (emp != null) {
			
			Erecord ere = new Erecord();
			ere = er.QueryRecordByEmpid(emp.getEmpid());
			Timestamp d = new Timestamp(System.currentTimeMillis());
			ere.setLogouttime(d);
			ere.setDid(emp.getDept().getDid());
			ere.setPid(emp.getPos().getPid());
			er.UpdateLogout(ere);
		}
		sess.removeAttribute("loginemp");
		mv.setViewName("/after/login");
		return mv;
	}

	/**
	 * *
	 * 
	 * @author 姚彬彬
	 * @date 2018年1月12日 下午9:26:46
	 * @describe 管理首页
	 */
	@RequestMapping("main")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("/after/employees/main");
		return mv;
	}

	@RequestMapping("maininfo")
	public ModelAndView mainInfo() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("/after/employees/main_info");
		return mv;
	}

	/**
	 * *
	 * 
	 * @author 姚彬彬
	 * @date 2018年1月12日 下午9:26:46
	 * @describe 添加员工基本信息
	 */
	@RequestMapping("add")
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("/after/employees/add");
		return mv;
	}
	@RequestMapping("/ValidationIdcard")
	public void QueryidCard(String idCard,HttpServletResponse response) throws Exception {
		String str=JSONObject.toJSONString(Idcard.ValidationIdcard(idCard));
		response.getWriter().write(str);
	}
	/**
	 * @title:adminlogin
	 * @author:陈强
	 * @Description:员工登录
	 */
	@RequestMapping("/login")
	public ModelAndView login(String account, String pwd, HttpSession s) {
		ModelAndView mv = new ModelAndView();
		Emp e = cs.empLogin(account, pwd);
		if (e != null) {
			Erecord ere = new Erecord();
			ere.setEmpid(e.getEmpid());
			ere.setDid(e.getDept().getDid());
			ere.setPid(e.getPos().getPid());
			Timestamp d = new Timestamp(System.currentTimeMillis());
			ere.setLogintime(d);
			int i = er.addLogintime(ere);
			s.setAttribute("loginemp", e);
			mv.setViewName("after/index");
			// 登录记录
			int to = er.gettotal(e.getEmpid());
			Erecord ereco = er.getere(e.getEmpid());
			s.setAttribute("to", to);
			s.setAttribute("ereco", ereco);
		} else {
			s.setAttribute("loginemp", null);
			mv.setViewName("after/login");
		}

		return mv;
	}

	/**
	 * @title:saveinfo
	 * @author:陈强
	 * @Description:数据保存及生成其他字段值的操作
	 */
	@RequestMapping("/saveinfo")
	public ModelAndView saveinfo(Emp em, HttpSession s) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("after/employees/main_info");
		String idCard = em.getIdCard();
		// 通过idCard得到性别和年龄
		int age = CustomerInfoUtil.getCustomerAge(idCard);
		String sex = CustomerInfoUtil.getCustomerGender(idCard);
		em.setAge(age);
		em.setSex(sex);
		// 生成empid
		int did = 1;
		String empid = EmployeeNumUtil.getEmployeeNum(did);
		em.setEmpid(empid);
		em.setDid(did);
		s.setAttribute("info", em);
		return mv;
	}

	/**
	 * @title:queryaccount
	 * @author:陈强
	 * @Description:管理员验证用户名是否存在
	 */
	@RequestMapping("/queryemp")
	public void queryaccount(String account, HttpServletResponse response)
			throws Exception {
		boolean ok = cs.queryuser(account);
		if (ok == true) {
			response.getWriter().write("success");
		} else {
			response.getWriter().write("error");
		}

	}

	/**
	 * @title:addEmp
	 * @author:陈强
	 * @Description:管理员添加员工详细信息并授权
	 */

	@RequestMapping("/addEmp")
	public ModelAndView addemp(Emp em, HttpSession s) {
		ModelAndView mv = new ModelAndView();
		Emp e = (Emp) s.getAttribute("info");
		e.setSalt(MD5Util.randomSalt());
		e.setAccount(em.getAccount());
		e.setPwd(MD5Util.inputToDataBases(em.getPwd(), e.getSalt()));
		e.setPid(em.getPid());
		e.setJoindate(new Date());
		e.setState(0);
		int i = cs.adminAddEmp(e);
		if (i > 0) {
			mv.setViewName("redirect:adminQueryEmp");
		}
		return mv;
	}

	/**
	 * @title:showinfo
	 * @author:陈强
	 * @Description:显示员工信息
	 */
	@RequestMapping("/adminQueryEmp")
	public ModelAndView adminQueryEmp(
			@RequestParam(defaultValue = "") String account,
			@RequestParam(defaultValue = "1") int pageno, Model m) {
		int count = 5;
		ModelAndView mv = new ModelAndView();
		mv.setViewName("after/employees/main_list");
		int page = cs.getcount(account, count);
		if (pageno >= page) {
			pageno = page;
		}
		List<Emp> emp = cs.adminQueryEmp(account, pageno, count);
		m.addAttribute("emp", emp);
		m.addAttribute("pageno", pageno);
		m.addAttribute("page", page);
		m.addAttribute("account", account);
		return mv;
	}

	@RequestMapping("/showinfo")
	public ModelAndView showinfo(String empid, Model m, HttpSession s) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("after/employees/update");
		Emp e = cs.adminShowInfo(empid);
		s.setAttribute("empid", empid);
		m.addAttribute("e", e);
		return mv;
	}

	@RequestMapping("/updateEmp")
	public ModelAndView updateEmp(Emp e) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:adminQueryEmp");
		int i = cs.adminUpdateEmp(e);
		return mv;
	}

	@RequestMapping("/updatepwd")
	public ModelAndView updatepwd(String pwd, HttpSession s) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:adminQueryEmp");
		String empid = (String) s.getAttribute("empid");
		int i = cs.adminUpdatePwd(empid, pwd);
		return mv;
	}

	@RequestMapping("/deleteEmp")
	public ModelAndView deleteEmp(String empid) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:adminQueryEmp");
		cs.adminDeleteEmp(empid);
		return mv;
	}
}
