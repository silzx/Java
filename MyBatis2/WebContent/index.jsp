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
  function reset(){
		document.getElementById("error").style.visibility="hidden";
		$("input[name='name']").val("");
		$("input[name='pwd']").val("");
	}
  </script>
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
  		}String errorinfo="";
  		if(session.getAttribute("error")!=null){%>
<!--   			errorinfo=(String)session.getAttribute("error"); -->
			<script type="text/javascript">
				function display(){
					document.getElementById("error").style.visibility="visible";
				}
				window.onload=display;
			</script>
  		<%}
   		%>
  <body>
  <script type="text/javascript" src="jquery1.8/jquery-1.8.0.min.js"></script>
  <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
		<center>
		<br><br><br><br>
		<fieldset style="width: 600px"><legend>login</legend>
				<form action="<%=basePath%>UserAction/userLogin.action" method="post">
				<span style="color: red; visibility: hidden;" id="error" >账号或者密码错误</span><p>
				<div id="reset" class="input-group" style="width: 30%">
					<span class="input-group-addon">账号</span>
					<input type="text" name="u.name" class="form-control" value="<%=name %>">
				</div>
				<p/>
				<div id="pad" class="input-group " style="width: 30%">
					<span class="input-group-addon">密码</span>
					<input type="password" name="u.pwd" class="form-control" ><p><br/>
				</div>
				<button class="button button-raised button-pill button-inverse button-small" name="login" type="submit">登录</button>
				</form>
				<button class="button button-raised button-pill button-inverse button-small" name="reg" onclick="window.location.href='reg.jsp'">注册</button> 
		</fieldset>
	</center>
	<%
  		session.removeAttribute("error");
  	%>
  </body>
</html>
