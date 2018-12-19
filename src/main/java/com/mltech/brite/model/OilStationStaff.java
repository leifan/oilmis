package com.mltech.brite.model;

/**
 * 油站员工管理表-每个油站中所有工作人员以及工作人员职位身份手机电话信息管理
 * @author user
 *
 */
public class OilStationStaff {
	
	private String id;
	
	/**
	 * 区域名称
	 */
	private String districtName;
	
	/**
	 * 油站名称
	 */
	private String oilStationName;
	
	/**
	 * 员工编号
	 */
	private String staffId;
	
	/**
	 * 员工姓名
	 */
	private String staffName;
	
	/**
	 * 员工类型-自定义：如主任、普通、经理
	 */
	private String staffType;
	
	/**
	 * 座机号码
	 */
	private String tel;
	
	/**
	 * 手机号码
	 */
	private String phone;
	
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

	public String getOilStationName() {
		return oilStationName;
	}

	public void setOilStationName(String oilStationName) {
		this.oilStationName = oilStationName;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffType() {
		return staffType;
	}

	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

}
