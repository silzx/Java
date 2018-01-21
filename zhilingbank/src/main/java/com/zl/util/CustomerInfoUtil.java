package com.zl.util;

import java.util.Calendar;
import java.util.Date;


/**
 * @Title CustomerAgeUtil
 * @Author 谢文奇
 * @Date 2018年1月8日上午9:14:41 
 * @Description 获取用户的年龄和性别信息
 */
public class CustomerInfoUtil {
	
	/**
	 * @param 身份证号
	 * @return 性别
	 * @description 根据身份证号获取客户的性别
	 */
	public static String getCustomerGender(String cardID){
		
		//取得身份证号的第17位
		int sex = Integer.parseInt(cardID.substring(16, 17));
		
		if(sex % 2 == 0){
			return "女";
		}
		
		return "男";
	}
	
	
	/**
	 * @param 身份证号
	 * @return 年龄
	 * @description 根据身份证号判断客户的年龄
	 */
	public static int getCustomerAge(String cardID){
		Calendar now = Calendar.getInstance();
		//获取当前年份，nowYear：当前年份
		int nowYear = now.get(Calendar.YEAR);
		//获取身份证中出生年份，birthYear：出生年份
		int birthYear = Integer.parseInt(cardID.substring(6, 10));
		
		//age：客户年龄
		int age = nowYear - birthYear;
		
		/*
		 * 获取客户生日的具体月份和日期
		 * 根据具体出生日期判断是否已过生日
		 * 如果过了生日，年龄就是当前年份减去出生年份
		 * 没过生日，年龄是当前年份减去出生年份再减一
		 */
		int nowMonth = now.get(Calendar.MONTH)+1;//当前月份
		int nowDay = now.get(Calendar.DAY_OF_MONTH);//当前日期
		int birthMonth = Integer.parseInt(cardID.substring(10, 12));//出生月份
		int birthDay = Integer.parseInt(cardID.substring(12, 14));//出生日期
		//判断是否已过生日
		if(nowMonth >= birthMonth && nowDay >= birthDay){
			return age;
		}else{
			return age-1;//还没过生日
		}
	}

}
