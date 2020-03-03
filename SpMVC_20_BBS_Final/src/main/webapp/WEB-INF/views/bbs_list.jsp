<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include-head.jspf"%>
<script>
	$(function() {

		$("button.btn-writer").click(function() {

			document.location.href = "${rootPath}/insert"

		})
		


	})
</script>
</head>

<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf"%>
	<section class="container-fluid">
		<article>
			<table class="table table-striped table-hover">

				<tr>
					<th width="15%">NO</th>
					<th width="15%">제목</th>
					<th width="30%">작성자</th>
					<th width="30%">일시</th>
				</tr>
				<c:forEach items="${BBS_LIST}" var="BBS" varStatus="i" >
					<tr class="detail">
						<td>${i.count}</td>
						<td><a href="${rootPath}/detail?b_id=${BBS.b_id}">
						${BBS.b_subject}
						</a></td>
						<td>${BBS.b_writer}</td>
						<td>${BBS.b_date_time}</td>

					</tr>
				</c:forEach>
			</table>
		</article>
		<article class="d-flex justify-content-end">
			<button class="btn btn-primary text-white btn-writer">글쓰기</button>
		</article>
	</section>
</body>
</html>