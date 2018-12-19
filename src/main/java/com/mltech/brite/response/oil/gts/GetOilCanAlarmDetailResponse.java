package com.mltech.brite.response.oil.gts;

import com.mltech.brite.model.GtsOilCanAlarm;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.user.ResultType;

public class GetOilCanAlarmDetailResponse extends BaseResponse{

	public GetOilCanAlarmDetailResponse(ResultType resultType) {
		super(resultType);
	}
	
	public GtsOilCanAlarm getDetail() {
		return detail;
	}

	public void setDetail(GtsOilCanAlarm detail) {
		this.detail = detail;
	}

	private GtsOilCanAlarm detail;
	

}
