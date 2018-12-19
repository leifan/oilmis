package com.mltech.brite.model;

public class Priority {
	
	public static String admin = "管理员";
	public static int adminCode = 1;
	public static String general = "普通用户";
	public static int generalCode = 0;
	
	private String priorityName;
	private int priorityCode;

	public String getPriorityName() {
		return priorityName;
	}

	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
	}

	public int getPriorityCode() {
		return priorityCode;
	}

	public void setPriorityCode(int priorityCode) {
		this.priorityCode = priorityCode;
	}

}
