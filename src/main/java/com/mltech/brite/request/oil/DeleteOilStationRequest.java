package com.mltech.brite.request.oil;

import com.mltech.brite.request.BaseValidateRequest;

public class DeleteOilStationRequest extends BaseValidateRequest{

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
