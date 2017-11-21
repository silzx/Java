package com.wzx.service.inter;

import com.wzx.dto.UserDto;

public interface IUserService {
	public UserDto login(UserDto u);
	public int reg(UserDto u);
	public UserDto regName(String name);
}
