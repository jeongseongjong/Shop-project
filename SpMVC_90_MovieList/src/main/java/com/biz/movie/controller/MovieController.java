package com.biz.movie.controller;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.movie.domain.PageDTO;
import com.biz.movie.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	MovieService mService;

	public String movie(String search, Model model,
						@RequestParam(value="currentPage", required = false, defaultValue = "1")long currentPageNo) {
		try {
			
			PageDTO pageDTO = mService.getPage(search, currentPageNo);
			model.addAttribute("PAGE", pageDTO);
			
			JSONArray resArray= mService.getMovie(search, currentPageNo);
			model.addAttribute("NAVER_ITEMS", resArray);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		model.addAttribute("search", search);
		model.addAttribute("currentPageNo", currentPageNo);
		
		return "home";
	}
	
	
}
