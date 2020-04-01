<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script>
	/*
	 * 화면상의 DOM객체가 모두 그려지기 전에 event등을 설정하면
	 기능이 제대로 작동되지 않는다.
	 jquery에서 $(function(){ 코드 })형식으로 작성하면
	 화면상의 모든 tag에 의한 DOM이 완전히 그려진 다음
	 코드들이 작동되어 문제를 일으키지 않는다.
	 */
	$(function() {
		$("button[type='button'].userId").click(function() {
			$.ajax({
				url : "sendUserId",
				data : $("form").serialize(),
				method : "POST",
				success : function(msg){
					alert(msg.RET_CODE)
					if(msg.RET_CODE == "RECV_OK"){
						
						let user = msg.userVO.userId + "\n"
						user += msg.userVO.password + "\n"
						user += msg.userVO.userName+ "\n"
						user += msg.userVO.rolle + "\n"
						
						alert("사용자 ID : " + user)
					}
				}
			})
		})
		
		$("button.user").click(function(){
			$.ajax({
				url : "sendUser",
				method:"POST",
				// form에 입력된 데이터를 통째로 json으로 변경
				data : $("form").serialize(),
				success : function(userVO){
					
					// json객체 형태의 데이터는 alert로 확인하면
					// [object, object] 형식으로만 확인이 된다.
					// 이 객체를 toString() 하는 것처럼 문자열로
					// 풀어서 alert으로 보여달라.
					/*
						json형태로 받은 userVO의 값을 사용해서
						html tag코드를 작성
					*/
					let html = "<p>" + userVO.userId + "</p>"
					html += "<p>" + userVO.password + "</p>"
					html += "<p>" + userVO.userName + "</p>"
					html += "<p>" + userVO.rolle + "</p>"
					
					$("#ret_html").html(html)
					
				}
			})
		})
		
		$("button.user_html").click(function(){
			$.ajax({
				url : "html",
				data : $("form").serialize(),
				success : function(result){
					$("#ret_html").html(result)
				}
			})
		})
	})
</script>
</head>
<body>
	<section>
		<h2>사용자정보</h2>
		<h5>사용자 ID : ${userVO.userId}</h5>
		<h5>비밀번호 : ${userVO.password}</h5>
		<h5>사용자 이름 : ${userVO.userName}</h5>
		<h5>사용자 권한 : ${userVO.rolle}</h5>
	</section>
	<section id="ret_html">
	
	</section>
	<section>
		<form action="saveUser" method="POST">
			<div>
				<input placeholder="사용자 ID" name="userId" id="userId">
			</div>
			<div>
				<input placeholder="비밀번호" name="password" id="password">
			</div>
			<div>
				<input placeholder="사용자 이름" name="userName" id="userName">
			</div>
			<div>
				<input placeholder="사용자 권한" name="rolle" id="rolle">
			</div>
			<%
				/*
					button에 type을 지정하지 않으면 기본 type="submit"이 되고
					이 버튼이 form 안에 있으면
					버튼을 클릭했을 때 form안의 input box에 입력한 값을 모두 모아서
					action으로 지정된 url로 모두 전송하는 기능을 수행
 					button type="button"으로 지정하면 
				*/
			%>
			<button>저장</button>
			<button type="button" class="userId">사용자 ID 전송</button>
			<button type="button" class="user">입력값전송</button>
			<button type="button" class="user_html">입력 HTML로 받기</button>
		</form>
	</section>
</body>
</html>