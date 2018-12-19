package com.mltech.brite.request.oil;

import com.mltech.brite.pagination.PaginationInfo;
import com.mltech.brite.request.BaseValidateRequest;

public class OilCanFeedingListRequest extends BaseValidateRequest{

	private String stationName;
	
	private String beginTime;
	
	private String endTime;
	
	private PaginationInfo paginationInfo;

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public PaginationInfo getPaginationInfo() {
		return paginationInfo;
	}

	public void setPaginationInfo(PaginationInfo paginationInfo) {
		this.paginationInfo = paginationInfo;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
}
