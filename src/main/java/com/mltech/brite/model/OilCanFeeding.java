package com.mltech.brite.model;

/**
 * 油罐进油模型
 * @author user
 *
 */
public class OilCanFeeding {
	
	private String id;
	
	/**
	 * 前尺或后尺，只有这两个选项
	 */
	private String feedingType;
	
	/**
	 * 油罐名称
	 */
	private String oilCanName;
	
	/**
	 * 油品类型
	 */
	private String oilProductName;
	
	/**
	 * 油站名称
	 */
	private String stationName;
	
	/**
	 * 液位
	 */
	private String oilHeight;
	
	/**
	 * 水位
	 */
	private String waterHeight;
	
	/**
	 * 平均温度
	 */
	private String avergeTemperate;
	
	/**
	 * 视温度
	 */
	private String shiTemperate;
	
	/**
	 * 视密度
	 */
	private String shiDensity;
	
	/**
	 * 标准密度
	 */
	private String standardDensity;
	
	/**
	 * 标准体积
	 */
	private String standardCapacity;
	
	/**
	 * 净油体积
	 */
	private String netOilCapacity;
	
	/**
	 * 水体积
	 */
	private String waterCapacity;
	
	/**
	 * 净油质量
	 */
	private String netOilQuality;
	
	private String createTime;

	private String creator;

	private String updater;

	private String updateTime;

	/**
	 * 查询开始时间
	 */
	private String beginTime;
	
	/**
	 * 查询结束时间
	 */
	private String endTime;
	
	/**
	 * 使用耗时
	 */
	private int useTime;//s
	
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

	public String getStandardDensity() {
		return standardDensity;
	}

	public void setStandardDensity(String standardDensity) {
		this.standardDensity = standardDensity;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getUseTime() {
		return useTime;
	}

	public void setUseTime(int useTime) {
		this.useTime = useTime;
	}
}
