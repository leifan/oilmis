package com.mltech.brite.request.oil;

import com.mltech.brite.annotation.NotBlank;
import com.mltech.brite.request.BaseValidateRequest;

public class AddOilCanRequest extends BaseValidateRequest{
	
	/**
	 * 
	 */
	private String id;
	
	/**
	 * 油罐编码
	 */
	@NotBlank
	private String oilCanCode;
	
	/**
	 * 油罐名称
	 */
	@NotBlank
	private String oilCanName;
	
	/**
	 * 油罐类型 立罐，卧罐，枚举类型
	 */
	@NotBlank
	private String oilCanType;
	
	/**
	 * 油品类型
	 */
	@NotBlank
	private String oilProductName;
	
	@NotBlank
	private String districtName;
	
	/**
	 * 油站名称
	 */
	@NotBlank
	private String stationCode;
	
	/**
	 * 油站名称
	 */
	@NotBlank
	private String stationName;
	
	/**
	 * 油站实际编码，这个编码
	 */
	@NotBlank
	private String stationRealCode;
	
	/**
	 * 油罐高度
	 */
	@NotBlank
	private String oilCanHeight;
	
	/**
	 * 油罐容量
	 */
	@NotBlank
	private String oilCanVolumn;
	
	/**
	 * 油罐容量
	 */
	@NotBlank
	private String oilCanStatus;

	public String getOilCanCode() {
		return oilCanCode;
	}

	public void setOilCanCode(String oilCanCode) {
		this.oilCanCode = oilCanCode;
	}

	public String getOilCanName() {
		return oilCanName;
	}

	public void setOilCanName(String oilCanName) {
		this.oilCanName = oilCanName;
	}

	public String getOilCanType() {
		return oilCanType;
	}

	public void setOilCanType(String oilCanType) {
		this.oilCanType = oilCanType;
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

	public String getOilCanVolumn() {
		return oilCanVolumn;
	}

	public void setOilCanVolumn(String oilCanVolumn) {
		this.oilCanVolumn = oilCanVolumn;
	}

	public String getOilCanHeight() {
		return oilCanHeight;
	}

	public void setOilCanHeight(String oilCanHeight) {
		this.oilCanHeight = oilCanHeight;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOilProductName() {
		return oilProductName;
	}

	public void setOilProductName(String oilProductName) {
		this.oilProductName = oilProductName;
	}

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getOilCanStatus() {
		return oilCanStatus;
	}

	public void setOilCanStatus(String oilCanStatus) {
		this.oilCanStatus = oilCanStatus;
	}
}
