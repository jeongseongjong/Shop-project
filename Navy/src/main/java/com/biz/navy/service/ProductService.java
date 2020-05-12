package com.biz.navy.service;

public interface ProductService {

	// 상품등록
	public String insert();
	
	// 상품수정
	public String update();
	
	// 상품삭제
	public String delete();
	
	// 상품전체리스트
	public String selectAll();
	
	// 상품조회
	public String findById();
}
