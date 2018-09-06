package com.zn.test.pojo;

import java.sql.Date;

public class LoginInfo {
	private String soeId;
	private String hostname;
	private String version;
	private String source;
	private Date lastLoginTime;
	public String getSoeId() {
		return soeId;
	}
	public void setSoeId(String soeId) {
		this.soeId = soeId;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	@Override
	public String toString() {
		return "LoginInfo [soeId=" + soeId + ", hostname=" + hostname + ", version=" + version + ", source=" + source + ", lastLoginTime=" + lastLoginTime + "]";
	}
	
}
