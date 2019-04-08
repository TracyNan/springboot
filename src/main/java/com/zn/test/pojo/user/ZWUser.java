package com.zn.test.pojo.user;

public class ZWUser {

	int loginId;
	String username;
	String password;

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ZWUser [loginId=" + loginId + ", username=" + username + ", password=" + password + "]";
	}
}
