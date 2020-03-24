<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div class="id_subject d-flex">
			<div>번호 : ${bcVO.b_id}</div>
			<div>제목 : ${bcVO.b_subject}</div>
		</div>
		<div>
			<div>소감</div>
			<div>${bcVO.b_impression}</div>
		</div>
	</div>
</body>
</html>