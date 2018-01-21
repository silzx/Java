package com.zl.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.sql.ast.expr.SQLCaseExpr.Item;

import com.zl.dao.ErecordDao;
import com.zl.pojo.Erecord;
import com.zl.service.inter.ErecordService;

/**
 * @author 作者 :陈强
 * @version 创建时间：2018年1月12日 下午3:40:55 类说明
 */
@Service
public class ErecordServiceImpl implements ErecordService {
	@Autowired
	private ErecordDao ed;

	@Override
	public int addLogintime(Erecord e) {

		return ed.addLogintime(e);

	}

	@Override
	public List<Erecord> QueryRecord(int pageno,int count) {
		Integer totalPage=1;
		if(pageno<=1) {
			pageno=1;
		}
		Integer totalCount=ed.getCount();
		if(totalCount%count==0) {
			totalPage=totalCount/count;
		}else {
			totalPage=totalCount/count+1;
		}
		if(pageno>=totalPage) {
			pageno=totalPage;
		}
		
		return ed.QueryRecord((pageno-1)*count, count);

	}

	@Override
	public List<Erecord> QueryRecordById(String empid) {
		// TODO Auto-generated method stub
		return ed.QueryRecordById(empid);

	}

	@Override
	public Erecord QueryRecordByEmpid(String empid) {
		// TODO Auto-generated method stub
		return ed.QueryRecordByEmpid(empid);

	}

	@Override
	public int UpdateLogout(Erecord ere) {
		// TODO Auto-generated method stub
		return ed.UpdateLogout(ere);
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return ed.getCount();
		
	}

	@Override
	public int gettotal(String empid) {
		// TODO Auto-generated method stub
		return ed.gettotal(empid);
		
	}

	@Override
	public Erecord getere(String empid) {
		// TODO Auto-generated method stub
		return ed.getere(empid);
		
	}

}
