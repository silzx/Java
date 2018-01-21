<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 开卡功能jsp页面 -->
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
<script src="http://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/angular.js/1.5.8/angular.min.js"></script>
<script type="text/javascript" src="js/distpicker.js"></script>

</head>
<body>
	<div align="center">
		<img src="img/111111111111111111.png">
	</div><br/>
	<div align="center">
		<div class="form-group">
		    <label  class="col-sm-2 control-label">个人手机</label>
		    <div class="col-sm-10">
		      <input id="phone" type="text" class="form-control"  placeholder="${uai.user.phone }" name="cardNum">
		    </div>
		    <label  class="col-sm-2 control-label">单位地址</label>
		    <div class="col-sm-10">
		      <input id="companyAdd" type="text" class="form-control"  placeholder="${uai.user.companyAdd }" name="cardNum">
		    </div>
		    <label  class="col-sm-2 control-label">家庭地址</label>
		    <div class="col-sm-10">
		      <input id="familyadd" type="text" class="form-control"  placeholder="${uai.user.familyadd }" name="cardNum">
		    </div>
		    <label  class="col-sm-2 control-label">紧急联系人</label>
		    <div class="col-sm-10">
		      <input id="linkman" type="text" class="form-control"  placeholder="${uai.user.linkman }" name="cardNum">
		    </div>
		    <label  class="col-sm-2 control-label">联系人电话</label>
		    <div class="col-sm-10">
		      <input id="linkphone" type="text" class="form-control"  placeholder="${uai.user.linkphone }" name="cardNum">
		    </div><br/>
		    <button class="btn btn-warning" id="updateinfo" onclick="return confirm('是否确认修改资料')">确认修改</button>
			<input type="hidden" value="${uai.user.idCard }" id="idCard">
			<input type="hidden" value="${uai.user.username }" id="username">
		</div>
	</div>

	<script type="text/javascript">
		$("#updateinfo").click(function(){
			var phone=$("#phone").val();
			var companyAdd=$("#companyAdd").val();
			var familyadd=$("#familyadd").val();
			var linkman=$("#linkman").val();
			var linkphone=$("#linkphone").val();
			var idCard=$("#idCard").val();
			var username=$("#username").val();
			$.ajax({
				data:{"username":username,"phone":phone,"companyAdd":companyAdd,"familyadd":familyadd,"linkman":linkman,"linkphone":linkphone,"idCard":idCard},				
				type:"post",
				dataType:"json",
				url:"user/updateuser",
				success:function(data){
					if(data.mess){
						alert("更新成功");
						window.close();
					}else{
						alert("更新失败，请联系客服");
					}
				},
				error:function(){
					alert("出错啦!");
				}
			})
		})
	</script>
	
	
</body>
</html>
