<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 还款jsp页面 -->
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
	  	<script type="text/javascript">
	  		var a=false;
	  		$(function(){
	  			$("#creditCardNum").focus(function(){
	  				$("font:eq(0)").html("");	  				
	  			})
	  			
	  			$("#username").focus(function(){
	  				$("font:eq(1)").html("");	  				
	  			})
	  			
	  			$("#creditCardNum").blur(function(){
	  				if($(this).val()==null||$(this).val()==""){
	  					$("font:eq(0)").html("还款卡号不能为空");	
	  				}else{
	  					$("font:eq(0)").html("");  					
	  				}
	  			});
	  			
	  			
				$("#username").blur(function(){
					a=false;
					var username=$("#username").val();	
					var cardNum=$("#creditCardNum").val();
					$.ajax({
						data:{"username":username,"cardNum":cardNum},						
						type:"post",
						dataType:"json",
						url:"card/querycardnum",
						success:function(data){
							if(data.mess==false){
								$("font:eq(1)").html("卡号或用户名有误");
								a=false;
								return;
							}else{
								$("font:eq(1)").html("");
								a=true;
							}	
						},
						error:function(){
							alert("出错了");
						}
					});
				});	
				
				$("#submit").click(function(){
					if(a==true){			//ajax调用还款方法
						alert("123");
						$.ajax({
							data:{
								"creditCardNum":$("#creditCardNum").val(),
								"money":$("#refundMoney").val(),
								"cardNum":$("#payCardNum").val(),
								"password":$("#payPassword").val(),
								"bankName":$("#bankName").val()
							},
							type:"post",
							dataType:"json",
							url:"card/payback",
							success:function(data){
								if(data.mess){
									alert("还款成功");
								}else{
									alert("还款失败");
								}
							},
							error:function(){
								
							}
						});
					}else{
						alert("信息有误，不能提交！");
					}
				});
				
	  		});
	  		
	  	</script>
	  </head>	
	<body>
		
		<div align="center">
			<div style="border: 1px solid gainsboro; width: 729px; margin-left: -194px; margin-top: -10px; height: 700px; float: right;">
				<div>
					以下还款方式仅支持人民币，知领银行不向客户收费，如有收费请详询第三方。

				<p></p>	1. 银联在线网上还款
					　<p></p>	　所用借记卡和信用卡的户名、证件号必须一致。首次使用本功能，需登录银联在线网站，在“我的银行卡”里分别绑定借记卡和信用卡。同一张信用卡每月通过该渠道、便利网点渠道以及其他银联服务渠道还款，每月交易合计笔数上限3笔，单笔最低还款金额为人民币10元，单日交易金额上限RMB5万元。另：针对代人还款，单张信用卡月累计最高可接受还款5万元，不得超过5次。每张借记卡每日最高累计还款额为5万元，每月最高累计还款额度为10万元。 
					
				<p></p>		2. 支付宝网上还款   访问官网，选择"信用卡还款" 
					　　<p></p>	每张信用卡每月限还款5笔，每月还款总限额25000元。23:30前还款当日内恢复额度，23:30后还款次日内恢复额度。
					
				<p></p>		3. 财付通还款 
					　<p></p>	　00：00-22：00还款当日恢复额度；22：00-24：00还款次日恢复额度”。相关操作流程及还款规定以财付通网站公布为准。

					
					
				</div>	
				<form id="form" class="form-horizontal" role="form" action="#" method="post"">
						
						<fieldset disabled>
							<p></p>
							<div class="form-group" style="width: 600px;">
								<label for="disabledSelect"  class="col-sm-2 control-label">还款银行
								</label>
								<div class="col-sm-10">
									<select id="disabledSelect" class="form-control">
										<option>知领银行</option>
									</select>
								</div>
							</div>
						</fieldset>
						<div class="form-group " style="width: 600px;"> 
							<label class="col-sm-2 control-label" >
								信用卡号
							</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="cardNum" id="creditCardNum">
								<font color="red" size="1" style="float: left"></font>
							</div>
						</div>
						<div class="form-group " style="width: 600px;">
							<label class="col-sm-2 control-label" >
								姓名
							</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="username" id="username">
								<font color="red" size="1" style="float: left"></font>
							</div>
						</div>
						<div class="form-group " style="width: 600px;">
							<label class="col-sm-2 control-label">
								还款金额
							</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" name="refundMoney" id="refundMoney">
							</div>
						</div>
						
						<div class="form-group " style="width: 600px;">
							<label class="col-sm-2 control-label">
								支付银行
							</label>
							<div class="col-sm-10">
							<select class="form-control" id="bankName">
								<option>中国银行</option>
								<option>美国银行</option>
								<option>英国银行</option>
								<option>法国银行</option>
								<option>俄国银行</option>
							</select>
							</div>
						</div>
						<div class="form-group" style="width: 600px;">
							<label class="col-sm-2 control-label" >
								支付卡号
							</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="payCardNum">
							</div>
						</div>
						<div class="form-group " style="width: 600px;">
							<label class="col-sm-2 control-label" >
								支付密码
							</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="payPassword">
							</div>
						</div>
						
						<input id="submit" type="button" class="btn btn-warning" value="提交还款申请">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;<input type="checkbox"  checked="checked"/>我已阅读还款协议<a><font size="1" href="#">《还款协议》</font></a>
					</form>
			</div>
		</div>
		
	</body>

</html>
