<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
	<h2>Model Attribute</h2>
</header>
<section>
	<h3>User ID : ${usersVO.userId }</h3>
	<h3>Password: ${usersVO.password }</h3>
	<h3>User Name : ${usersVO.userName }</h3>
	<h3>User ROLLE : ${usersVO.userRolle }</h3>
</section>

</body>
</html>