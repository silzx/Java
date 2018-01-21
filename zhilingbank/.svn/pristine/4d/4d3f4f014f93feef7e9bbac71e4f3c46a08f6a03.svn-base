package com.zl.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zl.tool.rsa;
import com.zl.util.InterfaceCall;



@RestController
@RequestMapping("/interface")
public class InterfaceController {
	
	@Autowired
	private InterfaceCall interfaceService;
	
	

	//测试URL
	//http://localhost:8080/interface/phone?phone=15768397755
    //验证码1
	@RequestMapping("/phone")
	public void phone(HttpServletResponse response,HttpServletRequest request) {
		
		String phone = request.getParameter("phone");
		//短信内容
		
		
		System.out.println(phone);
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
			int s = interfaceService.interfacePhone(phone);
			
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	
		
		
		
	
	}
	//测试URL
	//http://localhost:8080/interface/idcard?card_name=姚彬彬&card_id=430581199305147297
	//身份证
	@RequestMapping("/idcard")
	public void idCard(HttpServletResponse response,HttpServletRequest request,HttpSession sseion) throws Exception {

		String card_name = request.getParameter("card_name");
		String card_id = request.getParameter("card_id");
		
		PrintWriter out = null;
	
		try {
			out = response.getWriter();			
			JSONObject json =  interfaceService.interfaceIdCard(card_name, card_id);
			
			//Map m = new HashMap();
			//m=json.toMap();
           //System.out.println(m);

			
			out.print(json);
			out.close();
		} catch (Exception e) {
			
		}finally{			
			out.close();
		}
		
	}
	private Object json() {
		// TODO Auto-generated method stub
		return null;
	}
	//测试URL
	//http://localhost:8080/interface/company?company_name=腾讯    
    //company_id 公司ID查询暂时为空
	//工商局
	@RequestMapping("/company")
	public void company(HttpServletResponse response,HttpServletRequest request) {
		String company_name = request.getParameter("company_name");
		String company_id = request.getParameter("company_id");
		PrintWriter out = null;
		
		try {
			out = response.getWriter();			
			JSONObject json = interfaceService.interCompany(company_name, company_id);
			out.print(json);
			out.close();
		} catch (Exception e) {
			
		}finally{
			out.close();
		}
		
	}
	
}
