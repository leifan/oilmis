package com.mltech.brite.response.oil;

import com.mltech.brite.model.OilCanFeeding;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.user.ResultType;

public class OilCanFeedingDetailResponse extends BaseResponse{
	
	public OilCanFeedingDetailResponse(ResultType resultType) {
		super(resultType);
	}

	private OilCanFeeding detail;

	public OilCanFeeding getDetail() {
		return detail;
	}

	public void setDetail(OilCanFeeding detail) {
		this.detail = detail;
	}

}
