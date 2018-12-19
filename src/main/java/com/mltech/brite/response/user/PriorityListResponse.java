package com.mltech.brite.response.user;

import java.util.ArrayList;
import java.util.List;

import com.mltech.brite.model.Priority;
import com.mltech.brite.response.BaseResponse;

public class PriorityListResponse extends BaseResponse{
	
	public PriorityListResponse(ResultType resultType){
		super(resultType);
	}
	
	List<Priority> list = new ArrayList<Priority>();

	public List<Priority> getList() {
		return list;
	}

	public void setList(List<Priority> list) {
		this.list = list;
	}
	
}
