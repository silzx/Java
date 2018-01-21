package com.test.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author：汪泽轩
 * @Description: TODO(产生交易编码，产生机制为：随机为精确到秒日期+随机四位数)   
 * @Date:2018年1月14日下午4:35:04   
 * 
 */
public class TradeNum {

	public static String getTradeNum(){		//产生新的订单编号
		
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
		String dateSt=sdf.format(date);
		Random rd=new Random();
		int num=rd.nextInt(89999)+10000;
		return dateSt+num;
	}
	
}
