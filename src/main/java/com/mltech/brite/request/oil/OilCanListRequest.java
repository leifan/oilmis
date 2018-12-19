package com.mltech.brite.request.oil;

import com.mltech.brite.request.BaseValidateRequest;
import com.mltech.brite.pagination.PaginationInfo;

/**
 * 油罐列表
 * @author user
 *
 */
public class OilCanListRequest extends BaseValidateRequest{
	
	/**
	 * 分页参数，必传
	 */
	private String oilStationName;
	
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

	public String getOilStationName() {
		return oilStationName;
	}

	public void setOilStationName(String oilStationName) {
		this.oilStationName = oilStationName;
	}
	

}
