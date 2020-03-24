package com.biz.bucket.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.bucket.domain.BucketVO;
import com.biz.bucket.service.BucketService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BucketController {

	private final BucketService bcService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		
		
		List<BucketVO> bcList = bcService.selectAll();
		log.debug("여기는 버킷리스트 " + bcList);
		model.addAttribute("BC_LIST", bcList);
		
		return "bucket-list";
	}
	
//	@RequestMapping(value="/list",method=RequestMethod.POST)
//	public String list() {
//		
//		return "redirect:/list";
//	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert() {
		
		return "bucket-insert";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(BucketVO bcVO) {
		
		log.debug("여기는 왓니 ? ");
		int ret = bcService.insert(bcVO);
		log.debug("인서트가 되었는가 " + ret);
		
		return "redirect:/list";
	}
	
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(long b_id, Model model){
		
		BucketVO bucketVO = bcService.findById(b_id);
		
		model.addAttribute("BCVO", bucketVO);
		
		log.debug("여기는 id가져온 update VO " + bucketVO);
		
		return "bucket-insert";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(BucketVO bcVO){
		
		bcService.update(bcVO);
		
		return "redirect:/list";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(long b_id) {
		
		bcService.delete(b_id);
		
		return "redirect:/list";
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail(@RequestParam(value="b_id",required = false)String b_id, BucketVO bcVO, Model model) {
		
		if(b_id == null) {
			b_id = "0";
		}
		
		bcVO = bcService.findById(Long.valueOf(b_id));
		
		model.addAttribute("BCVO", bcVO);
		log.debug("여기는 디테일 " + bcVO);
		
		return "bucket-insert";
		
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.POST)
	public String detail(BucketVO bcVO) {
		
		bcService.update(bcVO);
		log.debug("detail이 드어갔는가 " + bcVO);
		
		return "redirect:/list";
	}
	
	@RequestMapping(value="/checkBox",method=RequestMethod.GET)
	public String checkBox(long b_id, Model model) {
		
		BucketVO bucketVO = bcService.findById(b_id);
		
		model.addAttribute("CHECK",bucketVO);
		
		return "bucket-include-list";
	}
	
	@RequestMapping(value="/checkBox",method=RequestMethod.POST)
	public String checkBox(BucketVO bcVO) {
		
		bcService.checkBox(bcVO);
		log.debug("complete 업데이트했니 " + bcVO);
		
		return "redirect:/list";
	}
}
