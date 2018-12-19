package com.mltech.brite.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class SimpleUserModel {

	public String id;
	
	public String userName;
	
	public String password;
	
	public String permission;
	
	public String lastLoginTime;
	
	public String lastLoginIp;
	
	public String createTime;

	//角色名称，对应权限类型，关联tb_user_permission表
	public List<String> permissions = new ArrayList<String>();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public List<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}
	
	public void reset(){
		if(StringUtils.isBlank(this.id)){
			this.id=null;
		}
		
		if(StringUtils.isBlank(this.userName)){
			this.userName=null;
		}
		
		if(StringUtils.isBlank(this.password)){
			this.password=null;
		}
		
		if(StringUtils.isBlank(this.permission)){
			this.permission=null;
		}
		
	}

}
