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
#search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF}
#search form span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
#search form input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
#search form input.text-but{height:24px; line-height:24px; width:55px; background:url(images/main/list_input.jpg) no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
#search a.add{ background:url(images/main/add.jpg) no-repeat 0px 6px; padding:0 10px 0 26px; height:40px; line-height:40px; font-size:14px; font-weight:bold; color:#FFF}
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
.bggray{ background:#f9f9f9; font-size:14px; font-weight:bold; padding:10px 10px 10px 0; width:120px;}
.main-for{ padding:10px;}
.main-for input.text-word{ width:310px; height:36px; line-height:36px; border:#ebebeb 1px solid; background:#FFF; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; padding:0 10px;}
.main-for select{ width:310px; height:36px; line-height:36px; border:#ebebeb 1px solid; background:#FFF; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666;}
.main-for input.text-but{ width:100px; height:40px; line-height:30px; border: 1px solid #cdcdcd; background:#e6e6e6; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#969696; float:left; margin:0 10px 0 0; display:inline; cursor:pointer; font-size:14px; font-weight:bold;}
#addinfo a{ font-size:14px; font-weight:bold; background:url(images/main/addinfoblack.jpg) no-repeat 0 1px; padding:0px 0 0px 20px; line-height:45px;}
#addinfo a:hover{ background:url(images/main/addinfoblue.jpg) no-repeat 0 1px;}
</style>

</head>
<body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：<a href=""  >信用卡申请审核</a> >>  <a href=""  >一审管理</a>  >>  <a href=""  >一审详情</a></td>
  </tr>
  <tr>
    <td align="left" valign="top" id="addinfo">
   <br/>
    </td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <form method="post" name="form" action="/afterAudit/firstSubmit">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
       <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">申办ID：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="uuid" onfocus="this.blur()" value="<c:out value="${customer.uuid }"/>" class="text-word">
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">申办人姓名：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="" onfocus="this.blur()" value='<c:out value="${customer.name }"/>' class="text-word" >
        </td>
        </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">身份证号码：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="" onfocus="this.blur()" value="<c:out value="${customer.idCard }"/>" class="text-word">
        </td>
        </tr>
         <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">驳回意见：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
      
        <textarea onfocus="this.blur()" rows="10" cols="60"><c:out value="${customer.remark }"/></textarea>
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">年龄：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" onfocus="this.blur()" name="" value="<c:out value="${customer.age }"/>" class="text-word">
        </td>
      </tr>
       <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">教育程度：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" onfocus="this.blur()" name="" value="<c:out value="${customer.edu }"/>" class="text-word">
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">婚姻状况：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
       <input type="text" onfocus="this.blur()" name="" value="<c:out value="${customer.marryed }"/>" class="text-word">
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">手机号码：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" onfocus="this.blur()" name="" value="<c:out value="${customer.mobile }"/>" class="text-word">
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">申办卡种：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" onfocus="this.blur()" name="" value="<c:out value="${customer.cardtypeObject.cardtypename }"/>" class="text-word">
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">申办地：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" onfocus="this.blur()" name="" value="<c:out value="${customer.applyArea }"/>" class="text-word">
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">申办时间：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" onfocus="this.blur()" name="" value="<fmt:formatDate value="${item.applyDate }" pattern="yyyy-MM-dd hh:mm:ss"/>" class="text-word">
        </td>
      </tr>
       <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">居住地址：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" onfocus="this.blur()" name="" value="<c:out value="${customer.homeAddress }"/>" class="text-word">
        </td>
      </tr>
       <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">单位名称：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" onfocus="this.blur()" name="" value="<c:out value="${customer.companyName }"/>" class="text-word">
        </td>
      </tr>
       <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">单位地址：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" onfocus="this.blur()" name="" value="<c:out value="${customer.jobAddress }"/>" class="text-word">
        </td>
      </tr>
       <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">单位联系方式：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" onfocus="this.blur()" name="" value="<c:out value="${customer.companyPhone }"/>" class="text-word">
        </td>
      </tr>
       <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">联系人信息：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" onfocus="this.blur()" name="" value="<c:out value="${customer.linkMan }"/>" class="text-word">
        </td>
      </tr>
       <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">年收入：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" onfocus="this.blur()" name="" value="<c:out value="${customer.salary  }"/>" class="text-word">
        </td>
      </tr>
        <c:if test="${customer.idCardCopy != '' }">
        <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">身份证复印件：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <img alt="" style="width: 300px;height: 130px;" src="/upload/<c:out value="${customer.idCardCopy }"/>">
        </td>
      </tr>
        </c:if>
       
      
       <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">收入/资产凭证：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <img alt="" style="width: 300px;height: 130px;" src="/upload/<c:out value="${customer.receipts }"/>">
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">&nbsp;</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="" type="button"  onclick="javascipt:location.href='/afterAudit/rejectedIndex'" value="返回" class="text-but">
        
        </tr>
    </table>
   
    </form>
    </td>
    </tr>
</table>
</body>
</html>