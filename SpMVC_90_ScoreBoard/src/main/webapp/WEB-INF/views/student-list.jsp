<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/include-head.jspf"%>
</head>
<script>
	
</script>
<body>
	<div class="container">
		<div class="row p-2">
			<div class="col-2">번호</div>
			<div class="col-2">학번</div>
			<div class="col-2">이름</div>
			<div class="col-2">학년</div>
			<div class="col-2">반</div>
			<div class="col-2">과목</div>
			<div class="col-2">점수</div>
			<div class="col-2">비고</div>
		</div>

		<c:forEach items="${JOIN_LIST}" var="list">
			<div class="row p-2">
				<div class="col-2">${list.st_id}</div>
				<div class="col-2">${list.st_num}</div>
				<div class="col-2">${list.st_name}</div>
				<div class="col-2">${list.st_grade}</div>
				<div class="col-2">${list.st_class}</div>
				<div class="col-2">${list.s_subject}</div>
				<div class="col-2">${list.s_score}</div>
				<div class="col-2">
					<a href="${rootPath}/student/update?st_num=${list.st_num}">수정</a>
					<a href="${rootPath}/student/delete?st_num=${list.st_num}">삭제</a>
				</div>
			</div>

		</c:forEach>
	</div>
	<a href="${rootpath}/score/student/insert">학생등록</a>
</body>
</html>