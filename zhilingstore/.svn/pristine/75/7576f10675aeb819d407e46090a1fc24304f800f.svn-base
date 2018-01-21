<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
	  	<link rel="stylesheet" type="text/css" href="css/buttons.css">
	  	<link href="http://cdn.bootcss.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
  </head>
  <script type="text/javascript">
  	$(function(){
  		$("#phonecard").attr("disabled",true);
  		$("#oilcard").attr("disabled",true);
  		$("#filmcard").attr( "disabled",true);
  		
  		$("#phonecard").click(function(){
  			var url='Add.aspx';                      //转向网页的地址; 
	           var name='电话卡购买';                          //网页名称，可为空; 
	           var iWidth=700;                          //弹出窗口的宽度; 
	           var iHeight=600;                         //弹出窗口的高度; 
	           //获得窗口的垂直位置 
	           var iTop = (window.screen.availHeight - 30 - iHeight) / 2; 
	           //获得窗口的水平位置 
	           var iLeft = (window.screen.availWidth - 10 - iWidth) / 2; 
	           window.open('buy.jsp?message=抱枕&price=48', name, 'height=' + iHeight + ',,innerHeight=' + iHeight + ',width=' + iWidth + ',innerWidth=' + iWidth + ',top=' + iTop + ',left=' + iLeft + ',status=no,toolbar=no,menubar=no,location=no,resizable=no,scrollbars=0,titlebar=no');
  			
  		});
  		$("#oilcard").click(function(){
  			var url='Add.aspx';                      //转向网页的地址; 
	           var name='电话卡购买';                          //网页名称，可为空; 
	           var iWidth=700;                          //弹出窗口的宽度; 
	           var iHeight=600;                         //弹出窗口的高度; 
	           //获得窗口的垂直位置 
	           var iTop = (window.screen.availHeight - 30 - iHeight) / 2; 
	           //获得窗口的水平位置 
	           var iLeft = (window.screen.availWidth - 10 - iWidth) / 2; 
	           window.open('buy.jsp?message=移动充&price=97', name, 'height=' + iHeight + ',,innerHeight=' + iHeight + ',width=' + iWidth + ',innerWidth=' + iWidth + ',top=' + iTop + ',left=' + iLeft + ',status=no,toolbar=no,menubar=no,location=no,resizable=no,scrollbars=0,titlebar=no');
  			
  		});
  		$("#filmcard").click(function(){
  			   var url='Add.aspx';                      //转向网页的地址; 
	           var name='电话卡购买';                          //网页名称，可为空; 
	           var iWidth=700;                          //弹出窗口的宽度; 
	           var iHeight=600;                         //弹出窗口的高度; 
	           //获得窗口的垂直位置 
	           var iTop = (window.screen.availHeight - 30 - iHeight) / 2; 
	           //获得窗口的水平位置 
	           var iLeft = (window.screen.availWidth - 10 - iWidth) / 2; 
	           window.open('buy.jsp?message=电竞椅&price=1296', name, 'height=' + iHeight + ',,innerHeight=' + iHeight + ',width=' + iWidth + ',innerWidth=' + iWidth + ',top=' + iTop + ',left=' + iLeft + ',status=no,toolbar=no,menubar=no,location=no,resizable=no,scrollbars=0,titlebar=no');
  		});
  		
  		$("#startPos").click(function(){
			$.ajax({
				url:"client/getPubKey",
				dataType:"json",
				success:function(data){
					if(data.mess){
						alert("成功");
						$("#phonecard").attr("disabled",false);
				  		$("#oilcard").attr("disabled",false);
				  		$("#filmcard").attr("disabled",false);
					}else{
						alert("失败");
					}
				},
				error:function(XMLHttpRequest, textStatus, errorThrown){
					alert(XMLHttpRequest.status);
					alert(XMLHttpRequest.readyState);
					alert(textStatus);
					alert("错误");
				}
			});  			
  		});
  	});
  </script>
  <body>
  <center>
  <div class="jumbotron">
			<h2>知领商城</h2><br/>
			<button id="startPos">开启POS机</button><font size="1" color="red" style="margin-right: -140px">POS机开启成功才能进行购买</font>
		</div> 
  			<table  class="table table-striped table-hover" style="width: 50%">
  				<tr>
  					<td align="center">商品列表</td>
  					<td align="center">价格</td>
  					<td align="center">操作</td>
  				</tr>
  				<tr>
  					<td align="center">抱枕</td>
  					<td align="center"><font id="p">48</font>元</td>
  					<td align="center"><input type="button" class="button button-3d button-caution button-small" value="购买" id="phonecard"></td>
  				</tr>
  				<tr>
  					<td align="center">移动充</td>
  					<td align="center"><font id="o">97</font>元</td>
  					<td align="center"><input type="button" class="button button-3d button-caution button-small" value="购买" id="oilcard"></td>
  				</tr>
  				<tr>
  					<td align="center">电竞椅</td>
  					<td align="center"><font id="f">1296</font>元</td>
  					<td align="center"><input type="button" class="button button-3d button-caution button-small" value="购买" id="filmcard"></td>
  				</tr>
  			</table>
  			</center>
  </body>
  
 </html> 