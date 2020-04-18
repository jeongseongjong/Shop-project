package com.biz.sec.controller;

import javax.mail.MessagingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.sec.service.MailSendService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value="/mail")
@RequiredArgsConstructor
public class MailController {

	private final MailSendService mService;
	
	@ResponseBody
	@RequestMapping(value="/send",method=RequestMethod.GET)
	public String sendMain() throws MessagingException {
		mService.sendMail();
		return "SEND OK";
	}
}
