package com.mltech.brite.request.oil;

import com.mltech.brite.annotation.NotBlank;
import com.mltech.brite.request.BaseValidateRequest;

public class UpdateOilStationRequest extends BaseValidateRequest{
	
	@NotBlank
	private String id;
	/**
	 * 
	 * 所属区域名称（如华北区）
	 */
	@NotBlank
	private String districtName;
	/**
	 * 油站编码
	 */
	@NotBlank
	private String stationCode;
	/**
	 * 油站名称
	 */
	@NotBlank
	private String stationName;
	/**
	 * 实际油站编码
	 */
	@NotBlank
	private String stationRealCode;
	
	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getStationRealCode() {
		return stationRealCode;
	}

	public void setStationRealCode(String stationRealCode) {
		this.stationRealCode = stationRealCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
