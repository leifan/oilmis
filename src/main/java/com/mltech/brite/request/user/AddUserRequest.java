package com.mltech.brite.request.user;


/**
 * 
 * <code>@NotNull</code> 不能为null，但可以为empty
 * <code>@NotEmpty</code>不能为null，而且长度必须大于0
 * <code>@NotBlank</code> 只能作用在String上，不能为null，而且调用trim()后，长度必须大于0
 * 
 * @author user
 *
 */
public class AddUserRequest {
	
	private String id;
	
	private String userName;
	
	private String password;
	
	private String groupName;
	
	private String departmentName;
	
	private String districtName;
	
	private String role;
	
	private String userInfo;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
}
