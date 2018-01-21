<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 未出账单jsp页面 -->
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
	  	$(function(){
	  		$("#check").click(function(){
	  			$.ajax({
	  				data:{"cardNum":$("#cardnum").val()},	  	  					
	  				type:"POST",
	  				dataType:"json",
	  				url:"user/record",
	  				success:function(data){
	  					var url='Add.aspx';                      //转向网页的地址; 
	 		           	var name='消费记录';                          //网页名称，可为空; 
	 		           	var iWidth=900;                          //弹出窗口的宽度; 
	 		           	var iHeight=600;                         //弹出窗口的高度; 
	 		           	//获得窗口的垂直位置 
	 		           	var iTop = (window.screen.availHeight - 30 - iHeight) / 2; 
	 		           	//获得窗口的水平位置 
	 		           	var iLeft = (window.screen.availWidth - 10 - iWidth) / 2; 
	 		           	window.open('admin/costbill.jsp', name, 'height=' + iHeight + ',,innerHeight=' + iHeight + 
	 		        		   ',width=' + iWidth + ',innerWidth=' + iWidth + ',top=' + iTop + ',left=' + iLeft + 
	 		        		   ',status=no,toolbar=no,menubar=no,location=no,resizable=no,scrollbars=0,titlebar=no');
					},
					error:function(){
						alert("error");
					}
	  			});
	  		});
	  	});
	  	</script>
  </head>
<body>
		<div class="table-responsive">
		<input id="cardnum" type="hidden" value="${uai.cardMessage.cardNum }">
				  <table class="table">
				    <thead>
				      <tr>
				        <th>出账日期</th>
				        <td><fmt:formatDate value="${uai.bills.nextBillDate }" pattern="yyyy年MM月dd日"/></td>
				        </tr>
				    </thead>
				    <tbody>
				    	<tr>
					        <th>未出账单总金额</th>
					        <td>${uai.bills.notreadyBill }</td>
				        </tr>
				      <tr>
				        <th>未出账单消费详情</td>
				        <td><button id="check" class="btn btn-primary">点击查看</button></td>
				        </tr>
				    </tbody>
				  </table>
		</div>
	</body>
 </html> 
