package com.zl.tool;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.security.*;

import javax.crypto.*;
import javax.crypto.spec.*;

import java.security.spec.X509EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;

import javax.crypto.Cipher;


import java.security.Key;
import java.util.Map;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class rsaKey {
	
	/**
	 * @author:姚彬彬
	 * @Description:rsa秘钥生成工具
	 */
	
	public static final String KEY_ALGORITHM = "RSA";
	public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
	private static final String PUBLIC_KEY = "RSAPublicKey";
	private static final String PRIVATE_KEY = "RSAPrivateKey";
	static String publicKey = null;
	static String privateKey = null;

	
	/** * 
	@author    姚彬彬 
	@date      2018年1月9日 下午3:10:47   
	@describe  调用方法生成秘钥并且存入文档
	*/
	public static Map<String,String> getKey(){
		Map<String, Object> keyMap;
		Map<String,String> keyPair=new HashMap<String, String>();
		try {
			keyMap = initKey();
			publicKey = getPublicKey(keyMap);// 公钥
//			System.out.println("公钥: " + publicKey);
//			System.out.println("公钥长度: " + publicKey.length());
			privateKey = getPrivateKey(keyMap);// 私钥
//			System.out.println("私钥: " + privateKey);
//			System.out.println("私钥长度: " + privateKey.length());
			//获取路径并且拼接
			File directory = new File("");
			String courseFile = directory.getCanonicalPath();
			TextToFile(courseFile+"/src/main/resources/publicKey",publicKey);
			TextToFile(courseFile+"/src/main/resources/privateKey",privateKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		keyPair.put("pubKey", publicKey);
		keyPair.put("priKey", privateKey);
		return keyPair;
	}
	

	public static Map<String, Object> initKey() throws Exception {
		KeyPairGenerator keyPairGen = KeyPairGenerator
				.getInstance(KEY_ALGORITHM);
		keyPairGen.initialize(1024);
		KeyPair keyPair = keyPairGen.generateKeyPair();
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		Map<String, Object> keyMap = new HashMap<String, Object>(2);
		keyMap.put(PUBLIC_KEY, publicKey);
		keyMap.put(PRIVATE_KEY, privateKey);
		return keyMap;
	}

	// 生成私钥和公钥
	public static String getPublicKey(Map<String, Object> keyMap)
			throws Exception {
		Key key = (Key) keyMap.get(PUBLIC_KEY);
		byte[] publicKey = key.getEncoded();
		return encryptBASE64(key.getEncoded());
	}

	// 生成私钥
	public static String getPrivateKey(Map<String, Object> keyMap)
			throws Exception {
		Key key = (Key) keyMap.get(PRIVATE_KEY);
		byte[] privateKey = key.getEncoded();
		return encryptBASE64(key.getEncoded());
	}
	
	/**
	 * @title:getKeyPair
	 * @author:黄超
	 * @Description:生成秘钥对	
	 */
	public static KeyPair getKeyPair() throws Exception{
		//keyPairGenerator类用于生成秘钥对，基于RSA算法生成对象
		KeyPairGenerator keyPairGen=null;
		keyPairGen=KeyPairGenerator.getInstance("RSA");	//创建RSA秘钥生成类对象
		keyPairGen.initialize(1024,new SecureRandom());		//初始化生成类大小 随机
		//生成秘钥对
		KeyPair keyPair=keyPairGen.generateKeyPair();
		return keyPair;
	}

	public static byte[] decryptBASE64(String key) throws Exception {
		return (new BASE64Decoder()).decodeBuffer(key);
	}

	public static String encryptBASE64(byte[] key) throws Exception {
		return (new BASE64Encoder()).encodeBuffer(key);
	}

	// 生成公私钥文档
	 public static void TextToFile(final String strFilename, final String strBuffer)  
	  {  
	    try  
	    {      
	      // 创建文件对象  
	      File fileText = new File(strFilename);  
	      // 向文件写入对象写入信息  
	      FileWriter fileWriter = new FileWriter(fileText);  
	  
	      // 写文件        
	      fileWriter.write(strBuffer);  
	      // 关闭  
	      fileWriter.close();  
	    }  
	    catch (IOException e)  
	    {  
	      //  
	      e.printStackTrace();  
	    }  
	  } 

	 
	 
}
