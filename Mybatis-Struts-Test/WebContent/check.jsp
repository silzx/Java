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
  <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<table border="0" class="table table-striped table-hover">
					<tr>
						<td>品牌</td>
						<td>颜色</td>
						<td>座位数</td>
						<td>百公里油耗</td>
						<td>生产日期</td>
						<td>日租金</td>
						<td>添加日期</td>
						<td>添加人昵称</td>
					</tr>
					<tr>
						<td>${car.brand }</td>
						<td>${car.color }</td>
						<td>${car.seats }</td>
						<td>${car.oil }升</td>
						<td><fmt:formatDate value="${car.exp}" pattern="yyyy年MM月dd日"/></td>
						<td>${car.daycast }</td>
						<td><fmt:formatDate value="${car.addtime}" pattern="yyyy年MM月dd日"/></td>
						<td>${car.addman }</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
  </body>
</html>
