package com.mltech.brite.response.oil.gts;

import java.util.ArrayList;
import java.util.List;

import com.mltech.brite.model.OilCanCom;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.user.ResultType;

public class OilCanComResponse extends BaseResponse{
	
	public OilCanComResponse(ResultType resultType) {
		super(resultType);
	}
	private List<OilCanCom> list = new ArrayList<OilCanCom>();
	
	/**
	 * 端口号列表，如COM1、COM2等等
	 */
	private List<String> portList = new ArrayList<String>();
	
	/**
	 * 协议列表，如COM1、COM2等等
	 */
	private List<String> protocolList = new ArrayList<String>();
	

	public List<OilCanCom> getList() {
		return list;
	}
	public void setList(List<OilCanCom> list) {
		this.list = list;
	}
	/**
	 * @return the protocolList
	 */
	public List<String> getProtocolList() {
		return protocolList;
	}
	/**
	 * @param protocolList the protocolList to set
	 */
	public void setProtocolList(List<String> protocolList) {
		this.protocolList = protocolList;
	}
	/**
	 * @return the portList
	 */
	public List<String> getPortList() {
		return portList;
	}
	/**
	 * @param portList the portList to set
	 */
	public void setPortList(List<String> portList) {
		this.portList = portList;
	}
	
	

}
