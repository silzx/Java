<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  <script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
  <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
		<center><p><p>
			<div class="row">
			<div class="span8">
				<form action="<%=basePath%>CarAction/add.action" method="post" enctype="multipart/form-data"><fieldset>
				<legend>新增汽车</legend>
				<label>品牌</label>
				<select name="c.brand">
 				<option>请选择</option>
 					<c:forEach items="${brands}" var="b">
				      	<option value="${b.brand}">${b.brand}</option>
				    </c:forEach>
 				</select></td><p>
				<label>颜色</label>
				<input type="text" name="c.color"><p>
				<label>座位数</label>
				<input type="text" name="c.seats"><p>
				<label>百公里油耗</label>
				<input type="text" name="c.oil"><p>
				<label>生产日期</label>
				<input type="text" name="c.exp" class="Wdate" onclick="WdatePicker()" readonly="readonly"><p>
				<label>日租金</label>
				<input type="text" name="c.daycast"><p>
				<input type="hidden" name="c.addman" value="${user.nickname }"><p>
				<input type="submit" class="button button-raised button-pill button-inverse button-small" value="添加">
				</fieldset>
			</form>
			</div>
			</div>
		</center>
  </body>
</html>
