<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 卡片管理jsp页面，与开发无关 -->
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
  </head>
	<body>
		<div align="center">
			<div style="width: 950px; height: 30px; background-color: aliceblue;">
			<font style="float: left; line-height: 30px;" size="2">尊&nbsp;敬&nbsp;的&nbsp;${uai.user.username }&nbsp;您&nbsp;好&nbsp;!&nbsp;</font>
			<a href="user/exitSys"><font style="float: right; line-height: 30px; margin-right: 10px;" size="2">注&nbsp;销</font></a>
			</div>
			<div align="center"><img src="img/gerenguanli.png"></div>
					<div style="width: 950px;" align="center" >
						<nav class="navbar navbar-default" role="navigation" style="background-color: coral">
						    <div class="container-fluid" align="center" style="width: 600px; padding-left: 80px;">
							    <div>
							        <ul class="nav navbar-nav" style="font-size: 14px;">
							            <li class="active" id="a"><a>个人中心</a></li>
							            <li  id="b"><a>交易记录</a></li>
							            <li  id="c"><a>账单管理</a></li>
							            <li  id="d"><a>卡片管理</a></li>
							            <li id="e"><a>分期服务</a></li>
							        </ul>
							    </div> 
						    </div>
						</nav>
						
					</div>
					<div id="yemian"></div>
		</div>
		
		<div id="foot">
			
			
			
			
		</div>
		<script type="text/javascript">
			$("#yemian").load("admin/accountinfo.jsp");
			$("#a").click(function(){
				$("#yemian").load("admin/accountinfo.jsp");
			});
			
			/*
			查询所有消费记录
			谢文奇
			*/
			$("#b").click(function(){
				$.ajax({
						data:"",
						type:"post",
						dataType:"json",
						//url:"user/queryConsumeInfo",
						url:"user/getRecords",
						success:function(data){
							if(data.mess){
								$("#yemian").load("admin/consumeinfo.jsp");
	  						}else if(data.noresult){
  	  							selectMeyhod2();
  	  						}else{
	  							$("#yemian").load("admin/consumeinfo.jsp");
	  							//alert("查询消费记录失败");
	  							return false;
	  						}
						},
						error:function(){
							$("#yemian").load("admin/consumeinfo.jsp");
							return false;
						}
					});
			});
			
			function selectMeyhod2(){
					$.ajax({
						data:{"page" : 1},
						type:"post",
						dataType:"json",
						url:"user/queryConsumeInfo",
						success:function(data){
							if(data.mess){
								$("#yemian").load("admin/consumeinfo.jsp");
	  							return true;
	  						}else if(data.noresult){
	  							$("#tbody1").text("没有消费记录");
	  						}else{
	  							alert("查询失败");
	  							return false;
	  						}
						},
						error:function(){
							$("#yemian").load("admin/consumeinfo.jsp");
							return false;
						}
					});
				}
			
			$("#c").click(function(){
				$("#yemian").load("admin/bill.jsp");
			});
			$("#d").click(function(){
				$("#yemian").load("admin/cardservice.jsp");
			});
			$("#e").click(function(){
				$("#yemian").load("admin/instalment.jsp");
			});
			
			$(".nav li").click(function(){
				$(".nav li").removeClass("active");
				$(this).addClass("active");
			})
			
		</script>
		
	</body>
 </html> 
