package com.zl.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * @author：汪泽轩
 * @Description: 员工信息   
 * @Date:2018年1月4日下午3:46:03   
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Emp implements Serializable{
	 private static final long serialVersionUID = 1L;

	private String account;//账号
	
	private String pwd;//密码
	
	private String mobile;//电话
	
	private String name;//员工姓名
	
	private String idCard;//身份证
	
	private String empid;//唯一ID
	
	private int age;//年龄
	
	private int did;//部门编号
	
	private int pid;//权限编号
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date joindate;//入职日期
	
	private String sex;//性别
	
	private String address;//详细住址
	
	private String linkman;//紧急联系人
	
	private String linkMobile;//联系人联系方式
	
	private int state;//伪删除 0为可用 1 为删除
	
	private String salt;//盐值
	private String eva;//评价
	private Dept dept;//部门实体类
	private Pos pos;//权限实体类
	
	
	
}
