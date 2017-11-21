package com.wzx.action;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.wzx.dto.Power;
import com.wzx.dto.UserDto;
import com.wzx.service.FileUploadService;
import com.wzx.service.UserService;
import com.wzx.service.inter.IFileUploadService;
import com.wzx.service.inter.IUserService;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements SessionAware{
	private UserDto u;
	private IUserService us = new UserService();
	private File img;//上传的图片文件
	private String imgFileName;//上传的图片的名字
	private String imgContentType;//上传的图片的类型
	private IFileUploadService ifs=new FileUploadService();
	private Map<String,Object> session;
	private Map<String,Object> json=new HashMap<String,Object>();
	public String userLogin(){
		String flag="error";
		UserDto user = us.login(u);
		try {
			if (user != null) {
				Cookie nameC = new Cookie("nameC", URLEncoder.encode(user.getName(), "utf-8"));
				Cookie pwdC = new Cookie("pwdC", user.getPwd());
				// 设置cookie失效时间
				nameC.setMaxAge(24 * 60 * 60);
				pwdC.setMaxAge(24 * 60 * 60);
				// 设置cookie保存路径
				nameC.setPath("/MyBatis");
				pwdC.setPath("/MyBatis");
				// 放到相应对象中
				ServletActionContext.getResponse().addCookie(nameC);
				ServletActionContext.getResponse().addCookie(pwdC);
				session.put("user", user);
				List<Power> power=user.getRole().getPower();
				session.put("power", power);
				flag="success";
			} else {
				session.put("error", "账号或者密码错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public String regsiter(){
		if(img!=null){
			u=ifs.getUser(img, imgFileName, u);
		}
		int i=us.reg(u);
		if(i>0){
			return "regsiter";
		}else{
			return "error";
		}
		
	}
	
	public String regName(){
		if(us.regName(u.getName())!=null){
			json.put("meg", true);
		}else{
			json.put("meg", false);
		}
		return "regName";
	}
	
	public String queryUser(){
		return "queryUser";
	}
	
	public String exit(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "exit";
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	public Map<String, Object> getJson() {
		return json;
	}

	public void setJson(Map<String, Object> json) {
		this.json = json;
	}

	public UserDto getU() {
		return u;
	}
	public void setU(UserDto u) {
		this.u = u;
	}

	public IUserService getUs() {
		return us;
	}

	public void setUs(IUserService us) {
		this.us = us;
	}

	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public String getImgContentType() {
		return imgContentType;
	}

	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}
	
}
