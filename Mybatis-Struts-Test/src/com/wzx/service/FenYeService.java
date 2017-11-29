package com.wzx.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.wzx.dto.FenYe;
import com.wzx.service.inter.ICarService;
import com.wzx.service.inter.IFenYeService;

public class FenYeService implements IFenYeService,RequestAware{
	ICarService ns=new CarService();
	private Map<String, Object> req=new HashMap<String, Object>();
	@Override
	public FenYe getFenYe(FenYe fy, String pag) {
		String brand="";
		String color="";
		String startDate="";
		String endDate="";
		if(ServletActionContext.getRequest().getAttribute("brand") !=null){
			brand=(String) ServletActionContext.getRequest().getAttribute("brand");
		}
		if(ServletActionContext.getRequest().getAttribute("color") !=null){
			color=(String) ServletActionContext.getRequest().getAttribute("color");
		}
		if(ServletActionContext.getRequest().getAttribute("startDate") !=null){
			startDate=(String) ServletActionContext.getRequest().getAttribute("startDate");
		}
		if(ServletActionContext.getRequest().getAttribute("endDate") !=null){
			endDate=(String) ServletActionContext.getRequest().getAttribute("endDate");
		}
		req.put("brand", brand);
		req.put("color", color);
		req.put("startDate", startDate);
		req.put("endDate", endDate);
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
