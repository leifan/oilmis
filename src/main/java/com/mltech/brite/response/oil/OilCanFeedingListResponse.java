package com.mltech.brite.response.oil;


import com.mltech.brite.model.OilCanFeeding;
import com.mltech.brite.pagination.PaginationList;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.user.ResultType;

public class OilCanFeedingListResponse extends BaseResponse{
	
	private PaginationList<OilCanFeeding> list = new PaginationList<OilCanFeeding>();

	public OilCanFeedingListResponse(ResultType resultType) {
		super(resultType);
	}

	public PaginationList<OilCanFeeding> getList() {
		return list;
	}

	public void setList(PaginationList<OilCanFeeding> list) {
		this.list = list;
	}
	
}
