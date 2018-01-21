package com.zl.util;


import org.apache.commons.codec.digest.DigestUtils;
/**
 * @author：汪泽轩
 * @Description: MD5加密   
 * @Date:2018年1月4日下午7:45:49   
 */
public class MD5Util {
    
    /**
     *固定salt值
     */
    private static final String salt = "0z9x8c7v6b5n4m";
    
    /**   
     * @Title: md5   
     * @author：汪泽轩
     * @Description: MD5加密               
     */
    public static String md5(String code){
    	return DigestUtils.md5Hex(code);
    }
    
    
    /**   
     * @Title: inputToForm   
     * @author：汪泽轩
     * @Description: 用户表单输入的密码加盐MD5加密              
     */
    public static String inputToForm(String input){
    	String str = "" + salt.charAt(0)+salt.charAt(2)+salt.charAt(4)+input+salt.charAt(5)+
    			salt.charAt(13)+salt.charAt(12)+salt.charAt(11)+salt.charAt(10)+salt.charAt(9);
    	return md5(str);
    }
    
    /**   
     * @Title: formToDataBases   
     * @author：汪泽轩
     * @Description: 表单存储到数据库的值加盐MD5加密               
     */
    public static String formToDataBases(String str, String dbSalt){
    	return md5(str+dbSalt);
    }
    
    /**   
     * @Title: inputToDataBases   
     * @author：汪泽轩
     * @Description: 入参：用户页面输入的值，随机盐值;返回存入数据库的加密值              
     */
    public static String inputToDataBases(String input, String dbSalt){
    	String ss = inputToForm(input);
    	String sss = formToDataBases(ss, dbSalt);
    	return sss;
    }
    
    /**   
     * @Title: randomSalt   
     * @author：汪泽轩
     * @Description: 生成二次加密所需的随机salt               
     */
    public static String randomSalt(){
		String chars = "abcdefghijklmnopqrstuvwxyz123456789";
		String randomNum="";
		for (int i = 0; i < 6; i++) {
			char b = chars.charAt((int)(Math.random() * 26));
			chars = chars.replace(String.valueOf(b), "");
			randomNum += String.valueOf(b);
		}
		return randomNum;
	}
}
