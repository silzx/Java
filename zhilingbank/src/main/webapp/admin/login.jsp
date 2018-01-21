<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 登录系统jsp页面 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<script
	  src="http://code.jquery.com/jquery-3.2.1.min.js"
	  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	  crossorigin="anonymous"></script>
		<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	  	<script src="https://cdn.bootcss.com/angular.js/1.5.8/angular.min.js"></script>

	  	<script type="text/javascript">
		  	var phone=null;		//获取到手机号
		  	$(function(){
					$("#cardNum").blur(function(){
		  				$.ajax({
						data:{"cardNum":$("#cardNum").val()},	  	  					
		  					type:"post",
		  					dataType:"json",
		  					url:"user/codeCheck",
		  					success:function(data){
		  						if(data.mess){
		  							if(data.phone!=null){
		  								phone=data.phone;
		  								$("#phone").val(phone);
		  							}else{
		  								phone=null;
		  							}
		  						}else{
		  							phone=null;
		  							$("#font1").attr({"color":"red","size":"1"}).html("卡号有误，请重新输入");
		  						}
		  					},
		  					error: function(XMLHttpRequest, textStatus, errorThrown) {  
		                        alert(XMLHttpRequest.status);  
		                        alert(XMLHttpRequest.readyState);  
		                        alert(textStatus);  
		                    }, 
		  				});
		  			});
					
					$("#getMessage").click(function(){
				  		var code = 0;
				  		if(phone!=null){
				  			$.ajax({
								data:{"phoneNum":$("#phone").val()},	  	  					
									type:"post",
									dataType:"json",
									url:"captcha/getPhoneMessage",
									success:function(data){
										if(data.mess){
											code=data.code;
											alert(code);
											$("#codeBox").val(code);
										}else{
											alert("失败");
										}
									},
									error:function(){
										alert("出错啦！");
									},
								});
				  		}else{
				  			alert("无法发送");
				  		}
				  	})
				});
		  	
		  	function code(){
					$.ajax({
						data:{"code":$("input[name='codecheck']").val(),"source":$("#codeBox").val()},
						type:"post",
						dataType:"json",
						url:"card/codecheck",
						success:function(data){
							if(data.codecheck){
								$.ajax({
									data:{"cardNum":$("#cardNum").val(),"password":$("#password").val()},
									type:"post",
									dataType:"json",
									url:"/user/login",
									success:function(data){
										if(data.mess){
											location.href="/admin/user.jsp";
										}else{
											alert("登录名或者密码错误");
										}
									},
									error:function(){
										alert("出错啦!!!");
									}
								})
							}else{
								alert("手机验证码填写错误！");
							}
						},
						error:function(){
							alert("出错啦！");
						}
					});
				}
		  	</script>
		  	
		  	<script type="text/javascript">
		  	var a=false;
		  	var b=false;
		  	var c=false;
		  	$(function(){
				 $("input:eq(0)").blur(function(){
					var reg=/^[0-9]{16}$/;
					a=false;
					if(reg.test($("input:eq(0)").val())==false){
						$("#font1").attr({"color":"red","size":"1"}).html("请输入16位信用卡号");
						return;
					}else{
						$("#font1").attr({"color":"green","size":"1"}).html("");
						a=true;
					}
				});
				 $("input:eq(1)").blur(function(){
						var reg=/^[0-9]{6}$/;
						b=false;
						if(reg.test($("input:eq(1)").val())==false){
							$("#font2").attr({"color":"red","size":"1"}).html("请输入6位的数字密码");
							return;
						}else{
							$("#font2").attr({"color":"green","size":"1"}).html("");
							b=true;
						}
					});
				 $("input:eq(3)").blur(function(){
						var reg=/^[0-9]{4}$/;
						c=false;
						if(reg.test($("input:eq(3)").val())==false){
							$("#font3").attr({"color":"red","size":"1"}).html("请输入4位验证码");
							return;
						}else{
							$("#font3").attr({"color":"green","size":"1"}).html("");
							c=true;
						}
					});
				 $("form").submit(function(){
				  		if(a&&b&&c){
							return true;
						}else{
							return false;
						}
				  	});
		  	});
	  	</script>
	</head>
	<body>
			<div align="center">
				<div id="middlediv" style="border: 1px solid gainsboro; height: 700px; width: 729px; margin-left: -198px; margin-top: -10px; float: right;" align="center">
					<h4 style="margin-top: 20px;">欢迎登录</h4>
				<p></p><hr/>
	
						
						<form class="form-horizontal" role="form" action="#" id="login" method="post">
						  <div class="form-group">
						  	<font size="1" id="font1" style="float: left;margin-left: 140px">&nbsp;</font><br>
						    <label  class="col-sm-2 control-label">信用卡号</label>
						    <div class="col-sm-10">
						      <input id="cardNum" type="text" class="form-control"  placeholder="请输入信用卡号" name="cardNum">
						    </div>
						  </div>
						  <div class="form-group">
						  <font size="1" id="font2" style="float: left;margin-left: 140px">&nbsp;</font><br>
						    <label  class="col-sm-2 control-label">密码</label>
						    <div class="col-sm-10">
						      <input type="password" class="form-control"  placeholder="请输入密码" id="password">
						    </div>
						  </div>
						  
						  <div class="form-group">
						    <label  class="col-sm-2 control-label">手机验证码</label>
						    <div class="col-sm-10" style="width: 200px; margin-left: -22px;" >
						     	<input type="button" class="btn btn-warning" value="获取短信验证码" id="getMessage">
						    </div>
						  </div>
						  
						  <div class="form-group">
						  <font size="1" id="font3" style="float: left;margin-left: 140px">&nbsp;</font><br>
						    <label  class="col-sm-2 control-label">验证</label>
						    
						    <div class="col-sm-10">
						      <input type="text"  name="codecheck" class="form-control"  placeholder="请输入验证码">
						      <input id="codeBox" type="hidden">
						      <input id="phone" type="hidden">
						    </div>
						  </div>
						  
						  <div class="form-group">
						    <div class="col-sm-offset-2 col-sm-10" style="width: 520px;">
						     <a href="javascript:code()"><button type="button" class="btn btn-warning" style="width: 150px;">登录</button></a>
						    </div>
						  </div>
						</form>
				</div>
			</div>
	</body>
</html>

