package com.zl.service.inter;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zl.pojo.Erecord;

/**
* @author 作者 :陈强
* @version 创建时间：2018年1月12日 下午3:39:11
* 类说明
*/
public interface ErecordService {
		//添加员工登录 和退出记录
		public int addLogintime(Erecord e);
		//查询所有员工最近一次记录
		public List<Erecord> QueryRecord(int pageno,int count);
		//查询员工第几次登录和最后登录时间		
		public int gettotal(String empid);		
		public Erecord getere(String empid);
		//查询所有员工最近一次记录的总数
		public int getCount();
		//查询某人员工的所有记录 按时间降序
		public List<Erecord> QueryRecordById(String empid);
		//查询某人最近一条记录
		public Erecord QueryRecordByEmpid(String empid);
		//修改某人的退出记录
		public int UpdateLogout(Erecord ere);
}
