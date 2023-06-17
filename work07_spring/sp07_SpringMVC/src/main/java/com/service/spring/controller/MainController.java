package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {	// POJO plain old java object 어느 것에도 제약 받지 않는 아주 단순한 자바 클래스

	@RequestMapping("/main.do")
	public ModelAndView main() {
		return new ModelAndView("main_view", "info","MainController Annotation~~!!");
	}
}
