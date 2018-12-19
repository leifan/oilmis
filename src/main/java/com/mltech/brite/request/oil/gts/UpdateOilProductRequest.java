package com.mltech.brite.request.oil.gts;

import com.mltech.brite.annotation.NotBlank;
import com.mltech.brite.request.BaseValidateRequest;

public class UpdateOilProductRequest extends BaseValidateRequest {

	@NotBlank
	private String id;
	@NotBlank
	private String oilProductCode;
	@NotBlank
	private String oilProductName;
	@NotBlank
	private String oilColor;
	@NotBlank
	private String density;

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

	public String getOilColor() {
		return oilColor;
	}

	public void setOilColor(String oilColor) {
		this.oilColor = oilColor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDensity() {
		return density;
	}

	public void setDensity(String density) {
		this.density = density;
	}

}
