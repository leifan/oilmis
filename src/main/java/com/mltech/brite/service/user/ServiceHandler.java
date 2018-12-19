package com.mltech.brite.service.user;

import com.mltech.brite.request.BaseValidateRequest;
import com.mltech.brite.response.BaseResponse;

public abstract class ServiceHandler<M extends BaseValidateRequest> {
	
	public abstract <T extends BaseResponse> T doService(M pojo) throws Exception;

}
