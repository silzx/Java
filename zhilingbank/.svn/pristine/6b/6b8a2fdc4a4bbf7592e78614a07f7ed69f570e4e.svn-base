package com.zl.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.NoArgsConstructor;

/**
 * @author：汪泽轩
 * @Description: 生成交易编号；格式为：时间戳+zl+10位uuid   
 * @Date:2018年1月7日上午11:48:13   
 */

@NoArgsConstructor
public final class TradeNum {
	
	public static String catchTradeNum(){
		String datePattern="yyyy-MM-dd HH:mm:ss";
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
		String timeStamp = sdf.format(date);
		String time = timeStamp.replace("-", "").replace(":", "").replace(" ", "");
		return time+"zl"+Uuid.getUuid().substring(22);
	}
}
