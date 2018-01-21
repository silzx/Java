<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.UUID"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	  	<link rel="stylesheet" type="text/css" href="admin/css/buttons.css">
	  	<link href="http://cdn.bootcss.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<%
	String message = request.getParameter("message");   
	String price = request.getParameter("price");
	String uuid = UUID.randomUUID().toString().replace("-", "");
%>
<script type="text/javascript">
	$(function(){
		$("#trade").attr("disabled",true);
		var a=false;
		var b=false;
		var c=false;
		$("#trade").click(function(){
			$.ajax({
				url:"client/trade",
				type:"post",
				dataType:"json",
				data:{
					"cardNum":$("#cardNum").val(),
					"password":$("#pas").val(),
					"backCode":$("#cvv2").val(),
					"price":$("#price").html(),
					"tradeDate":$("#tradeDate").val(),
					"storeName":$("#storeName").val(),
					"posNum":$("#posNum").val(),
					"tradeType":$("#tradeType").val()
				},
				success:function(data){
					if(data.mess){
						alert(data.code);
						window.close();
					}else{
						alert(data.code);
					}
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) { 
					alert("系统异常，消费失败");
                }, 
			});
		});
		
		$("#cardNum").blur(function(){
			a=false;
			var reg=/^[0-9]{16}$/;
			if(reg.test($(this).val())==false){
				$("font:eq(1)").html("卡号格式有误！");
				a=false;
			}else{
				$("font:eq(1)").html("支付信息");
				a=true;
				if(a==true&&b==true&&c==true){
					$("#trade").attr("disabled",false);
				}
			}
		});
		$("#pas").blur(function(){
			b=false;
			var reg=/^[0-9]{6}$/;
			if(reg.test($(this).val())==false){
				$("font:eq(1)").html("密码为六位数字！");
				b=false;
			}else{
				$("font:eq(1)").html("支付信息");
				b=true;
				if(a==true&&b==true&&c==true){
					$("#trade").attr("disabled",false);
				}
			}
		});
		$("#cvv2").blur(function(){
			c=false;
			var reg=/^[0-9]{3}$/;
			if(reg.test($(this).val())==false){
				$("font:eq(1)").html("ccv2码为三位数字！");
				c=false;
			}else{
				$("font:eq(1)").html("支付信息");
				c=true;
				if(a==true&&b==true&&c==true){
					$("#trade").attr("disabled",false);
				}
			}
		});
		
		
		
	});
		
</script>
<body>
	<center>
	<div class="jumbotron"><h2>付款信息页面</h2></div> 
			<table class="table table-striped table-hover" style="width: 50%">
				<tr>
					<td align="center">商品名:</td>
					<td align="center"><%=message%></td>
				</tr>
				<tr>
					<td align="center">价格</td>
					<td align="center"><font id="price"><%=price%></font>元</td>
				</tr>
			</table>
			<p><p><p>
			<font>支付信息</font>
			<table class="table table-striped table-hover" style="width: 50%">
				<tr>
					<td align="center">卡号</td>
					<td align="center"><input id="cardNum"></td>
				</tr>
				<tr>
					<td align="center">支付密码</td>
					<td align="center"><input type="password" id="pas"></td>
				</tr>
				<tr>
					<td align="center">卡片背后三位数字</td>
					<td align="center"><input type="password" id="cvv2"></td>
				</tr>
			</table>
			<input type="hidden" id="posNum" value="10010011">
			<input type="hidden" id="storeName" value="zhilingbankstore">
			<input type="hidden" id="tradeDate" value="<fmt:formatDate value="<%=new Date() %>" pattern="yyyy-MM-dd HH:mm:ss"/>">
			<input type="hidden" id="tradeType" value="1">
			<button id="trade">确认支付</button>
	</center>
</body>
</html>