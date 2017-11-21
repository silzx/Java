package com.wzx.service.inter;

import java.io.File;

import com.wzx.dto.NewsDto;
import com.wzx.dto.UserDto;

public interface IFileUploadService {
	public NewsDto getNews(File pic,String picFileName,NewsDto n);
	public UserDto getUser(File pic,String picFileName,UserDto n);
}
