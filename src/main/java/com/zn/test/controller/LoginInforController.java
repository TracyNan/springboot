package com.zn.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.zn.test.dao.LoginDao;
import com.zn.test.dao.UserInfoDao;
import com.zn.test.pojo.LoginInfo;
import com.zn.test.pojo.UserInfo;
import com.zn.test.pojo.user.ZWUser;

@Controller
public class LoginInforController {

	@Autowired
	private LoginDao loginDao;
	@Autowired
	private UserInfoDao userInfoDao;

	@RequestMapping("/check")
	// http://localhost:8080/check?name=rc47871
	String home(@RequestParam(value = "name", defaultValue = "nz18977") String id,
			@RequestParam(value = "action", defaultValue = "info") String action, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		JSONObject jsonObject;
		ObjectWriter oWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		switch (action) {
		case "info":
			LoginInfo loginInfo = new LoginInfo();
			loginInfo = loginDao.getLogininfo(id.toLowerCase());
			String infoJson = oWriter.writeValueAsString(loginInfo);
			jsonObject = new JSONObject(infoJson);
			jsonObject.put("Type", "info");
			out.print(jsonObject);
			break;
		case "prof":
			UserInfo userInfo = new UserInfo();
			userInfo = userInfoDao.getUserInfo(id.toLowerCase());
			String profJson = oWriter.writeValueAsString(userInfo);
			jsonObject = new JSONObject(profJson);
			jsonObject.put("Type", "prof");
			out.print(jsonObject);
			break;
		}
		return null;
	}

	@RequestMapping("/login")
	String login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		ZWUser user=loginDao.nwLogin(username, password);
		System.out.println(user.toString());
		PrintWriter out = response.getWriter();
		if (user.getLoginId()>=1) {
			out.print("success");
		}else {
			out.print("fail");
		}
		return null;
	}
}
