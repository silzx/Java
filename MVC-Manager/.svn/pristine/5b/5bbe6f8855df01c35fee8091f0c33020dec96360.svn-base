package com.wzx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzx.dao.PowerDao;
import com.wzx.dto.powerDto;
import com.wzx.service.IPowerService;
@Service
public class PowersService implements IPowerService{
	@Autowired
	private PowerDao pd;
	@Override
	public List<powerDto> powers() {
		return pd.powers();
	}

}
