package com.wzx.dao;

import java.util.List;

import com.wzx.dto.Role;

public interface RoleDao {
	public List<Role> queryAllRole();
	public Role getRole(int i);
}
