<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv=refresh content=10;url="${basepath}pages/user/login.jsp">
<title>登陆失败</title>
	<%@include file="/pages/common/header.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
</style>
</head>
<body>

		
		<div id="main" align="center">

			<h2 style=color:red>${requestScope.msg}</h2>
			<h2 style=color:red><span id=jump>10</span> 秒钟后页面将自动返回登录页面...</h2>
			<h2 style="color: blue"><a href="${basepath}pages/user/login.jsp" style="color: blue">点击此处立即跳转至首页</a></h2>
			<img src="static/img/12.png" ></img>
	
		</div>
		

</body>
<script>
	function countDown(secs){
		jump.innerText=secs;
		if(--secs>0)
			setTimeout("countDown("+secs+" )",1000);
	}
	countDown(10);
	function jumpToIndex(){
		window.location.href="${basepath}pages/user/login.jsp";
	}
</script>
</html>