package com.wzx.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wzx.dao.RoleDao;
import com.wzx.dto.Role;
import com.wzx.service.inter.IRoleService;
import com.wzx.util.SqlSessionUtil;

public class RoleService implements IRoleService{
	private RoleDao rd;
	@Override
	public Role getRole(int i) {
		SqlSession ss=SqlSessionUtil.init().getSs();
		rd=ss.getMapper(RoleDao.class);
		Role re=rd.getRole(i);
		ss.close();
		return re;
	}

	
}
