package com.mltech.brite.model;

public class GtsOilCanAlarm {
	
	private String id;
	
	/**
	 * 报警时间
	 */
	private String alarmDate;
	
	/**
	 * 报警时间
	 */
	private String alarmTime;
	
	private String oilCanName;
	
	/**
	 * 报警类型，如：油高报警，水高报警，温度报警，流速报警，泄露报警，盗油报警，通信报警，以二进制性质描述，每一位标识一个报警类型
	 * 比如
	 * 1 = 油高报警 二进制是 0000 0001
	 * 2 = 水高报警 二进制是 0000 0010
	 * 4 = 温度报警 二进制是 0000 0100
	 * 8 = 流速报警 二进制是 0000 1000
	 * 16 = 泄露报警 二进制是 0001 0000
	 * 32 = 盗油报警 二进制是 0010 0000
	 * 64 = 通信报警 二进制是 0100 0000
	 * 
	 * 按照上面的，如果既有油高报警、水高报警、温度报警、流速报警，那么可以就可以表示成1+2+4+8 = 0000 1111，当要匹配其中任何一种报警，只要做一个与(&)操作即可
	 * 
	 * 比如要看是否有水高报警，只要 2 & (1+2+4+8) = 2即可。
	 */
	private int alarmType;
	
	private String alarmName;
	
	/**
	 * 报警确认时间
	 */
	private String confirmTime;
	
	private String confirmUser;
	
	private String creator;
	
	private String createTime;
	
	private String updater;
	
	private String updateTime;
	
	private String beginDate;
	
	private String endDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(String alarmTime) {
		this.alarmTime = alarmTime;
	}

	public String getOilCanName() {
		return oilCanName;
	}

	public void setOilCanName(String oilCanName) {
		this.oilCanName = oilCanName;
	}

	public String getAlarmName() {
		return alarmName;
	}

	public void setAlarmName(String alarmName) {
		this.alarmName = alarmName;
	}

	public String getConfirmTime() {
		return confirmTime;
	}

	public void setConfirmTime(String confirmTime) {
		this.confirmTime = confirmTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public String getConfirmUser() {
		return confirmUser;
	}

	public void setConfirmUser(String confirmUser) {
		this.confirmUser = confirmUser;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getAlarmDate() {
		return alarmDate;
	}

	public void setAlarmDate(String alarmDate) {
		this.alarmDate = alarmDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public int getAlarmType() {
		return alarmType;
	}

	public void setAlarmType(int alarmType) {
		this.alarmType = alarmType;
	}

}
