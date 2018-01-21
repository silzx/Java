<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>接口</title>
<script src="/jquery1.8/jquery-1.8.0.min.js"></script>

<!-- rsa web端加密-->
<script src="http://passport.cnblogs.com/scripts/jsencrypt.min.js"></script>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript">


	function idcard() {	
		$.ajax({
			url : "/afterAudit/rsaPuKey",
			dataType : "json",		   			
			type : "post",
			success : function(data) {
				var encrypt = new JSEncrypt();
				//后端传过来的公钥加入到set方法里面
				encrypt.setPublicKey(data.pukey);			
				var card_name = $('#card_name').val();
				var card_id = $('#card_id').val();
				//数据加密
				card_name = encrypt.encrypt(card_name);
				card_id = encrypt.encrypt(card_id);
				//alert(card_name);
				$.ajax({
					url : "/afterAudit/idcard",
					dataType : "json",//返回的格式为json			   
					data : {
						"card_name" : card_name,
						"card_id" : card_id
					},//参数值
					type : "post",//请求的方式

					success : function(data) {
						alert("请求成功");
					},//请求成功的处理

					error : function() {
						alert("失败");
					}//请求出错的处理
				});		
			},
			error : function() {
				alert("失败");
			}
		});
		
	}

	
</script>
</head>
<body>


	<table>
	
		<tr>
			<td><h5>身份证验证</h5></td>
			<td></td>
			<td></td>
		</tr>
		<tr>

			<td>持卡人姓名：</td>
			<td><input id="card_name" type="text"></td>
			<td>证件号码：</td>
			<td><input id="card_id" type="text"></td>
			<td><a
				href="javascript:idcard();">点击</a></td>

		</tr>
	</table>
	<br>




</body>
</html>