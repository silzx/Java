package com.wzx.dao;

import com.wzx.dto.UserDto;

public interface UserDao {
	public UserDto login(UserDto u);
	public int reg(UserDto u);
	public UserDto regName(String name);
}
