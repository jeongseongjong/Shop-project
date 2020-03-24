<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${BC_LIST}" var="bc" varStatus="index">
		<div class="list" data-seq="${bc.b_id}">
			<div class="bc-list d-flex">
				<div class="col-2">${bc.b_id}</div>
				<div class="col-8 check-div">

					<c:choose>
						<c:when test="${bc.b_complete == 1}">
							<span style="text-decoration: line-through">${bc.b_subject}</span>
						</c:when>
						<c:otherwise>
							<span style="text-decoration: none">${bc.b_subject}</span>
						</c:otherwise>
					</c:choose>
					<input type="checkbox" class="check-box" name="b_complete"
						data-id="${bc.b_id}" id="b_complete_${index.index}" data-com="${bc.b_complete}">
				</div>
				<div class="col-2">
					<a href="${rootPath}/update?b_id=${bc.b_id}">수정</a> <a
						href="${rootPath}/delete?b_id=${bc.b_id}">삭제</a>
				</div>
			</div>
			<hr />
		</div>
	</c:forEach>
</body>
</html>