package com.biz.bbs.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biz.bbs.domain.BBsVO;
import com.biz.bbs.repository.BBsDao;

import lombok.extern.slf4j.Slf4j;

/*
 * 다중 select를 수행하는 method가 있고,
 * 재귀호출에 의해서 계속되는 select문이 실행된다.
 * 
 * 이때 @Transactional 설정하면
 * 다중 select를 transaction 으로 보호하여
 * 중간에 데이터 fetch가 누락되는 것을 막을 수 있다.
 */
@Transactional
@Slf4j
@Service("bbsV2")
public class BBsServiceImplV2 extends BBsServiceImpl{
	
	
	public BBsServiceImplV2(BBsDao bbsDao) {
		super(bbsDao);

	}

	/*
	 * pagination을 수행할 때
	 * 원글목록을 page대상으로 할것인지
	 * 원글 + 댓글 포함한 목록 pagi대상으로 할것인지 결정
	 */
	@Override
	public List<BBsVO> selectAll() {

		List<BBsVO> retList = bbsDao.selectLevel();
		
		
		return retList;
	}

	

	

}
