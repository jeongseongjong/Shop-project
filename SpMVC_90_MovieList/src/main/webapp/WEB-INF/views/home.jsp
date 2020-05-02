<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h3>네이버에 영화검색</h3>
	</header>
	<nav>
		<form action="${rootPath}/search">
			<select name="cat">
				<option value="movie">영화</option>
			</select>
			<input name="search" placeholder="검색어 입력">
			<button>검색</button>
		</form>
	</nav>
	<section class="main-container">
		<c:forEach items="${NAVER_ITEMS}" var="item">
			<a href="${item.link}" target="_new" class="title">
				<div class="d-box">
					<p class="title">${item.title}</p>
					<c:if test="${item.image != null}">
						<img src="${item.image}">
					</c:if>
					<p>${item.description}
				</div>
			</a>
		</c:forEach>
	</section>
	<section>
		<%@ include file="/WEB-INF/views/pagination.jsp"%>
	</section>
</body>
</html>