<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/include/include-head.jspf" %>
</head>
<body>
<h2>Shop</h2>
<nav>
	<ul>
		<li>
			<c:if test=""><a href="${rootPath}/user/login">login</a></c:if>
		</li>
		<li><a href="${rootPath}/user/join">join</a></li>
		<li>mypage</li>
	</ul>
</nav>
</body>
</html>