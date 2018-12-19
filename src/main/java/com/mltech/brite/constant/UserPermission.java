package com.mltech.brite.constant;

public enum UserPermission {
	
	Normal(1,"普通权限"),
	Super(2,"超级权限"),
	JiLiang(4,"计量权限"),
	Manger(8,"管理权限");
	
	private int code;
	private String name;
	
	UserPermission(int code,String name){
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
