package com.wzx.dao;

import java.util.List;
import java.util.Map;

import com.wzx.dto.FenYe;
import com.wzx.dto.NewsDto;

public interface NewsDao {
	public int delNews(int id);
	public List<NewsDto> queryNews(FenYe fy);
	public int addNews(NewsDto n);
	public int rowCount(Map<String,Object> map);
	public int update(NewsDto u);
	public NewsDto queryById(int id);
}
