package com.mltech.brite.request.user;

public class GetUserDetailRequest {
	
//	@NotEmpty(message = "{id为空}”)   提示用户名不能为空，即：message里面的没有起作用，")
	private String id;
	
	private String userName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
