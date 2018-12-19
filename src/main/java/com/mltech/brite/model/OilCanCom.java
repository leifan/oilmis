package com.mltech.brite.model;

public class OilCanCom {

	private String id;
	
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
	
	private String creator;
	
	private String createTime;
	
	private String updater;
	
	private String updateTime;
	
	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
