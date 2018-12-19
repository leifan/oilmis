package com.mltech.brite.model;

/**
 * 油品
 * 油品名称为：90#汽油，
 * 对应的油料类型为OilType中：汽油
 * 
 * @author user
 */
public class OilProduct {
	
	private String id;
	
	private String oilProductCode;
	
	private String oilProductName;
	
	private String oilTypeName;
	
	private String oilColor;
	
	private String oilProductNameForOuter;
	
	private String density;
	
	private String createTime;

	private String creator;

	private String updater;

	private String updateTime;


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
