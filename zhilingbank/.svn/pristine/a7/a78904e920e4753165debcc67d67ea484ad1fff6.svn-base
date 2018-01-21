<%@page import="com.zl.pojo.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>左侧导航menu</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/sdmenu.js"></script>
<script type="text/javascript" src="/after/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
	var myMenu;
	window.onload = function() {
		myMenu = new SDMenu("my_menu");
		myMenu.init();

		$.ajax({
			url : "/after/emp",
			dataType : "json",
			type : "post",
			success : function(data) {
				if (data.pos.pid == 1) {
					$(".a2,.a5,.a3,.a4").css({

						"display" : "none"
					});
				}
				if (data.pos.pid == 2) {
					$(".a1,.a5,.a3,.a4").css({

						"display" : "none"
					});
				}
				if (data.pos.pid == 3) {
					$(".a1,.a2,.a5,.a4").css({

						"display" : "none"
					});
				}
				if (data.pos.pid == 4) {
					$(".a1,.a2,.a3,.a5").css({

						"display" : "none"
					});

				}
				if (data.pos.pid == 5) {
					$(".a1,.a2,.a3,.a4").css({

						"display" : "none"
					});
				}

			},
			error : function() {
			}//请求出错的处理
		});

	};
</script>




<style type=text/css>
html {
	SCROLLBAR-FACE-COLOR: #538ec6;
	SCROLLBAR-HIGHLIGHT-COLOR: #dce5f0;
	SCROLLBAR-SHADOW-COLOR: #2c6daa;
	SCROLLBAR-3DLIGHT-COLOR: #dce5f0;
	SCROLLBAR-ARROW-COLOR: #2c6daa;
	SCROLLBAR-TRACK-COLOR: #dce5f0;
	SCROLLBAR-DARKSHADOW-COLOR: #dce5f0;
	overflow-x: hidden;
}

body {
	overflow-x: hidden;
	background: url(images/main/leftbg.jpg) left top repeat-y #f2f0f5;
	width: 194px;
}
</style>

</head>
<body onselectstart="return false;" ondragstart="return false;"
	oncontextmenu="return false;">
	<div id="left-top">
		<div>
			<img src="images/main/member.gif" width="44" height="44" />
		</div>
		<span>用户：${loginemp.account }<br>角色：${loginemp.pos.pname }
		</span>
	</div>
	<div style="float: left" id="my_menu" class="sdmenu">
		<div class="collapsed">
			<span>系统管理员</span> <a class="a1" href="/after/adminQueryEmp"
				target="mainFrame" onFocus="this.blur()">员工管理页</a> <a class="a1"
				href="/after/add" target="mainFrame" onFocus="this.blur()">添加员工基本信息</a>
			<a class="a1" href="/after/maininfo" target="mainFrame"
				onFocus="this.blur()">员工授权和密码</a>

		</div>
		<div>
			<span>信用卡申请审核</span> <a class="a2" href="/afterAudit/firstIndex"
				target="mainFrame" onFocus="this.blur()">一审管理</a> <a class="a3"
				href="/afterAudit/secondIndex" target="mainFrame"
				onFocus="this.blur()">二审管理</a> <a class="a5"
				href="/afterAudit/rejectedIndex" target="mainFrame"
				onFocus="this.blur()">驳回管理</a>
		</div>

		<div>
			<span>办卡业务员</span>
			<!--    <a class="a4"  href="salesman/main.jsp" target="mainFrame" onFocus="this.blur()">办卡业务员首页</a>-->
			<a class="a4" href="/salesman/addinfo" target="mainFrame"
				onFocus="this.blur()">申请办卡</a> <a class="a4"
				href="/salesman/showinfomation" target="mainFrame"
				onFocus="this.blur()">查看暂存信息</a>

		</div>
		<!--  
      <div>
        <span>系统设置</span>
        <a href="main.html" target="mainFrame" onFocus="this.blur()">分组权限</a>
        <a href="main_list.html" target="mainFrame" onFocus="this.blur()">级别权限</a>
        <a href="main_info.html" target="mainFrame" onFocus="this.blur()">角色管理</a>
        <a href="main.html" target="mainFrame" onFocus="this.blur()">自定义权限</a>
      </div>-->
	</div>
</body>
</html>