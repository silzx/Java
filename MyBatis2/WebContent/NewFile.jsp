<%@page import="com.wzx.dto.FenYe"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
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
  <style type="text/css">
	body,select,textarea {font-size:1.1em}
	body, html,input{font-family:"微软雅黑";font-weight:bold;}
  </style>
  <body>
  <script type="text/javascript" src="jquery1.8/jquery-1.8.0.min.js"></script>
  <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<div class="container" >
		<div class="row">
			<center>
				<div class="col-md-12 jumbotron">
				<h2>欢迎&nbsp;${user.nickname }&nbsp;登录</h2>&nbsp;&nbsp;<h3>拥有权限：${user.role.rname }</h3> &nbsp;
				</div>
			</center>
		</div>
		<div class="row">
			<div class="col-md-2">
				<ul>
					<c:forEach items="${power }" var="p" varStatus="status">
						<li><a href="${p.url }" target="right" name="hr">${p.pname }</a></li><p><p><p><p><p><p>
					</c:forEach>
					<li><a href="UserAction/exit.action"><input type="button" class="button button-highlight button-rounded button-small" value="退出"> </a></li>
				</ul>
			</div>
			<div class="col-md-10">
				<iframe name="right"  frameborder="0" height="100%" width="100%" >
    			</iframe>
			</div>
		</div>
	</div>
  </body>
</html>
