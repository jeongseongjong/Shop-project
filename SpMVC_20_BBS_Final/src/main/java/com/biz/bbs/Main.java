package com.biz.bbs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.biz.bbs.domain.BBsVO;
import com.biz.bbs.service.FileReaderService;

public class Main {

	// 진입점, end point method
	public static void main(String[] args) {
		
		FileReaderService fService = new FileReaderService();
		
		List<BBsVO> bbsList = fService.getBBsData();
		
		// sort
		// 정렬할대상, 정렬할 코드
		Collections.sort(bbsList,new Comparator<BBsVO>() {
			
			public int compare(BBsVO o1, BBsVO o2) {
				int s = (int)(o1.getB_id() - o2.getB_id());
				
				return s;
			}
			
		});
		
		// 람다코드
		// sort() mehtod 의 정의에 첫번째 매개변수는 정렬할 List
		// 두번째 매개변수는 Comparator 인터페이스를 이용한
		// 구현체가 오도록 되어있기 때문에 가능하다
		Collections.sort(bbsList,(o1,o2)->
			(int)(o1.getB_id() - o2.getB_id())
		);
		
		// 날짜 시간 역순정렬
		Collections.sort(bbsList,(o1,o2)->
			o2.getB_date_time().compareTo(o1.getB_date_time())
		);
		
		// 부모 id(b_p_id)가 0인 리스트만 추출
		List<BBsVO> pList = new ArrayList<BBsVO>();
		
		// BBsData가 들어있는 bbsList를 vo에 차례대로 주입
		for(BBsVO vo : bbsList){
			
			// vo의 p_id(부모id)가 0 이라면
			if(vo.getB_p_id() == 0) {
				
				// 형태만 있는 pList에 Data가 담긴 vo를 주입
				pList.add(vo);
				
				System.out.println("홋쉬요기기기?? " + vo);
			}
		}
		
		System.out.println("혹쉬 pList ??" + pList);
		
		// for(BBsVO vo : bbsList)와 같은 코드
		bbsList.forEach(vo->{
			if(vo.getB_p_id() == 0 ) {
				pList.add(vo);
			}
		});
		
		// 람다를 이용한 화면출력
		bbsList.forEach(vo->{
			System.out.println(vo);
		});
		
		bbsList.forEach(System.out::println);
		
	}
}
