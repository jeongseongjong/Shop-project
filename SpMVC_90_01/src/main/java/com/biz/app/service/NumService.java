package com.biz.app.service;

import org.springframework.stereotype.Service;

import com.biz.app.domain.ScoreVO;

/*
 * service 클래스
 * @Service Annotation을 설정한 클래스
 * 
 * Controller가 사용자의 요청을 받았는데
 * 단순한 연산을 수행해서 결과를 보낼 사안이 아닐 때
 * 1. 조금 복잡한 무언가를 수행해야할 때
 *		Controller에서 기능을 보조하는 역할을 수행한다. 
 * 2
 */
@Service
public class NumService {

	public int add(int num1, int num2) {

		int sum = 0;
		sum = num1 + num2;

		return sum;
	}

	public int even(int start, int end) {

		// start = 1;
		// end = 100;
		int sum = 0;
		for (int i = start; i <= end; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		return sum;
	}

	public int sum(int kor, int eng, int math, int sc, int music) {

		int sum = kor + eng + math + sc + music;

		return sum;
	}

	public int avg(int kor, int eng, int math, int sc, int music) {

		int sum = (kor + eng + math + sc + music);
		int avg = sum / 5;

		return avg;
	}

	public void score(ScoreVO scoreVO) {

		int sum = scoreVO.getKor();
		sum += scoreVO.getEng();
		sum += scoreVO.getMath();
		sum += scoreVO.getSc();
		sum += scoreVO.getMusic();
		
		scoreVO.setSum(sum);
		scoreVO.setAvg(sum/5);
		
	}

}
