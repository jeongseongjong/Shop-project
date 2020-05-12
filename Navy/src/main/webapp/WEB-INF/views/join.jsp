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
<%@ include file="/WEB-INF/views/include/include-head.jspf"%>
<script>
	$(function() {
		$(document).on("click", "#btn-join", function() {
			let username = $("#username")
			let password = $("#password")
			let re_password = $("#re_password")

			if (username.val() == "") {
				alert("아이디를 입력하세요")
				username.focus()
				return false;
			}

			if (password.val() == "") {
				alert("비밀번호를 입력하세요")
				password.focus()
				return false;
			}

			if (re_password.val() == "") {
				alert("비밀번호를 입력하세요.")
				password.focus()
				return false;
			}

			if (password.val() != re_password.val()) {
				alert("비밀번호가 맞지 않습니다.")
				password.focus()
				return false;
			}

			$("form").submit()
		})
	})
</script>
<body>
	<div class="w3-container w3-red">
		<h2>회원가입</h2>
	</div>

	<form:form method="POST" action="${rootPath}/user/join">
		<p>
			<label>ID</label> <input id="username" name="username"
				placeholder="User ID" class="w3-input" type="text">
		</p>
		<p>
			<label>PASSWORD</label> <input id="password" name="password"
				placeholder="비밀번호" class="w3-input" type="password">
		</p>
		<p>
			<label>re_PASSWORD</label> <input id="re_password" name="re_password"
				placeholder="비밀번호" class="w3-input" type="password">
		</p>

		<button type="button" id="btn-join">회원가입</button>
		<button type="button" id="btn-loss">ID/비밀번호 찾기</button>
	</form:form>
</body>
</html>