package com.mltech.brite.response;

import com.mltech.brite.response.user.ResultType;

public class BaseResponse {
	
	public int retCode;
	
	public String retDesc;
	
	public BaseResponse(ResultType resultType){
		this.retCode = resultType.getCode();
		this.retDesc = resultType.getDesc();
	}

	public int getRetCode() {
		return retCode;
	}

	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}

	public String getRetDesc() {
		return retDesc;
	}

	public void setRetDesc(String retDesc) {
		this.retDesc = retDesc;
	}
}
