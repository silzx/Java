package com.zl.tool;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.zl.pojo.TradeRecord;


/**
 * @Title PageBean
 * @Author 谢文奇
 * @Date 2018年1月11日下午4:11:48
 * @Description 分页工具
 */
public class PageBean implements Serializable{

	//起始页
	public static int page;
	//每页显示记录数
	public static int row;
	//总页数
	public static int pageCount;
	//总记录数
	public static int rowCount;
	//起始记录数
	public static int startRow;
	public static int endRow;
	public static Map<String, Object> search;
	public static PageBean pb;

	public PageBean() {
		row = 3;

		endRow = page * row;
	}

	public static void init() {
		pb = new PageBean();
	}

}
