package com.mltech.brite.request.oil.gts;

import com.mltech.brite.annotation.NotBlank;
import com.mltech.brite.request.BaseValidateRequest;

public class OilCanAlarmRequest extends BaseValidateRequest{
	
	@NotBlank
	private String beginDate;
	
	@NotBlank
	private String endDate;
	
	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
