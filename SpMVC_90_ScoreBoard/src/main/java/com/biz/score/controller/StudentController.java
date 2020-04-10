package com.biz.score.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.score.domain.StudentVO;
import com.biz.score.service.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@RequestMapping(value="/student")
@Slf4j
public class StudentController {

	private final StudentService studentService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String studentList(Model model) {
		
		List<StudentVO> studentList = new ArrayList<StudentVO>();
		studentList = studentService.studentList();
		log.debug("여기는 스튜던트 리스트 " + studentList);
		
		model.addAttribute("STUDENT_LIST",studentList);
		
		return "student-list";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert() {
		
		return "student-insert";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(StudentVO studentVO, Model model) {

		log.debug("여기는 스튜던트 인서트 1"+studentVO);
		studentService.insert(studentVO);
		log.debug("여기는 스튜던트 인서트2 " + studentVO);
		
		return "redirect:/student/list";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(@RequestParam("st_num")String st_num, Model model) {
		
		StudentVO studentVO = studentService.findByNum(st_num);
		log.debug("여기는 게터 모델보내기 전 st_num으로 불러온 VO이다" + studentVO);
		model.addAttribute("STUDENT" ,studentVO);
		
		return "student-insert";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(StudentVO studentVO) {
		
		log.debug("여기는 업데이트 포스트 update 전 " + studentVO);
		studentService.update(studentVO);
		log.debug("여기는 업데이트 포스트 update 후 " + studentVO);
		
		return "redirect:/student/list";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(long st_num) {
		
		studentService.delete(st_num);
		return "redirect:/student/list";
	}
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join(long st_num, Model model) {
		List<StudentVO> joinList = new ArrayList<StudentVO>();
		joinList = studentService.join(st_num);
		log.debug("여기는 컨트롤러 조인의 list이다" + joinList);
		model.addAttribute("JOIN_LIST", joinList);
		
		return "student-list";
	}
}
