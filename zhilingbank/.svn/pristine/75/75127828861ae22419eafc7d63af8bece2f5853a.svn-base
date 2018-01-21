package com.zl.util;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author 黄超
 *		   redis连接池工具类
 *			已测试成功
 */
public class RedisUtil {
	
	//redis连接池对象
	private JedisPool jp=null;
	
	//redis连接池配置对象
	private JedisPoolConfig jpc=null;
	
	private static RedisUtil ru=new RedisUtil();
	private RedisUtil(){
		jpc=new JedisPoolConfig();
		jpc.setMaxIdle(8);		//最大空闲连接
		jpc.setMaxTotal(100); 	//最大连接数
		jpc.setMaxWaitMillis(10000); 	//最长等待连接时间
		jpc.setTestOnBorrow(true);		//保证获得连接都可能
		jp=new JedisPool(jpc,"192.168.188.41",6379);		//创建连接池对象
	}
	
	//返回数据库连接
	public Jedis getRedis(){
		return jp.getResource();
	}
	
	public static RedisUtil initRedis(){
		return ru;
	}
	
	
}
