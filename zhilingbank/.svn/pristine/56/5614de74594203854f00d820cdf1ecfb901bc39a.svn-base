package com.zl.tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.security.*;

import javax.crypto.*;
import javax.crypto.spec.*;

import java.security.spec.X509EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;

import javax.crypto.Cipher;
import javax.servlet.http.HttpServletRequest;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

//rsa 公钥 和私钥的生成
//公钥 e 用来加密，私钥 d 用来解密。
@SuppressWarnings("unused")
public class rsa {
	/**
	 * @author:姚彬彬
	 * @Description:rsa加密解密工具类
	 */

	public static final String KEY_ALGORITHM = "RSA";
	public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
	private static final String PUBLIC_KEY = "RSAPublicKey";
	private static final String PRIVATE_KEY = "RSAPrivateKey";
	static rsa r = new rsa();



	/** * 
	@author    姚彬彬 
	@date      2018年1月9日 下午3:09:04   
	@describe  数据加密
	*/
	public String getEncrypt(String source) throws Exception {
		String PbKey = r.PuYey();
		/** 将文件中的公钥对象读出 */

		// System.err.println("myBuilderStr :  length:" + getPbKey.length() +
		// "  公钥: "
		// + getPbKey);
		BASE64Decoder b64d = new BASE64Decoder();
		byte[] keyByte = b64d.decodeBuffer(PbKey);
		X509EncodedKeySpec x509ek = new X509EncodedKeySpec(keyByte);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(x509ek);

		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] sbt = source.getBytes();
		byte[] epByte = cipher.doFinal(sbt);
		BASE64Encoder encoder = new BASE64Encoder();
		String epStr = encoder.encode(epByte);
		return epStr;

	}

	
	/** * 
	@author    姚彬彬 
	@date      2018年1月9日 下午3:09:14   
	@describe  数据解密
	*/
	public static String getDecrypt(String cryptograph, String PvKey) throws Exception {
		HttpServletRequest request = null;


		if (PvKey == null || PvKey.equals("")) {
			PvKey = r.PeYey();
		}
		BASE64Decoder b64d = new BASE64Decoder();
		byte[] keyByte = b64d.decodeBuffer(PvKey);
		PKCS8EncodedKeySpec s8ek = new PKCS8EncodedKeySpec(keyByte);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = keyFactory.generatePrivate(s8ek);


		/** 得到Cipher对象对已用公钥加密的数据进行RSA解密 */

		Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding"); //或者换 RSA/ECB/NoPadding

//		Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");

		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] b1 = decoder.decodeBuffer(cryptograph);
		/** 执行解密操作 */
		byte[] b = cipher.doFinal(b1);
		return new String(b);
	}

	/** * 
	@author    姚彬彬 
	@date      2018年1月9日 下午3:09:46   
	@describe  获取文本内容私钥
	*/
	public static String PeYey() throws IOException {
		String key = "";
		FileReader fr = null;
		//获取项目路径
		File directory = new File("");
		String courseFile = directory.getCanonicalPath();
		try {
			//得到绝对路径
			fr = new FileReader(courseFile+"/src/main/resources/privateKey");
			// 调用read方法输出到控制台上
			int len = 0;
			try {
				while ((len = fr.read()) != -1) {

					key += (char) len;

				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return key;
	}

	/** * 
	@author    姚彬彬 
	@date      2018年1月9日 下午3:10:19   
	@describe  获取文本内容公钥
	*/
	public static String PuYey() throws IOException {
		String key = "";
		FileReader fr = null;
		//获取项目路径
		File directory = new File("");
		String courseFile = directory.getCanonicalPath();
		try {
			//得到绝对路径
			fr = new FileReader(courseFile+"/src/main/resources/publicKey");

			// 调用read方法输出到控制台上
			int len = 0;
			try {
				while ((len = fr.read()) != -1) {
					// if((char) len!="\n"){
					key += (char) len;
					// }

				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return key;
	}
	

	
	
	
}