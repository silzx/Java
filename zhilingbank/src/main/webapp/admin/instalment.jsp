<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.zl.pojo.UserAllInfo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 分期业务jsp页面 -->
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
			<h3 style="margin-left: -750px;">分期业务</h3>	
			
			<hr style="height:1px;border:none;border-top:1px solid #555555;"/>
			</div>
			<div class="table-responsive">
			  <table class="table" >
			    <caption style="margin-left: 10px;">分期信息</caption>
			    <tbody>
			      <tr>
			        <th style="padding-left: 150px;">本期账单金额</th>
			        <td>${uai.bills.alreadyBill }</td></tr>
			      <tr>
			        <th style="padding-left: 150px;">未还款金额</th>
			        <td id="canFenqi">${uai.bills.notRefundNow }</td></tr>
			      <tr>
			      <tr>
			        <th style="padding-left: 150px;">输入分期金额</th>
			        <td>
			        	<input type="text" id="tarMoney">
			        </td></tr>
			      <tr>
			        <th style="padding-left: 150px;">选择分期</th>
			        <td><select style="width: 100px;" class="form-control" id="select">
				        	<option value="3">3期</option>
				        	<option value="6">6期</option>
				        	<option value="12">12期</option>
				        	<option value="24">24期</option>
			      		 </select>
			        </td></tr>
			      <tr>
			        <th style="padding-left: 150px;"><button id="count">计算分期手续费</button></th>
			        <td>
			        	<font id="monBox"></font>
			        </td></tr>
			        <tr>
			        <th style="padding-left: 150px;">每期需还金额</th>
			        <td id="moneyBox">
			        	
			        </td></tr>
			       <tr>
			       <th style="padding-left: 150px;"></th>
			       <td></td></tr>
			       
			    </tbody>
			  </table>
			  	<button id="fenqi" class="btn btn-warning" style="margin-left: -100px;" onclick="return confirm('是否确定分期！')">确定分期</button>
				<input type="hidden" value="${uai.bills.idCard }" id="idCard">
				<input type="hidden" value="${uai.bills.restqishu}" id="restqishu">
			</div>
			
			
			</div>
		</div>	
		
		<script type="text/javascript">
			$("#count").click(function(){
				var money=$("#tarMoney").val();
				var lixi;
				var month=$("#select").val();
				var canFenqi=$("#canFenqi").html();
				if(parseInt(money)>parseInt(canFenqi)){
					alert("分期金额不合法");
				}else{
					if(month==3){
						lixi=(money*0.00595).toFixed(2);
						money=(money/3+parseFloat(lixi)).toFixed(2)
						$("#monBox").html(lixi);
						$("#moneyBox").html(money);
					}
					if(month==6){
						lixi=(money*0.00515).toFixed(2);
						$("#monBox").html(lixi);
						money=(money/6+parseFloat(lixi)).toFixed(2)
						$("#moneyBox").html(money);
					}
					if(month==12){
						lixi=(money*0.00445).toFixed(2);
						money=(money/12+parseFloat(lixi)).toFixed(2)
						$("#monBox").html(lixi);
						$("#moneyBox").html(money);
					}
					if(month==24){
						lixi=(money*0.004).toFixed(2);
						money=(money/24+parseFloat(lixi)).toFixed(2)
						$("#monBox").html(lixi);
						$("#moneyBox").html(money);
					}
				}
			})
			
			$("#fenqi").click(function(){
				var restqishu=$("#restqishu").val();
				if(restqishu!=0){
					alert("您已分期，不能再次分期");
					return;
				}
				//确认分期，要把数据库中的金额改变为分期后的金额，同时页面显示也需要更新				
				//改变可分期金额，即未还部分
				var allmoney=parseFloat($("#canFenqi").html());	//可分期金额
				var tarmoney=parseFloat($("#tarMoney").val());		//分期金额
				var month=parseFloat($("#select").val());		//分期月数
				var paypermonth=parseFloat($("#moneyBox").html());	//每期需还金额
				var notrefund=(allmoney-tarmoney+paypermonth);
				
				if(paypermonth>0){
					$.ajax({
						data:{"qishu":month,"notRefundNow":notrefund,"refundByStages":paypermonth,"idCard":$("#idCard").val()},					
						type:"post",
						dataType:"json",
						url:"user/billByStages",
						success:function(data){
							if(data.mess){
								alert("分期成功");
								location.reload();
							}else{
								alert("分期失败，请联系客服");
							}
						},
						error:function(){
							alert("系统异常请联系客服");
						}
					});
				}else{
					alert("请计算分期手续费");
				}
			});
		</script>
		
		
	</body>
 </html> 
