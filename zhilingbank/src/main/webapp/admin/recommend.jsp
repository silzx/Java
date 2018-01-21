<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 推荐亲友办卡jsp页面 -->
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
	  	<script type="text/javascript" src="jquery1.8/jquery-1.8.0.js"></script>
	  	<script type="text/javascript">
	  		var reginformation=null;
		 	 var bname=false;
			 var brname=false;
			 var brphone=false;
			 var braddress=false;
			 var brcompany=false;	
	  		$(function(){
	  			$("input[name]").blur(function(){
	  				var inputName=this.name;
	  				if("name"==inputName){
	  					bname=false;
	  					if(this.value==null||this.value==''){
	  						$("#namefont").attr({"size":"1","color":"red"}).html("请填写推荐人姓名");
	  						return;
	  					}else{
	  						bname=true;
	  						$("#namefont").html("");
	  					};
	  				};
	  				if("rname"==inputName){
	  					brname=false;
	  					if(this.value==null||this.value==''){
	  						$("#rnamefont").attr({"size":"1","color":"red"}).html("请填写被推荐人姓名");
	  						return;
	  					}else{
	  						brname=true;
	  						$("#rnamefont").html("");
	  					};
	  				};
	  				if("rphone"==inputName){
	  					brphone=false;
	  					if(this.value==null||this.value==''){
	  						$("#rphonefont").attr({"size":"1","color":"red"}).html("请填写亲友联系电话");
	  						return;
	  					}else{
	  						var reg=/^1[3|4|5|8][0-9]\d{4,8}$/;
	  						if(!reg.test($("#phone").val())){
	  							$("#rphonefont").attr({"size":"1","color":"red"}).html("手机号码必须为11位数字");
	  							return;
	  						}else{
	  							brphone=true;
		  						$("#rphonefont").html("");
	  						};
	  					};
	  				};
	  				if("raddress"==inputName){
	  					braddress=false;
	  					if(this.value==null||this.value==''){
	  						$("#raddressfont").attr({"size":"1","color":"red"}).html("请填写亲友联系地址");
	  						return;
	  					}else{
	  						braddress=true;
	  						$("#raddressfont").html("");
	  					};
	  				};
	  				if("rcompany"==inputName){
	  					brcompany=false;
	  					if(this.value==null||this.value==''){
	  						$("#rcompanyfont").attr({"size":"1","color":"red"}).html("请填写亲友所在公司");
	  						return;
	  					}else{
	  						brcompany=true;
	  						$("#rcompanyfont").html("");
	  					};
	  				};
	  			});
	  			$("#idcard").blur(function(){
	  				var reg=/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
	  				if(!reg.test($("#idcard").val())){
	  					
	  					$("#idcardfont").attr({"size":"1","color":"red"}).html("身份证输入不合法!");
	  				}else{
	  					$.ajax({
		  					url:"card/regIdcard",
	  						type:"post",
			  				dataType:"json",
			  				data:{"idcard":$("#idcard").val()},
			  			    success:function(data){
			  			    	reginformation=data.meg;
			  			    	if(data.meg){
			  			    	}else{
			  			    		$("#promessage").attr({"color":"red","size":"1"}).html("您还不是本行持卡用户,请先申卡");
			  			    	}
			  			    }
		  				});	
	  				}
	  			});
	  			$("form").submit(function(){
	  				if(reginformation&&bname&&brname&&brphone&&braddress&&brcompany){
	  					return true;
	  				}else{
	  					return false;
	  				}	
	  			});
	  		});
	  	</script>
	</head>
	<body>
			<div align="center">
				<div id="middlediv" style="border: 1px solid gainsboro; width: 729px; margin-left: -198px; margin-top: -10px; float: right;" align="center">
					<div align="center"><img src="img/20180102171058.png"/></div>
					<div><img src="img/20180102212513.png"/></div>
					<div style="width: 500px;" align="center">2018年1月1日至31日，推荐未持卡亲友申请招行信用卡，亲友在成功发卡后30天内激活实体卡片，推荐人即可获得相应奖励： 
						<p></p>【推荐1人及以上】10元抢购Dickies双肩背包或10元换购1500积分（2选1）；
						<p></p>【推荐3人及以上】10元抢购美旅子母拉杆箱或10元换购5000积分（2选1）；  
						<p></p>【推荐6人及以上】10元抢购BOSE音箱或OPPO手机或10元换购10000积分（3选1）。
						<p></p>特别提示：上述3档奖励不可兼得，实物礼品数量有限，先到先得，兑完即止，积分礼品不限量，详见活动细则。
					</div>
					
					<p></p>
					<div align="left" style="margin-left: 100px; margin-top: 30px;"><font size="3" color="coral">请填写以下信息开始推荐:
					</font></div><hr/>
					<form class="form-horizontal" role="form" action="card/addRefereeInfo.do" method="post">
						
						<div class="form-group " style="width: 600px;">
							<label class="col-sm-2 control-label" >
								姓名
							</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="name" >
								<font  id="namefont" style="float: left"></font>
							</div>
						</div>
						<div class="form-group " style="width: 600px;">
							<label class="col-sm-2 control-label" >
								身份证号
							</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="idcard" name="ridcard">
								<font  id="idcardfont" style="float: left"></font>
							</div>
							
						</div>
						<div class="form-group" style="width: 600px;">
							<label class="col-sm-2 control-label" >
								亲友姓名
							</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="rname" >
								<font  id="rnamefont" style="float: left"></font>
							</div>
						</div>
						
						<div class="form-group " style="width: 600px;">
							<label class="col-sm-2 control-label" >
								亲友手机
							</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="rphone" id="phone">
								<font  id="rphonefont" style="float: left"></font>
							</div>
						</div>
						<div class="form-group " style="width: 600px;">
							<label class="col-sm-2 control-label" >
								亲友地址
							</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="raddress">
								<font  id="raddressfont" style="float: left"></font>
							</div>
						</div>
						<div class="form-group"  style="width: 600px;">
							<label class="col-sm-2 control-label" >
								亲友公司
							</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="rcompany" >
								<font  id="rcompanyfont" style="float: left"></font>
							</div>
						</div>
						<font style="margin-left:0;" id="promessage" style="float: right"></font>
						<input type="submit"  class="btn btn-warning"  value="立即提交"><br/>
						
					</form>
					<hr/>
				</div>
			</div>
	</body>
</html>
