package com.mltech.brite.model;

/**
 * 油品类型（汽油柴油等）
 * @author user
 *
 */
public class OilType {
	
	private String id;
	
	/**
	 * 油品类型编码
	 */
	private String oilTypeCode;
	
	/**
	 * 油品类型名称，如：90#车汽
	 */
	private String oilTypeName;
	
	private String createTime;

	private String creator;

	private String updater;

	private String updateTime;

	public String getOilTypeCode() {
		return oilTypeCode;
	}

	public void setOilTypeCode(String oilTypeCode) {
		this.oilTypeCode = oilTypeCode;
	}

	public String getOilTypeName() {
		return oilTypeName;
	}

	public void setOilTypeName(String oilTypeName) {
		this.oilTypeName = oilTypeName;
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

	
}
