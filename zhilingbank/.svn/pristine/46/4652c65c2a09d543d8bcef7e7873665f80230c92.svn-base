package com.zl.util;

import lombok.NoArgsConstructor;

/**
 * @author：汪泽轩
 * @Description: 卡片背后7位数字   
 * @Date:2018年1月8日上午9:59:00   
 */
@NoArgsConstructor
public final class Cvv2 {
	/**   
	 * @Title: catchCvv2   
	 * @author：汪泽轩
	 * @Description: 生成卡片背后4位数+CVV2码；入参：卡号               
	 */
	private static String cvv2=null;
	public static String catchCvv2(String cardNum){
		int num = (int)(Math.random()*900)+100;
		String lastNum = cardNum.replace(" ", "").substring(12);
		cvv2 = lastNum+" "+String.valueOf(num);
		return cvv2;
	}
	
	/**   
	 * @Title: splitCvv2   
	 * @author：汪泽轩
	 * @Description: CVV2码         
	 */
	public static String splitCvv2(){
		return cvv2.substring(5);
	}
}
