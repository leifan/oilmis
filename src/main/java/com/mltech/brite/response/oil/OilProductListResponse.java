package com.mltech.brite.response.oil;

import java.util.ArrayList;
import java.util.List;

import com.mltech.brite.model.OilProduct;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.user.ResultType;

public class OilProductListResponse extends BaseResponse{
	
	private List<OilProduct> list = new ArrayList<OilProduct>();

	public OilProductListResponse(ResultType resultType) {
		super(resultType);
	}

	public List<OilProduct> getList() {
		return list;
	}

	public void setList(List<OilProduct> list) {
		this.list = list;
	}
	
}
