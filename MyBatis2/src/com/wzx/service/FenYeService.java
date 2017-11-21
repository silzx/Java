package com.wzx.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.wzx.dto.FenYe;
import com.wzx.service.inter.IFenYeService;
import com.wzx.service.inter.INewsService;

public class FenYeService implements IFenYeService,RequestAware{
	INewsService ns=new NewsService();
	private Map<String, Object> req=new HashMap<String, Object>();
	@Override
	public FenYe getFenYe(FenYe fy, String pag) {
		String qtitle="";
		String qcontext="";
		if(ServletActionContext.getRequest().getAttribute("qtitle") !=null){
			qtitle=(String) ServletActionContext.getRequest().getAttribute("qtitle");
		}
		if(ServletActionContext.getRequest().getAttribute("qcontext") !=null){
			qcontext=(String) ServletActionContext.getRequest().getAttribute("qcontext");
		}
		req.put("qtitle", qtitle);
		req.put("qcontext", qcontext);
		FenYe.search=req;
		if(pag==null){
			FenYe.page=1;
		}else{
			FenYe.page=Integer.parseInt(pag);
		}
		FenYe.rowCount=ns.rowCount(FenYe.search);
		FenYe.init();
		return FenYe.fy;
	}
	@Override
	public void setRequest(Map<String, Object> req) {
		this.req=req;
	}
}
