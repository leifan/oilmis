package com.mltech.brite.request.oil;

import com.mltech.brite.annotation.NotBlank;
import com.mltech.brite.request.BaseValidateRequest;

/**
 * 增加油品类型请求类
 * @author user
 *
 */
public class AddOilTypeRequest extends BaseValidateRequest{
	
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

}
