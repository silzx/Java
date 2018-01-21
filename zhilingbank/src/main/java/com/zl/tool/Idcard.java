package com.zl.tool;

import java.text.ParseException;

import com.zl.util.InitialidCard;
/**
* @author 作者 :陈强
* @version 创建时间：2018年1月10日 下午8:31:35
* 类说明  	身份证的各种方法接口
*/
public  class Idcard {
	//前台输入身份证初步验证其真实性
	public static String ValidationIdcard(String Idcard) throws Exception {
		//将身份证最后一位的x转换为大写，便于统一  
		Idcard = Idcard.toUpperCase();
		String str=InitialidCard.IDCardValidate(Idcard);		
		return str;
	}
	//身份证获取性别
	public static String GetSex(String idcard) {
		String str=InitialidCard.getSex(idcard);
		return str;
	}
	//身份证获取年龄
	public static int GetAge(String idcard) {
		int age=InitialidCard.getAge(idcard);
		return age;
	}
}
