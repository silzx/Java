package com.test.store;

import org.springframework.stereotype.Component;




@Component
public class CardCost {
	private String cardNum;//卡号
	
	private String passWord;//支付密码
	
	private String backcode;//CVV2
	
	private String idcard;//身份证
	
	private double price;//消费金额

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getBackcode() {
		return backcode;
	}

	public void setBackcode(String backcode) {
		this.backcode = backcode;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
