package com.zn.test.pojo;

import java.util.List;

import com.zn.test.pojo.user.UserBaseInfo;
import com.zn.test.pojo.user.UserProfInfo;
import com.zn.test.pojo.user.UserRoleInfo;

public class UserInfo {
	private UserBaseInfo userBaseInfo;
	private UserProfInfo userProfInfo;
	private List<UserRoleInfo> userRoleInfos;

	public UserBaseInfo getUserBaseInfo() {
		return userBaseInfo;
	}

	public void setUserBaseInfo(UserBaseInfo userBaseInfo) {
		this.userBaseInfo = userBaseInfo;
	}

	public UserProfInfo getUserProfInfo() {
		return userProfInfo;
	}

	public void setUserProfInfo(UserProfInfo userProfInfo) {
		this.userProfInfo = userProfInfo;
	}

	public List<UserRoleInfo> getUserRoleInfos() {
		return userRoleInfos;
	}

	public void setUserRoleInfos(List<UserRoleInfo> userRoleInfos) {
		this.userRoleInfos = userRoleInfos;
	}

	@Override
	public String toString() {
		return "UserInfo [" + userBaseInfo.toString() + ", " + userProfInfo.toString() + ", " + userRoleInfos.toString() + "]";
	}

}
