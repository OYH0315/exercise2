<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>李智恩</title>
	<%@include file="/pages/common/header.jsp"%>
</head>
<body>
	<div id="header">
			<span class="wel_word">李智恩图片下载器</span>
			<div>
                <c:if test="${empty sessionScope.user}"><!--判断是否登陆登陆成功的话显示功能按钮-->
					<a href="pages/user/login.jsp">登录</a> |
					<a href="pages/user/regist.jsp">注册</a>
				</c:if>
				 &nbsp;&nbsp;<c:if test="${not empty sessionScope.user}">
				<span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临李智恩小屋</span>
				<a href="userservlet?action=logout">安全退出</a>|<!--注销删除session中的user数据-->
				<a href="down?action=showpage">下载</a>|
				<a href="pages/manager/manager.jsp">后台管理</a>
			</c:if>
			</div>
	</div>
<p align="center"><img src="static/img/15.jpg"width="70%" height="80%" alt=""></p>

	
	<div id="bottom">
		<span>
			李智恩下载器.Copyright &copy;2020
		</span>
	</div>
</body>
</html>