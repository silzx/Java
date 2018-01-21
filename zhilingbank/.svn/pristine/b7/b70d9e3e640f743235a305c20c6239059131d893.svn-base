package com.zl.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.zl.pojo.CustomerInfo;
import com.zl.pojo.Emp;
import com.zl.pojo.Info;
import com.zl.service.inter.CardAuditSystem;
import com.zl.util.CustomerInfoUtil;
import com.zl.util.Uuid;

/**
* @author 作者 :陈强
* @version 创建时间：2018年1月10日 下午12:06:39
* 类说明 业务员操作类
*/
@Controller
@RequestMapping("/salesman")
public class SalesmanController {
	@Autowired
	private CardAuditSystem cs;

	/**
	 * @title:addinfo
	 * @author:姚彬彬
	 * @Description:申请办卡
	 */	
	@RequestMapping("addinfo")
	public ModelAndView addinfo(){
		ModelAndView mv = new ModelAndView("/after/salesman/addinfo");
		
		return mv;
	}
	
	
	/**
	 * @title:savefo
	 * @author:陈强
	 * @Description:提交信息	
	 */	
	@RequestMapping(value = "/batch/upload", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView savein(CustomerInfo f,HttpServletRequest request,HttpSession s) throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect:/salesman/showinfomation");
		//文件上传
		List<MultipartFile> files = ((MultipartHttpServletRequest) request)
		        .getFiles("file");
		MultipartFile file = null;
		BufferedOutputStream stream = null;
		for (int i = 0; i < files.size(); ++i) {
			file = files.get(i);
			 if (!file.isEmpty()) {
				 byte[] bytes = file.getBytes();
		          stream = new BufferedOutputStream(new FileOutputStream(
		              new File(file.getOriginalFilename())));
		         
		          String fileName = file.getOriginalFilename();
		          String filePath = "/src/main/webapp/upload/";
		          File d=new File("");
		          String str=d.getCanonicalPath();
		          File dest = new File(str+filePath + fileName);
		          file.transferTo(dest);
		          stream.write(bytes);
		          stream.close();
				 
			 }
			 if(i==0) {
	        	  f.setIdCardCopy(file.getOriginalFilename());
	          }
	          if(i==1){
	        	  f.setReceipts(file.getOriginalFilename());
	        	  }
			
		}
		//保存信息到info表
		int age=CustomerInfoUtil.getCustomerAge(f.getIdCard());
		String sex=CustomerInfoUtil.getCustomerGender(f.getIdCard());
		Emp e=(Emp) s.getAttribute("loginemp");
		f.setSex(sex);
		f.setAge(age);
		f.setApplyMethod("人工申请");
		f.setApplyStatus(1);
		f.setApplyDate(new Date());
		f.setUuid(Uuid.getUuid());
		f.setAddMan(e.getName());
		cs.salesmanAddInfo(f);
		return mv;
	}
	@RequestMapping(value = "/batch/save", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView save(CustomerInfo f,HttpServletRequest request,HttpSession s) throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect:/salesman/showinfomation");
		//文件上传
		List<MultipartFile> files = ((MultipartHttpServletRequest) request)
		        .getFiles("file");
		MultipartFile file = null;
		BufferedOutputStream stream = null;
		for (int i = 0; i < files.size(); ++i) {
			file = files.get(i);
			 if (!file.isEmpty()) {
				 byte[] bytes = file.getBytes();
		          stream = new BufferedOutputStream(new FileOutputStream(
		              new File(file.getOriginalFilename())));
		          String fileName = file.getOriginalFilename();
		          String filePath = "/src/main/webapp/upload/";
		          File d=new File("");
		          String str=d.getCanonicalPath();
		          File dest = new File(str+filePath + fileName);
		          file.transferTo(dest);
		          stream.write(bytes);
		          stream.close();
				 
			 }
			 if(i==0) {
	        	  f.setIdCardCopy(file.getOriginalFilename());
	          }
	          if(i==1){
	        	  f.setReceipts(file.getOriginalFilename());
	        	  }
		}
		//保存信息到info表
		int age=CustomerInfoUtil.getCustomerAge(f.getIdCard());
		String sex=CustomerInfoUtil.getCustomerGender(f.getIdCard());
		Emp e=(Emp) s.getAttribute("loginemp");
		f.setSex(sex);
		f.setAge(age);
		f.setApplyMethod("人工申请");
		f.setApplyStatus(4);
		f.setApplyDate(new Date());
		f.setUuid(Uuid.getUuid());
		f.setAddMan(e.getName());
		cs.salesmanAddInfo(f);
		return mv;
	}
	@RequestMapping("/showinfomation")
	public ModelAndView show(@RequestParam(defaultValue="1")int pageno,Model m) {
		int count=6;
		int page=0;
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/after/salesman/main_list");
		int total=cs.getcountinfo();
		if(total%count==0) {
			page=total/count;
		}else {
			page=total/count+1;
		}
		if(pageno>=page) {
			pageno=page;
		}
		if(pageno<=1) {
			pageno=1;
		}
		List<CustomerInfo> info=cs.salesmanQueryInfo(pageno, count);
		m.addAttribute("total", total);
		m.addAttribute("info", info);
		m.addAttribute("page", page);
		m.addAttribute("pageno", pageno);
		return mv;
	}
	@RequestMapping("/queryInfo")
	public ModelAndView queryInfo(String uuid,Model m) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("after/salesman/updateInfo");
		CustomerInfo fo=cs.salesmanShowInfo(uuid);
		m.addAttribute("fo", fo);
		return mv;
	}
	//修改废弃用户状态并提交
	@RequestMapping(value = "/batch/change", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView change(String uuid,HttpServletRequest request,String idcardcopy,String receipts) throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect:/salesman/showinfomation");
		//文件上传
		List<MultipartFile> files = ((MultipartHttpServletRequest) request)
		        .getFiles("file");
		MultipartFile file = null;
		BufferedOutputStream stream = null;
		for (int i = 0; i < files.size(); ++i) {
			file = files.get(i);
			 if (!file.isEmpty()) {
				 byte[] bytes = file.getBytes();
		          stream = new BufferedOutputStream(new FileOutputStream(
		              new File(file.getOriginalFilename())));
		          String fileName = file.getOriginalFilename();
		          String filePath = "/src/main/webapp/upload/";
		          File d=new File("");
		          String str=d.getCanonicalPath();
		          File dest = new File(str+filePath + fileName);
		          file.transferTo(dest);
		          stream.write(bytes);
		          stream.close();
				 
			 }
			 if(i==0) {
				 idcardcopy=file.getOriginalFilename();
	          }
	          if(i==1){
	        	  receipts=file.getOriginalFilename();
	        	  }
		}		
		int i=cs.salesmanSubmitCustomer(uuid, idcardcopy, receipts);
		return mv;
		
	}
}