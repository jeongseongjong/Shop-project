package com.biz.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biz.shop.dao.AuthoritiesDao;
import com.biz.shop.dao.UserDao;
import com.biz.shop.domain.AuthorityVO;
import com.biz.shop.domain.UserDetailsVO;

@Service
public class UserService {

	private final PasswordEncoder passwordEncoder;
	private final UserDao userDao;
	private final AuthoritiesDao authDao;

	@Autowired
	public UserService(PasswordEncoder passwordEncoder, UserDao userDao, AuthoritiesDao authDao) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.userDao = userDao;
		this.authDao = authDao;

		String create_user_table = " CREATE TABLE IF NOT EXISTS tbl_users ("
				+ "	id bigint  PRIMARY KEY AUTO_INCREMENT, " + "	user_name varchar(50) UNIQUE, "
				+ "	user_pass varchar(125), " + "   enabled boolean default true, " + "	email varchar(50), "
				+ "	phone varchar(20), " + "	address varchar(125) " + " ) ";

		String create_auth_table = " CREATE TABLE IF NOT EXISTS authorities ("
				+ "	id bigint PRIMARY KEY AUTO_INCREMENT," + "    username varchar(50)," + "    authority varchar(50)"
				+ " ) ";

		userDao.create_table(create_user_table);
		userDao.create_table(create_auth_table);
	}
	
	@Transactional
	public int insert(String username, String password) {
		
		String encPassword = passwordEncoder.encode(password);
		UserDetailsVO userVO = UserDetailsVO.builder()
				.username(username)
				.password(encPassword)
				.build();
		
		int ret = userDao.insert(userVO);
		List<AuthorityVO> authList = new ArrayList();
		
		authList.add(AuthorityVO.builder()
					.username(userVO.getUsername())
					.authority("ROLE_USER").build());
		
		authList.add(AuthorityVO.builder()
				.username(userVO.getUsername())
				.authority("USER").build());
		
		authDao.insert(authList);
		return ret;
	}
	
	public boolean isExistsUserName(String username) {
		
		UserDetailsVO userVO = userDao.findByUserName(username);
		
		if(userVO != null && userVO.getUsername().equalsIgnoreCase(username)) {
			return true;
		}
		return false;
	}
	
	public UserDetailsVO findById(long id) {
		
		UserDetailsVO userVO = userDao.findById(id);
		return userVO;
	}
	
	public boolean check_password(String password) {
		UserDetailsVO userVO = (UserDetailsVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		return passwordEncoder.matches(password,  userVO.getPassword());
	}
	
	public int update(UserDetailsVO userVO, String[] authList) {
		
		int ret = userDao.update(userVO);
		if(ret > 0 ) {
			List<AuthorityVO> authCollection= new ArrayList();
			for(String auth : authList) {
				if(!auth.isEmpty()) {
					AuthorityVO authVO = AuthorityVO.builder()
							.username(userVO.getUsername())
							.authority(auth).build();
					authCollection.add(authVO);
				}
			}
			authDao.delete(userVO.getUsername());
			authDao.insert(authCollection);
		}
		
		return ret;
	}
	
	
	@Transactional
	public List<UserDetailsVO> selectAll() {
		return userDao.selectAll();
	}
	
	public UserDetailsVO findByUserName(String username) {
		
		return userDao.findByUserName(username);
	}
}
