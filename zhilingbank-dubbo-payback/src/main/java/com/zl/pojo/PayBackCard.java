package com.zl.pojo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class PayBackCard implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bankName;
	private String cardNum;
	private String password;
	private double money;
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
	
	
}
