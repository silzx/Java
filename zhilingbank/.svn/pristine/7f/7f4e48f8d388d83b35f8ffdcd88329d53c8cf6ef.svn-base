package zl_Test;

import java.io.File;
import java.io.IOException;



import org.junit.Test;

import com.zl.tool.RsaSignature;
import com.zl.tool.rsa;

/**
 * *
 * 
 * @author 姚彬彬
 * @date 2018年1月13日 上午10:14:13
 * @describe
 */
public class T1 {

	//加密解密过程
	@Test
	public void TestRsa() throws Exception {
		rsa r = new rsa();

		String inputStr = "12345";

		String strA = r.getEncrypt(inputStr);
		System.out.println("数据加密数据：" + strA);

		String strB = r.getDecrypt(strA, "");
		System.out.println("数据解密数据：" + strB);

		
		
		
		File directory = new File("");
		String courseFile = directory.getCanonicalPath();
	}
	
	
	
	//签名解签名过程
	//一般情况下我们会base64成一个字符串，方便传输。这样的字符串就是数字签名了。
    //服务器端只需要用对应的公钥进行验签就可以判断出是不是秘钥持有者发送的消息了。
	@Test
	public void TestQm() throws IOException{
		    rsa r = new rsa();
		
		
		    System.out.println("---------------私钥签名过程------------------");  
	        String content="需要签名的数据10086";  
	        //对数据进行签名
	        String signstr=RsaSignature.sign(content,r.PeYey());  
	        System.out.println("签名原串："+content);  
	        System.out.println("签名串："+signstr);  
	        System.out.println();  
	          
	        System.out.println("---------------公钥校验签名------------------");  
	        System.out.println("签名原串："+content);  
	        System.out.println("签名串："+signstr);  
	        //验证签名   
	        
	        System.out.println("验签结果："+RsaSignature.doCheck(content, signstr, r.PuYey()));  
	        System.out.println();  
	}
	
	
	
}
