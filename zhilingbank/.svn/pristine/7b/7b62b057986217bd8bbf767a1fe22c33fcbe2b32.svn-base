<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.zl.pojo.UserAllInfo" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 账单信息jsp页面  -->
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
	  	<% UserAllInfo user=(UserAllInfo)session.getAttribute("uai"); 
   			if(user==null){%>
			<script type="text/javascript">
				alert("登录超时！");
				parent.location.reload();
			</script>
		<%} %>
  </head>
	<body>
	<input value="${uai.user.idCard }" id="idcard" type="hidden">
		<div style="width: 950px; height: 500px; border: 1px solid #555555;">
				<div style="margin-top: 20px;">
					<h3 style="margin-left: -750px;">账单信息</h3>	
					<hr style="height:1px;border:none;border-top:1px solid #555555;"/>
				</div>
				<div class="col-xs-3" id="myScrollspy">
				
		            <ul class="nav nav-tabs nav-stacked" data-spy="affix" data-offset-top="125" style="float: left; width: 150px;">
		                <li id="showacount"><a>个人账户</a></li>
		                <li id="billalready" ><a>已出账单</a></li>
		                <li id="billnotready"><a>未出账单</a></li>
		            </ul>
        		</div>
				<div id="billinfo" style=" margin-left: 50px; width: 600px; height: 400px;"></div>
		</div>	
		<button id="bill">产生账单</button>
		<script type="text/javascript">
			$("#bill").click(function(){
				$.ajax({
					dataType:"json",
					url:"card/dobill",
					success:function(){
						alert("ok");
					},
					error:function(){
						alert("notok")
					}
				})				
			})	
		
			$(function(){
				$.ajax({
					data:{"idCard":$("#idcard").val()},	  	  					
	  				type:"post",
	  				dataType:"json",
	  				url:"user/query",
	  				success:function(data){
					},
					error:function(){
						
					}
				});
			}) ;
			
			$("#billinfo").load("admin/showaccount.jsp");
			$("#billalready").click(function(){
				$("#billinfo").load("admin/billalready.jsp");
			})
			$("#billnotready").click(function(){
				$("#billinfo").load("admin/billnotready.jsp");
			});
			$("#showacount").click(function(){
				$("#billinfo").load("admin/showaccount.jsp");
			});
		</script>
		
		
	</body>
 </html> 
