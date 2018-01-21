package com.zl.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author：汪泽轩
 * @Description: 账单   
 * @Date:2018年1月4日下午4:02:45   
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bills implements Serializable{
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
	
}
