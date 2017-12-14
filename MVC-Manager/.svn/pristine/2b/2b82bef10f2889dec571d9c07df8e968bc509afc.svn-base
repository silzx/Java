package com.wzx.service.impl;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wzx.dao.InfoDao;
import com.wzx.dto.empDto;
import com.wzx.service.IInfoService;
import com.wzx.util.FenYe;
@Service
public class InfoService implements IInfoService{
	@Autowired
	private InfoDao id;
	@Override
	public List<empDto> emps(FenYe fy) {
		return id.emps(fy);
	}
	@Override
	public int rowCount(Map<String, Object> map) {
		return id.rowCount(map);
	}
	@Override
	public boolean del(String[] ids) {
		if(ids==null){
			String[] a=new String[1];
			a[0]="0";
			return id.del(a)>0?true:false;
		}
		return id.del(ids)>0?true:false;
	}
	@Override
	public empDto queryById(String ids) {
		return id.queryById(ids);
	}
	@Override
	public boolean update(empDto emp,HttpServletRequest req,MultipartFile img) {
		String picName=" ";
		//获得项目绝对路径
		String picPath=req.getSession().getServletContext().getRealPath("/");
		//获得图片存放路径
		picPath=picPath.replace("MVC-Manager", "img");
		if(img.getSize()>0){
			//获取图片名字
			picName=img.getOriginalFilename();
			//给图片取新名字
			String newfileName=UUID.randomUUID().toString()+picName.substring(picName.lastIndexOf("."));
			//写入本地磁盘
			File file=new File(picPath+newfileName);
			emp.setPic(newfileName);
			try {
				img.transferTo(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return id.update(emp)>0?true:false;
	}
	@Override
	public List<Map<String, Object>> emm(FenYe fy) {
		return id.emm(fy);
	}
	@Override
	public boolean add(empDto emp,HttpServletRequest req,MultipartFile img) {
		String picName=" ";
		//获得项目绝对路径
		String picPath=req.getSession().getServletContext().getRealPath("/");
		//获得图片存放路径
		picPath=picPath.replace("MVC-Manager", "img");
		if(img.getSize()>0){
			//获取图片名字
			picName=img.getOriginalFilename();
			//给图片取新名字
			String newfileName=UUID.randomUUID().toString()+picName.substring(picName.lastIndexOf("."));
			//写入本地磁盘
			File file=new File(picPath+newfileName);
			emp.setPic(newfileName);
			try {
				img.transferTo(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return id.add(emp)>0?true:false;
	}

}
