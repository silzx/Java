package com.wzx.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wzx.dao.CarDao;
import com.wzx.dto.BrandDto;
import com.wzx.dto.CarDto;
import com.wzx.dto.FenYe;
import com.wzx.service.inter.ICarService;
import com.wzx.util.SqlSessionUtil;

public class CarService implements ICarService{
	private CarDao cd;
	@Override
	public List<CarDto> list(FenYe fy) {
		SqlSession ss=SqlSessionUtil.init().getSs();
		cd=ss.getMapper(CarDao.class);
		List<CarDto> cars=cd.list(fy);
		ss.close();
		return cars;
	}
	@Override
	public int rowCount(Map<String, Object> map) {
		SqlSession ss=SqlSessionUtil.init().getSs();
		cd=ss.getMapper(CarDao.class);
		int i=cd.rowCount(map);
		ss.close();
		return i;
	}
	@Override
	public int del(int id) {
		SqlSession ss=SqlSessionUtil.init().getSs();
		cd=ss.getMapper(CarDao.class);
		int i=cd.del(id);
		ss.commit();
		ss.close();
		return i;
	}
	@Override
	public CarDto check(int id) {
		SqlSession ss=SqlSessionUtil.init().getSs();
		cd=ss.getMapper(CarDao.class);
		CarDto car=cd.check(id);
		ss.close();
		return car;
	}
	@Override
	public List<BrandDto> brands() {
		SqlSession ss=SqlSessionUtil.init().getSs();
		cd=ss.getMapper(CarDao.class);
		List<BrandDto> brands=cd.brands();
		ss.close();
		return brands;
	}
	@Override
	public int add(CarDto car) {
		SqlSession ss=SqlSessionUtil.init().getSs();
		cd=ss.getMapper(CarDao.class);
		int i=cd.add(car);
		ss.commit();
		ss.close();
		return i;
	}

}
