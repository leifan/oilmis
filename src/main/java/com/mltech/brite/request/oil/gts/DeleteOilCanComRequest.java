package com.mltech.brite.request.oil.gts;

import com.mltech.brite.request.BaseValidateRequest;

public class DeleteOilCanComRequest extends BaseValidateRequest{
	
	/**
	 * 通道号，通道号唯一
	 */
	private String channelId;

	/**
	 * @return the channelId
	 */
	public String getChannelId() {
		return channelId;
	}

	/**
	 * @param channelId the channelId to set
	 */
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	
}
