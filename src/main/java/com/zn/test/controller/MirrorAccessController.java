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

import com.zn.test.dao.MirrorAccessDao;

/**
 * @author nz18977
 *
 */
@Controller
public class MirrorAccessController {

	@Autowired
	private MirrorAccessDao mirrorAccessDao;

	@RequestMapping("/mirror")
	public String mirrorAccess(@RequestParam(value = "mirrorId") String mirrorId, @RequestParam(value = "userId") String userId, @RequestParam(value = "userName") String userName,
			@RequestParam(value = "userMail") String userMail, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");
		try {
			mirrorAccessDao.mirrorAccess(mirrorId, userId, userName, userMail);
		} catch (Exception e) {
			jsonObject.put("result", "error");
		}
		out.print(jsonObject);
		return null;
	}
}
