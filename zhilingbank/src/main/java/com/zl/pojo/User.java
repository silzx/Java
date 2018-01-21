package com.zl.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.stereotype.Component;


/**
 * @author：汪泽轩
 * @Description: 用户实体类  
 * @Date:2018年1月4日下午3:48:24   
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class User implements Serializable{
	private String userid;//客户编号
	
	private String username;//用户名
	
	private String idCard;//身份证
	
	private String phone;//预留手机
	
	private String companyName;//公司名
	
	private String companyAdd;//公司地址
	
	private String comphone;//公司电话
	
	private String ismarry;//婚姻情况
	
	private String familyadd;//家庭地址
	
	private double creditline;//总信用额度--不变
	
	private double avabalance;//可用信用余额--变
	
	private double usedbalance;//已用额度--变
	
	private double overline;//溢出金额--变
	
	private String linkman;//紧急联系人
	
	private String linksex;//联系人性别
	
	private String linkrelationship;//与联系人关系
	
	private String linkphone;//联系人手机

}
