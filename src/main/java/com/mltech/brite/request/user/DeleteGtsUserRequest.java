package com.mltech.brite.request.user;

public class DeleteGtsUserRequest {
	
	//必传项
	private String id;
	//必传项
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
