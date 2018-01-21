<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.zl.pojo.UserAllInfo" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 个人信息中心jsp页面 -->
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
  		<script type="text/javascript">
  			$(function(){
				$("#updateMessage").click(function(){
			           var name='add';                          //网页名称，可为空; 
			           var iWidth=700;                          //弹出窗口的宽度; 
			           var iHeight=600;                         //弹出窗口的高度; 
			           //获得窗口的垂直位置 
			           var iTop = (window.screen.availHeight - 30 - iHeight) / 2; 
			           //获得窗口的水平位置 
			           var iLeft = (window.screen.availWidth - 10 - iWidth) / 2; 
			           window.open('admin/updateinfo.jsp', name, 'height=' + iHeight + ',,innerHeight=' + iHeight + ',width=' + iWidth + ',innerWidth=' + iWidth + ',top=' + iTop + ',left=' + iLeft + ',status=no,toolbar=no,menubar=no,location=no,resizable=no,scrollbars=0,titlebar=no'); 
			          // window.open("AddScfj.aspx", "newWindows", 'height=100,width=400,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no'); 				
				});  				
  			});
  		</script>
  		<style type="text/css">
  			tr{margin: center;}
  		</style>
  </head>
 <body>
		<div style="width: 950px; height: 500px; border: 1px solid #555555;">
			<div style="margin-top: 20px;">
			<h3 style="margin-left: -750px;">个人中心</h3>	
			
			<hr style="height:1px;border:none;border-top:1px solid #555555;"/>
			</div>
			<div class="table-responsive">
			  <table class="table" >
			    <caption style="margin-left: 10px;">个人基本信息</caption>
			    <tbody>
			      <tr>
			        <th style="padding-left: 150px;">持卡人姓名</th>
			        <td>${uai.user.username }</td></tr>
			      <tr>

			        <th style="padding-left: 150px;">卡号</th>
			        <td>${uai.cardMessage.cardNum }</td></tr>
			      <tr>

			        <th style="padding-left: 150px;">身份证号码</th>
			        <td>${uai.cardMessage.idCard }</td></tr>
			      <tr>
			        <th style="padding-left: 150px;">手机号码</th>
			        <td>${uai.user.phone }</td></tr>
			        
			       <tr>
			       <th style="padding-left: 150px;">单位地址</th>
			       <td>${uai.user.companyAdd }</td></tr>
			       
			       <tr>
			       <th style="padding-left: 150px;">紧急联系人</th>
			       <td>${uai.user.linkman }</td></tr> 
			       <tr>
			       <th style="padding-left: 150px;">联系人电话</th>
			       <td>${uai.user.linkphone }</td></tr>
			    </tbody>
			  </table>
			  	<button class="btn btn-warning" style="margin-left: -100px;" id="updateMessage">修改资料</button>
			</div>
		</div>
		
	</body>
 </html>
