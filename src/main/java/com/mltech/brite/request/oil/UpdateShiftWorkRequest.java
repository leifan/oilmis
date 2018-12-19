package com.mltech.brite.request.oil;

import java.sql.Timestamp;

import com.mltech.brite.annotation.NotBlank;
import com.mltech.brite.request.BaseValidateRequest;

/**
 * 添加交班信息
 * @author user
 */

public class UpdateShiftWorkRequest extends BaseValidateRequest{
	
	@NotBlank
	private Integer id;
	@NotBlank
	private String className;
	@NotBlank
	private String stationName;
	@NotBlank
	private String districtName;
	@NotBlank
	private String oilCanName;
	@NotBlank
	private String oilProductName;
	@NotBlank
	private String shiftTime;
	@NotBlank
	private String oilHeight;
	@NotBlank
	private String waterHeight;
	@NotBlank
	private String avergeTemperate;
	@NotBlank
	private String shiTemperate;
	@NotBlank
	private String shiDensity;
	@NotBlank
	private String standardDensity;
	@NotBlank
	private String standardCapacity;
	@NotBlank
	private String netOilCapacity;
	@NotBlank
	private String waterCapacity;
	@NotBlank
	private String netOilQuality;
	
	private String creator;
	
	private Timestamp createTime;
	
	private String updater;
	
	private Timestamp updateTime;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getOilCanName() {
		return oilCanName;
	}

	public void setOilCanName(String oilCanName) {
		this.oilCanName = oilCanName;
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

	public String getStandardDensity() {
		return standardDensity;
	}

	public void setStandardDensity(String standardDensity) {
		this.standardDensity = standardDensity;
	}

	public String getStandardCapacity() {
		return standardCapacity;
	}

	public void setStandardCapacity(String standardCapacity) {
		this.standardCapacity = standardCapacity;
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

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShiftTime() {
		return shiftTime;
	}

	public void setShiftTime(String shiftTime) {
		this.shiftTime = shiftTime;
	}

	public String getWaterHeight() {
		return waterHeight;
	}

	public void setWaterHeight(String waterHeight) {
		this.waterHeight = waterHeight;
	}
	
}

