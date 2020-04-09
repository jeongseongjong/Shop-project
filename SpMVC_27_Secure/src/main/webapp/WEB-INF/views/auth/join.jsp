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
<%@ include file="/WEB-INF/views/include/include-head.jspf"%>
<link rel="stylesheet" href="../css/login.css">
</head>
<script>
	$(function() {
		$(document).on("click", "#btn-join", function() {

			// 유효성 검사
			// id, pw가 입력되지 않았을때 경고
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
				alert("비밀번호 확인란을 입력하세요")
				re_password.focus()
				return false;
			}

			if (password.val() != re_password.val()) {
				alert("비밀번호와 비밀번호 확인이 다릅니다.")
				password.focus()
				return false;
			}
			$("form").submit()
		})
		
		// 현재 입력박스에서 포커스가 벗어났을때 발생하는 이벤트
		$(document).on("blur","#username",function(){
			let username = $(this).val()
			if(username == ""){
				$("#m_username").text("아이디는 반드시 입력해야 합니다.")
				return false;
			}
			$.ajax({
				url : "${rootPath}/user/idcheck",
				method:"POST",
				data : {
					username : username
				},
			success: function(result){
				if(result == "USE"){
					$("#m_username").text("이미 가입된 사용자 이름입니다.")
					$("#m_username").css("color","red")
					return false
				}
			},
				error:function(){
					// alert("서버와 통신 오류")
				}
			})
		})
	})
</script>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Tabs Titles -->

			<!-- Icon -->
			<div class="fadeIn first">
				<img src="../image/login.png" id="icon" alt="User Icon" />
			</div>

			<!-- Login Form -->
			<form:form action="${rootPath}/user/join" method="POST">
			<!-- 	<input type="text" name="${_csrf.parameterName}" value="${_csrf.token}"> -->
				<input type="text" id="username" class="fadeIn second"
					name="username" placeholder="username">
				<div class="message" id="m_username"></div>
				<input type="password" id="password" class="fadeIn third"
						 name="password" placeholder="password"> 
				<input type="password" id="re_password"
					class="fadeIn third" name="re_password" placeholder="password">
				<input type="button" class="fadeIn fourth"
					 id="btn-join"value="회원가입"> 
				<input type="button"
					class="fadeIn fourth join" id="btn-loss" value="ID/PW 찾기">
			</form:form>

		</div>
	</div>
</body>
</html>