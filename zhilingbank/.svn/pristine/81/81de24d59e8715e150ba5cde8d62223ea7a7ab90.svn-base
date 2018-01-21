package com.zl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TimeUtil {
	public static Date getTime() throws ParseException{
		String datePattern="yyyy年MM月dd日";
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
		String a = sdf.format(date);
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日"); 
		return sdf2.parse(a); 
	}
	
}
