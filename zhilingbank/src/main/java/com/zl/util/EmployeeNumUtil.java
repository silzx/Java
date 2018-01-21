package com.zl.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

/**
 * 
 * @Title EmployeeNumUtil
 * @Author 谢文奇
 * @Date 2018年1月7日下午12:13:42
 * @Description 生成员工编号类
 */
public class EmployeeNumUtil {
	
	/**
	 * @param 部门编号
	 * @return 员工编号
	 * @description 生成员工唯一编号
	 */
	public static String getEmployeeNum(int department) throws Exception {

		// employeeNum：员工号基础模板，"ZLYH" + 部门编号
		String employeeNum = new String("ZLYH" + department);

		//读取员工编号文件
		File file = new File("src/main/java/com/zl/util/empno.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		//读取文件中的自增编号
		String flag = br.readLine();
		Integer in = Integer.parseInt(flag);
		System.out.println("新员工后四位编号：" + in);
		
		//将自增编号加入到新员工的编号中
		employeeNum = employeeNum + in; 

		//编号自增一次，存入到编号文件中，给下一个员工备用
		FileOutputStream fos = new FileOutputStream(file);
		in++;
		String s = in.toString();
		fos.write(s.getBytes());
		System.out.println("下一位员工后四位编号：" + in);
		
		//关闭资源
		fos.close();
		br.close();
		fr.close();
		
		return employeeNum;
	}
	public static void main(String[] args) throws Exception {
		System.out.println(getEmployeeNum(11));
	}
}
