package com.zl.controller;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.zl.util.InterfaceCall;

@Controller
@Scope("prototype")
@RequestMapping("captcha")
public class CaptchaController {
	@Autowired
	private Producer captchaProducer;
	@Autowired
	private InterfaceCall ic;
	
	
	@RequestMapping("getKaptchaImage")
	public ModelAndView getKaptchaImage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String code = (String) session
				.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		System.out.println("******************验证码是: " + code
				+ "******************");

		response.setDateHeader("Expires", 0);

		// Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control",
				"no-store, no-cache, must-revalidate");

		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");

		// Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");

		// return a jpeg
		response.setContentType("image/jpeg");

		// create the text for the image
		String capText = captchaProducer.createText();

		// store the text in the session
		session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);

		// create the image with the text
		BufferedImage bi = captchaProducer.createImage(capText);
		ServletOutputStream out = response.getOutputStream();

		// write the data out
		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
		return null;
	}
	
	//黄超   调用短信发送action层方法
	/**
	 * @title:sendPhoneMessage
	 * @author:黄超
	 * @Description:获取短信验证码方法，接收参数为手机号码	
	 */
	@RequestMapping("getPhoneMessage")
	@ResponseBody
	public Map<String,Object> sendPhoneMessage(String phoneNum){
		System.out.println("方法处理中");
		Map<String,Object> json=new HashMap<String, Object>();
		int a=ic.interfacePhone(phoneNum);
		json.put("code", a);
		System.out.println(a);
		if(a==0){
			json.put("mess", false);
		}else{
			json.put("mess", true);
			json.put("code", a);
		}
		return json;
	} 
	
	/**
	 * @param 支付密码
	 * @return true or false
	 * @description 判断输入的支付密码是否符合规则,支付密码必须为六位数纯数字
	 */
	@RequestMapping(value="judgePW")
	@ResponseBody
	public Map<String, Object> judgePW(String pw){
		Map<String, Object> map = new HashMap<>();
		
		if(pw.length() == 6){
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher isNum = pattern.matcher(pw);
			if( isNum.matches() ){
				map.put("pwMessage", true);
			}else{
				map.put("pwMessage", false);
			}
		}else{
			map.put("pwMessage", false);
		}
		
		return map;
	}
}
