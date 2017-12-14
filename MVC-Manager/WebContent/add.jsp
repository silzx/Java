<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="buttons/buttons.css">
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <script type="text/javascript" src="jquery1.8/jquery-1.8.0.min.js"></script>
  <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
  <script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
  <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
  <br><br><br>
		<center>
			<form action="<%=basePath%>info/add" method="post" enctype="multipart/form-data"><p>
			<table border="0"> 
			<tr>
			<td>用户名：</td>
			<td><input type="text" name="ename"><p></td>
			</tr>
			<tr>
			<td>密码：</td>
			<td><input type="text" name="epwd"><p></td>
			</tr>
			<tr>
			<td>权限：</td>
			<td><select name="pid">
					<option>--请选择--</option>
					<c:forEach items="${powers }" var="power" varStatus="status">
						<option value="${status.count }">${power.pname }</option>
					</c:forEach>
			</select><p></td>
			</tr>
			<tr>
			<td>年龄：</td>
			<td><input type="text" name="eage"><p></td>
			</tr>
			<tr>
			<td>入职日期：</td>
			<td><input type="text" name="joindate" class="Wdate" onclick="WdatePicker()" readonly="readonly"><p></td>
			</tr>
			<tr>
			<td>部门：</td>
			<td>
			<select name="did">
				<c:if test="${emp.pid==4 }">
					<option value="${emp.did }" selected="selected">${emp.dept.dname }</option>
				</c:if>
				<c:if test="${emp.pid==5 }">
					<option>--请选择--</option>
					<c:forEach items="${depts }" var="dept" varStatus="status">
						<option value="${status.count }">${dept.dname }</option>
					</c:forEach>
				</c:if>
			</select>
			<p></td>
			</tr>
			<tr>
			<td>性别：</td>
			<td>
			<input name="esex" type="radio" value="1" checked="checked">男
     		<input name="esex" type="radio" value="0">女<p/>
			</td>
			</tr>
			<tr>
			<td>头像：</td>
			<td>
			<input type="file" name="img">
			</td>
			</tr>
			</table>
			<input type="submit" class="button button-raised button-pill button-inverse button-small " value="添加">
		</form>
		</center>
  </body>
</html>
