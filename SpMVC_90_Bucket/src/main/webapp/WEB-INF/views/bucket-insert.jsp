<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bucket-insert</title>
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
	text-align: center;
	width: 978px;
}

.btn-save {
	float: right;
}
</style>
<body>

	<div class="container">
		<div class="jumbotron text-center bg-dark text-white">Bucket
			List</div>
		<form method="POST">
			<div class="form-group">
				<div>
					<input type="hidden" name="b_id" value="0">
				</div>
				<div>
					제목 : <input name="b_subject" value="${BCVO.b_subject}"
						placeholder="제목을 입력하세요">
				</div>
				<div>
					내용 : <input name="b_content" value="${BCVO.b_content}"
						placeholder="내용을 입력하세요">
				</div>
				<button class="btn btn-save btn-success">저장</button>
			</div>
		</form>
	</div>
</body>
</html>