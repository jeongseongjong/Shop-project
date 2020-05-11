package com.biz.naviya.service;

public interface AuthProviderImpl {

	// 권한등록
	public String insert();
	
	// 권한삭제
	public String deleteById();
	
	// 권한삭제
	public String deleteByUsername();
	
	// 사용자 권한 조회
	public String findByUsername();

}
