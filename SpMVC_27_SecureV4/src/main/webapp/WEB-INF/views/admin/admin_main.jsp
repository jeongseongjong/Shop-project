<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include-head.jspf" %>
<style>
	#body {
		position:fixed;
		top:60px;
		left:0;
		width:100%;
		display:flex;
	}
	#body menu {
		flex : 1;
		border: 1px solid blue;
		margin:5px;
	}
	#body menu li{
		list-style :none;
	}
	#body menu li a{
		display: inline-block;
		padding:5px 10px;
		width:150px;
		margin-left: 10px;
		border-bottom : 2px solid blue;
	}
	#body menu li a:hover{
		background-color: blue;
		color:white;
		border-bottom : 2px solid yellow;
	}
	#body article{
		flex : 3;
		border: 1px solid blue;
		margin:5px;
	}
	
</style>
</head>
<script>
$(function(){
	$(document).on("click","#user_list",function(){
		$.get("${rootPath}/admin/user_list",function(result){
			$("#admin_content").html(result)
		})
	})
	
	$(document).on("click","tr.tr_user",function(){
		let username = $(this).data("id")
		$.get("${rootPath}/admin/user_detail_view/" + username,
				function(result){
			$("#admin_content").html(result)
		})
	})
	
	$(document).on("click","button#btn_save",function(){
		
		let formdata = $("form").serialize()
		$.post("${rootPath}/admin/user_detail_view",formdata,function(result){
			$("#admin_content").html(result)
			alert("Update 성공")
		})
		
	})
	
	// $("#auth_append").click();
	
	// ajax시 사용할 수 있는 함수 
	$(document).on("click","#auth_append",function(){
			
			let auth_input = $("<input/>",
					{class:"auth",name:"auth"})
			// auth_input.append($("<p/>",
			//		{text:'제거',class:'auth_delete'}))		
			$("div#auth_box").append(auth_input)
		})
})
</script>
<body>
<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>
<section id="body">
<menu>
	<h3>관리자 페이지</h3>
	<ul>
		<li><a href="javascript:void(0)" id="user_list">User List</a>
		<li><a href="#">메뉴 1</a>
		<li><a href="#">메뉴 2</a>
	</ul>
</menu>
<article id="admin_content">

</article>
</section>
</body>
</html>