<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 开卡功能jsp页面 -->
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
<script src="http://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/angular.js/1.5.8/angular.min.js"></script>
<script type="text/javascript" src="js/distpicker.js"></script>
<script type="text/javascript" src="js/md5.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript">
  		
  			$(function(){
  				var phoneNum = null;//手机号
  				var authCode = 0;//手机验证码
  				var doPw1 = false;
  				var doPw2 = false;
  				var doveryfi = false;//判断手机验证码
  				
  				//根据信用卡号获取关联的手机号
  				$("#inputCardNum").blur(function(){
  					$.ajax({
  						data:{"cardNum":$("#inputCardNum").val()},
  						type:"post",
  						dataType:"json",
  						url:"card/getPhoneNum",
  						success:function(data){
  							if(data.phoneNumMessage){
  								$("#phoneNumHint").text("");
  	  							phoneNum = data.phoneNum;
  	  						}else{
  	  							$("#phoneNumHint").text("信用卡号输入错误");
  	  							return false;
  	  						}
  						},
  						error:function(){
  							return false;
  						}
  					});
  				});
  				
  			
  			
  			//判断支付密码是否符合规则
  			$("#pw1").blur(function(){
  				$.ajax({
						data:{"pw":$("#pw1").val()},
						type:"post",
						dataType:"json",
						url:"card/judgePW",
						success:function(data){
							if(!data.pwMessage){
	  							$("#pw1Message").text("支付密码必须是六位数数字");
	  							return false;
	  						}else{
	  							$("#pw1Message").text("");
	  							doPw1 = true;
	  						}
						},
						error:function(){
							alert("支付密码出错");
							return false;
						}
					});
  			});
  			

  			//判断“确认密码”是否正确
  			function verifyPw2(){
  				var pw1 = $("#pw1").val();
  				var pw2 = $("#pw2").val();
  				if(pw1 != pw2){
  					$("#pw2Message").text("两次密码不一致，请检查");
						return false;
  				}else{
  					doPw2 = true;
  					$("#pw2Message").text("");
  				}
  			}
  			
  			/* //失去焦点时判断两次密码是否一致
  			$("#pw2").blur(function(){
  				verifyPw2();
  			}); */
  			
  			//获取手机验证码。同时判断两次密码是否一致，因为输入完确认密码之后直接点获取验证码按钮不会触发失去焦点事件
  			$(function(){
  				$("#getAuthCodeBtn").click(function(){
  					verifyPw2();
  					if(doPw2){
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
		  	  						alert("出错啦！");
		  	  						return false;
		  	  					}
		  	  					
		  	  				});
	  					}else{
	  						alert("未查询到手机号，请检查卡号是否正确！");
	  					}
  					}else{
  						return;
  					}
  	  			});
  				
  			});
  			
  			//判断手机验证码
  			function verifyCode(){
  				var aci = $("#authCodeInput").val();
  				if(aci != authCode){
  					$("#authCodeHint").text("验证码错误");
  					return false;
  				}else{
  					doveryfi = true;
  				}
  			};
  			
  				
  			//判断“确认密码”是否正确
  			$("#pw2").blur(function(){
  				var pw1 = $("#pw1").val();
  				var pw2 = $("#pw2").val();
  				if(pw1 != pw2){
  					$("#pw2Message").text("两次密码不一致");
						return false;
  				}else{
  					doPw2 = true;
  				}
  			});
  			
  			
  			//定制提交按钮事件，先触发一次判断验证码
  			$("#comitInfo").click(function(){
  				verifyCode();
  				var salt = "0z9x8c7v6b5n4m";
  				var pass = $("#pw1").val();
  				var str = "" + salt.charAt(0)+salt.charAt(2)+salt.charAt(4)+pass+salt.charAt(5)+
    			salt.charAt(13)+salt.charAt(12)+salt.charAt(11)+salt.charAt(10)+salt.charAt(9);
  				var password = md5(str);
  				if(doPw1 && doPw2 && doveryfi){
  					$.ajax({
						data:{"cardNum":$("#inputCardNum").val(),"password":password},
						type:"post",
  	  					dataType:"json",
  	  					url:"card/activationCard",
  	  					success:function(data){
  	  						if(data.activationMessage){
  	  							location.href="admin/opshow.jsp";
  	  						}else{
  	  							location.href="admin/opfailed.jsp";
  	  							alert("激活失败，请联系人工客服");
  	  						}
  	  					},
  	  				error: function(XMLHttpRequest, textStatus, errorThrown) {  
                        alert(XMLHttpRequest.status);  
                        alert(XMLHttpRequest.readyState);  
                        alert(textStatus);  
                    }, 
  	  					
  	  				});
  				}else{
  					alert("提交失败");
  					return false;
  				}
  			});
  			
  			//当“信用卡号”输入框获取焦点时，取消信用卡输入错误的提示信息
  			$("#inputCardNum").focus(function(){
  				$("#phoneNumHint").text("");
  			});
  			//当“支付密码”输入框获取焦点时，取消信用卡输入错误的提示信息
  			$("#pw1").focus(function(){
  				$("#pw1Message").text("");
  			});
  			//当“确认密码”输入框获取焦点时，取消确认密码错误的提示信息
  			$("#pw2").focus(function(){
  				$("#pw2Message").text("");
  			});
  		//当“确认密码”输入框获取焦点时，取消确认密码错误的提示信息
  			$("#authCodeInput").focus(function(){
  				$("#authCodeHint").text("");
  			});
  		
  		});
  		
  		</script>
</head>
<body>
	<div align="center">
		<img src="img/111111111111111111.png">
	</div>
	<div align="center">
		<div align="center" style="width: 700px;">
			<!-- <form class="form-horizontal" role="form" action=""> -->
				<div class="form-group" align="center">
					<label class="col-sm-2 control-label">信用卡号</label>
					<div class="col-sm-10" style="margin-left: 0px;">
						<input type="text" class="form-control" id="inputCardNum"
							placeholder="请输入信用卡号">
						<!-- 信用卡号输入错误是显示提示信息 -->
						<font id="phoneNumHint" color="red" size="1" style="float: left"></font><br/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" style="clear: both;">支付密码</label>
					<div class="col-sm-10" style="margin-left: 0px;">
						<input type="password" class="form-control" id="pw1" placeholder="请输入密码">
						<!-- 支付密码输入不符合规则时显示提示信息 -->
						<font id="pw1Message" color="red" size="1" style="float: left"></font><br/>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label" style="clear: both;">确认支付密码</label>
					<div class="col-sm-10" style="margin-left: 0px;">
						<input type="password" class="form-control" id="pw2" placeholder="请再次输入密码">
						<!-- 两次密码输入不一样时显示提示信息 -->
						<font id="pw2Message" color="red" size="1" style="float: left"></font><br/>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label" style="clear: both;">手机验证码</label>
					<div class="col-sm-10" style="width: 200px;">
						<input type="button" class="btn btn-warning" id="getAuthCodeBtn" value="获取手机验证码">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label" style="clear: both;">验证</label>
					<div class="col-sm-10" style="margin-left: 0px;">
						<input type="text" class="form-control" id="authCodeInput" placeholder="请输入验证码"><!-- 两次密码输入不一样时显示提示信息 -->
						<!-- 验证码不匹配时显示提示 -->
						<font id="authCodeHint" color="red" size="1" style="float: left"></font><br/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10" style="width: 520px;">
						<button type="submit" class="btn btn-warning" id="comitInfo"
							style="width: 130px;">提交</button>
					</div>
				</div>
			<!-- </form> -->
		</div>
	</div>
</body>
</html>
