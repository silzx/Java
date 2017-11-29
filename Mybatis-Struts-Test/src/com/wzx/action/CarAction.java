package com.wzx.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.wzx.dto.BrandDto;
import com.wzx.dto.CarDto;
import com.wzx.dto.FenYe;
import com.wzx.service.CarService;
import com.wzx.service.FenYeService;
import com.wzx.service.inter.ICarService;
import com.wzx.service.inter.IFenYeService;

public class CarAction extends ActionSupport implements SessionAware{
	private IFenYeService fs=new FenYeService();
	private ICarService cs=new CarService();
	private Map<String, Object>session=new HashMap<String, Object>();
	private String brand;
	private String color;
	private String startDate;
	private String endDate;
	private int[] ids;
	private int id;
	private CarDto c;
	public String carlist(){
		String pag=ServletActionContext.getRequest().getParameter("page");
		FenYe.fy=fs.getFenYe(FenYe.fy, pag);
		List<CarDto> cars=cs.list(FenYe.fy);
		if(cars!=null){
			session.put("cars",cars);
			return "carlist";
		}else{
			return "error";
		}
	}
	
	public String del(){
		if(ids!=null){
			for(int id:ids){
				cs.del(id);
			}
		}else{
			cs.del(id);
		}
		return "success";
	}
	
	public String check(){
		CarDto car=cs.check(id);
		if(car!=null){
			session.put("car", car);
			return "success";
		}else{
			return "error.jsp";
		}
	}
	
	public String mid(){
		List<BrandDto> brands=cs.brands();
		session.put("brands", brands);
		return "add";
	}
	
	public String add(){
		int i=cs.add(c);
		if(i>0){
			return "success";
		}else{
			return "error";
		}
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CarDto getC() {
		return c;
	}

	public void setC(CarDto c) {
		this.c = c;
	}
	
}
