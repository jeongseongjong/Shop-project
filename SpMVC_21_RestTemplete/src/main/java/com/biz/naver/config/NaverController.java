package com.biz.naver.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.naver.domain.NaverVO;
import com.biz.naver.service.NaverService;

@Controller
@RequestMapping
public class NaverController {

	@Autowired
	NaverService naverService;

	@ResponseBody
	@RequestMapping(value = "/search", method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public List<NaverVO> naverSearch(String search, String cat) {

		try {
			List<NaverVO> naverList = naverService.naverSearch(cat, search);
			return naverList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
