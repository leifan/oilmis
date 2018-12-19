package com.mltech.brite.request.oil;

import com.mltech.brite.request.BaseValidateRequest;

/**
 * 增加油品类型请求类
 * @author user
 *
 */
public class DeleteDistrictTypeRequest extends BaseValidateRequest{
	
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
