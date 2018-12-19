package com.mltech.brite.model;

/**
 * 油罐枚举类
 * @author user
 *
 */
public class OilCan {
	
	private String id;
	
	/**
	 * 油罐编码
	 */
	private String oilCanCode;
	
	/**
	 * 油罐名称
	 */
	private String oilCanName;
	
	/**
	 * 油罐类型
	 */
	private String oilCanType;
	
	/**
	 * 油品类型
	 */
	private String oilProductName;
	
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
	 * 油站实际编码
	 */
	private String stationRealCode;
	
	/**
	 * 油罐高度
	 */
	private String oilCanHeight;
	
	/**
	 * 油罐容量
	 */
	private String oilCanVolumn;
	
	/**
	 * 液位
	 */
	private String liquidLevel;
	
	/**
	 * 水位
	 */
	private String waterLevel;
	
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
	private String stardardDensity;
	
	/**
	 * 标准体积
	 */
	private String stardardCapacity;
	
	/**
	 * 净油体积
	 */
	private String netOilCapacity;
	
	/**
	 * 水体积
	 */
	private String waterCapacity;
	
	/**
	 * 空容积
	 */
	private String emptyCapacity;
	
	/**
	 * 净油质量
	 */
	private String netOilQuality;
	
	/**
	 * 储罐状态
	 */
	private String oilCanStatus;
	
	/**
	 * 检测时间yyyy-mm-dd HH:mm:ss
	 */
	private String checkTime;
	
	/**
	 * 报警状态
	 */
	private String alarmStatus;
	
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

	public String getOilCanVolumn() {
		return oilCanVolumn;
	}

	public void setOilCanVolumn(String oilCanVolumn) {
		this.oilCanVolumn = oilCanVolumn;
	}

	public String getLiquidLevel() {
		return liquidLevel;
	}

	public void setLiquidLevel(String liquidLevel) {
		this.liquidLevel = liquidLevel;
	}

	public String getWaterLevel() {
		return waterLevel;
	}

	public void setWaterLevel(String waterLevel) {
		this.waterLevel = waterLevel;
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

	public String getStardardCapacity() {
		return stardardCapacity;
	}

	public void setStardardCapacity(String stardardCapacity) {
		this.stardardCapacity = stardardCapacity;
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

	public String getEmptyCapacity() {
		return emptyCapacity;
	}

	public void setEmptyCapacity(String emptyCapacity) {
		this.emptyCapacity = emptyCapacity;
	}

	public String getNetOilQuality() {
		return netOilQuality;
	}

	public void setNetOilQuality(String netOilQuality) {
		this.netOilQuality = netOilQuality;
	}

	public String getOilCanStatus() {
		return oilCanStatus;
	}

	public void setOilCanStatus(String oilCanStatus) {
		this.oilCanStatus = oilCanStatus;
	}

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	public String getAlarmStatus() {
		return alarmStatus;
	}

	public void setAlarmStatus(String alarmStatus) {
		this.alarmStatus = alarmStatus;
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

	public String getOilCanHeight() {
		return oilCanHeight;
	}

	public void setOilCanHeight(String oilCanHeight) {
		this.oilCanHeight = oilCanHeight;
	}

	public String getOilProductName() {
		return oilProductName;
	}

	public void setOilProductName(String oilProductName) {
		this.oilProductName = oilProductName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

}
