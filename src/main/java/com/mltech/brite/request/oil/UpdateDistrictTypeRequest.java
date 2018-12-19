package com.mltech.brite.request.oil;

import com.mltech.brite.annotation.NotBlank;
import com.mltech.brite.request.BaseValidateRequest;

/**
 * 增加油品类型请求类
 * @author user
 *
 */
public class UpdateDistrictTypeRequest extends BaseValidateRequest{
	
	private String id;
	/**
	 * 部门标号
	 */
	@NotBlank
	private String districtId;

	/**
	 * 部门名称
	 */
	@NotBlank
	private String districtName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	
}
