package com.mltech.brite.response.user;

import java.util.ArrayList;
import java.util.List;

import com.mltech.brite.model.SimpleUserModel;
import com.mltech.brite.response.BaseResponse;

public class GtsUserListResponse extends BaseResponse{
	
	public GtsUserListResponse(ResultType resultType){
		super(resultType);
	}

	List<SimpleUserModel> list = new ArrayList<SimpleUserModel>();

	public List<SimpleUserModel> getList() {
		return list;
	}

	public void setList(List<SimpleUserModel> list) {
		this.list = list;
	}
	
}
