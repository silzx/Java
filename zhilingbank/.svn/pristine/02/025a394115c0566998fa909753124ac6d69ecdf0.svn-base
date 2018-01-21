<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 显示账户基本信息jsp页面 -->
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
	  	</script>
  </head>
  <body>
		<div class="table-responsive">
				  <table class="table">
				    
				    <thead>
				      	<tr>
					        <th>卡片状态</th>
					        <c:if test="${uai.cardMessage.cardStatus eq 0}">
					        	<td>未激活</td>
					        </c:if>
					        <c:if test="${uai.cardMessage.cardStatus eq 1}">
					        	<td>正常</td>
					        </c:if>
					        <c:if test="${uai.cardMessage.cardStatus eq 2}">
					        	<td>已挂失</td>
					        </c:if>
					        <c:if test="${uai.cardMessage.cardStatus eq 3}">
					        	<td>已冻结</td>
					        </c:if>
					        <c:if test="${uai.cardMessage.cardStatus eq 4}">
					        	<td>已注销</td>
					        </c:if>
					        
				        </tr>
				    </thead>
				    <tbody>
				    	<tr>
					        <th>账户总额度</th>
					        <td>${uai.user.creditline }</td>
				        </tr>
				        <tr>
					        <th>已用余额</th>
					        <td>${uai.user.creditline-uai.user.avabalance }</td>
				        </tr>
				    	<tr>
					        <th>可用余额</th>
					        <td>${uai.user.avabalance }</td>
				        </tr>
				     	<tr>
					        <th>溢出金额</th>
					        <td>${uai.user.overline }</td>
				        </tr>
				       
				    </tbody>
				  </table>
		</div>
		
		
	</body>
 </html> 
