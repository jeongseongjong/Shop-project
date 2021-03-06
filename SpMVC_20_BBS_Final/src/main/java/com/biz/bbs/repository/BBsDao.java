package com.biz.bbs.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.biz.bbs.domain.BBsVO;


// @Mapper
public interface BBsDao {

	public List<BBsVO> selectLevel();
	
	// 원글만 리스트 추출
	@Select("SELECT * FROM tbl_bbs "
			+ " where b_p_id = 0"
			+ " ORDER BY b_date_time DESC")
	public List<BBsVO> selectAll();
	
	@Select("select * from tbl_bbs"
			+ " where b_p_id = #{b_id}"
			+ " order by b_date_time desc")
	public List<BBsVO> findByPId(long b_p_id);
	
	@Select("SELECT * FROM tbl_bbs WHERE b_id = #{b_id}")
	public BBsVO findById(long b_id);
	
	public List<BBsVO> findBySubject(String b_subject);
	public List<BBsVO> findByWriter(String b_writer);
	
	public int insert(BBsVO bbsVO);
	public int update(BBsVO bbsVO);
	
	@Delete("DELETE FROM tbl_bbs WHERE b_id = #{b_id}")
	public int delete(long b_id);
}
