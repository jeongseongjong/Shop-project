package com.biz.score.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.score.dao.ScoreDao;
import com.biz.score.domain.ScoreVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScoreService {

	private final ScoreDao scoreDao;
	
	public List<ScoreVO> findBySNum(long s_num) {

		return scoreDao.findBySNum(s_num);
	}

}
