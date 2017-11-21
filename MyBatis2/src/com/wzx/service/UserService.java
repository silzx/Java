package com.wzx.service;

import org.apache.ibatis.session.SqlSession;

import com.wzx.dao.UserDao;
import com.wzx.dto.UserDto;
import com.wzx.service.inter.IUserService;
import com.wzx.util.SqlSessionUtil;

public class UserService implements IUserService{
	private UserDao ud;
	@Override
	public UserDto login(UserDto u) {
		SqlSession ss=SqlSessionUtil.init().getSs();
		ud=ss.getMapper(UserDao.class);
		UserDto user=ud.login(u);
		ss.close();
		return user;
	}
	@Override
	public int reg(UserDto u) {
		SqlSession ss=SqlSessionUtil.init().getSs();
		ud=ss.getMapper(UserDao.class);
		int i=ud.reg(u);
		ss.commit();
		ss.close();
		return i;
	}
	@Override
	public UserDto regName(String name) {
		SqlSession ss=SqlSessionUtil.init().getSs();
		ud=ss.getMapper(UserDao.class);
		UserDto u=ud.regName(name);
		ss.close();
		return u;
	}
	
	
	
}
