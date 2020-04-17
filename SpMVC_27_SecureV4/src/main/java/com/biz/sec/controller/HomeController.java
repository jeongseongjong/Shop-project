package com.biz.sec.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.sec.domain.UserDetailsVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	/*
	 * security mapping을 Annotation을 사용하여 설정
	 * @secured(value={문자열 배열}
	 */
	
	// @Secured(value= {"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	public String auth(Model model) {
		return "auth/auth_view";
	}
	
	/**
	 * Controller의 method에 HttpServletRquest 클래스로부터
	 * 인증(로그인한) 정보를 추출하여 세부항목을 보는 방법
	 * 
	 * @param id
	 * @param req
	 * @return
	 */
	@ResponseBody
	@Secured(value= {"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping(value = "/auth/{id}", method = RequestMethod.GET)
													// 클라이언트가 보내는 모든 req정보가 담겨져있다(securty포함)
	public Object auth(@PathVariable("id") String id, HttpServletRequest req) {
		
		int intId = 0;
		try {
			
			intId = Integer.valueOf(id);	
		} catch (Exception e) {
			
			return e.getMessage();
		}
		
		if(intId ==1) {
			log.debug("intId = 1");
		}else if(intId == 2) {
			log.debug("intId = 2");
		}
		
		Authentication auth = (Authentication) req.getUserPrincipal();
		
		// switch (id) case "1" : id == 1이라는뜻이다
		// 문자열은 equals로 사용하는것이 좋기때문에 완벽하지 않은 코드이다.
		// switch case문은 1번 문항에 해당되더라도 2,3번문항을 다 걸쳐서 끝나기때문에 반드시 return 또는 break문을 걸어주어야한다.
		switch (intId) {
		case 1: // if(id == 1)
			return auth.getDetails();
			
		case 2: // if(id == 1)
			return auth.getCredentials();
			
		case 3: // if(id == 3)
			UserDetailsVO userVO = (UserDetailsVO) auth.getPrincipal();
			return userVO;
			
		case 4: // if(id == 4)
			return auth.getAuthorities();
			
		case 5: // if(id == 5)
			return auth.getName();
			
		default: // 그외
			return "Not Found";
		}
	}	
}
