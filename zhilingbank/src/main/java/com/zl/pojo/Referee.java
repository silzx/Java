package com.zl.pojo;
/**
 * @author 吕攀
 * @Time 下午3:54:14 2018年1月9日
 */
public class Referee {
	private String id;
	private String name;
	private String ridcard;
	private String rname;
	private String rphone;
	private String raddress;
	private String rcompany;
	private Integer cardstate=0;
	public Integer getCardstate() {
		return cardstate;
	}
	public void setCardstate(Integer cardstate) {
		this.cardstate = cardstate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRidcard() {
		return ridcard;
	}
	public void setRidcard(String ridcard) {
		this.ridcard = ridcard;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRphone() {
		return rphone;
	}
	public void setRphone(String rphone) {
		this.rphone = rphone;
	}
	public String getRaddress() {
		return raddress;
	}
	public void setRaddress(String raddress) {
		this.raddress = raddress;
	}
	public String getRcompany() {
		return rcompany;
	}
	public void setRcompany(String rcompany) {
		this.rcompany = rcompany;
	}
	
	
}
