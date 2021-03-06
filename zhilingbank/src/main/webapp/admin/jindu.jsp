<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 进度查询jsp页面 -->
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
	  	<script type="text/javascript" src="js/distpicker.js"></script>
<script type="text/javascript">
  		
  			$(function(){
  				var phoneNum = null;//手机号
  				var authCode = 0;//手机验证码
  				var doveryfi = false;//判断手机验证码
  				var status = null;//申卡状态
  				
  				//获取手机号方法
  				function getPhoneNum(){
  					//身份证号正则表达式
  					var regIdNo = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/; 
  					
  					if(!regIdNo.test($("#idCardInput").val())){
  						$("#IdCardHint").text("身份证号输入错误"); 
  					  	return false; 
  					}else{
	  					$.ajax({
	  						data:{"idCard":$("#idCardInput").val()},
	  						type:"post",
	  						dataType:"json",
	  						url:"card/getPhoneNumByIdCard",
	  						success:function(data){
	  							if(data.phoneNumMessage){
	  	  							phoneNum = data.phoneNum;
	  	  							status = data.status;
	  	  							return true;
	  	  						}else{
	  	  							$("#IdCardHint").text("未查询到预留手机号，请检查证件号是否正确");
	  	  							return false;
	  	  						}
	  						},
	  						error:function(){
	  							alert("获取手机号出错");
	  							return false;
	  						}
	  					});
  					}
  				}
  				
  				$("#getAuthCodeBtn").click(function(){
  					getPhoneNum();
  					if(phoneNum != null){
	  	  				$.ajax({
							data:{"phoneNum":phoneNum},	  	  					
	  	  					type:"post",
	  	  					dataType:"json",
	  	  					url:"captcha/getPhoneMessage",
	  	  					success:function(data){
	  	  						if(data.mess){
	  	  							alert("验证码已发送");
	  	  							authCode = data.code;
	  	  							alert(authCode);
	  	  						}else{
	  	  							alert("失败");
	  	  						}
	  	  					},
	  	  					error:function(){
	  	  						alert("验证码发送出错啦！");
	  	  						return false;
	  	  					}
	  	  					
	  	  				});
  					}
  	  			});
  				
  		
  			
  			function verifyCode(){
  				var aci = $("#authCodeInput").val();
  				if(aci != authCode){
  					$("#authCodeHint").text("验证码错误");
  					return false;
  				}else{
  					doveryfi = true;
  				}
  			}
  			
  			
  			//定制提交按钮事件
  			$("#comitInfo").click(function(){
  				verifyCode();
  				if(doveryfi){
  					if(status==0){
  						window.location.href="admin/ing.jsp";
  						alert("审核中...");
  					}else if(status==1){
  						window.location.href="admin/pass.jsp";
  						alert("申请通过");
  					}else if(status==2){
  						window.location.href="admin/notpass.jsp";
  						alert("申请失败");
  					}else{
  						alert("有误，请联系客服");
  					}
  				}else{
  					alert("查询失败");
  					return false;
  				}
  			});
  			
  			//当“信用卡号”输入框获取焦点时，取消信用卡输入错误的提示信息
  			$("#idCardInput").focus(function(){
  				$("#IdCardHint").text("");
  			});
  			//当“支付密码”输入框获取焦点时，取消信用卡输入错误的提示信息
  			$("#authCodeInput").focus(function(){
  				$("#authCodeHint").text("");
  			});
  		});
  		
  		</script>
  </head>
  <body>
		<div align="center"><img src="img/111111111111111111.png"></div>
		<div align="center">
			<div align="center" style="width: 700px;">
				<form class="form-horizontal" role="form" action="">
					  <div class="form-group" align="center">
					    <label  class="col-sm-2 control-label">身份证号</label>
					    <div class="col-sm-10" style="margin-left: 0px;">
					      <input type="text" class="form-control" id="idCardInput" placeholder="请输入身份证号">
					      <font id="IdCardHint" color="red"></font>
					    </div>
					  </div>
					  
					  <div class="form-group">
						    <label  class="col-sm-2 control-label">手机验证码</label>
						    <div class="col-sm-10" style="width: 200px;" >
						      <input type="button" class="btn btn-warning" id="getAuthCodeBtn" value="获取手机验证码" >
						    </div>
					  </div>
					  
					  <div class="form-group">
					    <label  class="col-sm-2 control-label">验证</label>
					    <div class="col-sm-10" style="margin-left: 0px;">
					      <input type="text" class="form-control" id="authCodeInput"  placeholder="请输入验证码">
					      <font id="authCodeHint" color="red"></font>
					    </div>
					  </div>
					  <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10" style="width: 520px;">
					      <button type="submit" class="btn btn-warning" id="comitInfo" style="width: 130px;">查询</button>
					  </div>
				
				<form>
			</div>
			
		</div>
	</body>
 </html> 
