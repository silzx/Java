package com.wzx.service;

import org.apache.ibatis.session.SqlSession;

import com.wzx.dao.UserDao;
import com.wzx.dto.UserDto;
import com.wzx.service.inter.IUserService;
import com.wzx.util.SqlSessionUtil;

public class UserService implements IUserService{
	private UserDao ud;
	@Override
	public UserDto login(UserDto user) {
		SqlSession ss=SqlSessionUtil.init().getSs();
		ud=ss.getMapper(UserDao.class);
		UserDto u=ud.login(user);
		ss.close();
		return u;
	}

}
