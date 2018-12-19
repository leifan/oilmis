package com.mltech.brite.request.oil;

import com.mltech.brite.annotation.NotBlank;
import com.mltech.brite.request.BaseValidateRequest;

public class AddOilStationStaffRequest extends BaseValidateRequest{

	/**
	 * 油站编码
	 */
	@NotBlank
	private String districtName;
	
	/**
	 * 油站名称
	 */
	@NotBlank
	private String oilStationName;
	
	/**
	 * 员工编号
	 */
	@NotBlank
	private String staffId;
	
	/**
	 * 员工姓名
	 */
	@NotBlank
	private String staffName;
	
	/**
	 * 员工类型-自定义：如主任、普通、经理
	 */
	@NotBlank
	private String staffType;
	
	/**
	 * 座机号码
	 */
	@NotBlank
	private String tel;
	
	/**
	 * 手机号码
	 */
	@NotBlank
	private String phone;
	
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

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

}
