package com.mltech.brite.response.oil;

import java.util.ArrayList;
import java.util.List;

import com.mltech.brite.model.UserGroup;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.user.ResultType;

public class GetUserGroupListResponse extends BaseResponse{
	
	public GetUserGroupListResponse(ResultType resultType){
		super(resultType);
	}
	
	List<UserGroup> list = new ArrayList<UserGroup>();

	public List<UserGroup> getList() {
		return list;
	}

	public void setList(List<UserGroup> list) {
		this.list = list;
	}}
