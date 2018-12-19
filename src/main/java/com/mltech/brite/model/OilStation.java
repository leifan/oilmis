package com.mltech.brite.model;

/**
 * 
 * 油站类
 * @author user
 *
 */
public class OilStation {

	private String id;
	/**
	 * 所属区域名称（如华北区）
	 */
	private String districtName;
	/**
	 * 油站编码
	 */
	private String stationCode;
	/**
	 * 油站名称
	 */
	private String stationName;
	/**
	 * 实际油站编码
	 */
	private String stationRealCode;
	
	private String createTime;

	private String creator;

	private String updater;

	private String updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getStationRealCode() {
		return stationRealCode;
	}

	public void setStationRealCode(String stationRealCode) {
		this.stationRealCode = stationRealCode;
	}
	
}
