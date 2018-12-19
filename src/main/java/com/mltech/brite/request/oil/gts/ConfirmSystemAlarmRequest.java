package com.mltech.brite.request.oil.gts;

import com.mltech.brite.annotation.NotBlank;
import com.mltech.brite.request.BaseValidateRequest;

public class ConfirmSystemAlarmRequest extends BaseValidateRequest{
	
	@NotBlank
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
