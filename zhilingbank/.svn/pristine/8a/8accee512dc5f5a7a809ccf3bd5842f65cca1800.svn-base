package com.zl.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * @author：汪泽轩
 * @Description: 二审业务   
 * @Date:2018年1月4日下午3:46:39   
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SecondAudit {
	private String uuid;//业务ID-唯一序列，根据此ID查看详细信息
	
	private String addMan;//提交该审核的一审人员
	
	@DateTimeFormat(pattern = ("yyyy年MM月dd日"))
	private Date applpayDate;//申卡时间
	
	private String cardType;//申卡类型
	
	private String auditResult;//二审结果
}
