package com.biz.navy.dao;

import com.biz.navy.domain.UserDetailsVO;

public interface UserDao {

	public int insert(UserDetailsVO userVO);

	public UserDetailsVO findByUserName(String username);

	public int update(UserDetailsVO userVO);

}
