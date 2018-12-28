package com.zn.test.pojo.user;

public class UserBaseInfo {
	private String id;
	private String Name;
	private String eMail;
	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserBaseInfo [id=" + id + ", Name=" + Name + ", eMail=" + eMail + ", status=" + status + "]";
	}
}
