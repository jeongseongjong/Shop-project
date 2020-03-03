<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<form method="POST" class="repl">
	<div class="row p-2 ">

		<input type="hidden" name="c_p_id" id="c_p_id" value="${CMT.c_p_id}"> <input
			type="hidden" name="c_b_id" value="${CMT.c_b_id}">

		<div class="col-2">
			<input name="c_writer"
				class="form-control comment border border-info" id="c_writer"
				placeholder="작성자">
		</div>
		<div class="col-8">
			<input name="c_subject"
				class="form-control comment border border-info" id="c_subject"
				placeholder="댓글">
		</div>
		<button type="button" class="btn btn-success btn-cmt-save">답변저장</button>
	</div>
	<hr />
</form>
