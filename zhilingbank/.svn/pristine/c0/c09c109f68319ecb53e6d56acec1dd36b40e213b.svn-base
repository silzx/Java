<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 头部页面，优先打开，与开发无关 -->
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
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script
	  src="http://code.jquery.com/jquery-3.2.1.min.js"
	  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	  crossorigin="anonymous"></script>
		<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	  	<script src="https://cdn.bootcss.com/angular.js/1.5.8/angular.min.js"></script>
	  	
	  	<script type="text/javascript">
	  		function openWin() { 
	           var url='Add.aspx';                      //转向网页的地址; 
	           var name='add';                          //网页名称，可为空; 
	           var iWidth=700;                          //弹出窗口的宽度; 
	           var iHeight=600;                         //弹出窗口的高度; 
	           //获得窗口的垂直位置 
	           var iTop = (window.screen.availHeight - 30 - iHeight) / 2; 
	           //获得窗口的水平位置 
	           var iLeft = (window.screen.availWidth - 10 - iWidth) / 2; 
	           window.open('admin/opencard.jsp', name, 'height=' + iHeight + ',,innerHeight=' + iHeight + ',width=' + iWidth + ',innerWidth=' + iWidth + ',top=' + iTop + ',left=' + iLeft + ',status=no,toolbar=no,menubar=no,location=no,resizable=no,scrollbars=0,titlebar=no'); 
	          // window.open("AddScfj.aspx", "newWindows", 'height=100,width=400,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no'); 
      		 }
	  		
	  		function openwin() { 
	           var url='Add.aspx';                             //转向网页的地址; 
	           var name='add';                            //网页名称，可为空; 
	           var iWidth=700;                          //弹出窗口的宽度; 
	           var iHeight=600;                         //弹出窗口的高度; 
	           //获得窗口的垂直位置 
	           var iTop = (window.screen.availHeight - 30 - iHeight) / 2; 
	           //获得窗口的水平位置 
	           var iLeft = (window.screen.availWidth - 10 - iWidth) / 2; 
	           window.open('admin/jindu.jsp', name, 'height=' + iHeight + ',,innerHeight=' + iHeight + ',width=' + iWidth + ',innerWidth=' + iWidth + ',top=' + iTop + ',left=' + iLeft + ',status=no,toolbar=no,menubar=no,location=no,resizable=no,scrollbars=0,titlebar=no'); 
	          // window.open("AddScfj.aspx", "newWindows", 'height=100,width=400,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no'); 
      		 }
	  	</script>
	  	
	  	
  </head>
  <body>
  	<div align="center">
			<div align="center"><img src="img/e5a040645a29534c54fbdae32e8b5565.png"></div>
					<div style="width: 950px;" align="center" >
						<nav class="navbar navbar-default" role="navigation" style="background-color: coral">
						    <div class="container-fluid" align="center" style="width: 600px;">
							    <div>
							        <ul class="nav navbar-nav" style="font-size: 14px;">
							            <li class="active" id="main"><a>新用户快捷申请</a></li>
							            <li id="huaikuan"><a>信用卡还款</a></li>
							            <li id="recommend"><a>推荐亲友办卡</a></li>
							            <li id="bankmessage"><a>信息公示</a></li>
							            <li id="login"><a>用户登录</a></li>
							        </ul>
							    </div> 
						    </div>
						</nav>
						<div id="yemian"></div>
						<div style=" width: 150;  margin-top: -10px; float: left;margin-left: 15px">
							<img src="img/zhilingyinhang.png" style="clear: both;"><p></p>
							<a onclick="openWin()"><img src="img/cardopen.gif"></a><br/><p></p>
							<a onclick="openwin()"><img src="img/20180102195418.png"/></a>
							<br/><br/><br/><br/><br/>
							<img  src="img/20180102121908.png" style="margin-left: -20px;margin-top: -20px">
						</div>
					</div>
					
	</div>
		
		
		<div id="foot">
			
			
			
			
		</div>
		<script type="text/javascript">
			$("#yemian").load("admin/main.jsp");
			$("#main").click(function(){
				$("#yemian").load("admin/main.jsp");
			});
			$("#huaikuan").click(function(){
				$("#yemian").load("admin/huaikuan.jsp");
			});
			$("#login").click(function(){
				$("#yemian").load("admin/login.jsp");
			});
			$("#recommend").click(function(){
				$("#yemian").load("admin/recommend.jsp");
			});
			$("#bankmessage").click(function(){
				$("#yemian").load("admin/bankmessage.jsp");
			});
			
			$(".nav li").click(function(){
				$(".nav li").removeClass("active");
				$(this).addClass("active");
			})
			
		</script>
		
  
  
  
  </body>
</html>