package com.zn.test.pojo.user;

public class UserRoleInfo {
	private String id;
	private String resourceId;
	private String resourceName;
	private String roleName;
	private String env;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}

	@Override
	public String toString() {
		return "UserRoleInfo [id=" + id + ", resourceId=" + resourceId + ", resourceName=" + resourceName + ", roleName=" + roleName + ", env=" + env + "]";
	}

}
