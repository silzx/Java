<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
  </head>
  
  <body>
  <script type="text/javascript" src="jquery1.8/jquery-1.8.0.min.js"></script>
  <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
  <script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
  <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
		<center><p><p>
			<div class="row">
			<div class="span8">
				<form action="<%=basePath%>NewsAction/addNews.action" method="post" enctype="multipart/form-data"><fieldset>
				<legend>添加新闻</legend>
				<label>新闻编号</label>
				<input type="text" name="n.newsid"><p>
				<label>新闻标题</label>
				<input type="text" name="n.title"><p>
				<label>新闻内容</label>
				<textarea rows="6" cols="23" name="n.context"></textarea><p>
				<label>新闻记者</label>
				<input type="text" name="n.newsman"><p>
				<label>发布时间</label>
				<input type="text" name="n.newsdate" class="Wdate" onclick="WdatePicker()" readonly="readonly"><p>
				<label>新闻图片</label>
				<input type="file" name="img"><p>
				<input type="submit" class="button button-raised button-pill button-inverse button-small" value="添加">
				</fieldset>
			</form>
			</div>
			</div>
		</center>
  </body>
</html>
