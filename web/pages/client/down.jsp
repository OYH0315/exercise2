<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>李智恩小屋</title>
	<%@include file="/pages/common/header.jsp"%>
	<script type="text/javascript">
		$(function () {
			$("button.addcart").click(function () {
				var id=$(this).attr("iuid");
				location.href="${pageScope.base}down?action=downpicture&id="+id;
			})
		})
	</script>
</head>
<body>
	<div id="header">
			<span class="wel_word">李智恩下载器</span>
			<div>

				 &nbsp;&nbsp;<c:if test="${not empty sessionScope.user}">
				<span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临李智恩小屋下载器</span>
				<a href="userservlet?action=logout">安全退出</a>|<!--注销删除session中的user数据-->
				<a href="userservlet?action=logout">注销</a>&nbsp;&nbsp;
			</c:if>
				<a href="pages/cart/cart.jsp">下载记录</a>
				<a href="pages/manager/manager.jsp">后台管理</a>
			</div>
	</div>
	<div id="main">
		<div id="book">
			<c:forEach items="${requestScope.list}" var="list">
			<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="${list.path}" />
				</div>
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">名称:</span>
						<span class="sp2">${list.name}</span>
					</div>
					<div class="book_author">
						<span class="sp1">描述:</span>
						<span class="sp2">${list.description}</span>
					</div>
					<div class="book_price">
						<span class="sp1">推荐指数:</span>
						<span class="sp2">${list.star}星</span>
					</div>
					<div class="book_sales">
						<span class="sp1">大小:</span>
						<span class="sp2">${list.size}M</span>
					</div>
					<div class="book_add">
						<button iuid="${list.id}" class="addcart">下载图片</button>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
	
	</div>
	
	<div id="bottom">
		<span>
			李智恩下载器.Copyright &copy;2020
		</span>
	</div>
</body>
</html>