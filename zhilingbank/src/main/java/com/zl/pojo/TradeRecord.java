package com.zl.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author：汪泽轩
 * @Description: 交易记录  
 * @Date:2018年1月4日下午3:52:33   
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TradeRecord implements Serializable{
	
	
	private String tradeUUID;//交易编号
	
	private String tradeType;//交易方式(消费/取现/还款·)
	
	private BigDecimal trade;//交易金额
	
	@DateTimeFormat(pattern = ("yyyy年MM月dd日 HH:mm:ss"))
	private Date tradeDate;//交易日期
	
	private String cardNum;	//交易卡号
}
