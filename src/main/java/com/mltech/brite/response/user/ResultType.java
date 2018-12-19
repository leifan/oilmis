package com.mltech.brite.response.user;

public enum ResultType {

	success(200,"成功"),
	fail(201,"系统故障"),
	paramFail(202,"参数有误"),
	
	/*用户登录信息相关*/
	invalidUser(203,"不存在此用户，请重新核对"),
	wrongPassword(204,"用户名或密码不对，请重新输入"),
	offLine(205,"当前用户登录失效，需要重新登录"),
	
	/*已存在相同的记录*/
	repeat(300,"已存在相同内容记录"),
	noRecord(301,"查询不到该记录");
	
	private int code;
	private String desc;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	ResultType(int code,String desc){
		this.code = code;
		this.desc = desc;
	}
	
}
