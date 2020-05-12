package com.biz.shop.controller;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.shop.domain.UserDetailsVO;
import com.biz.shop.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value="/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	private final UserDetailsService udService;
	
	@ModelAttribute("userVO")
	public UserDetailsVO newUser() {
		return new UserDetailsVO();
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		
		return "join";
	}
	
	@ResponseBody
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(String username, String password) {
		log.debug("인서트 포스트인데 오니1 ?" + username);
		log.debug("인서트 포스트인데 오니1 ?" + password);
		int ret = userService.insert(username, password);
		
		return String.format("아이디 : <b>%s</b>, 비번 : <b>%s</b>",username, password);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {

		return "login";
	}
	
	
	public String idcheck(String username) {
		
		boolean ret = userService.isExistsUserName(username);
		if(ret) {
			return "Exists".toUpperCase();
		}
		return "NonExists".toUpperCase();
	}
	
	public String password(String password) {
		
		boolean ret = userService.check_password(password);
		if(ret) return "PASS_OK";
		
		return "PASS_FAIL";
	}
}
