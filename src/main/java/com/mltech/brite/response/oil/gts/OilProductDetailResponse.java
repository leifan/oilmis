package com.mltech.brite.response.oil.gts;

import com.mltech.brite.model.OilProduct;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.user.ResultType;

public class OilProductDetailResponse extends BaseResponse{

	private OilProduct detail;
	
	public OilProductDetailResponse(ResultType resultType) {
		super(resultType);
	}

	public OilProduct getDetail() {
		return detail;
	}

	public void setDetail(OilProduct detail) {
		this.detail = detail;
	}

}
