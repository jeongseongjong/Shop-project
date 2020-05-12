package com.biz.navy.service;

public interface QnaService {


		// 질문 등록
		public String insert();
		
		// 질문 조회
		public String selectAll();
		
		// 질문 수정
		public String update();
		
		// 질문 삭제
		public String delete();
		
		// 상품별 질문조회
		public String findByPId();
}
