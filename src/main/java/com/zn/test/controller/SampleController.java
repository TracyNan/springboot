package com.zn.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zn.test.dao.LoginDao;
import com.zn.test.pojo.LoginInfo;

@Controller
public class SampleController {

	@Autowired
	private LoginDao loginDao;

	@RequestMapping("/check")
	// http://localhost:8080/check?name=rc47871
	String home(@RequestParam(value = "name", defaultValue = "nz18977") String id, HttpServletRequest request) {
		LoginInfo loginInfo = new LoginInfo();
		loginInfo = loginDao.getLogininfo(id.toLowerCase());
		System.out.println("logininfo is " + loginInfo);
		request.setAttribute("loginInfo", loginInfo);
		return "/login";
	}
}
