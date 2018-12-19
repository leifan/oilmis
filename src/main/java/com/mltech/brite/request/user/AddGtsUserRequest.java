package com.mltech.brite.request.user;

import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * <code>@NotNull</code> 不能为null，但可以为empty
 * <code>@NotEmpty</code>不能为null，而且长度必须大于0
 * <code>@NotBlank</code> 只能作用在String上，不能为null，而且调用trim()后，长度必须大于0
 * 
 * @author user
 *
 */
public class AddGtsUserRequest {
	
	private String id;
	
	private String userName;
	
	private String password;
	
	/**
	 * 对应枚举值见 {@link com.mltech.brite.constant.UserPermission}
	 */
	private List<String> permission;
	
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

	public List<String> getPermission() {
		return permission;
	}

	public void setPermission(List<String> permission) {
		this.permission = permission;
	}
	
	public void reset(){
		if(StringUtils.isBlank(this.id)){
			this.id=null;
		}
		
		if(StringUtils.isBlank(this.userName)){
			this.userName = null;
		}
		
		if(StringUtils.isBlank(this.password)){
			this.password = null;
		}
	}

}
