package com.mltech.brite.response.oil;

import java.util.ArrayList;
import java.util.List;

import com.mltech.brite.model.OilStation;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.user.ResultType;

public class OilStationListResponse extends BaseResponse{

	private List<OilStation> list = new ArrayList<OilStation>();
	
	public OilStationListResponse(ResultType resultType) {
		super(resultType);
	}

	public List<OilStation> getList() {
		return list;
	}

	public void setList(List<OilStation> list) {
		this.list = list;
	}
	
	

}
