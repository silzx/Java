package com.zl.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import lombok.NoArgsConstructor;

/**
 * @author：汪泽轩
 * @Description: 卡片日期工具  
 * @Date:2018年1月8日上午10:30:44   
 */
@NoArgsConstructor
public class Expire {
	/**   
	 * @Title: catchExpire   
	 * @author：汪泽轩
	 * @Description: 根据入参获取过期时间，入参格式严格要求为：年/月/日              
	 */
	public static String catchExpire(String bornDate) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		Date d1 = sdf.parse(bornDate);
		Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(d1);
        rightNow.add(Calendar.YEAR, 5);// 日期+5年
        Date d2 = rightNow.getTime();
        String reStr = sdf.format(d2);
        return reStr;
	}
	
	public static void main(String[] args) {
		
	}
}
