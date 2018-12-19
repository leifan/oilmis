package com.mltech.brite.response.oil;

import com.mltech.brite.model.OilCan;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.user.ResultType;

public class GetOilCanDetailResponse extends BaseResponse{
	
	public GetOilCanDetailResponse(ResultType resultType) {
		super(resultType);
	}

	private OilCan detail;

	public OilCan getDetail() {
		return detail;
	}

	public void setDetail(OilCan detail) {
		this.detail = detail;
	}
}
