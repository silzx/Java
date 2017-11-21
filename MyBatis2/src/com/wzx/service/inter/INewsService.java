package com.wzx.service.inter;

import java.util.List;
import java.util.Map;

import com.wzx.dto.FenYe;
import com.wzx.dto.NewsDto;

public interface INewsService {
	public int delNews(int id);
	public List<NewsDto> queryNews(FenYe fy);
	public int addNews(NewsDto n);
	public int rowCount(Map<String, Object> map);
	public int update(NewsDto n);
	public NewsDto queryById(int id);
}
