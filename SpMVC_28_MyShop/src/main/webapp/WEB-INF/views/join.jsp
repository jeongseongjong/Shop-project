<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@ include file="/WEB-INF/views/include/include-head.jspf" %>
<script>
$(function(){
	$(document).on("click","#btn-join", function(){
		let username = $("#username")
		let password = $("#password")
		let re_password = $("#re_password")
		
		if(username.val() == ""){
			alert("아이디를 입력하세요")
			username.focus()
			return false;
		}
		
		if(password.val() == ""){
			alert("비밀번호를 입력하세요")
			password.focus()
			return false;
		}
		
		if(re_password.val() == ""){
			alert("비밀번호를 입력하세요.")
			password.focus()
			return false;
		}
		
		if(password.val() != re_password.val()){
			alert("비밀번호가 맞지 않습니다.")
			password.focus()
			return false;
		}
		
		$("form").submit()
	})
})
</script>
<body>
	<section class="container">
		<form:form method="POST" modelAttribute="userVO"
			action="${rootPath}/user/join" class="join_form">

			<h2>회원가입</h2>
			<div class="input-box">
				<label for="username">USER NAME</label>
				<form:input type="text" class="form-control" path="username"
					placeholder="사용자  ID" />
			</div>
			<div class="input-box">
				<label for="password">PASSWORD</label>
				<form:input type="text" class="form-control" path="password"
					placeholder="사용자  비밀번호" />
			</div>
			<div class="input-box">
				<label for="password">RE PASSWORD</label> <input type="text"
					class="form-control" id="re_password" name="re_password"
					placeholder="비밀번호 재확인" class="form-control view-pass" />
			</div>
			<button type="button" class="btn btn-sucess" id="btn-join">회원가입</button>
			<button type="button" class="btn btn-sucess" id="btn-loss">ID/PW찾기</button>
		</form:form>
	</section>
</body>
</html>