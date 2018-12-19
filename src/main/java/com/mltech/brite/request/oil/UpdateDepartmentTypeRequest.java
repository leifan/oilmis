package com.mltech.brite.request.oil;

import com.mltech.brite.annotation.NotBlank;
import com.mltech.brite.request.BaseValidateRequest;

public class UpdateDepartmentTypeRequest extends BaseValidateRequest{

	private String id;
	
	/**
	 * 部门标号
	 */
	@NotBlank
	private String departmentId;
	
	/**
	 * 部门名称
	 */
	@NotBlank
	private String departmentName;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
