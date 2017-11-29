package com.wzx.dao;

import java.util.List;
import java.util.Map;

import com.wzx.dto.BrandDto;
import com.wzx.dto.CarDto;
import com.wzx.dto.FenYe;

public interface CarDao {
	public List<CarDto> list(FenYe fy);
	public int rowCount(Map<String, Object> map);
	public int del(int id);
	public CarDto check(int id);
	public List<BrandDto> brands();
	public int add(CarDto car);
}
