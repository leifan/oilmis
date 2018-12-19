package com.mltech.brite.response.user;

import java.util.ArrayList;
import java.util.List;

import com.mltech.brite.model.UserModel;
import com.mltech.brite.response.BaseResponse;

public class UserListResponse extends BaseResponse{
	
	public UserListResponse(ResultType resultType){
		super(resultType);
	}

	List<UserModel> list = new ArrayList<UserModel>();

	public List<UserModel> getList() {
		return list;
	}

	public void setList(List<UserModel> list) {
		this.list = list;
	}
	
}
