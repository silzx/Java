package com.wzx.util;

import com.opensymphony.xwork2.ActionSupport;
import com.wzx.dto.Power;
import com.wzx.dto.UserDto;
import com.wzx.service.UserService;
import com.wzx.service.inter.IUserService;

public class Test extends ActionSupport{
	public  static void main(String[] args) {
		IUserService us=new UserService();
		UserDto u=new UserDto();
		u.setName("tianhe");
		u.setPwd("123");
		u=us.login(u);
		System.out.println(u.getName()+"是"+u.getRole().getRname()+",权限是");
		for(Power p:u.getRole().getPower()){
			System.out.println(p.getPname());
		}
		
	}

}
