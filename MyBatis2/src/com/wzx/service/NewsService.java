package com.wzx.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wzx.dao.NewsDao;
import com.wzx.dto.FenYe;
import com.wzx.dto.NewsDto;
import com.wzx.service.inter.INewsService;
import com.wzx.util.SqlSessionUtil;

public class NewsService implements INewsService{
	private NewsDao nd;
	@Override
	public int delNews(int id) {
		SqlSession ss=SqlSessionUtil.init().getSs();
		nd=ss.getMapper(NewsDao.class);
		int i=nd.delNews(id);
		ss.commit();
		ss.close();
		return i;
	}

	@Override
	public List<NewsDto> queryNews(FenYe fy) {
		SqlSession ss=SqlSessionUtil.init().getSs();
		nd=ss.getMapper(NewsDao.class);
		List<NewsDto> news=nd.queryNews(FenYe.fy);
		ss.close();
		return news;
	}

	@Override
	public int addNews(NewsDto n) {
		SqlSession ss=SqlSessionUtil.init().getSs();
		nd=ss.getMapper(NewsDao.class);
		int i=nd.addNews(n);
		ss.commit();
		ss.close();
		return i;
	}

	@Override
	public int rowCount(Map<String, Object> map) {
		SqlSession ss=SqlSessionUtil.init().getSs();
		nd=ss.getMapper(NewsDao.class);
		int i=nd.rowCount(FenYe.search);
		ss.close();
		return i;
	}

	@Override
	public int update(NewsDto n) {
		SqlSession ss=SqlSessionUtil.init().getSs();
		nd=ss.getMapper(NewsDao.class);
		int i=nd.update(n);
		ss.commit();
		ss.close();
		return i;
	}

	@Override
	public NewsDto queryById(int id) {
		SqlSession ss=SqlSessionUtil.init().getSs();
		nd=ss.getMapper(NewsDao.class);
		NewsDto n=nd.queryById(id);
		ss.close();
		return n;
	}
}
