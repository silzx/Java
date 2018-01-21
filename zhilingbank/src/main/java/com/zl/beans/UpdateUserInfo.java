package com.zl.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.stereotype.Component;


/**
 * @author：汪泽轩
 * @Description: 用户修改自己信息的实体类   
 * @Date:2018年1月6日上午9:36:13   
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateUserInfo {
	private String familyadd;
	
	private String linkman;
	
	private Integer linkPhone;
	
	private Integer phone;
	
	private String userid;
}
