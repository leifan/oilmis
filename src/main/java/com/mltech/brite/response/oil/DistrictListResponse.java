package com.mltech.brite.response.oil;

import java.util.ArrayList;
import java.util.List;

import com.mltech.brite.model.DistrictType;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.user.ResultType;

public class DistrictListResponse extends BaseResponse{
	
	public DistrictListResponse(ResultType resultType) {
		super(resultType);
	}

	private List<DistrictType> list = new ArrayList<DistrictType>();

	public List<DistrictType> getList() {
		return list;
	}

	public void setList(List<DistrictType> list) {
		this.list = list;
	}
	
	

}
