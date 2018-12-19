package com.mltech.brite.response.oil;

import java.util.ArrayList;
import java.util.List;

import com.mltech.brite.model.OilCan;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.user.ResultType;

/**
 * 油罐信息列表
 * @author user
 *
 */
public class OilCanListResponse extends BaseResponse{

	private List<OilCan> list = new ArrayList<OilCan>();
	
	public OilCanListResponse(ResultType resultType) {
		super(resultType);
	}

	public List<OilCan> getList() {
		return list;
	}

	public void setList(List<OilCan> list) {
		this.list = list;
	}
}
