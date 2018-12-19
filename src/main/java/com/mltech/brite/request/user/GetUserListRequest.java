package com.mltech.brite.request.user;

import com.mltech.brite.request.BaseValidateRequest;

public class GetUserListRequest extends BaseValidateRequest{
	
	private String districtName;
	
	private String departmentName;
	
	private String groupName;
	
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
}
