package com.test.store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.interfaces.RSAPublicKey;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.pojo.MessageInfo;
import com.test.util.RsaSignature;
import com.test.util.TradeNum;
import com.test.util.rsa;


@Controller
@RequestMapping("client")
public class ClientSocket {
	
	
	@RequestMapping("getPubKey")
	@ResponseBody
	public Map<String,Object> getPubKey(HttpSession session) throws Exception{
		Map<String,Object> json=new HashMap<String, Object>();
		Socket socket = new Socket("localhost", 8888);
		OutputStream os=socket.getOutputStream();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
		bw.write("requestPubKey");		//发送获取公钥消息
		bw.flush();
		socket.shutdownOutput();		//发送数据，关闭输出流
		
		InputStream is=socket.getInputStream();
		String key="";
		int a=0;
		while((a=is.read())!=-1){
			key+=(char)a;
		}
		System.out.println("读取到的公钥为："+key);
		
		session.setAttribute("pubKey", key); 	//将publicKey存入到session
		json.put("mess", true);
		socket.shutdownInput();
		return json;		//根据是否收到数据返回结果
	}
	
	
	
	@RequestMapping("trade")
	@ResponseBody
	public Map<String,Object> creatClient(MessageInfo mi,HttpSession session) throws Exception{
		Map<String,Object> json = new HashMap<String, Object>();
		
		//从session中获取 publicKey字符串
		String pubKey=(String) session.getAttribute("pubKey");
		
		//获取传输过来的信息，将信息进行拼接
		Double money=mi.getPrice();
		String mon=String.format("%.2f", money);	//将double转为保留两位小数
		mon=mon.replace(".", "");	//去掉小数点
		while(mon.length()<9){		//位数不够前面
			mon=0+mon;
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String tradeNum=TradeNum.getTradeNum();
		String st=tradeNum+"|"+sdf.format(mi.getTradeDate())+"|"+mi.getCardNum()+"|"+mi.getPassword()+mi.getBackCode()+"|"+mon
				+"|"+mi.getStoreName()+"|"+mi.getPosNum()+"|"+mi.getTradeType();
		
		System.out.println("加密前的报文为："+st);
		//将需要传输的数据进行加密
		String enData=rsa.getEncrypt(st, pubKey);
		System.out.println("加密后为:"+enData);
		
		//签名加密
		File file=new File("D:\\wzx\\workspace\\zhilingstore\\src\\privateKey");
		FileReader fr=new FileReader(file);
		String str1="";
		int a=0;
		while((a=fr.read())!=-1){
			str1+=(char)a;
		}
		String priKey=str1;		//获得私钥
		
		String sign=RsaSignature.sign("samh", priKey);
		String code=enData+"."+sign;
		System.out.println("拼接后的数据是"+code);
		try {
			//创建客户端socket，指定服务器地址和端口
			Socket socket = new Socket("localhost", 8888);
			//获取输出流，向服务器端发送信息
			OutputStream os = socket.getOutputStream();
			PrintWriter pw=new PrintWriter(os);
			pw.write(code);
			pw.flush();//刷新缓存，向服务器端输出信息
			socket.shutdownOutput();//关闭输出流
			
			//获取服务端数据
			InputStream is = socket.getInputStream();//获取输入流，响应服务端的信息
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String str=br.readLine();
			System.out.println("收到服务端的信息是:"+str);
			
			/*String info = "";
			int a=0;
			while((a=is.read())!=-1){
				info+=(char)a;
			}
			System.out.println("收到服务端的信息为："+info);*/
			if("100".equals(str)){
				json.put("mess", true);
				json.put("code", "支付成功，交易编号"+tradeNum);
			}else if("101".equals(str)){
				json.put("mess", false);
				json.put("code", "余额不足！");
			}else if("102".equals(str)){
				json.put("mess", false);
				json.put("code", "账户信息有误！");
			}else{
				json.put("mess", false);
				json.put("code", "系统异常");
			}
			is.close();
			pw.close();
			os.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return json;
	}
	
}
