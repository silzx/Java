<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String type = (String)request.getParameter("type");
%>
<!-- 申请信用卡jsp页面 -->
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
  		<script type="text/javascript" src="js/distpicker.data.js"></script>
  		<script type="text/javascript" src="js/distpicker.js"></script>
  		<script type="text/javascript">
  			$(function(){
  				$("#submit").attr("disabled",true);
  				var h=false;
  				var a=false;
  				var b=false;
  				var c=false;
  				var d=false;
  				var e=false;
  				var f=false;
  				var g=false;
  				var h=false;
  				var i=false;
  				var j=false;
  				var k=false;
  				var code=0;		//获取到验证码
  				$("#idcard").blur(function(){
 					
 				});
  				$("#getMessage").click(function(){
  	  				$.ajax({
						data:{"phoneNum":$("#phoneNum").val()},	  	  					
  	  					type:"post",
  	  					dataType:"json",
  	  					url:"captcha/getPhoneMessage",
  	  					success:function(data){
  	  						if(data.mess){
  	  							code=data.code;
  	  							$("#codeBox").val(code); 
  	  							alert(code);
  	  						}else{
  	  							alert("失败");
  	  						}
  	  					},
  	  					error:function(){
  	  						alert("出错啦！");
  	  					},
  	  					
  	  				});
  	  			});
  				
  				
  				$("#name").blur(function(){
  					a=false;
  	  				if($(this).val()==null||$(this).val()==""){
  						a=false;
  	  				}else{
  	  					a=true;
  	  				}
  	  				if(a==true&&b==true&&c==true&&d==true&&e==true&&f==true&&j==true&&h==true&&i==true&&j==true){
						$("#submit").attr("disabled",false);
					}else{
						$("#submit").attr("disabled",true);
					}
  	  			});
  				$("#idcard").blur(function(){
  					b=false;
  					$.ajax({
  						data:{"idCard":$("#idcard").val()},	  	  					
  	 	  					type:"post",
  	 	  					dataType:"JSON",
  	 	  					url:"card/search",
  	 	  					success:function(data){
  	 	  						if(data.mes){
  	 	  							alert("60天内不可重复申卡！");
  	 	  							b=false;
  	 	  							return ;
  	 	  						}else{
  	 	  							b=true;
  	 	 	  	  			if(a==true&&b==true&&h==true&&c==true&&d==true&&e==true&&f==true&&j==true&&i==true&&j==true){
  	 	 						$("#submit").attr("disabled",false);
  	 	 					}else{
  	 	 						$("#submit").attr("disabled",true);
  	 	 					}
  	 	  						};
  	 	  					},
  	 	  					error:function(){
  	 	  					},
  	 	  					
  	 	  				});
  	  			});
  				$("#homeAddress").blur(function(){
  					c=false;
  	  				if($(this).val()==null||$(this).val()==""){
  						c=false;
  	  				}else{
  	  					c=true;
  	  				}
	  	  			if(a==true&&b==true&&c==true&&d==true&&e==true&&f==true&&j==true&&h==true&&i==true&&j==true){
						$("#submit").attr("disabled",false);
					}else{
						$("#submit").attr("disabled",true);
					}
  	  			});
  				$("#phoneNum").blur(function(){
  					d=false;
  	  				if($(this).val()==null||$(this).val()==""){
  						d=false;
  	  				}else{
  	  					d=true;
  	  				}
	  	  			if(a==true&&b==true&&c==true&&d==true&&e==true&&f==true&&j==true&&h==true&&i==true&&j==true){
						$("#submit").attr("disabled",false);
					}else{
						$("#submit").attr("disabled",true);
					}
	  	  			});
  				$("#linkMobile").blur(function(){
  					e=false;
  	  				if($(this).val()==null||$(this).val()==""){
  						e=false;
  	  				}else{
  	  					e=true;
  	  				}
  	  				
	  	  			if(a==true&&b==true&&c==true&&d==true&&e==true&&f==true&&j==true&&h==true&&i==true&&j==true){
						$("#submit").attr("disabled",false);
					}else{
						alert("所有内容不能为空！")
						$("#submit").attr("disabled",true);
					}
  	  			});
  				
  				
  				$("#code").blur(function(){
  					f=false;
  	  				if($(this).val()!=code){
  						f=false;
  						alert("验证码输入有误");
  	  				}else{
  	  					f=true;
  	  				}
	  	  			if(a==true&&b==true&&c==true&&d==true&&e==true&&f==true&&j==true&&h==true&&i==true&&j==true){
						$("#submit").attr("disabled",false);
					}else{
						$("#submit").attr("disabled",true);
					}
  	  			});
  				$("#companyName").blur(function(){
  					g=false;
  	  				if($(this).val()==null||$(this).val()==""){ 
  						g=false;
  	  				}else{
  	  					g=true;
  	  				}
	  	  			if(a==true&&b==true&&c==true&&d==true&&e==true&&f==true&&j==true&&h==true&&i==true&&j==true){
						$("#submit").attr("disabled",false);
					}else{
						$("#submit").attr("disabled",true);
					}
  	  			});
  				$("#jobAddress").blur(function(){
  					h=false;
  	  				if($(this).val()==null||$(this).val()==""){ 
  						h=false;
  	  				}else{
  	  					h=true;
  	  				}
	  	  			if(a==true&&b==true&&c==true&&d==true&&e==true&&f==true&&j==true&&h==true&&i==true&&j==true){
						$("#submit").attr("disabled",false);
					}else{
						$("#submit").attr("disabled",true);
					}
  	  			});
  				$("#companyPhone").blur(function(){
  					i=false;
  	  				if($(this).val()==null||$(this).val()==""){
  						i=false;
  	  				}else{
  	  					i=true;
	  	  				}
	  	  			if(a==true&&b==true&&c==true&&d==true&&e==true&&f==true&&j==true&&h==true&&i==true&&j==true){
						$("#submit").attr("disabled",false);
					}else{
						$("#submit").attr("disabled",true);
					}
  	  			});
  				$("#linkMan").blur(function(){
  					j=false;
  	  				if($(this).val()==null||$(this).val()==""){
  						j=false;
  	  				}else{
  	  					j=true;
  	  				}
  	  				
	  	  			if(a==true&&b==true&&c==true&&d==true&&e==true&&f==true&&j==true&&h==true&&i==true&&j==true){
						$("#submit").attr("disabled",false);
					}else{
						$("#submit").attr("disabled",true);
					}
  	  			});
  				
  				
  			});
  		
  				function code(){
  					$.ajax({
  						data:{"code":$("input[name='code']").val(),"source":$("#codeBox").val()},
  						type:"post",
  						dataType:"json",
  						url:"card/codecheck",
  						success:function(data){
  							if(data.codecheck){
  								alert("注册成功！点击确定跳转到主页面");
  								$("form[name='form']").submit();
  							}else{
  								alert("手机验证码填写错误！");
  							}
  						},
  						error:function(){
  							alert("出错啦！");
  						}
  					});
  				}
  			
  			$(function(){//自动选中卡种类
  				document.getElementById("ty")[<%=type%>].selected=true;
  			});
  			
  		</script>
  		
  		
  </head>
<body>		
			<div align="center"><img src="img/e5a040645a29534c54fbdae32e8b5565.png"></div>
			<div align="center" style="border: 1px solid black; width: 950px; margin-left: 250px;"></div>
					<div style="width: 950px; margin-left: 250px;" align="center " >
						<h3 align="center" style=" color: coral;" >欢迎申请知领银行信用卡</h3><p></p><br/>
						<h4>请详细填写以下资料</h4>
						<form action="card/insert" class="form-horizontal" role="form" style="margin-left: 150px;" onsubmit="return check()" enctype="multipart/form-data" method="post">
							  <div class="form-group" style="width: 600px;">
							    <label  class="col-sm-2 control-label">名字</label>
							    <div class="col-sm-10">
							      <input id="name" type="text" class="form-control" name="name" placeholder="请输入名字">
							    </div>
							  </div>
							  <div class="form-group" style="width: 600px;">
							    <label  class="col-sm-2 control-label">身份证号</label>
							    <div class="col-sm-10">
							      <input id="idcard" type="text" class="form-control" name="idCard" placeholder="请输入身份证号">
							    </div>
							  </div>
							  
							  <div class="form-group" style="width: 600px;">
							    <label  class="col-sm-2 control-label">家庭住址</label>
							    <div class="col-sm-10">
							      <input id="homeAddress" type="text" class="form-control" name="homeAddress" placeholder="请输入家庭住址">
							    </div>
							  </div>
							  
							  <div class="form-group" style="width: 600px;">
								    <label  class="col-sm-2 control-label">婚姻状况</label>
								    <div class="col-sm-10">
								      <select name="marryed" class="form-control" style="width: 470px;">
								      <option>未婚</option>
								      <option>已婚</option>
								      <option>离异</option>
							   		</select>
								    </div>
								</div>
							  
						   		<div class="form-group" style="width: 600px;">
								    <label  class="col-sm-2 control-label">卡片种类</label>
								    <div class="col-sm-10">
								      <select name="cardType" id="ty" class="form-control" style="width: 470px;">
								      <option value="0">知领银行盒马信用卡</option>
								      <option value="1">知领银行饿了么联名卡</option>
								      <option value="2">知领银行王者荣耀联名信用卡</option>
								      <option value="3">知领银行阴阳师联名信用卡-基础款</option>
								      <option value="4">知领银行网易游戏信用卡</option>
								      <option value="5">知领银行腾讯新闻联名信用卡</option>
							   		</select>
								    </div>
								</div>
							   		
						   		<label class="col-sm-2 control-label" style="margin-left: -30px; padding-right: 30px;">所在地域</label><br/><p></p><br/>
								<div data-toggle="distpicker" style="width: 554px; padding-left: 112px; margin-top: -40px;">   
									<div class="form-group">    
										<label class="sr-only" for="province1">Province</label>   
										<select name="p" class="form-control" id="province1"></select>  
									</div>  
									<div class="form-group">    
										<label class="sr-only" for="city1">City</label>    
										<select name="c" class="form-control" id="city1"></select>   
									</div>   
									<div class="form-group"> 
											<label class="sr-only" for="district1">District</label>    
											<select name="d" class="form-control" id="district1"></select>   
									</div>  
								</div>
								
								<div class="form-group" style="width: 600px;">
								    <label  class="col-sm-2 control-label">行业种类</label>
								    <div class="col-sm-10">
								      <select name="jobType" class="form-control" style="width: 470px;">
								      <option>公共管理与社会组织</option>
								      <option>科研文化卫生教育</option>
								      <option>金融电力电信</option>
								      <option>邮政交通运输公用</option>
								      <option>计算机服务与软件业</option>
								      <option>体育娱乐</option>
								      <option>工业商业服务业贸易</option>
								      <option>其他</option>
							   		</select>
								    </div>
								</div>
								
								<div class="form-group" style="width: 600px;">
								    <label  class="col-sm-2 control-label">职称</label>
								    <div class="col-sm-10">
								      <select name="zc" class="form-control" style="width: 470px;">
								      <option>高级</option>
								      <option>中级</option>
								      <option>初级</option>
								      <option>其他</option>
							   		</select>
								    </div>
								</div>
								
								<div class="form-group" style="width: 600px;">
								    <label  class="col-sm-2 control-label">职务</label>
								    <div class="col-sm-10">
								      <select name="zw" class="form-control" style="width: 470px;">
								      <option>厅局级以上（含）</option>
								      <option>处级</option>
								      <option>科级</option>
								      <option>一般干部</option>
								      <option>总经理级以上（含）</option>
								      <option>部门经理</option>
								      <option>职员</option>
								      <option>其他</option>
							   		</select>
								    </div>
								</div>
								
								
								<div class="form-group" style="width: 600px;">
								    <label class="col-sm-2 control-label">手机号码</label>
								    <div class="col-sm-10">
								      <input name="mobile" type="text" class="form-control" placeholder="请输入手机号" id="phoneNum">
								    </div>
							    </div>	
							    
							    <div class="form-group" style="width: 615px;" >
								    <label class="col-sm-2 control-label" >短信验证</label>
								    <div style="margin-left: 35px;">
									    <input id="code" type="text" name="code" class="form-control" placeholder="请输入短信验证码" style="width:200px; margin-left: 80px;">
									    <input type="hidden" id="codeBox">
									    <input type="button" class="btn btn-warning" value="获取短信验证码" style="margin-right: -200px; margin-top: -35px;" id="getMessage"/>
							    	</div>
								</div>	
							    
							    <div class="form-group" style="width: 600px;">
								    <label  class="col-sm-2 control-label">公司名称</label>
								    <div class="col-sm-10">
								      <input id="companyName" name="companyName" type="text" class="form-control"  placeholder="请输入公司名称">
								    </div>
								</div>
								
								<div class="form-group" style="width: 600px;">
								    <label  class="col-sm-2 control-label">公司地址</label>
								    <div class="col-sm-10">
								      <input id="jobAddress" name="jobAddress" type="text" class="form-control"  placeholder="请输入公司详细地址">
								    </div>
								</div>
								
								<div class="form-group" style="width: 600px;">
								    <label  class="col-sm-2 control-label">公司电话</label>
								    <div class="col-sm-10">
								      <input id="companyPhone" name="companyPhone" type="text" class="form-control"  placeholder="请输入公司联系方式">
								    </div>
								</div>
								
								<div class="form-group" style="width: 600px;">
								    <label  class="col-sm-2 control-label">紧急联系人</label>
								    <div class="col-sm-10">
								      <input id="linkMan" name="linkMan" type="text" class="form-control"  placeholder="请输入紧急联系人名称">
								    </div>
								</div>
								
								<div class="form-group" style="width: 600px;">
								    <label  class="col-sm-2 control-label">联系人电话</label>
								    <div class="col-sm-10">
								      <input id="linkMobile" name="linkMobile" type="text" class="form-control"  placeholder="请输入紧急联系人电话">
								    </div>
								</div>
								
								<div class="form-group" style="width: 600px;">
								    <label  class="col-sm-2 control-label">联系人关系</label>
								    <div class="col-sm-10">
								      <select name="linkNexus" class="form-control" style="width: 470px;">
								      <option>亲人</option>
								      <option>朋友</option>
								      <option>同事</option>
							   		</select>
								    </div>
								</div>
								
								<div class="form-group" style="width: 600px;">
								    <label  class="col-sm-2 control-label">住宅情况</label>
								    <div class="col-sm-10">
								      <select name="house" class="form-control" style="width: 470px;">
								      <option>有按揭自置商品房</option>
								      <option>无按揭自置商品房</option>
								      <option>租房</option>
								      <option>住他人住房</option>
								      <option>其他</option>
							   		</select>
								    </div>
								</div>
								
								<div class="form-group" style="width: 600px;">
								    <label  class="col-sm-2 control-label">年收入</label>
								    <div class="col-sm-10">
								      <select name="salary" class="form-control" style="width: 470px;">
								      <option>1-5万</option>
								      <option>5-10万</option>
								      <option>10-30万</option>
								      <option>30万及以上</option>
							   		</select>
								    </div>
								</div>
								
								<div class="form-group" style="width: 600px;">
								    <label  class="col-sm-2 control-label">教育程度</label>
									    <div class="col-sm-10">
									      <select name="edu" class="form-control" style="width: 470px;">
									      <option>小学/初中</option>
									      <option>中专/高中</option>
									      <option>大专/本科</option>
									      <option>硕士及以上</option>
								   		</select>
									    </div>
								</div>
								
								<div class="form-group" style="width: 600px;">
								    <label  class="col-sm-2 control-label">身份证复印件</label>
								    <div style="margin-left: 20px;">
									    <input name="file" type="file" id="inputfile" style="padding-left:15px;">
									</div>
								</div>	
								
								<div class="form-group" style="width: 600px;">
								    <label  class="col-sm-2 control-label">资产证明</label>
								    <div style="margin-left: 20px;">
									    <input name="file" type="file" id="inputfile" style="padding-left:15px;">
									</div>
								</div>	
							   	<div style="margin-left: -150px;">	
							   	<a href="javascript:code()"><input name="cod" type="submit" class="btn btn-primary" value="提交申请" id="submit">
							   	</a>	
							   	</div>	
						</form>	
						<br/><br/><br/>
					</div>	
					<div align="center" style="border: 1px solid black; width: 950px; margin-left: 250px;"></div>
	</body>
 </html> 
