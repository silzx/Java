package com.wzx.dao;

import java.util.List;

import com.wzx.dto.powerDto;

public interface PowerDao {
	powerDto querypower(int pid);
	List<powerDto> powers();
}
