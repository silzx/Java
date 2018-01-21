<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.zl.pojo.UserAllInfo" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!-- 消费记录jsp页面 -->
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
	  	<script type="text/javascript" src="js/distpicker.js"></script>
	  	<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
	  	<% UserAllInfo user=(UserAllInfo)session.getAttribute("uai"); 
   			if(user==null){%>
			<script type="text/javascript">
				alert("登录超时！");
				parent.location.reload();
			</script>
		<%} %>
		<script type="text/javascript">
  		
  			$(function(){
  				var page = 0;
  				//下一页事件
  				$("#nextPage").click(function(){
  					page = 1;
  					selectMeyhod();
  				});
  				
  				//上一页事件
  				$("#lastPage").click(function(){
  					page = -1;
  					selectMeyhod();
  				});
  				
  				$("#timeBtn").click(function(){
  					page = 0;
  					selectMeyhod();
  				});
  		
  				//根据时间条件改变访问的方法
  				function selectMeyhod(){
  					//默认查询redis中的数据
  			    	var url = "user/getRecords";
  					
  					//当有时间条件时，进入mysql数据库查询
  			    	if($("#dt1").val() != null && $("#dt1").val() != "" && $("#dt2").val() != null && $("#dt2").val() != ""){
  			    		url = "user/queryConsumeInfo";
  			    	}
  					$.ajax({
  						data:{"page":page, "timeIn1":$("#dt1").val(), "timeIn2":$("#dt2").val()},
  						type:"post",
  						dataType:"json",
  						//url:"user/queryConsumeInfo",
  						url:url,
  						success:function(data){
  							if(data.mess){
  								$("#yemian").load("admin/consumeinfo.jsp");
  	  							return true;
  	  						}else if(data.noresult){
  	  							selectMeyhod2();
  	  						}else{
  	  							alert("查询失败");
  	  							return false;
  	  						}
  						},
  						error:function(){
  							alert("查询出错");
  							return false;
  						}
  					});
  				}
  				
  				function selectMeyhod2(){
  					$.ajax({
  						data:{"page":page, "timeIn1":$("#dt1").val(), "timeIn2":$("#dt2").val()},
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
  							alert("查询出错");
  							return false;
  						}
  					});
  				}
  				
  				
  			});
  		
  		</script>
  		
  </head>
<body>
			<div style="width: 950px; height: 500px; border: 1px solid #555555;">
				<div style="margin-top: 20px;">
				<h3 style="margin-left: -750px;">交易信息</h3>	
				<hr style="height:1px;border:none;border-top:1px solid #555555;"/>
				</div>
					<input id="dt1" type="text" class="Wdate" value="${firstTime }" onfocus="WdatePicker({readOnly:true,maxDate:'%y-%M-%d'})" />&nbsp;
					-&nbsp;
					<input id="dt2" type="text" class="Wdate" value="${lastTime }" onfocus="WdatePicker({readOnly:true,maxDate:'%y-%M-%d'})" />
					<input type="submit" id="timeBtn" class="btn btn-warning" value="查询" />
				<div class="table-responsive">
						<table class="table" align="center">
							<caption>交易信息详情</caption>
							<thead>
								<tr align="center">
									<td><font  style="font-weight:bold">交易编号</font></td>
									<td><font  style="font-weight:bold">交易时间</font></td>
									<td><font  style="font-weight:bold">交易种类</font></td>
									<td><font  style="font-weight:bold">交易金额</font></td>
								</tr>
							</thead>
							
							<tbody id="tbody1">
								<c:forEach items="${TRList }" var="record">
									<tr align="center" align="center">
										<td>${record.tradeUUID }</td>
										<td><fmt:formatDate value="${record.tradeDate }" pattern="yyyy-MM-dd hh:mm:ss"/></td>
										<td>${record.tradeType }</td>
										<td>${record.trade }</td>
									</tr>
								</c:forEach>
								<tr style="text-align: center;">
									<td colspan="4">
										<button id="lastPage">上一页</button>&nbsp;&nbsp;
										<span> ${page } / ${pageCount } </span>&nbsp;&nbsp;
										<button id="nextPage">下一页</button>
									</td>
								</tr>
							</tbody>
					</table>
				</div>
				
				
				
			</div>	
	
	</body>
 </html> 
