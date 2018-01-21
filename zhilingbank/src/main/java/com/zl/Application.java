package com.zl;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimerTask;









import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



import com.zl.Interceptor.EmpInterceptor;
import com.zl.beans.CardCost;
import com.zl.pojo.MessageInfo;
import com.zl.service.CostSocketImpl;
import com.zl.service.ServiceTool;
import com.zl.service.inter.IUserService;
import com.zl.socket.ShopThread;
import com.zl.tool.RsaSignature;
import com.zl.tool.rsa;
import com.zl.util.RedisTool;

@Configuration
@EnableTransactionManagement// 启注解事务管理，等同于xml配置方式的
@SpringBootApplication
@EnableScheduling
@MapperScan("com.zl.dao")
@ComponentScan("com.zl")
public class Application extends WebMvcConfigurerAdapter{
	
	public static void main(String[] args) throws Exception {
		/** * 
		@author    姚彬彬 
		@date      2018年1月8日 上午10:24:13    
		@describe  rsa秘钥定时器生成
		*/		
		//暂时关闭秘钥生成定时器
//		 Timer timer = new Timer();
//				 timer.scheduleAtFixedRate(new TimerT ask() {
//				 public void run() {
//				 rsaKey key = new rsaKey();
//				 key.getKey();
//				 }
//				 }, 3000, 1000*60*60);
		//SpringApplication.run(Application.class, args);
		ConfigurableApplicationContext run=SpringApplication.run(Application.class, args);
		RedisTool tr=run.getBean(RedisTool.class);
		tr.setKey();
		ServerSocket serverSocket = new ServerSocket(8888);
		Socket socket = null;
		OutputStream os = null;
		InputStream is = null;
		BufferedWriter bw = null;
		int count = 0;
		//调用accept()方法监听，等待客户端连接
		System.out.println("服务器即将启动,等待客户端连接ing......");
		while(true){//循环监听等待客户端连接
			socket = serverSocket.accept();		//获取连接
			os=socket.getOutputStream();
			is=socket.getInputStream();		//获取传输的数据
			String str="";
			int a=0;
			while((a=is.read())!=-1){
				str+=(char)a;
			}
			System.out.println("接收到的整合数据为:"+str);
			if("requestPubKey".equals(str)){	//先发送公钥给客户端
				bw=new BufferedWriter(new OutputStreamWriter(os));
				//获得公钥字符串
				String pubKey=rsa.PuYey();
				//把公钥发送给客户端用户加密
				//System.out.println("服务端发送的公钥是"+pubKey);
				bw.write(pubKey);
				bw.flush();
				bw.close();
				os.close();
			}else{

				String[] strs=str.split("\\.");
				System.out.println("RSA加密："+strs[0]);
				System.out.println("签名:"+strs[1]);
				String pubKey=rsa.PuYey();

				String priKey=rsa.PeYey();
				ShopThread st=new ShopThread(socket);	//创建实现类对象

				st.setPubKey(pubKey);
				st.setSign(strs[1]);
				st.setStr(strs[0]);

				st.setPriKey(priKey);
				st.start();		//进入线程
			}
			count ++;
			System.out.println("连接的客户端的数量："+count);
		}
		
		
	}
	
	
		
		public void addInterceptors(InterceptorRegistry registry) {
			/**
			 * @author 姚彬彬
			 * @date 2018年1月8日 上午10:24:13
			 * @describe 后台页面拦截器
			 */
			registry.addInterceptor(new EmpInterceptor()).addPathPatterns("/**");
	
			super.addInterceptors(registry);
		}

}
