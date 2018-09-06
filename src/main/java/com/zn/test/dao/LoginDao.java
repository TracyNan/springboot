package com.zn.test.dao;

import com.zn.test.pojo.LoginInfo;

public interface LoginDao {
	public LoginInfo getLogininfo(String userId);
}
