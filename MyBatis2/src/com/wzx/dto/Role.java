package com.wzx.dto;

import java.util.List;

public class Role {
	private int id;
	private int role_id;
	private String rname;
	private List<Power> power;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public List<Power> getPower() {
		return power;
	}
	public void setPower(List<Power> power) {
		this.power = power;
	}
	
}
