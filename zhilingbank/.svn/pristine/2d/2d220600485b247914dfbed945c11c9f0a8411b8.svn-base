package com.zl.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author：汪泽轩
 * @Description: 一审业务  
 * @Date:2018年1月4日下午3:25:52   
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FirstAudit {
	private String uuid;//业务ID-唯一序列，根据此ID查看详细信息
	
	private String idCard;//身份证
	
	private String applyMethod;//申卡方式
	
	@DateTimeFormat(pattern = ("yyyy年MM月dd日"))
	private Date applpayDate;//申卡时间
	
	private String auditResult;//一审结果
	
	private String  remark;//备注
	
	private String cardType;//申卡类型
}
