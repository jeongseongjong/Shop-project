<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<style>
.cmt-item:hover {
	border: 1px solid #ccc;
}

.cmt-item-del:hover {
	cursor: pointer;
	border: 1px solid #ddd;
}
</style>
<c:forEach items="${CMT_LIST}" var="cmt">
	<div class="row p-2 cmt-item" data-id="${cmt.c_id}">
		<div class="col-2 bg-right writer"><b>${cmt.c_writer}님</b></div>
		<br />
		<div class="col-8 subject">${cmt.c_subject}</div>
		<div class="col-1 cmt-item-repl"><b>답변</b></div>
		<div class="col-1 cmt-item-del">&times;</div>
	</div>
</c:forEach>
