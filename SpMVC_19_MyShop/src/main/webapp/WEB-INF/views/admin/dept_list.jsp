<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/include/include-head.jspf" %>

<style>
td, th{
	white-space :nowrap;
}
</style>
<script>
$(function(){

	$(".dept_tr").click(function(){
		
		// let id = $(this).data("id") // attr("data-id")와 같다
		// let c = $(this).attr("class")
		
		let tds = $(this).children();
		let d_code = tds.eq(0).text()
		let d_name = tds.eq(1).text()
		
		//나를 open한 화면에 있는 p_dcode input 박스에 
		// d_code값을 채워 넣어라
		$("#p_dcode", opener.document).val(d_code)
		$("#d_name", opener.document).text(d_name)
		
		window.close()
		window.open('about:blank', '_self'.self.close())
		
		
		// document.location.href="${rootPath}/admin/dept/update/" + id
		// document.location.href="${rootPath}/admin/dept/update/upodate?id=" + id
		
	})
	
	var dept_call = function(key){
		var id = $(this).data("id")
		if(key == "edit"){
			document.location.href="${rootPath}/admin/dept/update/" + id		
		}else if(key =="delete"){
			if(confirm("정말 삭제합니까?")){
				document.location.href="${rootPath}/admin/dept/delete/" + id	
			}
		}
	}
	
	$.contextMenu({
		selector:".dept_tr",
		items:{
			"edit" : {name:"거래처 수정",icon:"edit"},
			"delete" : {name:"거래처 삭제",icon:"delete"}
		},
		callback : dept_call
	})
})

</script>
<table>
	<tr>
		<th>거래처코드</th>
		<th>거래처명</th>
		<th>대표자명</th>
		<th>사업자 번호</th>
		<th>대표전화</th>
		<th>담당자</th>
		<th>담당자 번호</th>
		<th>비고<th>
	</tr>
	<c:choose>
		<c:when test="${empty DEPT_LIST}">
			<tr>
				<td colspan="6">거래처 정보가 없습니다.</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach var="DEPT" items="${DEPT_LIST}" varStatus="i">
				<tr class="dept_tr" data-id="${DEPT.id}">
					<td>${DEPT.d_code}</td>
					<td>${DEPT.d_name}</td>
					<td>${DEPT.d_ceo}</td>
					<td>${DEPT.d_sid}</td>
					<td>${DEPT.d_tel}</td>
					<td>${DEPT.d_manager}</td>
					<td>${DEPT.d_mtel}</td>
					<td>${DEPT.d_rem}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
