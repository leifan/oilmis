package com.mltech.brite.request.oil;

import com.mltech.brite.annotation.NotBlank;
import com.mltech.brite.request.BaseValidateRequest;

public class AddOilProductRequest extends BaseValidateRequest {

	@NotBlank
	private String oilProductCode;
	@NotBlank
	private String oilProductName;
	@NotBlank
	private String oilTypeName;
	@NotBlank
	private String oilColor;
	@NotBlank
	private String oilProductNameForOuter;

	public String getOilProductCode() {
		return oilProductCode;
	}

	public void setOilProductCode(String oilProductCode) {
		this.oilProductCode = oilProductCode;
	}

	public String getOilProductName() {
		return oilProductName;
	}

	public void setOilProductName(String oilProductName) {
		this.oilProductName = oilProductName;
	}

	public String getOilTypeName() {
		return oilTypeName;
	}

	public void setOilTypeName(String oilTypeName) {
		this.oilTypeName = oilTypeName;
	}

	public String getOilColor() {
		return oilColor;
	}

	public void setOilColor(String oilColor) {
		this.oilColor = oilColor;
	}

	public String getOilProductNameForOuter() {
		return oilProductNameForOuter;
	}

	public void setOilProductNameForOuter(String oilProductNameForOuter) {
		this.oilProductNameForOuter = oilProductNameForOuter;
	}

}
