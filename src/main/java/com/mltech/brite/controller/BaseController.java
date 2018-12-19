package com.mltech.brite.controller;

import com.alibaba.fastjson.JSON;
import com.mltech.brite.request.BaseValidateRequest;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.user.ResultType;
import com.mltech.brite.service.user.ServiceHandler;

public class BaseController {
	
	public <T extends BaseValidateRequest> String doMain(T pojo,
			ServiceHandler<T> handler) throws Exception {
		BaseResponse response = new BaseResponse(ResultType.success);
		try{
			response = new BaseResponse(ResultType.success);
			response = handler.doService(pojo);
		}catch(Exception e){
			response = new BaseResponse(ResultType.fail);
			return JSON.toJSONString(response);
		}
		
		return JSON.toJSONString(response);
		
	}

}
