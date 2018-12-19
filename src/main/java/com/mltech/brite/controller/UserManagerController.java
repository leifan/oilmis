package com.mltech.brite.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.mltech.brite.request.user.AddGtsUserRequest;
import com.mltech.brite.request.user.AddUserRequest;
import com.mltech.brite.request.user.DeleteUserRequest;
import com.mltech.brite.request.user.GetSimpleUserListRequest;
import com.mltech.brite.request.user.GetUserDetailRequest;
import com.mltech.brite.request.user.GetUserListRequest;
import com.mltech.brite.request.user.LoginRequest;
import com.mltech.brite.request.user.ResetPasswordRequest;
import com.mltech.brite.request.user.UpdateGtsUserList;
import com.mltech.brite.response.BaseResponse;
import com.mltech.brite.response.user.ResultType;
import com.mltech.brite.service.user.UserManagerService;
import com.mltech.brite.util.LoggerUtil;

@Controller
@RequestMapping("user")
public class UserManagerController {
	
	@Resource
	UserManagerService userManagerService;
	
	@RequiresPermissions("admin")
	@RequiresAuthentication
	@RequestMapping(value = "add", method = { RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String addUser(AddUserRequest pojo){
		try{
			return userManagerService.addUser(pojo);
		}catch(Exception e){
			LoggerUtil.error("addUser", e);
			return JSON.toJSONString(new BaseResponse(ResultType.fail));
		}
		
	}
	
	@RequiresPermissions("admin")
	@RequiresAuthentication
	@RequestMapping(value = "delete", method = { RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String deleteUser(DeleteUserRequest pojo){
		try{
			return userManagerService.deleteUser(pojo);
		}catch(Exception e){
			LoggerUtil.error("deleteUser",e);
			return JSON.toJSONString(new BaseResponse(ResultType.fail));
		}
	}
	
	@RequiresPermissions("admin")
	@RequiresAuthentication
	@RequestMapping(value = "update", method = { RequestMethod.POST },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String updateUser(AddUserRequest pojo){
		try{
			return userManagerService.updateUser(pojo);
		}catch(Exception e){
			LoggerUtil.error("updateUser",e);
			return JSON.toJSONString(new BaseResponse(ResultType.fail));
		}
		
	}
	@RequiresPermissions("user")
	@RequiresAuthentication
	@RequestMapping(value = "info", method = { RequestMethod.POST,RequestMethod.GET },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String userDetail(GetUserDetailRequest pojo){
		try{
			return userManagerService.userDetail(pojo);
		}catch(Exception e){
			LoggerUtil.error("userDetail",e);
			return JSON.toJSONString(new BaseResponse(ResultType.fail));
		}
		
	}
	
	
	@RequestMapping(value = "login", method = { RequestMethod.POST,RequestMethod.GET },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String login(LoginRequest pojo, HttpServletRequest httpServletRequest,Model model ){
		
		try{
			BaseResponse validateResult = pojo.validate();
			
			if(validateResult.getRetCode() != ResultType.success.getCode()){
				return JSON.toJSONString(validateResult);
			}
			
			pojo.setLastLoginIp(httpServletRequest.getRemoteAddr());
			return userManagerService.login(pojo);
		}catch(Exception e){
			LoggerUtil.error("login",e);
			return JSON.toJSONString(new BaseResponse(ResultType.fail));
		}
		
	}
	
	@RequiresPermissions("admin")
	@RequiresAuthentication
	@RequestMapping(value = "resetPassword", method = { RequestMethod.POST,RequestMethod.GET },produces="text/text;charset=UTF-8")
	@ResponseBody
	public String resetPassword(ResetPasswordRequest pojo, HttpServletRequest httpServletRequest ){
		try{
			return userManagerService.resetPassword(pojo);
		}catch(Exception e){
			LoggerUtil.error("resetPassword",e);
			return JSON.toJSONString(new BaseResponse(ResultType.fail));
		}
		
	}
	
	@RequiresPermissions("admin")
	@RequiresAuthentication
	@RequestMapping(value = "getUserList", method = { RequestMethod.POST,RequestMethod.GET },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getUserList(GetUserListRequest pojo, HttpServletRequest httpServletRequest ){
		try{
			return userManagerService.getUserList(pojo);
		}catch(Exception e){
			LoggerUtil.error("getUserList",e);
			return JSON.toJSONString(new BaseResponse(ResultType.fail));
		}
		
	}
	
	@RequiresPermissions("admin")
	@RequiresAuthentication
	@RequestMapping(value = "getPriorityList", method = { RequestMethod.POST,RequestMethod.GET },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getPriorityList(HttpServletRequest httpServletRequest ){
		try{
			return userManagerService.getPriorityList();
		}catch(Exception e){
			LoggerUtil.error("getPriorityList",e);
			return JSON.toJSONString(new BaseResponse(ResultType.fail));
		}
	}
	
	@RequiresPermissions("admin")
	@RequiresAuthentication
	@RequestMapping(value = "getGtsUserList", method = { RequestMethod.POST,RequestMethod.GET },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String getGtsUserList(GetSimpleUserListRequest pojo,HttpServletRequest httpServletRequest ){
		try{
			return userManagerService.getSimpleUserList(pojo);
		}catch(Exception e){
			LoggerUtil.error("getPriorityList",e);
			return JSON.toJSONString(new BaseResponse(ResultType.fail));
		}
	}
	
	@RequiresPermissions("admin")
	@RequiresAuthentication
	@RequestMapping(value = "addGtsUserList", method = { RequestMethod.POST,RequestMethod.GET },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String addGtsUserList(AddGtsUserRequest pojo,HttpServletRequest httpServletRequest ){
		try{
			return userManagerService.addSimpleUser(pojo,httpServletRequest);
		}catch(Exception e){
			LoggerUtil.error("getPriorityList",e);
			return JSON.toJSONString(new BaseResponse(ResultType.fail));
		}
	}
	
	@RequiresPermissions("admin")
	@RequiresAuthentication
	@RequestMapping(value = "updateGtsUser", method = { RequestMethod.POST,RequestMethod.GET },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String updateGtsUserList(AddGtsUserRequest pojo,HttpServletRequest httpServletRequest ){
		try{
			return userManagerService.updateGtsUser(pojo);
		}catch(Exception e){
			LoggerUtil.error("getPriorityList",e);
			return JSON.toJSONString(new BaseResponse(ResultType.fail));
		}
	}
	
	@RequiresPermissions("admin")
	@RequiresAuthentication
	@RequestMapping(value = "updateGtsUserList", method = { RequestMethod.POST,RequestMethod.GET },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String updateGtsUserList(UpdateGtsUserList pojo,HttpServletRequest httpServletRequest ){
		try{
			return userManagerService.updateGtsUserList(pojo);
		}catch(Exception e){
			LoggerUtil.error("getPriorityList",e);
			return JSON.toJSONString(new BaseResponse(ResultType.fail));
		}
	}
	
	@RequiresPermissions("admin")
	@RequiresAuthentication
	@RequestMapping(value = "deleteGtsUserList", method = { RequestMethod.POST,RequestMethod.GET },produces="application/json;charset=UTF-8")
	@ResponseBody
	public String deleteGtsUserList(String id,HttpServletRequest httpServletRequest ){
		try{
			return userManagerService.deleteGtsUser(id);
		}catch(Exception e){
			LoggerUtil.error("getPriorityList",e);
			return JSON.toJSONString(new BaseResponse(ResultType.fail));
		}
	}
	
	
}
