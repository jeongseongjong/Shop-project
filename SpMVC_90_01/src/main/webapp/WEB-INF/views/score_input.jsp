<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" 
	  content="width=device-width, initial-scale=1">
<title>□□□ 나의 JSP 페이지 □□□</title>
</head>
<body>
<h3>학생점수</h3>
<form action="score_input" method=POST>
	<lable>국어</lable><input name="kor" placeholder="국어점수" value="<c:out value="${scoreVO.kor}" default="0"/>"><br/>
	<lable>영어</lable><input name="eng" placeholder="영어점수" value="<c:out value="${scoreVO.eng}" default="0"/>"><br/>
	<lable>수학</lable><input name="math" placeholder="수학점수" value="<c:out value="${scoreVO.math}" default="0"/>"><br/>
	<lable>과학</lable><input name="sc" placeholder="과학점수" value="<c:out value="${scoreVO.sc}" default="0"/>"><br/>
	<lable>음악</lable><input name="music" placeholder="음악점수" value="<c:out value="${scoreVO.music}" default="0"/>"><br/>
	<button>계산</button>
</form>
<div><b>총점</b> : ${scoreVO.sum}</div>
<div><b>평균</b> : ${scoreVO.avg}</div>
</body>
</html>