package com.biz.naviya.service;

public interface UserService {

	// 회원가입
	public String join() ; 
	
	// 회원정보(수정)
	public String mypage() ;
	
	// 회원탈퇴(?)
	public String delete();
	
	// 회원정보 리스트
	public String selectAll() ;
	
	// 회원  이름으로 찾기
	public String findByUsername();
	

}
