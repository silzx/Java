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
	<center>
		<br><br><br><br>
		<fieldset style="width: 600px"><legend>register</legend>
				<form action="<%=basePath%>UserAction/regsiter.action" method="post" onsubmit="return sub()" enctype="multipart/form-data">
				<div  class="input-group" style="width: 30%">
					<span class="input-group-addon">账号</span>
					<input type="text" name="u.name" id="name" class="form-control">
				</div><font id="a"></font><p>
				<div  class="input-group " style="width: 30%">
					<span class="input-group-addon">密码</span>
					<input type="password" name="u.pwd" id="pwd" class="form-control" >
				</div><font id="b"></font><p>
				<div  class="input-group " style="width: 30%">
					<span class="input-group-addon">密码</span>
					<input type="password" name="second" id="sec" class="form-control" >
				</div><font id="c"></font><p>
				<div  class="input-group " style="width: 30%">
					<span class="input-group-addon">年龄</span>
					<input type="text" name="u.age" class="form-control" >
				</div><p>
				<div  class="input-group " style="width: 30%">
					<span class="input-group-addon">昵称</span>
					<input type="text" name="u.nickname" class="form-control" >
				</div><p>
				<label>头像</label>
				<input type="file" name="img"><p>
				</p>
				<input type="submit" class="button button-action  button-rounded button-small" value="注册"> 
				</form>
		</fieldset>
	</center>
  </body>
  <script type="text/javascript">
	 	var name=false;
		var pwd=false;
		var second=false;
		$(function(){
			//用户名判断
			$("input").blur(function(){
				if(this.name=="u.name"){
					name=false;
					if($("#name").val()==""){
						$("#a").attr({"size":"1","color":"red"}).html("用户名不可为空！");
						return;
					}else{
						$.ajax({
							type:"post",
							data:{"u.name":$("input[name='u.name']").val()},
							dataType:"json",
							url:"UserAction/regName.action",
							success: function(date){
								if(date.meg){
									$("#a").attr({"size":"1","color":"red"}).html("有重复用户名");
								}else{
									name=true;
									$("#a").attr({"size":"1","color":"green"}).html("用户校验通过");
								}
							}
						})
					}
				}
				if(this.name=="u.pwd"){
					pwd=false;
					if(this.value==""){
						$("#b").attr({"size":"1","color":"red"}).html("密码不可为空！");
						return;
					}else{
						if(this.value.length<3){
							$("#b").attr({"size":"1","color":"red"}).html("密码必须是3位数以上！");
						}else{
							var i=/^[A-Za-z0-9]+$/;
							if(i.test(this.value)){
								$("#b").attr({"size":"1","color":"green"}).html("密码校验通过");
								pwd=true;
							}else{
								$("#b").attr({"size":"1","color":"red"}).html("密码只能由数字与字母构成！");
							}
						}
					}
				}
				if(this.name=="second"){
					second=false;
					if(this.value==$("#pwd").val()){
						$("#c").attr({"size":"1","color":"green"}).html("二次密码校验通过");
						second=true;
					}else{
						$("#c").attr({"size":"1","color":"red"}).html("两次输入的密码要一致！");	
					}
				}
			});
		});
		function sub(){
				if(name && pwd && second){
					return true;
				}else{
					return false;
				}
			}
	</script>
</html>
