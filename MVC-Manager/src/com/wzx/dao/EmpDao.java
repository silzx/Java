package com.wzx.dao;

import com.wzx.dto.empDto;

public interface EmpDao {
	/**  
	* @Title: login  
	* @Description: 登录方法
	* @throws 
	* @date 2017年12月7日 下午5:45:16 
	*/ 
	empDto login(empDto emp);
}
