<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bucket List</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<style>
.container {
	width: 768px;
}

.list-title {
	margin-bottom: 5px;
	text-align: center;
}

hr {
	margin: 0;
	padding: 0;
}

.list {
	font-size: 20px;
}

.list:hover {
	background-color: #ccc;
	cursor: pointer;
}

.bc-insert {
	margin-top: 10px;
	border: 1px solid #ccc;
}

.col-2 {
	text-align: center;
}

.check-div {
	display: flex;
	justify-content: space-between;
}

.check-box {
	margin-top: 10px;
}
</style>
<script>
	$(function() {
		$(".bc-insert").click(function() {
			document.location.href = "${rootPath}/insert"
		})
		
		$("input:checkbox").on("click", function(e) {
			e.stopPropagation();
			var b_id = $(this).data("id")
			var b_complete = $(this).data("com")
			alert(b_id)

			$.ajax({
				url : "${rootPath}/checkBox",
				data : {
					b_id : b_id,
					b_complete : b_complete
				},
				type : 'POST',
				success : function() {
					location.reload()
				},
				error : function() {
					alert("체크박스 오류")
				}
			})
			return false

		})

	})
</script>
<body>
	<div class="container">
		<div class="jumbotron text-center bg-dark text-white">Bucket
			List</div>
		<div>
			<div class="bg-secondary list-title d-flex text-white">
				<div class="col-2">번호</div>
				<div class="col-8">제목</div>
				<div class="col-2">비고</div>
			</div>
			<%@ include file="/WEB-INF/views/bucket-include-list.jsp" %>
			<button class="btn float-right bc-insert">버킷리스트 작성</button>
		</div>
	</div>
</body>
</html>