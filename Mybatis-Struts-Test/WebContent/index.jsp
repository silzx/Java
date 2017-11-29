<%@page import="java.net.URLDecoder"%>
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
	<style type="text/css">
		button[name='login']{position: fixed;right: 643px;top: 250px}
		button[name='reg']{position: fixed;right: 643px;top: 290px}
		#reset{position: relative;right: 15px}
		#pad{position: relative;right: 15px;}
	</style>
  </head>
  <script type="text/javascript">
  function login(){
		$.ajax({
			type:"post",
			url:"UserAction/login.action",
			data:{"u.name":$("input[name='name']").val(),"u.pwd":$("input[name='pwd']").val()},
			dataType:"json",
			success: function(date){
				if(date.mes){
					location.href="<%=basePath%>CarAction/carlist.action";
				}else{
					document.getElementById("error").style.visibility="visible";
				}
			},
			erorr:function(date){
				alert(arguments[1]);
			},
		});
	}
  </script>
  
  <body>
  <script type="text/javascript" src="jquery1.8/jquery-1.8.0.min.js"></script>
  <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
		<center>
		<br><br><br><br>
		<fieldset style="width: 600px"><legend>login</legend>
				<span style="color: red; visibility: hidden;" id="error" >账号或者密码错误</span><p>
				<div id="reset" class="input-group" style="width: 30%">
					<span class="input-group-addon">账号</span>
					<input type="text" name="name" class="form-control">
				</div>
				<p/>
				<div id="pad" class="input-group " style="width: 30%">
					<span class="input-group-addon">密码</span>
					<input type="password" name="pwd" class="form-control"><p><br/>
				</div>
				<button class="button button-raised button-pill button-inverse button-small" name="login" onclick="login()">登录</button>
				<button class="button button-raised button-pill button-inverse button-small" name="reg" onclick="window.location.href='reg.jsp'">注册</button> 
		</fieldset>
	</center>
	<%
  		session.removeAttribute("error");
  	%>
  </body>
</html>
