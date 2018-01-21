package com.zl.util;

import java.util.Map;

	public class FenYe {
		public static int page;		//当前第几页
		public static int row;		//每页显示多少行
		public static int pageCount;		//总页数
		public static int rowCount;			//总条数
		public static int startRow;			//每页开始行
		public static int endRow;			//每页结束行
		public static Map<String, Object> search;	//条件
		public static FenYe fy;		
		public FenYe() {
			row=3;
			
			if(page==0){
				page=1;
			}
			
			if(rowCount%row==0){
				pageCount=rowCount/row;
			}else{
				pageCount=rowCount/row+1;
			}
			
			startRow=(page-1)*row;
			endRow=page*row;
		}
		
		public static void init(){
			fy=new FenYe();
		}
}
