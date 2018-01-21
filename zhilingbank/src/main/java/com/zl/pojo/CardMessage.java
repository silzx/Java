package com.zl.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class CardMessage implements Serializable{
	private String idCard;//身份证
	
	private String cardNum;//卡号
	
	private String salt;//盐值
	
	private Integer cardType;//卡种
	
	private String password;//支付密码
	
	private String backCode;//背后7位数字
	
	@DateTimeFormat(pattern = ("yyyy年MM月dd日"))
	private Date deadDate;//过期时间
	
	@DateTimeFormat(pattern = ("yyyy年MM月dd日"))
	private Date billDate;//账单日
	
	@DateTimeFormat(pattern = ("yyyy年MM月dd日"))
	private Date repayDate;//还款日
	
	private String cardStatus;//卡状态(正常，注销，冻结，挂失,未激活)
}
