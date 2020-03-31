package com.biz.models.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.biz.models.domain.UsersVO;

@Mapper
public interface UserDao {

	@Select("SELECT * FROM tbl_user where userId = #{userId}")
	public UsersVO findByUserId(String userId);

	@Insert("INSERT INTO `books`.`tbl_user`\r\n" + 
			" (`userId`," + 
			" `password`," + 
			" `userName`," + 
			" `userRolle`)" + 
			" VALUES" + 
			" (#{userId }," + 
			" #{password }," + 
			" #{userName }," + 
			" #{userRolle })")
	public int insert(UsersVO userVO);
	
	@Delete("DELETE FROM tbl_user where userId = #{userId}")
	public int delete(String userId);
}
