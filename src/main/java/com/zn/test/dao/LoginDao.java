package com.zn.test.dao;

import com.zn.test.pojo.LoginInfo;
import com.zn.test.pojo.user.ZWUser;

public interface LoginDao {
	public LoginInfo getLogininfo(String userId);

	public ZWUser nwLogin(String username,String password);
}
