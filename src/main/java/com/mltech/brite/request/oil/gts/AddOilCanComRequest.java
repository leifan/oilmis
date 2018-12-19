package com.mltech.brite.request.oil.gts;

import com.mltech.brite.request.BaseValidateRequest;

public class AddOilCanComRequest extends BaseValidateRequest{
	
	
	/**
	 * 通道号
	 */
	private String channelId;
	
	/**
	 * 端口号
	 */
	private String port;
	
	/**
	 * 设备协议
	 */
	private String protocol;
	
	/**
	 * 通信周期
	 */
	private String comPeriod;
	
	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getComPeriod() {
		return comPeriod;
	}

	public void setComPeriod(String comPeriod) {
		this.comPeriod = comPeriod;
	}

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
