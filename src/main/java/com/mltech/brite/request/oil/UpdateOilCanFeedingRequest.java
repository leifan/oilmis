package com.mltech.brite.request.oil;

import com.mltech.brite.annotation.NotBlank;
import com.mltech.brite.request.BaseValidateRequest;

public class UpdateOilCanFeedingRequest extends BaseValidateRequest{
	
	private String id;
	/**
	 * 前尺或后尺，只有这两个选项
	 */
	@NotBlank
	private String feedingType;
	/**
	 * 油罐名称
	 */
	@NotBlank
	private String oilCanName;
	
	/**
	 * 油品类型
	 */
	@NotBlank
	private String oilProductName;
	
	/**
	 * 油站名称
	 */
	@NotBlank
	private String stationName;
	
	/**
	 * 液位
	 */
	@NotBlank
	private String oilHeight;
	
	/**
	 * 水位
	 */
	@NotBlank
	private String waterHeight;
	
	/**
	 * 平均温度
	 */
	@NotBlank
	private String avergeTemperate;
	
	/**
	 * 视温度
	 */
	@NotBlank
	private String shiTemperate;
	
	/**
	 * 视密度
	 */
	@NotBlank
	private String shiDensity;
	
	/**
	 * 标准密度
	 */
	@NotBlank
	private String stardardDensity;
	
	/**
	 * 标准体积
	 */
	@NotBlank
	private String standardCapacity;
	
	/**
	 * 净油体积
	 */
	@NotBlank
	private String netOilCapacity;
	
	/**
	 * 水体积
	 */
	@NotBlank
	private String waterCapacity;
	
	/**
	 * 净油质量
	 */
	@NotBlank
	private String netOilQuality;
	
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

	public String getOilCanName() {
		return oilCanName;
	}

	public void setOilCanName(String oilCanName) {
		this.oilCanName = oilCanName;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getAvergeTemperate() {
		return avergeTemperate;
	}

	public void setAvergeTemperate(String avergeTemperate) {
		this.avergeTemperate = avergeTemperate;
	}

	public String getShiTemperate() {
		return shiTemperate;
	}

	public void setShiTemperate(String shiTemperate) {
		this.shiTemperate = shiTemperate;
	}

	public String getShiDensity() {
		return shiDensity;
	}

	public void setShiDensity(String shiDensity) {
		this.shiDensity = shiDensity;
	}

	public String getStardardDensity() {
		return stardardDensity;
	}

	public void setStardardDensity(String stardardDensity) {
		this.stardardDensity = stardardDensity;
	}

	public String getNetOilCapacity() {
		return netOilCapacity;
	}

	public void setNetOilCapacity(String netOilCapacity) {
		this.netOilCapacity = netOilCapacity;
	}

	public String getWaterCapacity() {
		return waterCapacity;
	}

	public void setWaterCapacity(String waterCapacity) {
		this.waterCapacity = waterCapacity;
	}

	public String getNetOilQuality() {
		return netOilQuality;
	}

	public void setNetOilQuality(String netOilQuality) {
		this.netOilQuality = netOilQuality;
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

	public String getOilProductName() {
		return oilProductName;
	}

	public void setOilProductName(String oilProductName) {
		this.oilProductName = oilProductName;
	}

	public String getOilHeight() {
		return oilHeight;
	}

	public void setOilHeight(String oilHeight) {
		this.oilHeight = oilHeight;
	}

	public String getWaterHeight() {
		return waterHeight;
	}

	public void setWaterHeight(String waterHeight) {
		this.waterHeight = waterHeight;
	}

	public String getFeedingType() {
		return feedingType;
	}

	public void setFeedingType(String feedingType) {
		this.feedingType = feedingType;
	}

	public String getStandardCapacity() {
		return standardCapacity;
	}

	public void setStandardCapacity(String standardCapacity) {
		this.standardCapacity = standardCapacity;
	}

}
