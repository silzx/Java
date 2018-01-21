<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>主要内容区main</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="images/main/favicon.ico" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="/after/js/jquery-1.8.0.min.js"></script>
<style>
body{overflow-x:hidden; background:#f2f0f5; padding:15px 0px 10px 5px;}
#searchmain{ font-size:12px;}
#search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF; float:left}
#search form span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
#search form input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
#search form input.text-but{height:24px; line-height:24px; width:55px; background:url(images/main/list_input.jpg) no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
#search a.add{ background:url(images/main/add.jpg) no-repeat -3px 7px #548fc9; padding:0 10px 0 26px; height:40px; line-height:40px; font-size:14px; font-weight:bold; color:#FFF; float:right}
#search a:hover.add{ text-decoration:underline; color:#d2e9ff;}
#main-tab{ border:1px solid #eaeaea; background:#FFF; font-size:12px;}
#main-tab th{ font-size:12px; background:url(images/main/list_bg.jpg) repeat-x; height:32px; line-height:32px;}
#main-tab td{ font-size:12px; line-height:40px;}
#main-tab td a{ font-size:12px; color:#548fc9;}
#main-tab td a:hover{color:#565656; text-decoration:underline;}
.bordertop{ border-top:1px solid #ebebeb}
.borderright{ border-right:1px solid #ebebeb}
.borderbottom{ border-bottom:1px solid #ebebeb}
.borderleft{ border-left:1px solid #ebebeb}
.gray{ color:#dbdbdb;}
td.fenye{ padding:10px 0 0 0; text-align:right;}
.bggray{ background:#f9f9f9}
</style>
<script type="text/javascript">
function fuzzyQuery(){
	var fuzzy= $("input[name='fuzzy']").val();
	javascript:location.href="/afterAudit/firstIndex?fuzzy="+fuzzy;
}
</script>

<script type="text/javascript">


window.onload = function() {
	var perm = <c:out value="${perm }"/>;
	if(perm==2){
		alert("该账户只能访问一审页面");
	}
  }
</script>
</head>
<body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：<a href=""  >信用卡申请审核</a> >>  <a href=""  >一审管理</a></td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
  		<tr>
   		 <td width="90%" align="left" valign="middle">
	         <form method="post" action="">
	         <span>一审查询：<c:out value="${permissions }"/></span>
	         <input type="text" name="fuzzy" value='<c:out value="${fuzzy }"/>' class="text-word">
	         <input type="button" value="查询" onclick="fuzzyQuery();" class="text-but">
	         </form>
         </td>
  		 
  		</tr>
	</table>
    </td>
  </tr>
  <tr>
    <td align="left" valign="top">
    
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr>
        <th></th>
        <th align="center" valign="middle" class="borderright">申卡编号</th>
        <th align="center" valign="middle" class="borderright">申卡人姓名</th>
        <th align="center" valign="middle" class="borderright">申卡类型</th>
        <th align="center" valign="middle" class="borderright">申卡状态</th>
        <th align="center" valign="middle" class="borderright">申卡时间</th>
        <th align="center" valign="middle">操作</th>
      </tr>
      <c:forEach  var="item" items="${customer_list }">
          <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
           <td><input value="<c:out value="${item.uuid }"/>" type ="checkbox"> </td>
           <td align="center" valign="middle" class="borderright borderbottom"><c:out value="${item.uuid }"/> </td>
           <td align="center" valign="middle" class="borderright borderbottom"><c:out value="${item.name }"/></td>
           <td align="center" valign="middle" class="borderright borderbottom"><c:out value="${item.cardtypeObject.cardtypename }"/></td>
           <td align="center" valign="middle" class="borderright borderbottom"><c:out value="${item.applyStatusType.applystatus }"/></td>
           <td align="center" valign="middle" class="borderright borderbottom">         
          <fmt:formatDate value="${item.applyDate }" pattern="yyyy-MM-dd hh:mm:ss"/>
           </td>
           <td align="center" valign="middle" class="borderbottom"><a href="/afterAudit/firstInfo?uuid=<c:out value="${item.uuid }"/>" target="mainFrame" onFocus="this.blur()" class="add">申请详情</a><span class="gray"></td>
         </tr>
      
      </c:forEach>
  
     
     
      
    </table></td>
    </tr>
  <tr>
    <td align="left" valign="top" class="fenye"><c:out value="${count }"/>条数据 <c:out value="${cupage }"/>/<c:out value="${pages }"/> 页&nbsp;&nbsp;<a href="/afterAudit/firstIndex?cupage=1&fuzzy=<c:out value="${fuzzy }"/>" target="mainFrame" onFocus="this.blur()">首页</a>&nbsp;&nbsp;<a href="/afterAudit/firstIndex?cupage=<c:out value="${(cupage-1)<=1?1:cupage-1 }"/>&fuzzy=<c:out value="${fuzzy }"/>" target="mainFrame" onFocus="this.blur()">上一页</a>&nbsp;&nbsp;<a href="/afterAudit/firstIndex?cupage=<c:out value="${cupage+1>=pages?pages:cupage+1 }"/>&fuzzy=<c:out value="${fuzzy }"/>" target="mainFrame" onFocus="this.blur()">下一页</a>&nbsp;&nbsp;<a href="/afterAudit/firstIndex?cupage=<c:out value="${pages }"/>&fuzzy=<c:out value="${fuzzy }"/>" target="mainFrame" onFocus="this.blur()">尾页</a></td>
  </tr>
</table>
</body>
</html>