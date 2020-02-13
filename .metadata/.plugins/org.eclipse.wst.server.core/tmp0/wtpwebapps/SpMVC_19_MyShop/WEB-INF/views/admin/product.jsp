<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<section class="row justify-content-center container-fluid">
	<article class="col-7 bg-light pro-input">
		<form:form modelAttribute="productVO">
			<div class="container-fluid form-=group row">
				<form:select path="p_bcode" class="custom-select-sm">
					<option>품목을 선택하시오</option>
					<option>품목을 선택하시오</option>
					<option>공산품</option>
					<option>농산물</option>
					<option>수산물</option>
				</form:select>
				<form:select path="p_dcode" class="custom-select-sm">
					<option>거래처를 선택하시오</option>
					<option>대덕물산</option>
					<option>삼성물산</option>
					<option>목포수산</option>
				</form:select>
			</div>

			<div class="form-group">
				<form:input path="p_code" class="form-control" placeholder="상품코드" />
			</div>
			<div class="form-group">
				<form:input path="p_name" class="form-control" placeholder="상품이름" />
			</div> 
			<div class="container-fluid form-group row">
				<form:input path="p_iprice" class="form-control col-6" placeholder="매입단가" /> 
				<form:input path="p_oprice" class="form-control col-6" placeholder="판매단가" />
			</div>
			<div class="form-group">
				<form:textarea path="p_detail" class="form-control" rows="" cols="" placeholder="상세정보" />
			</div>
		</form:form>
	</article>

	<article class="col-3 bg-primary pro-list"></article>


</section>