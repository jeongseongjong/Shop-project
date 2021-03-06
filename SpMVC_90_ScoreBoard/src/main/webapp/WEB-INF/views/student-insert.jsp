<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/include-head.jspf" %>
</head>
<body>
	<div class="container">
		<form method="POST">
		<div class="row p-2">
			<c:choose>
				<c:when test="${empty STUDENT || STUDENT.st_num == 0  }">
					<input type="text" name="st_num" placeholder="학번을 작성">
				</c:when>
				<c:otherwise>
					<input type="hidden" name="st_num" value="${STUDENT.st_num}">
				</c:otherwise>
			</c:choose>
			
				<input type="text" name="st_name" placeholder="이름을 작성하세요">
				<input type="text" name="st_grade" placeholder="학년을 작성하세요"> 
				<input type="text" name="st_class" placeholder="반을 작성하세요">
				<input type="text" name="scoreVO.subjectVO.kor" placeholder="국어점수를 입력하세요">
				<input type="text" name="scoreVO.subjectVO.eng" placeholder="영어점수를 입력하세요">
				<input type="text" name="scoreVO.subjectVO.math" placeholder="수학점수를 입력하세요">
				<input type="text" name="scoreVO.subjectVO.science" placeholder="과학점수를 입력하세요">
				<input type="text" name="scoreVO.subjectVO.history" placeholder="국사점수를 입력하세요">
				<input type="text" name="scoreVO.s_name" placeholder="점수를 작성하세요">
				<button class="btn btn-info save">저장</button>
			</div>
		</form>
	</div>
</body>
</html>