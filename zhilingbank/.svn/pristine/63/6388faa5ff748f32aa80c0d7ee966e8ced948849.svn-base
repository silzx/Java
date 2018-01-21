package com.zl.util;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.zl.pojo.TradeRecord;

/**
 * @author redis工具类
 *
 */
@Component
public class RedisTool {
	@Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valOpsStr;		//可以设置String key-value对


    @Autowired
    RedisTemplate<Object, Object> redisTemplate;


    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> valOpsObj;		//可以设置Object key-value对
    
	
	RedisTemplate<String, Object> rt;
	
	/**
	 * @title:setRedisObject
	 * @author:黄超
	 * @Description:把对象存入redis	
	 */
	public void setRedisObject(String key ,Object value){
		valOpsObj.set(key, value);
	}	
	
	/**
	 * @title:getRedisObject
	 * @author:黄超
	 * @Description:从redis取出对象	
	 */
	public Object getRedisObject(String key){
 		Object object=valOpsObj.get(key);
		return object;
	}
	

	public void setKey(){
		valOpsObj.set("k6", "v6");
		System.out.println("设置中");
		List<TradeRecord> lists=(List<TradeRecord>) valOpsObj.get("shieryue");
		if(lists!=null){
			System.out.println("查询成功");
			System.out.println(lists.size());
		}else{
			System.out.println("查询失败");
		}
	} 

	
	/*public void setKey(){
		valOpsObj.set("k6", "v6");
		System.out.println("设置中");
		System.out.println(valOpsObj.get("k6"));
		List<TradeRecord> lists=(List<TradeRecord>) valOpsObj.get("december");
		if(lists!=null){
			System.out.println("查询成功");
			System.out.println(lists.size());
		}else{
			System.out.println("查询失败");
		}
	}*/
}
