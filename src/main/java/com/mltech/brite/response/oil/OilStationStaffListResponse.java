package com.mltech.brite.response.oil;

import java.util.ArrayList;
import java.util.List;

import com.mltech.brite.model.OilStationStaff;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.user.ResultType;

public class OilStationStaffListResponse extends BaseResponse{

	private List<OilStationStaff> list = new ArrayList<OilStationStaff>();
	
	public OilStationStaffListResponse(ResultType resultType) {
		super(resultType);
	}

	public List<OilStationStaff> getList() {
		return list;
	}


	public void setList(List<OilStationStaff> list) {
		this.list = list;
	}
	
	

}
