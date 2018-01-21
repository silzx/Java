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

<script type="text/javascript">
	function submitInfo() {
		var idCardYz = $("input[name='idCardYz']").val();
		var promisesYz = $("input[name='promisesYz']").val();
		var avabalance = $("input[name='avabalance']").val();
		
		var form = $("[name='form']");
		if (idCardYz == 0) {
			alert("身份证未核实");
			
		}
		if (promisesYz == 0) {
			alert("客户失信未核实");
			
		}		
		if (avabalance == "") {
			alert("信用额度不能为空");
		}
		if (idCardYz == 1&&promisesYz==1&&avabalance!="") {
		   if (confirm("确定提交?")) {
			
				form.submit();
			}
		}
	}

	function idCardVt() {
		if (confirm("确定认证?")) {
			var name = $("input[name='name']").val();
			var idCard = $("input[name='idCard']").val();
			var idCardImg = $("#idCardImg");
			var idCardYz = $("input[name='idCardYz']");
			
			$.ajax({
				url : "/afterAudit/cardValidation",
				dataType : "json",

				data : {
					"idCard" : idCard,
					"name" : name
				},
				type : "post",
				success : function(data) {
					if (data.charge == true) {
						idCardImg.attr("src", "/after/images/gg.jpg");
						idCardImg.show();
						idCardYz.val("1");
						alert(data.data.compareStatusDesc);

					} else {
						idCardImg.attr("src", "/after/images/xx.jpg");
						idCardImg.show();
						idCardYz.val("0");
						alert(data.result.errorDesc);

					}
				},
				error : function() {
					alert("认证错误");
				}
			});
		}
	}

	
	function promisesVt() {
		if (confirm("确定认证?")) {
			var name = $("input[name='name']").val();
			var idCard = $("input[name='idCard']").val();
			var idCardImg = $("#promisesImg");
			var idCardYz = $("input[name='promisesYz']");
			
			$.ajax({
				url : "/afterAudit/promises",
				dataType : "json",

				data : {
					"idCard" : idCard,
					"name" : name
				},
				type : "post",
				success : function(data) {
					if (data.charge == true) {
						idCardImg.attr("src", "/after/images/gg.jpg");
						idCardImg.show();
						idCardYz.val("1");
						alert(data.data.compareStatusDesc);

					} else {
						idCardImg.attr("src", "/after/images/xx.jpg");
						idCardImg.show();
						idCardYz.val("0");
						alert(data.result.errorDesc);

					}
				},
				error : function() {
					alert("认证错误");
				}
			});
		}
	}
	function rejectedshow() {

		var rejecteddiv = $("[name=rejecteddiv]");
		rejecteddiv.show();

	}
	function rejectedhide() {
		var rejecteddiv = $("[name=rejecteddiv]");
		rejecteddiv.hide();
	}

	function rejected() {
		if (confirm("确定驳回?")) {
			var rejectedText = $("[name='rejectedText']").val();
			var uuid = $("input[name='uuid']").val();
			javascipt: location.href = "/afterAudit/ssetRejected?rejectedText="
					+ rejectedText + "&uuid=" + uuid;
		}
	}
</script>

</head>
<body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：<a href=""  >信用卡申请审核</a> >>  <a href=""  >二审管理</a>  >>  <a href=""  >二审详情</a></td>
  </tr>
  <tr>
    <td align="left" valign="top" id="addinfo">
   <br/>
    </td>
  </tr>
   <tr>
    <td align="left" valign="top">
    <form method="post" name="form" action="/afterAudit/secondSubmit">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
       <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">申办ID：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" onfocus="this.blur()" name="uuid" value="<c:out value="${customer.uuid }"/>" class="text-word">
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">申办人姓名：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="username" onfocus="this.blur()" value='<c:out value="${customer.name }"/>' class="text-word" >
        </td>
        </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">身份证号码：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" id="idCard" onfocus="this.blur()" name="idCard" value="<c:out value="${customer.idCard }"/>" class="text-word">
        
        </td>
         <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">实名验证：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">      
        <input type="hidden" name="idCardYz" value="0"> 
        <input type="button" value="验证" onclick="idCardVt();">
        &nbsp;&nbsp;&nbsp;<img alt="" id="idCardImg"  style="position:relative; width: 30px;height: 30px;display: none;" src="">
        </td>
        </tr>
         <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">失信验证：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">      
        <input type="hidden" name="promisesYz" value="0"> 
        <input type="button" value="验证" onclick="promisesVt();">
        &nbsp;&nbsp;&nbsp;<img alt="" id="promisesImg"  style="position:relative;width: 30px;height: 30px;display: none;" src="">
        </td>
        </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">手机号码：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="" onfocus="this.blur()" value="<c:out value="${customer.mobile }"/>" class="text-word">
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">教育程度：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="" onfocus="this.blur()" value="<c:out value="${customer.edu }"/>" class="text-word">
        </td>
      </tr>
    
      
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">申办地：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="" onfocus="this.blur()" value="<c:out value="${customer.applyArea }"/>" class="text-word">
        </td>
      </tr>
       
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">申办提交时间：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="" onfocus="this.blur()" value="<fmt:formatDate value="${customer.applyDate }" pattern="yyyy-MM-dd hh:mm:ss"/>" class="text-word">
        </td>
     </tr>
    
      
       <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">年收入：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="" onfocus="this.blur()" value="<c:out value="${customer.salary  }"/>" class="text-word">
        </td>
        
         <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">信用额度：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="avabalance"  value="" class="text-word">
        </td>
      </tr>
      </tr>
       <c:if test="${customer.idCardCopy != ''||customer.idCardCopy != null }">
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
        <input name="" type="button" value="通过" onclick="submitInfo();" class="text-but">
        <input name="" type="reset" value="驳回" onclick="rejectedshow();" class="text-but"></td>
        </tr>
    </table>
    <div name="rejecteddiv"  style="display:none; background-color:#EAEAE8; position:fixed; top: 30%;left: 50%;margin-left: -250px;width: 500px;" >
     <h4 style="margin-left: 45%;">驳回意见</h4>
     
     <textarea name="rejectedText" style="margin-left: 50px;max-width:400px;" rows="10" cols="60"></textarea>
      <br/>
     <input style="margin-left: 35%; width: 10%;" type="button" onclick="rejected();" value="确认">
     <input style="margin-left: 5%; width: 10%;" type="button" onclick="rejectedhide();" value="返回">
      <br/>&nbsp;
    </div>
    </form>
    </td>
    </tr>
</table>
</body>
</html>