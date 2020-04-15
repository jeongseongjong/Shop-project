<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="POST">
		<input type="hidden" name="id" value="${USVO.id}">
		<input name="username" value="${USVO.username}" placeholder="아이디">
		<input name="password" value="${USVO.password}" placeholder="비밀번호">
		<input name="email" value="${USVO.email}" placeholder="email">
		<input name="phone" value="${USVO.phone}" placeholder="phone">
		<input name="address" value="${USVO.address}" placeholder="address">
		<button>저장</button>
	</form:form>
</body>
</html>