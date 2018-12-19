package com.mltech.brite.constant;

public enum UserPriority {
	
	admin("admin","管理员"),
	user("user","普通");
	
	private String code;
	private String desc;
	
	UserPriority(String code,String desc){
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public static String getCodeByDesc(String desc){
		
		for(UserPriority e : UserPriority.values()){
			if(e.getDesc().equals(desc)){
				return e.getCode();
			}
		}
		return null;
	}

	public static String getDescByCode(String code){
		for(UserPriority e : UserPriority.values()){
			if(e.getCode().equals(code)){
				return e.getDesc();
			}
		}
		return null;
	}
}
