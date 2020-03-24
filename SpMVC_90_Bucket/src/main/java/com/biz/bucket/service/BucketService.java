package com.biz.bucket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.bucket.dao.BucketDao;
import com.biz.bucket.domain.BucketVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class BucketService {

	private final BucketDao bcDao;

	public List<BucketVO> selectAll() {

		return bcDao.selectAll();
	}

	public int insert(BucketVO bcVO) {

		return bcDao.insert(bcVO);
	}

	public int update(BucketVO bcVO) {

		return bcDao.update(bcVO);
	}

	public int checkBox(BucketVO bcVO) {
		log.debug("이거뭔고 " + bcVO);
		if (bcVO.getB_complete() == 1) {

			bcVO.setB_complete(0);
		} else if(bcVO.getB_complete() == 0){
			bcVO.setB_complete(1);
		}

		return bcDao.checkBox(bcVO);
	}

	public int delete(long b_id) {

		return bcDao.delete(b_id);
	}

	public BucketVO findById(long b_id) {
		// TODO Auto-generated method stub
		return bcDao.findById(b_id);
	}
	
}
