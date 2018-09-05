<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
	  <meta charset="utf-8">
		<title>个人主页</title>
		<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
		<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
		<script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
		<style type="text/css">
			body{

				background-color: #f0f0f0;

			}
			div{
				display: block;
			}
			.leftside{
				position: center;
				float:left;
				width:360px;
				overflow-y:hidden;
				color:#000000;
				text-align:center;
			}
			.logo{
				border: 1px solid #e7e7e7;
				background-color:#d3d3d3;
				font-size: 24px;
				text-align:center;
			}
			.name{
				font-size: 24px;
			}
			.baseinfo{
				font-size: 20px;

			}
			.menu{
				list-style-type: none;
			}
			ul {
				list-style-type: none;
				margin: 0;
				padding: 0;
				overflow: hidden;
				border: 1px solid #e7e7e7;
				background-color: #f3f3f3;
			}
			li {
				float: left;
			}
			li p {
				display: block;
				color: #666;
				text-align: center;
				padding: 14px 16px;
				text-decoration: none;
			}
			li p:hover:not(.active) {
				background-color: #ddd;
			}

			li p.active {
				color: white;
				background-color: #4CAF50;
			}
			#rightside{
				background-color: #f3f3f3;
			}

		</style>
	</head>
	<body>
	<jsp:useBean id="pser" class="bean.PersonalService"></jsp:useBean>
    <jsp:useBean id="pinfo" class="bean.PersonalInfo"></jsp:useBean>
    <%
    pinfo = pser.queryInfo((String)session.getAttribute("account"));
    %>
		<div class="leftside">
			<div class="logo">
				<p>个人主页</p>
			</div>
			<div class="teachersummary">
				<div class="photo">
					<img src="<%out.println(pinfo.getPhotoPath()); %>" width="120" height="150">
				</div>
				<div class="name">
					<p><%out.println(pinfo.getName()); %></p>
				</div>
				<div class="baseinfo">
					<p>性别:<%out.println(pinfo.getSex()); %></p>
					<p>学校:<%out.println(pinfo.getSchool()); %></p>
					<p>学院:<%out.println(pinfo.getMajor()); %></p>
					<p>班级:<%out.println(pinfo.getClassName()); %></p>

					<a href="alter.jsp" class="btn btn-primary active">编辑个人信息<a>
				</div>
			</div>

		</div>
		<div id="rightside">
			<div class="nav">
				<ul class="nav nav-tabs" role="tablist">
					<li class="nav-item">
						<a class="nav-link active" data-toggle="tab" href="#work">工作经历</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" data-toggle="tab" href="#award">获奖情况 </a>
					</li>
					<li class="nav-item">
						<a class="nav-link" data-toggle="tab" href="#other">其他 </a>
					</li>
				</ul>

			</div>
			<div class="tab-content">
				<div id="work" class="container tab-pane active"><br>
					<h3>工作经历</h3>
					<p>使用场景：关闭页面弹窗时执行sql语句。</p>
					<p>其实js里执行sql语句有多种方式。</p>
					<p>方式一：直接在js代码里调用sql语句，原则上不能使用，因为这将sql直接暴露在客户端，安全性极差。</p>
					<p>方式二：在js里运用ajax技术，调用后台方法执行sql语句。</p>
					<p>方式三：运用dwr框架，其实是对ajax技术进行了封装。</p>
				</div>
				<div id="award" class="container tab-pane fade"><br>
					<h3>获奖情况</h3>
					<p>1.随机生成a~z之间的字符</p>
					<p>(char)('a'+Math.random()*('z'-'a'+1));</p>
					<p>2.随机生成cha1~cha2的字符</p>
					<p>(char)(cha1+Math.random()*(cha2-cha1+1));</p>
				</div>
				<div id="other" class="container tab-pane fade"><br>
					<h3>其他</h3>
					<p>除了Math类的Random()方法可以获取随机数之外，还可以Java.util.Random类，可以通过实例化一个Random对象创建一个随机数生成器。</p>
					<p>以这种形式实例化对象时，Java编译器以系统当前时间作为随机数生成器的种子，因为每时每刻的时间都不可能相同，所以产生的随机数也不同。如果运行速度太快，也会产生两次运行结果相同的随机数。</p>
				</div>
			</div>

		</div>




	</body>
	</html>