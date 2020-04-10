package com.biz.score.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.score.domain.ScoreVO;

public interface ScoreDao {

	@Select("SELECT * FROM tbl_score")
	public List<ScoreVO> selectAll();
	
	public int insert(ScoreVO scoreVO);
	public int update(ScoreVO scoreVO);

	@Select("SELECT * FROM tbl_score where s_num = #{s_num}")
	public List<ScoreVO> findBySNum(long s_num);
}
