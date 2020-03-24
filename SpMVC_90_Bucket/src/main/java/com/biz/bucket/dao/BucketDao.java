package com.biz.bucket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.biz.bucket.domain.BucketVO;

@Mapper
public interface BucketDao {

	@Select("SELECT * FROM tbl_bucket ORDER BY b_id desc")
	public List<BucketVO> selectAll();
	
	public BucketVO findById(long b_id);
	
	public int insert(BucketVO bcVO);
	
	public int update(BucketVO bcVO);
	
	public int delete(long b_id);

	public int checkBox(BucketVO bcVO);
}
