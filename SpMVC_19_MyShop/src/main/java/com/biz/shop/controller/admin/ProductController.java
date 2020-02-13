package com.biz.shop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.shop.domain.ProductVO;

@RequestMapping(value = "/admin/product")
@Controller
public class ProductController {

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input(Model model) {

		ProductVO productVO = new ProductVO();
		
		model.addAttribute("productVO", productVO);
		model.addAttribute("BODY", "PRODUCT");

		return "admin/main";
	}

}
