package com.zl.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.NoArgsConstructor;

/**
 * @author：汪泽轩
 * @Description: 生成客户编号；格式为：zlyh+年月日+随机三位不重复字母数字   
 * @Date:2018年1月8日上午9:48:07   
 */
@NoArgsConstructor
public class CustomerNum {
	
	public static String catchCustomerNum(){
		String datePattern="yyyy-MM-dd";
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
		String a = sdf.format(date);
		String chars = "abcdefghijklmnopqrstuvwxyz123456789";
		String randomNum="";
		for (int i = 0; i < 3; i++) {
			char b = chars.charAt((int)(Math.random() * 26));
			chars = chars.replace(String.valueOf(b), "");
			randomNum += String.valueOf(b);
		}
		return ("zlyh"+a+randomNum).replace("-", "");
	}
	
}
