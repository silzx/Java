<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
			<div class="col-md-3">
			
			</div>
			<div class="col-md-6">
				<table border="0" class="table table-striped table-hover">
					<tr>
						<td>头像</td>
						<td>账号</td>
						<td>密码</td>
						<td>昵称</td>
						<td>年龄</td>
						<td>权限</td>
					</tr>
					<tr>
						<td><a href="../img/${user.pic }"><img style="width:90px;height: 120px" alt="无法显示" src="../img/${user.pic }" class="img-rounded"></a></td>
						<td>${user.name }</td>
						<td>${user.pwd }</td>
						<td>${user.nickname }</td>
						<td>${user.age }岁</td>
						<td>${user.role.rname }</td>
					</tr>
				</table>
			</div>
			<div class="col-md-3">
			
			</div>
		</div>
	</div>
  </body>
</html>
