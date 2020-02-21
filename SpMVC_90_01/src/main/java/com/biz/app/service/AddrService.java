package com.biz.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.app.AddrVO;

@Service
public class AddrService {

	public List<AddrVO> addrListAll(){
		
		List<AddrVO> addrList = new ArrayList<AddrVO>();
		
		AddrVO addrVO = new AddrVO();
		addrVO.setName("홍길동");
		addrVO.setTel("011");
		addrVO.setPost("6001");
		addrVO.setCity("서울시");
		addrVO.setAddr("강남구 도곡동 타워펠리스");

		addrList.add(addrVO);
		
		addrVO = new AddrVO();
		addrVO.setName("이몽룡");
		addrVO.setTel("012");
		addrVO.setPost("6002");
		addrVO.setCity("남원시");
		addrVO.setAddr("광한루 철물점");

		addrList.add(addrVO);
		
		addrVO = new AddrVO();
		addrVO.setName("성춘향");
		addrVO.setTel("013");
		addrVO.setPost("6003");
		addrVO.setCity("익산시");
		addrVO.setAddr("익산역 앞 맛집");

		addrList.add(addrVO);
		
		return addrList;
	}
}
