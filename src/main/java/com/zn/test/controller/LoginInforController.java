package com.zn.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zn.test.dao.LoginDao;
import com.zn.test.dao.UserInfoDao;
import com.zn.test.pojo.LoginInfo;
import com.zn.test.pojo.UserInfo;

@Controller
public class LoginInforController {

	@Autowired
	private LoginDao loginDao;
	@Autowired
	private UserInfoDao userInfoDao;

	@RequestMapping("/check")
	// http://localhost:8080/check?name=rc47871
	String home(@RequestParam(value = "name", defaultValue = "nz18977") String id, @RequestParam(value = "action", defaultValue = "info") String action, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		switch (action) {
		case "info":
			LoginInfo loginInfo = new LoginInfo();
			loginInfo = loginDao.getLogininfo(id.toLowerCase());
			System.out.println("logininfo is " + loginInfo);
			// request.setAttribute("loginInfo", loginInfo);
			out.print(loginInfo);
			break;
		case "prof":
			UserInfo userInfo = new UserInfo();
			userInfo = userInfoDao.getUserInfo(id.toLowerCase());
			System.out.println("user info is " + userInfo);
			out.print(userInfo);
			break;
		}
		return null;
	}
}
