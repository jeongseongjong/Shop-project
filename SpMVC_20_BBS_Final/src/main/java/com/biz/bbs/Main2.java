package com.biz.bbs;

import java.util.ArrayList;
import java.util.List;

import com.biz.bbs.domain.BBsVO;
import com.biz.bbs.service.FileReaderService;

public class Main2 {

	public static void main(String[] args) {
		
		FileReaderService fService = new FileReaderService();
		
		// 전체 데이터를 가져와 bbsList에 담기
		List<BBsVO> bbsList = fService.getBBsData();
		
		List<BBsVO> pList = fService.getMain(bbsList);
	
		List<BBsVO> prList = new ArrayList<BBsVO>();
		
		// 원글을 forEach로 
		pList.forEach(vo->{
			
			prList.add(vo);
			
			// addAll
			// 리스트를 하나씩 집어넣는게 아닌 리스트 통으로 집어넣어줘라
			prList.addAll(fService.getRepl(bbsList, vo));
			
		});
		
		prList.forEach(System.out::println);
	}
	
	
}
