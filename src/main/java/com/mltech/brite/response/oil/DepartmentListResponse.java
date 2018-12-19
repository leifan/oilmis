package com.mltech.brite.response.oil;

import java.util.ArrayList;
import java.util.List;

import com.mltech.brite.model.DepartmentType;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.user.ResultType;

public class DepartmentListResponse extends BaseResponse{

	
	public DepartmentListResponse(ResultType resultType) {
		super(resultType);
	}

	List<DepartmentType> list = new ArrayList<DepartmentType>();

	public List<DepartmentType> getList() {
		return list;
	}

	public void setList(List<DepartmentType> list) {
		this.list = list;
	}
	
}
