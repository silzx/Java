package com.zl.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @author 作者 :陈强
* @version 创建时间：2018年1月10日 下午8:15:38
* 类说明 	职位表实体类
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pos implements Serializable{
	private Integer pid;//职位id
	
	private String pname;//职位名称

}
