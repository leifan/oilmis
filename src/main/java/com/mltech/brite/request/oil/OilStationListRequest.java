package com.mltech.brite.request.oil;

import com.mltech.brite.request.BaseValidateRequest;
import com.mltech.brite.pagination.PaginationInfo;

public class OilStationListRequest extends BaseValidateRequest{
	
	/**
	 * 分页参数，必传
	 */
	private String districtName;
	
	/**
	 * 分页参数，非必传
	 */
	private PaginationInfo paginationInfo;

	public PaginationInfo getPaginationInfo() {
		return paginationInfo;
	}

	public void setPaginationInfo(PaginationInfo paginationInfo) {
		this.paginationInfo = paginationInfo;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
}
