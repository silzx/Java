package com.wzx.util;


import java.util.Set;

import redis.clients.jedis.Jedis;

public class JedisTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jedis je=new Jedis("localhost");
		je.set("redis-key", "redis-value");
		Set<String> keys=je.keys("*");
		je.append("redis-key", "append value");
		System.out.println(je.get("redis-key")+keys);
	}
}
