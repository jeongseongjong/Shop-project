package com.biz.navy.service;

public interface CartService {

	// 장바구니 개수
	public String count();
	
	public String delivery();
	
	// 장바구니 담기
	public String insert();
	
	// 장바구니에 담긴 상품 개수 수정
	public String qtyUpdate();
	
	// 장바구니 상품 삭제
	public String delete();
	
	// 장바구니 담겨진 상품 총 금액
	public String sum();
	
}
