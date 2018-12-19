package com.mltech.brite.request.oil;

import com.mltech.brite.annotation.NotBlank;
import com.mltech.brite.request.BaseValidateRequest;

public class GetOilCanDetailRequest extends BaseValidateRequest{
	
	/**
	 * 油罐所在站名
	 */
//	@NotBlank
//	private String oilStationName;
	
	/**
	 * 油罐名称
	 */
	@NotBlank
	private String oilCanName;
	
//	public String getOilStationName() {
//		return oilStationName;
//	}
//	public void setOilStationName(String oilStationName) {
//		this.oilStationName = oilStationName;
//	}
	
	public String getOilCanName() {
		return oilCanName;
	}
	public void setOilCanName(String oilCanName) {
		this.oilCanName = oilCanName;
	}

}
