package com.mltech.brite.request.oil;

import com.mltech.brite.request.BaseValidateRequest;
import com.mltech.brite.pagination.PaginationInfo;

public class OilStationStaffListRequest extends BaseValidateRequest{
	
	private String oilStationName;
	
	private String districtName;

	public String getOilStationName() {
		return oilStationName;
	}

	public void setOilStationName(String oilStationName) {
		this.oilStationName = oilStationName;
	}
	
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
