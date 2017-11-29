package com.wzx.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class SqlSessionUtil {
	private static SqlSessionUtil ssu=new SqlSessionUtil();
	private static InputStream is=null;
	SqlSessionFactory ssf=null;
	private SqlSessionUtil(){
		try {
			is = Resources.getResourceAsStream("SqlMapConfig.xml");
			ssf=new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public SqlSession getSs(){
		return ssf.openSession();
	}
	public static SqlSessionUtil init(){
		return ssu;
	}
	//关闭
	public void colse(SqlSession ss){
		if(ss!=null){
			ss.close();
		}
	}
	//提交
	public void commit(SqlSession ss){
		if(ss!=null){
			ss.commit();
		}
	}
	
}
