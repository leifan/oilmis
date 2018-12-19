package com.mltech.brite.response.oil;

import java.util.ArrayList;
import java.util.List;

import com.mltech.brite.model.ShiftWork;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.user.ResultType;

public class GetShiftWorkListResult extends BaseResponse{
	
	public GetShiftWorkListResult(ResultType resultType) {
		super(resultType);
	}

	List<ShiftWork> list = new ArrayList<ShiftWork>();

	public List<ShiftWork> getList() {
		return list;
	}

	public void setList(List<ShiftWork> list) {
		this.list = list;
	}
	
}
