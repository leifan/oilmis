package com.mltech.brite.request.user;

import java.util.ArrayList;
import java.util.List;

import com.mltech.brite.request.BaseValidateRequest;

public class UpdateGtsUserList extends BaseValidateRequest{
	
	List<AddGtsUserRequest> list = new ArrayList<AddGtsUserRequest>();

	public List<AddGtsUserRequest> getList() {
		return list;
	}

	public void setList(List<AddGtsUserRequest> list) {
		this.list = list;
	}

}
