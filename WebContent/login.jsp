<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
		<meta charset="UTF-8">
		<style type="text/css">
			body{  
				font-family:arial, times, serif;  
				font-style:normal;  
				font-weight:normal;  
				font-size:20px; 

			}  
			td{
				padding: 20px;
				color: blue;
			}
			#body1{
			}
			button{  
				width:120px;  
				height:40px;  
				color:white;  
				background-color:rgb(2, 114, 188);  
				border-radius:10%;  
			}  
			#table_login{
				border: 2px solid #a1a1a1;
				border-radius: 10px;
				box-shadow: 10px 10px 5px #888888;
				background-color:#dddddd;
			}
			#table_login td:nth-of-type(1){
				width:90px;  
				height:55px;  
				border:0;  
			}
			#table_login td:nth-of-type(2){
				width:0px;  
				height:55px;  
				border:0;  
			}
			#table_login td:nth-of-type(3){
				width:300px;  
				height:54px;  
				border:1px;  
			}
			#table_login td:nth-of-type(3) input{
				width:240px;  
				height:35px;  
			}
		</style>
		<title>login</title>
		<script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js">
		</script>
		<script>
			$(document).ready(function(){
				$("#getverifycode").click(function(){
				    $.ajax({  
				        type:"POST",  
				        url:"/WebTest/VerifyServlet",//web.xml中的url-pattern，使用struts改成：命名空间/action_**即可.0  
				        data:{  
				            name:$("#username").val(),   
				        },  
				        dataType:"text",//类型  
				        beforeSend:function(XMLHttpRequest){  
				            $("#verifycode").text("loading..");  
				        },  
				        success:function(data,textStatus){//data代表servlet返回的数据，随意命名，一般写msg  
				            var result = data;
				            alert(result);
				            $("#verifycode").val(result);
				            $("#verification").css("color","red");  
				        },  error: function (res) {  
			            }  
				    });  
					});
			});
			</script>
			<script type="text/javascript">
			function checkVerify(){
				var verification = document.getElementById("verification");
				if(verification.value.length<=0){
					alert("验证码不能为空");
					return false;
				}
				checklogin();
			}

			function checklogin(){
				var a = document.getElementById("verification").value;
				var b = document.getElementById("verifycode").value;
				if(a!=b){
					alert(b);
					return false;
				}
				if(a.length<=0){
					alert("验证码不能为空");
					return false;
				}
				return true;
			}
			

		</script>
	</head>
	<body align="center" id="body1">
		<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">    
			<img src="img\flower.jpg" height="100%" width="100%"/>    
		</div>  
		<div class="title">
			<h1>个人主页</h1>
			<h1> 登录 </h1>
		</div>
		<form name="from_login" method="post" onsubmit="return checklogin()" action="LoginServlet?method=login">
			<table id="table_login" align="center">
				<tbody>
					<div class="loginform">
						<tr>
							<td><label>用户名</label></td>
							<td></td>
							<td><input type="text" id="username" name="username" maxlength="20" required="required"></td>
						</tr>
						<tr>
							<td><label>验证码</label></td>
							<td></td>
							<td><input type="number" id="verification" name="verification" maxlength="6" style="width: 120px" onclick="">
								<span id="getverifycode" value="产生验证码">产生验证码</span></td>
							</tr>
							<tr>
								<td><button type="submit" value="登录" />登录</button></td>
							</tr>
						</div>
					</tbody>
				</table>
			</form>
			<input type="hidden" id="verifycode" disabled="disabled">
		</body>
		</html>