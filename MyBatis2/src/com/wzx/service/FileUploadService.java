package com.wzx.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.wzx.dto.NewsDto;
import com.wzx.dto.UserDto;
import com.wzx.service.inter.IFileUploadService;

public class FileUploadService implements IFileUploadService{

	@Override
	public NewsDto getNews(File pic, String picFileName, NewsDto n) {
		String path=ServletActionContext.getServletContext().getRealPath("/")+"..\\img";
		String newfileName=UUID.randomUUID().toString()+picFileName.substring(picFileName.lastIndexOf("."));
		File file=new File(path+"\\"+newfileName);
		try {
			FileUtils.copyFile(pic, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		n.setPic("../img/"+newfileName);
		return n;
	}

	@Override
	public UserDto getUser(File pic, String picFileName, UserDto u) {
		String path=ServletActionContext.getServletContext().getRealPath("/")+"..\\img";
		String newfileName=UUID.randomUUID().toString()+picFileName.substring(picFileName.lastIndexOf("."));
		File file=new File(path+"\\"+newfileName);
		try {
			FileUtils.copyFile(pic, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		u.setPic("../img/"+newfileName);
		return u;
	}


}
