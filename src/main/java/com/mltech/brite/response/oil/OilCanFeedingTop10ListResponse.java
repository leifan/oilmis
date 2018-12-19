package com.mltech.brite.response.oil;


import java.util.ArrayList;
import java.util.List;

import com.mltech.brite.model.OilCanFeeding;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.user.ResultType;

public class OilCanFeedingTop10ListResponse extends BaseResponse{
	
	private List<OilCanFeeding> list = new ArrayList<OilCanFeeding>();

	public OilCanFeedingTop10ListResponse(ResultType resultType) {
		super(resultType);
	}

	public List<OilCanFeeding> getList() {
		return list;
	}

	public void setList(List<OilCanFeeding> list) {
		this.list = list;
	}
	
}
