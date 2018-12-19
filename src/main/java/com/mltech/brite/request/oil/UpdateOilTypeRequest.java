package com.mltech.brite.request.oil;

import com.mltech.brite.annotation.NotBlank;
import com.mltech.brite.request.BaseValidateRequest;

public class UpdateOilTypeRequest extends BaseValidateRequest{
	
	@NotBlank(message="id不能为空")
	private String id;
	/**
	 * 油品类型编码
	 */
	@NotBlank(message="oilTypeCode不能为空")
	private String oilTypeCode;
	/**
	 * 油品类型名称
	 */
	@NotBlank(message="oilTypeName不能为空")
	private String oilTypeName;

	public String getOilTypeName() {
		return oilTypeName;
	}

	public void setOilTypeName(String oilTypeName) {
		this.oilTypeName = oilTypeName;
	}

	public String getOilTypeCode() {
		return oilTypeCode;
	}

	public void setOilTypeCode(String oilTypeCode) {
		this.oilTypeCode = oilTypeCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
