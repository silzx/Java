<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.zl.pojo.UserAllInfo" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 卡片服务jsp页面 -->
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
		<div style="width: 950px; height: 500px; border: 1px solid #555555;">
				<div style="margin-top: 20px;">
					<h3 style="margin-left: -750px;">账单信息</h3>	
					<hr style="height:1px;border:none;border-top:1px solid #555555;"/>
				</div>
				<div class="col-xs-3" id="myScrollspy">
				
		            <ul class="nav nav-tabs nav-stacked" data-spy="affix" data-offset-top="125" style="float: left; width: 150px;">
		                <li class="active"><a>卡片须知</a></li>
		                <li id="aa"><a>卡片注销</a></li>
		                <li id="bb"><a>卡片挂失</a></li>
		                <li id="cc"><a>解除挂失</a></li>
		            </ul>
        		</div>
				<div id="cardinfo" style=" margin-left: 150px; width: 600px; height: 400px;"></div>
		</div>	
		
		<script type="text/javascript">
			$("#cardinfo").load("admin/showcard.jsp");
			$("#aa").click(function(){
				$("#cardinfo").load("admin/logout.jsp")
			})
			$("#bb").click(function(){
				$("#cardinfo").load("admin/cardloss.jsp")
			})
			$("#cc").click(function(){
				$("#cardinfo").load("admin/cardback.jsp")
			})
			
		</script>
		
	</body>
 </html> 
