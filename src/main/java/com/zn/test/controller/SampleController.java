package com.zn.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zn.test.dao.LoginDao;
import com.zn.test.pojo.LoginInfo;

@RestController
public class SampleController {

	@Autowired
	private LoginDao loginDao;
	
	@RequestMapping("/check")
	//http://localhost:8080/check?name=rc47871
	String home(@RequestParam(value="name", defaultValue="nz18977") String id) {
		LoginInfo loginInfo=new LoginInfo();
		loginInfo=loginDao.getLogininfo(id.toLowerCase());
		System.out.println("logininfo is "+loginInfo);
		return loginInfo.toString();
	}
}
