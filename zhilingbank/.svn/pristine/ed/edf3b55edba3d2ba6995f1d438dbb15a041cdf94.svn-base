package com.zl.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author：汪泽轩
 * @Description: 账单管理所需信息实体类   
 * @Date:2018年1月10日下午12:02:24   
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillsInfo implements Serializable{

	private String cardStatus;//卡片状态
	
	private BigDecimal creditline;//总额度
	
	private BigDecimal avabalance;//可用额度
	
	@DateTimeFormat(pattern = "yyyy年MM月dd日")
	private Date billdate;//账单日期
	
	@DateTimeFormat(pattern = "yyyy年MM月dd日")
	private Date payback;//还款日期
	
	private BigDecimal alreadybill;//已出账单金额
	
	private BigDecimal notreadybill;//未出账单金额
	
	private BigDecimal refundnow;//已还款额
	
	private BigDecimal notrefundnow;//未还款额
}
