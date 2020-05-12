package com.biz.navy.service;

public interface ReviewService {

	// 리뷰등록
	public String insert();
	
	// 리뷰조회
	public String selectAll();
	
	// 리뷰수정
	public String update();
	
	// 리뷰삭제
	public String delete();
	
	// 상품별 리뷰조회
	public String findByPId();
	
	
}
