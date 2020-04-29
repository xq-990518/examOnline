<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" href="<%=path%>/css/student.css" type="text/css" />
		<script type="text/javascript" src="<%=path%>/js/tools.js"></script>
		<title>学生登陆成功</title>
	</head>
<body >

<div class="container">
			
			<div class="header">
				<div class="logo">
					<a href="<%=path%>/student/showInfo.jsp"><img src="<%=path%>/images/logo.png" alt="" /></a>
				</div>
				<div class="headerinner">
					<ul class="headmenu">

						<li class="right">
							<div class="userloggedinfo">
								<img src="<%=path%>/images/photos/thumb5.png" alt="" />
								<div class="userinfo">
									<h5>${student.s_Name} <small>you are welcome</small></h5>
									<ul>
										<li><a href="<%=path %>/login.jsp">退出登录</a></li>
									</ul>
								</div>
							</div>
						</li>
					</ul>
					<!--headmenu-->
				</div>
			</div>

			<div class="examed_uc maincontentinner">
				<h3 style="text-align: center;">考试情况</h3>
				<div align="center" style="font-size: 18px">考生姓名:${student.s_Name}</div>
				<div align="center" style="font-size: 16px">考生得分:${score}分</div>
				<div align="center"><a href="showAnswer?e_id=${e_id}">查看答案</a></div>
				<br>
			</div>
			
	</div>

</body>
</html>