<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<link href="${rootPath}/js/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<!-- Custom styles for this template -->
<link href="${rootPath}/js/css/heroic-features.css" rel="stylesheet">
<!-- Bootstrap core JavaScript -->
<script src="${rootPath}/js/vendor/jquery/jquery.min.js"></script>
<script src="${rootPath}/js/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<style>
body {
	height: 100%;
}

.detail-li {
	list-style: none;
}

.product-container-box {
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
}

.img-box {
	border: 1px solid black;
	width: 300px;
	height: 270px;
	margin: 3rem;
}

.btn-box {
	display: flex;
	justify-content: center;
	align-items: center;
}

#btn-cart, #btn-buy {
	margin: 3px;
	width: 200px;
}

.producthtag {
	font-weight: bold;
}

p {
	white-space: pre-line;
}
</style>
<script>

	$(function(){
		
		$("#btn-cart").click(function(){
			
			let p_qty = parseInt($("#p_qty").val())
			
			if(p_qty <= 0){
				alert("수량은 0개 이상")
				return false;
			}

			$.ajax({
				url : "${rootPath}/user/product/cart",
				type : "POST",
				data : {
					p_code : "${B2C_DTO.p_code}",
					p_oprice : "${B2C_DTO.p_oprice}",
					p_qty : p_qty,
					
					// 포스트일 경우에는 이 값을 보내주어야 한다.
					"${_csrf.parameterName}" : "${_csrf.token}"
				},
				success : function(result){
					
					if(result == 'LOGIN_FAIL'){
						alert("먼저 로그인을 수행해야 한다.")
					}else if(result == "OK"){
						if(confirm("상품을 카트에 담았습니다.\n" + "장바구니로 이동하겠습니까?")){
							document.location.href="${rootPath}/user/product/cart_view"
						}
					}
				},
				error:function(){
					alert("서버 통신 오류")
				}
			})
			
			// document.location.href = "${rootPath}/user/product/cart?p_code=${B2C_DTO.p_code}" +
			//		"&p_oprice=${B2C_DTO.p_oprice}" +
			//		"&p_qty=" + p_qty
		})
		
	})

</script>
<body>

	<div class="product-container-box">

		<div class="img-box">
			<img>
		</div>

		<div class="product-item-box">
			<div class="product-name">
				<h2 class="producthtag">${B2C_DTO.p_name}</h2>
				<hr />
			</div>
			<table>
				<tbody>
					<tr>
						<th>판매가</th>
						<td><fmt:formatNumber value="${B2C_DTO.p_oprice}" type="currency" /></td>
					</tr>
					<tr>
						<th>상품코드</th>
						<td>${B2C_DTO.p_code}</td>
					</tr>
					<tr>
						<th>제조사/공급사</th>
						<td>${B2C_DTO.p_dcode}</td>
					</tr>
					<tr>
						<th>구매수량</th>
						<td><input type="number" id="p_qty" name="p_qty" value="0"></td>
					</tr>
				</tbody>
			</table>
			<hr />
			<div class="btn-box">
				<button class="btn btn-primary" id="btn-cart">장바구니</button>
				<button class="btn btn-primary" id="btn-buy">바로구매</button>
			</div>
		</div>
	</div>



	<div class="container">
		<hr />
		<p>
			${B2C_DTO.p_detail}
		</p>
	</div>

