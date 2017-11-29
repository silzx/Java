package com.wzx.action;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.wzx.dto.UserDto;
import com.wzx.service.UserService;
import com.wzx.service.inter.IUserService;

public class UserAction extends ActionSupport implements SessionAware{
	private UserDto u;
	private Map<String, Object> session=new HashMap<String, Object>();
	private IUserService us=new UserService();
	public String login(){
		UserDto user=us.login(u);
		try {
			if (user != null) {
				Cookie nameC = new Cookie("nameC", URLEncoder.encode(user.getName(), "utf-8"));
				Cookie pwdC = new Cookie("pwdC", user.getPwd());
				// 设置cookie失效时间
				nameC.setMaxAge(24 * 60 * 60);
				pwdC.setMaxAge(24 * 60 * 60);
				// 设置cookie保存路径
				nameC.setPath("/Mybatis-Struts-Test");
				pwdC.setPath("/Mybatis-Struts-Test");
				// 放到相应对象中
				ServletActionContext.getResponse().addCookie(nameC);
				ServletActionContext.getResponse().addCookie(pwdC);
				session.put("user", user);
				session.put("mes", true);
			} else {
				session.put("error", "账号或者密码错误");
				session.put("mes", false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "login";
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	public UserDto getU() {
		return u;
	}
	public void setU(UserDto u) {
		this.u = u;
	}
	
	
}
