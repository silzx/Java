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
		body {  
		background-image: url("../img/34b329e6-f9cf-42de-bbcc-b4f911e57704.jpg");  
		background-position: center 0;  
		background-repeat: no-repeat;  
		background-attachment: fixed;  
		background-size: cover;  
		-webkit-background-size: cover;  
		-background-size: cover;  
		-moz-background-size: cover;  
		-ms-background-size: cover;  
}
	</style>
	
	<%
   		String name="";
   		String pwd="";
   		Cookie[] cs=request.getCookies();
  		if(cs!=null){
  			for(Cookie c:cs){
  					if("nameC".equals(c.getName())){
  	  					name=c.getValue();
  	  					name=URLDecoder.decode(name, "utf-8");
  	  				}
  	  				if("pwdC".equals(c.getName())){
  	  					pwd=c.getValue();
  	  				}
  			}
  		}%>
  </head>
  <script type="text/javascript">
  
  function login(){
		$.ajax({
			type:"post",
			url:"emp/login",
			data:{"ename":$("input[name='name']").val(),"epwd":$("input[name='pwd']").val()},
			dataType:"json",
			success: function(date){
				if(date.mes){
					location.href="<%=basePath%>info/query";
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
					<input type="text" name="name" class="form-control" value="<%=name%>">
				</div>
				<p/>
				<div id="pad" class="input-group " style="width: 30%" onkeydown="if(event.keyCode==13) return login();">
					<span class="input-group-addon">密码</span>
					<input type="password" name="pwd" class="form-control" value="<%=pwd%>"><p><br/>
				</div>
				<button class="button button-raised button-pill button-inverse button-small" name="login" onclick="login()" onkeydown="return enter(event)">登录</button>
				<button class="button button-raised button-pill button-inverse button-small" name="reg" onclick="window.location.href='reg.jsp'">注册</button> 
		</fieldset>
	</center>
	<%
  		session.removeAttribute("error");
  	%>
  </body>
</html>
