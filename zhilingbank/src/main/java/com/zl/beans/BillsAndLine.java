package com.zl.beans;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class BillsAndLine {
	private String idCard;	//身份证号
	
	private Date billDate;//账单日期
	
	private Date payBack;//还款日期
	
	private Integer qishu;//分期数
	
	private Integer currentqs;//当前期数
	
	private double alreadyBill;	//已出账单金额
	
	private double notreadyBill;//未出账单金额
	
	private double RefundNow;	//当前已还款金额
	
	private double notRefundNow;	//当前未还款金额
	
	private Date nextBillDate; 	//下次出账时间
	
	private Double refundByStages;		//每期应还金额
	
	private int restqishu;		//剩余期数
	
	private double overline;
	
	

	public double getOverline() {
		return overline;
	}

	public void setOverline(double overline) {
		this.overline = overline;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public Date getPayBack() {
		return payBack;
	}

	public void setPayBack(Date payBack) {
		this.payBack = payBack;
	}

	public Integer getQishu() {
		return qishu;
	}

	public void setQishu(Integer qishu) {
		this.qishu = qishu;
	}

	public Integer getCurrentqs() {
		return currentqs;
	}

	public void setCurrentqs(Integer currentqs) {
		this.currentqs = currentqs;
	}

	

	public double getAlreadyBill() {
		return alreadyBill;
	}

	public void setAlreadyBill(double alreadyBill) {
		this.alreadyBill = alreadyBill;
	}

	public double getNotreadyBill() {
		return notreadyBill;
	}

	public void setNotreadyBill(double notreadyBill) {
		this.notreadyBill = notreadyBill;
	}

	public double getRefundNow() {
		return RefundNow;
	}

	public void setRefundNow(double refundNow) {
		RefundNow = refundNow;
	}

	public double getNotRefundNow() {
		return notRefundNow;
	}

	public void setNotRefundNow(double notRefundNow) {
		this.notRefundNow = notRefundNow;
	}

	public Date getNextBillDate() {
		return nextBillDate;
	}

	public void setNextBillDate(Date nextBillDate) {
		this.nextBillDate = nextBillDate;
	}

	public Double getRefundByStages() {
		return refundByStages;
	}

	public void setRefundByStages(Double refundByStages) {
		this.refundByStages = refundByStages;
	}

	public int getRestqishu() {
		return restqishu;
	}

	public void setRestqishu(int restqishu) {
		this.restqishu = restqishu;
	}
	
	
}
