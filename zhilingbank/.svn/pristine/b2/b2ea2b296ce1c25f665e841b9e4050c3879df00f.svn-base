<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加办卡顾客信息</title>
<link href="css/css.css" type="text/css" rel="stylesheet" />
<link href="css/main.css" type="text/css" rel="stylesheet" />
<link rel="shortcut icon" href="images/main/favicon.ico" />
<script type="text/javascript" src="/jquery1.8/jquery-1.8.0.js"></script>
<style>
body{overflow-x:hidden; background:#f2f0f5; padding:15px 0px 10px 5px;}
#searchmain{ font-size:12px;}
.bggray{ background:#f9f9f9; font-size:14px; font-weight:bold; padding:10px 10px 10px 0; width:120px;}
.main-for{ padding:10px;}
.main-for input.text-word{ width:310px; height:36px; line-height:36px; border:#ebebeb 1px solid; background:#FFF; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; padding:0 10px;}
.main-for select{ width:310px; height:36px; line-height:36px; border:#ebebeb 1px solid; background:#FFF; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666;}
.main-for input.text-but{ width:100px; height:40px; line-height:30px; border: 1px solid #cdcdcd; background:#e6e6e6; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#969696; float:left; margin:0 10px 0 0; display:inline; cursor:pointer; font-size:14px; font-weight:bold;}
#search{ font-size:12px; background:#548fc9; margin:10px 10px 0 0; display:inline; width:100%; color:#FFF; float:left}
#search form span{height:40px; line-height:40px; padding:0 0px 0 10px; float:left;}
#search form input.text-word{height:24px; line-height:24px; width:180px; margin:8px 0 6px 0; padding:0 0px 0 10px; float:left; border:1px solid #FFF;}
#search form input.text-but{height:24px; line-height:24px; width:55px; background:url(images/main/list_input.jpg) no-repeat left top; border:none; cursor:pointer; font-family:"Microsoft YaHei","Tahoma","Arial",'宋体'; color:#666; float:left; margin:8px 0 0 6px; display:inline;}
#search a.add{  padding:0 10px 0 26px; height:40px; line-height:40px; font-size:14px; font-weight:bold; color:#FFF; float:right}
#search a:hover.add{ text-decoration:underline; color:#d2e9ff;}
#main-tab{ border:1px solid #eaeaea; background:#FFF; font-size:12px;width: 40%;margin: 0 auto;}
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
</head>
<body>
<!--main_top-->
<table width="99%" border="0" cellspacing="0" cellpadding="0" id="searchmain">
  <tr>
    <td width="99%" align="left" valign="top">您的位置：业务管理&nbsp;&nbsp;>&nbsp;&nbsp;添加顾客信息</td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="search">
  		<tr>
   		 <td width="90%" align="left" valign="middle">
	         
         </td>
  		  <td width="10%" align="center" valign="middle" style="text-align:right; width:150px;"><a href="#" target="mainFrame" onFocus="this.blur()" class="add"></a></td>
  		</tr> 
	</table>
    </td>
  </tr>
  <tr>
    <td align="left" valign="top">
    <form method="POST" enctype="multipart/form-data" action="/salesman/batch/upload" id="form1">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" id="main-tab">
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">顾客姓名：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="name" value="" class="text-word">
        </td>
        </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">顾客身份证：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="idCard" value="" class="text-word">
        </td>
        </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">顾客电话：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="mobile" value="" class="text-word">
        </td>
      </tr>
       <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">申卡区域：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="applyArea" value="" class="text-word">
        </td>
      </tr>
         <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">申卡类型：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <select name="cardType" id="pid">
	    <option value="1" >&nbsp;&nbsp;知领银行河马信用卡</option>
	    <option value="2" >&nbsp;&nbsp;知领银行饿了么联名卡</option>
	    <option value="3" >&nbsp;&nbsp;知领银行王者荣耀联名信用卡</option>
	    <option value="4" >&nbsp;&nbsp;知领银行阴阳师联名信用卡</option>
	    <option value="5" >&nbsp;&nbsp;知领银行网易游戏信用卡</option>
	    <option value="6" >&nbsp;&nbsp;知领银行腾讯新闻联名信用卡</option>
        </select>
        </td>
      </tr>
         <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">教育程度：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <select name="edu" id="pid">
	    <option value="1" >&nbsp;&nbsp;博士</option>
	    <option value="2" >&nbsp;&nbsp;硕士</option>
	    <option value="3" >&nbsp;&nbsp;本科</option>
	    <option value="4" >&nbsp;&nbsp;高中</option>
	    <option value="5" >&nbsp;&nbsp;初中及以下</option>
        </select>
        </td>
      </tr>
       <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">单位名称：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="companyName" value="" class="text-word">
        </td>
      </tr> <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">单位详细地址：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="jobAddress" value="" class="text-word">
        </td>
      </tr>
       <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">单位详细电话：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="companyPhone" value="" class="text-word">
        </td>
      </tr>
         <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">工作种类：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <select name="jobType" id="pid">
	    <option value="1" >&nbsp;&nbsp;超级管理员</option>
	    <option value="2" >&nbsp;&nbsp;一审员工</option>
	    <option value="3" >&nbsp;&nbsp;二审员工</option>
	    <option value="4" >&nbsp;&nbsp;办卡业务员</option>
        </select>
        </td>
      </tr>
       <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">职称：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="zc" value="" class="text-word">
        </td>
      </tr>
       <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">职务：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="zw" value="" class="text-word">
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">居住地址：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="homeAddress" value="" class="text-word">
        </td>
      </tr>
        <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">婚姻状况：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <select name="marryed" id="marryed">
	    <option value="1" >&nbsp;&nbsp;已婚</option>
	    <option value="2" >&nbsp;&nbsp;未婚</option>
        </select>
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">联系人：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="linkman" value="" class="text-word">
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">联系人电话：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="linkMobile" value="" class="text-word">
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">联系人关系：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="linknexus" value="" class="text-word">
        </td>
      </tr>
        <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">年薪：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="salary" value="" class="text-word">
        </td>
      </tr>
        <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">资产：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="text" name="asset" value="" class="text-word">
        </td>
      </tr>
        <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">身份证复印件：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="file" name="file" value="" class="text-word">
        </td>
      </tr>
       </tr>
        <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">收入凭证：</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input type="file" name="file" value="" class="text-word">
        </td>
      </tr>
      <tr onMouseOut="this.style.backgroundColor='#ffffff'" onMouseOver="this.style.backgroundColor='#edf5ff'">
        <td align="right" valign="middle" class="borderright borderbottom bggray">&nbsp;</td>
        <td align="left" valign="middle" class="borderright borderbottom main-for">
        <input name="" type="button" value="提交" class="text-but" id="sumbit">
        <input name="" type="button" value="保存" class="text-but" id="save"></td>
        </tr>
    </table>
    </form>
    </td>
    </tr>
</table>
</body>
<script type="text/javascript">
$("#sumbit").bind("click",function(){	
	 var name=$("input[name='name']").val();
	 var idCard=$("input[name='idCard']").val();
	 if(name!=""&&idCard!=""){
		 $("#form1").submit(); //提交ID为form1的表单
	 }
    
})
$("#save").bind("click",function(){
	var name=$("input[name='name']").val();
	 var idCard=$("input[name='idCard']").val();
	 if(name!=""&&idCard!=""){
		 var newUrl = "/salesman/batch/save";    //设置新提交地址
		 $("#form1").attr("action",newUrl);    //通过jquery为action属性赋值
	     $("#form1").submit(); //提交ID为form1的表单
	 }
	
})

</script>
</html>