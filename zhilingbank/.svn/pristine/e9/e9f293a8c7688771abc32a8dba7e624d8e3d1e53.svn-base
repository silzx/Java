package com.zl.util;

/**
 * @Title CreditCardUtil
 * @Author 谢文奇
 * @Date 2018年1月7日下午12:54:33 
 * @Description 生成信用卡号
 */
public class CreditCardUtil {
	
	/**
	 * @param 卡种编号
	 * @return 信用卡号
	 */
	public static String getCreditCardNum(String cardKind){
		String creditCardNum = null;//creditCardNum：卡号
		String cardType = "";
		
		if(cardKind.equals("0")){
			cardType ="0123";
		}else if(cardKind.equals("1")){
			cardType ="1234";
		}else if(cardKind.equals("2")){
			cardType ="2345";
		}else if(cardKind.equals("3")){
			cardType ="3456";
		}else if(cardKind.equals("4")){
			cardType ="4567";
		}else if(cardKind.equals("5")){
			cardType ="5678";
		}else if(cardKind.equals("6")){
			cardType ="6789";
		}else{
			cardType ="0123";
		}
		
		
		//生成卡号的最后四位随机数
		int random = (int) (Math.random() * (9999 - 1000 + 1)) + 1000;
		
		//卡号：62151300 + 四位卡种编号 + 四位随机数
		creditCardNum = "62151300" + cardType + random;
		
		return creditCardNum;
	}

}
