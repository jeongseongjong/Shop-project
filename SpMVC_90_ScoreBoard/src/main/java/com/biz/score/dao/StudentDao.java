package com.biz.score.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.biz.score.domain.StudentVO;

@Mapper
public interface StudentDao {

	@Select("SELECT * FROM tbl_student")
	public List<StudentVO> selectAll();
	
	@Select("SELECT * FROM tbl_student WHERE st_num = #{st_num}")
	public StudentVO findByNum(String st_num);
	
	public int insert(StudentVO studentVO);
	
	public int update(StudentVO studentVO);
	
	@Delete("DELETE FROM tbl_student where st_num = #{st_num}")
	public int delete(long st_num);

	public List<StudentVO> join(long st_num);
	
}
