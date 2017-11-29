<%@page import="com.wzx.dto.FenYe"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="buttons/buttons.css">
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
  		input[name='exit']{position: fixed; right: 200px;height: 200px}
  	</style>
  </head>
  <body>
  <script type="text/javascript" src="jquery1.8/jquery-1.8.0.min.js"></script>
  <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<center>
		<div class="jumbotron">
			<h2>欢迎&nbsp;${user.nickname }&nbsp;登录</h2>&nbsp;&nbsp;
		</div>
		<div>
			<form action="<%=basePath%>CarAction/carlist.action" method="post" id="reset" class="form-search">
				<input type="text" value="<%=FenYe.page %>" name="page"/>
				<input type="text" value="<%=FenYe.pageCount %>" name="pageCount"/>
				汽车品牌：
				<input type="text" name="brand" class="input-medium search-query" value="${brand }">&nbsp;&nbsp;
				汽车颜色：
				<input type="text" name="color" class="input-medium search-query" value="${color }">
				生产日期：
				<input type="text" name="startDate" class="input-medium search-query" value="${startDate }">~
				<input type="text" name="endDate" class="input-medium search-query" value="${endDate }">
				<button type="submit" class="button button-action  button-rounded button-small">搜索</button>
				<a href="javascript:reset()"><input type="button" class="button button-square  button-rounded button-small" value="重置"></a>
			</form>
		</div>
		<div >
			<form action="CarAction/del.action" method="post">
			<table border="0" class="table table-striped table-hover">
			<tr align="center">
				<td>
				<input type="checkbox" name="selAll" style="display: none;">
				<input type="button" class="btn btn-warning" value="全选" onclick="aclick()">
				</td> 
				<td>序号</td>
				<td>品牌</td>
				<td>颜色</td>
				<td>座位数</td>
				<td>日租金</td>
				<td>添加日期</td>
				<td>删除</td>
				<td>查看</td>
			</tr>
				<c:forEach items="${cars}" var="c" varStatus="status">
				<tr align="center">
				<td><input type="checkbox" name="ids" value="${c.cid }"></td>
				<td>${status.index+1}</td>
				<td>${c.brand }</td>
				<td>${c.color }</td>
				<td>${c.seats }</td>
				<td>${c.daycast }</td>
				<td><fmt:formatDate value="${c.addtime }" pattern="yyyy年MM月dd日"/></td>
				<td><a href="CarAction/del.action?ids=${c.cid }"><input type="button" class="button button-3d button-caution button-small" value="删除"></a></td>
				<td><a href="CarAction/check.action?id=${c.cid }"><input type="button" class="button button-3d button-primary button-small" value="查看"></a></td>
				</tr>
				</c:forEach>
		</table>
			<div class="button-group">
			    <button type="submit" class="button button-royal button-rounded button-raised" onclick="return confirm('是否删除？')">删除选中</button>
			    <button type="button" class="button button-royal button-rounded button-raised" onclick="location.href='CarAction/mid.action'">新增汽车</button>
  			</div><p><p>
  			<div>
  				<a href="javascript:firstPage()"><input type="button" class="button button-border button-inverse button-small" value="首页"></a>&nbsp;&nbsp;
  				<a href="javascript:previousPage()"><input type="button" class="button button-border button-inverse button-small" value="上一页"></a>&nbsp;&nbsp;
  				<a href="javascript:nextPage()"><input type="button" class="button button-border button-inverse button-small" value="下一页"></a>&nbsp;&nbsp;
  				<a href="javascript:lastPage()"><input type="button" class="button button-border button-inverse button-small" value="尾页"></a>&nbsp;&nbsp;
  			</div>
  			<div><%=FenYe.page %>/<%=FenYe.pageCount %>页</div>
		</form>
		</div>
	</center>
	<script type="text/javascript">
	 var isCheck=false;
	  function aclick(){
		 if(isCheck){
			 isCheck=false;
			 $("input[name='selAll']").attr("checked",false);
		 }else{
			 isCheck=true;
			 $("input[name='selAll']").attr("checked","checked");
		 }
		 if($("input[name='selAll']").attr("checked")){
			 $("input[name='ids']").attr("checked","checked");
		 }else{
			 $("input[name='ids']").attr("checked",false);
		 }
	  }
	  
	  function reset(){
		  $("input[name='qtitle']").val("");
		  $("input[name='qcontext']").val("");
		  location.href="CarAction/carlist.action";
	  }
	  
	  function firstPage(){
		  $("input[name='page']").val(1);
		  $("#reset").submit();
	  }
	  
	  function nextPage(){
		  var page=$("input[name='page']").val();
		  page=parseInt(page);
		  var pageCount=$("input[name='pageCount']").val();
		  pageCount=parseInt(pageCount);
		  if(page>=pageCount){
			  alert("已经是最后一页");
		  }else{
			  $("input[name='page']").val(page+1);
			  $("#reset").submit();
		  }
	  }
	  
	  function previousPage(){
		  var page=$("input[name='page']").val();
		  page=parseInt(page);
		 if(page==1){
			 alert("已经是第一页");
		 }else{
			 $("input[name='page']").val(page-1);
			 $("#reset").submit();
		 }
	  }
	  
	  function lastPage(){
		  var page=$("input[name='page']").val();
		  page=parseInt(page);
		  var pageCount=$("input[name='pageCount']").val();
		  pageCount=parseInt(pageCount);
		  $("input[name='page']").val(pageCount);
		  $("#reset").submit();
	  }
	</script>
  </body>
</html>
