package com.mltech.brite.response.oil.gts;

import java.util.ArrayList;
import java.util.List;

import com.mltech.brite.model.GtsOilCanAlarm;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.user.ResultType;

public class OilCanAlarmResponse extends BaseResponse{
	
	public OilCanAlarmResponse(ResultType resultType) {
		super(resultType);
	}

	List<GtsOilCanAlarm> list = new ArrayList<GtsOilCanAlarm>();

	public List<GtsOilCanAlarm> getList() {
		return list;
	}

	public void setList(List<GtsOilCanAlarm> list) {
		this.list = list;
	}
	
}
