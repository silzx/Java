<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 已出账单jsp页面 -->
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
		<div class="table-responsive">
		  <table class="table">
		    
		    <thead>
		      <tr>
		        <th>出账日期</th>
		        <td><fmt:formatDate value="${uai.bills.billDate }" pattern="yyyy年MM月dd"/></td>
		        
		        </tr>
		    </thead>
		    <tbody>
		    	<tr>
			        <th>最后还款日期</th>
			        <td><fmt:formatDate value="${uai.bills.payBack }" pattern="yyyy年MM月dd"/></td>
		        </tr>
		      <tr>
		        <th>本期账单额</th>
		        <td>${uai.bills.alreadyBill }</td>
		        </tr>
		      <tr>
		        <th>最低还款额</th>
		        <td>${uai.bills.alreadyBill/10 }</td>
		        </tr>
		      <tr>
		        <th>已还金额</th>
		        <td>${uai.bills.alreadyBill-uai.bills.notRefundNow }</td>
		        </tr>
		      <tr>
		        <th>未还金额</th>
		        <td>${uai.bills.notRefundNow }</td>
		        </tr>
		    </tbody>
		    <c:if test="${uai.bills.notRefundNow<=0 }">
		       	<td><font color="green" size="1">您的账单本期账单已还清</font></td>
		    </c:if>
		  </table>
		</div>
		
	</body>
 </html> 
