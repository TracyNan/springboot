package com.zn.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/index")
	public String index() {
		return "/index.html";
	}
	@RequestMapping("/success")
	public String success() {
		return "/success.html";
	}
	@RequestMapping("/fail")
	public String fail() {
		return "/fail.html";
	}
}
