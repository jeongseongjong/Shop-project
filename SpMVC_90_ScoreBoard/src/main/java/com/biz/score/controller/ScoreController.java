package com.biz.score.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.score.domain.ScoreVO;
import com.biz.score.service.ScoreService;
import com.biz.score.service.StudentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value="/score")
@RequiredArgsConstructor
public class ScoreController {

	private final ScoreService scoreService;
	private final StudentService studentSerivce;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String scoreList(Model model, long st_num) {
		List<ScoreVO> scoreList = new ArrayList<ScoreVO>();
		scoreList = scoreService.findBySNum(st_num);
		
		model.addAttribute("STUDENT_LIST",scoreList);
		return "student-list";
	}
}
