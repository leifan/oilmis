package com.mltech.brite.response.user;

import com.mltech.brite.model.UserModel;
import com.mltech.brite.response.BaseResponse;


public class LoginResponse extends BaseResponse{

	private UserModel userModel;
	
	public LoginResponse(ResultType resultType) {
		super(resultType);
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

}
