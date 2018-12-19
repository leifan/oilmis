package com.mltech.brite.response.oil;

import java.util.ArrayList;
import java.util.List;

import com.mltech.brite.model.OilType;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.user.ResultType;

public class OilTypeListResponse extends BaseResponse{
	
	private List<OilType> list = new ArrayList<OilType>();

	public OilTypeListResponse(ResultType resultType) {
		super(resultType);
	}

	public List<OilType> getList() {
		return list;
	}

	public void setList(List<OilType> list) {
		this.list = list;
	}
	

}
