package com.mltech.brite.service.user;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.JSONToken;
import com.mltech.brite.constant.UserPriority;
import com.mltech.brite.dao.user.SimpleUserDao;
import com.mltech.brite.dao.user.UserDao;
import com.mltech.brite.model.Priority;
import com.mltech.brite.model.SimpleUserModel;
import com.mltech.brite.model.UserModel;
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
import com.mltech.brite.response.user.GtsUserListResponse;
import com.mltech.brite.response.user.LoginResponse;
import com.mltech.brite.response.user.PriorityListResponse;
import com.mltech.brite.response.user.ResultType;
import com.mltech.brite.response.user.UserListResponse;
import com.mltech.brite.util.DateUtil;

@Service
public class UserManagerService {
	
	@Resource
	UserDao userDao;
	
	@Resource
	SimpleUserDao simpleUserDao;

	public String addUser(AddUserRequest pojo){
		
		BaseResponse response;
		
		UserModel cond = new UserModel();
		cond.setUserName(pojo.getUserName());
		List<UserModel> existUsers = userDao.findEntityByCond(cond);
		if(existUsers!= null && existUsers.size()>0){
			response = new BaseResponse(ResultType.repeat);
			response.setRetDesc("已存在该用户名");
			return JSON.toJSONString(response);
		}
		
		UserModel userModel = new UserModel();
		userModel.setUserName(pojo.getUserName());
		userModel.setPassword(pojo.getPassword());
		userModel.setGroupName(pojo.getGroupName());
		userModel.setDepartmentName(pojo.getDepartmentName());
		userModel.setDistrictName(pojo.getDistrictName());
		userModel.setRole(UserPriority.getCodeByDesc(pojo.getRole()));
		userModel.setUserInfo(pojo.getUserInfo());
		userModel.setCreateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		
		userDao.addEntity(userModel);
		response = new BaseResponse(ResultType.success);
		return JSON.toJSONString(response);
		
	}
	
	public String deleteUser(DeleteUserRequest pojo){
		
		BaseResponse response = new BaseResponse(ResultType.success);
		UserModel userModel = new UserModel();
		userModel.setId(pojo.getId());
		userModel.setUserName(pojo.getUserName());
		userModel.setCreateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		userDao.deleteEntity(userModel);
		
		return JSON.toJSONString(response);
		
	}
	
	public String updateUser(AddUserRequest pojo){
		
		BaseResponse response = new BaseResponse(ResultType.success);
		UserModel cond = new UserModel();
		cond.setUserName(pojo.getUserName());
		
		if(StringUtils.isBlank(pojo.getUserName())){
			return JSON.toJSONString(response);
		}
		
		List<UserModel> existUsers = userDao.findEntityByCond(cond);
		if(existUsers!= null && existUsers.size()>0){
			if(existUsers.get(0).getId().equals(pojo.getId())){
				response = new BaseResponse(ResultType.repeat);
				response.setRetDesc("已存在该用户名");
				return JSON.toJSONString(response);
				
			}
		}
		
		
		UserModel userModel = new UserModel();
		userModel.setId(pojo.getId());
		userModel.setUserName(pojo.getUserName());
		userModel.setPassword(pojo.getPassword());
		userModel.setGroupName(pojo.getGroupName());
		userModel.setDepartmentName(pojo.getDepartmentName());
		userModel.setDistrictName(pojo.getDistrictName());
		userModel.setRole(UserPriority.getCodeByDesc(pojo.getRole()));
		userModel.setUserInfo(pojo.getUserInfo());
		userModel.setCreateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		userDao.updateEntity(userModel);
		
		return JSON.toJSONString(response);
		
	}
	
	/**
	 * 查询用户详细信息
	 * @param pojo
	 * @return
	 */
	public String userDetail(GetUserDetailRequest pojo){
		
		LoginResponse loginResponse = null; 
		UserModel userModel = new UserModel();
//		userModel.setId(pojo.getId());
		userModel.setUserName(pojo.getUserName());
		List<UserModel> result = userDao.findEntityByCond(userModel);
		
		if(result == null || result.size() == 0){
			loginResponse = new LoginResponse(ResultType.invalidUser);
			return JSON.toJSONString(loginResponse);
		}
		
		for(int i=0;i<result.size(); i++){
			result.get(i).setRole(UserPriority.getDescByCode(result.get(i).getRole()));
		}
		
		loginResponse = new LoginResponse(ResultType.success);
		loginResponse.setUserModel(result.get(0));
		
		return JSON.toJSONString(loginResponse);
		
	}
	
	public String login(LoginRequest pojo){
		String msg = "";
		LoginResponse loginResponse = null;
		UserModel userModel = new UserModel();
		userModel.setPassword(pojo.getPassword());
		userModel.setUserName(pojo.getUserName());
		
		UsernamePasswordToken token = new UsernamePasswordToken(pojo.getUserName(), pojo.getPassword());  
	    token.setRememberMe(true);  
	    Subject subject = SecurityUtils.getSubject();  
	    
	    try {  
	        subject.login(token);  
	        if (subject.isAuthenticated()) {  
	        } else {  
	        	System.out.println("subject.isAuthenticated()=false");
	        	loginResponse = new LoginResponse(ResultType.invalidUser);
	        	
	        	return JSON.toJSONString(loginResponse);
	        }  
	    } catch (IncorrectCredentialsException e) {  
	        msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";  
	        System.out.println(msg);  
	    } catch (ExcessiveAttemptsException e) {  
	        msg = "登录失败次数过多";  
	        System.out.println(msg);  
	    } catch (LockedAccountException e) {  
	        msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";  
	        System.out.println(msg);  
	    } catch (DisabledAccountException e) {  
	        msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";  
	        System.out.println(msg);  
	    } catch (ExpiredCredentialsException e) {  
	        msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";  
	        System.out.println(msg);  
	    } catch (UnknownAccountException e) {  
	        msg = "帐号不存在. There is no user with username of " + token.getPrincipal();  
	        System.out.println(msg);  
	    } catch (UnauthorizedException e) {  
	        msg = "您没有得到相应的授权！" + e.getMessage();  
	    }  
		
		List<UserModel> result = userDao.findEntityByCond(userModel);
		
		if(result == null || result.size() == 0){
			loginResponse = new LoginResponse(ResultType.wrongPassword);
			return JSON.toJSONString(loginResponse);
		}
		
		//设置登录时间和ip
		UserModel updateModel = new UserModel();
		updateModel.setId(result.get(0).getId());
		updateModel.setLastLoginIp(pojo.getLastLoginIp());
		updateModel.setLastLoginTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		
		userDao.updateEntity(updateModel);
		
		//重新加工数据返回给前端页面
		result.get(0).setLastLoginIp(pojo.getLastLoginIp());
		result.get(0).setLastLoginTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		loginResponse = new LoginResponse(ResultType.success);
		loginResponse.setUserModel(result.get(0));
		
		return JSON.toJSONString(loginResponse);
		
	}
	
	/**
	 * 重置密码信息
	 * @param request
	 * @return
	 */
	public String resetPassword(ResetPasswordRequest request){
		
		BaseResponse response = null;
		UserModel userModel = new UserModel();
		userModel.setUserName(request.getUserName());
		userModel.setPassword(request.getOriginalPassword());
		
		List<UserModel> userModels = userDao.findEntityByCond(userModel);
		
		if(userModels == null || userModels.size() == 0){
			response = new BaseResponse(ResultType.wrongPassword);
			return JSON.toJSONString(response);
		}
		
		userModel.setId(userModels.get(0).getId());
		userModel.setPassword(request.getNewPassword());;
		userDao.updateEntity(userModel);
		response = new BaseResponse(ResultType.success);
		return JSON.toJSONString(response);
		
	}
	
	/**
	 * 用户列表
	 * @param pojo
	 * @return
	 */
	public String getUserList(GetUserListRequest pojo){
		UserListResponse response = new UserListResponse(ResultType.success);
		
		UserModel cond = new UserModel();
		cond.setDepartmentName(pojo.getDepartmentName());
		cond.setDistrictName(pojo.getDistrictName());
		cond.setGroupName(pojo.getGroupName());
		
		List<UserModel> list = userDao.findEntityByCond(cond);
		
		if(list != null){
			for(int i=0;i<list.size();i++){
				list.get(i).setRole(UserPriority.getDescByCode(list.get(i).getRole()));
			}
		}
		
		response.setList(list);
		return JSON.toJSONString(response);
		
	}
	
	/**
	 * 权限类型
	 * @return
	 */
	public String getPriorityList(){
		PriorityListResponse response = new PriorityListResponse(ResultType.success);
		
		Priority admin = new Priority();
		admin.setPriorityCode(Priority.adminCode);
		admin.setPriorityName(Priority.admin);
		
		Priority general = new Priority();
		general.setPriorityCode(Priority.generalCode);
		general.setPriorityName(Priority.general);
		response.getList().add(admin);
		response.getList().add(general);
		
		return JSON.toJSONString(response);
		
	}
	
	
	/************SimpleUser relative******************/
	/**
	 * 用户列表
	 * @param pojo
	 * @return
	 */
	public String getSimpleUserList(GetSimpleUserListRequest pojo){
		GtsUserListResponse response = new GtsUserListResponse(ResultType.success);
		
		SimpleUserModel cond = new SimpleUserModel();
		List<SimpleUserModel> list = simpleUserDao.findEntityByCond(cond);
		
		for(int i=0;i<list.size();i++){
			list.get(i).setPermissions(JSON.parseArray(list.get(i).getPermission(),String.class));
		}
		
		response.setList(list);
		return JSON.toJSONString(response);
	}
	
	/**
	 * 增加gts user
	 * @param pojo
	 * @return
	 */
	public String addSimpleUser(AddGtsUserRequest pojo,HttpServletRequest servlet){
		BaseResponse response = new BaseResponse(ResultType.success);
		
		SimpleUserModel cond = new SimpleUserModel();
		cond.setLastLoginIp(servlet.getRemoteHost());
		cond.setCreateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		cond.setCreateTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		cond.setPassword(pojo.getPassword());
		cond.setUserName(pojo.getUserName());
		cond.setPermission(JSON.toJSONString(pojo.getPermission()));
		simpleUserDao.addEntity(cond);
		
		return JSON.toJSONString(response);
	}
	
	/**
	 * 删除gts user
	 * @param pojo
	 * @return
	 */
	public String deleteGtsUser(String id){
		BaseResponse response = new BaseResponse(ResultType.success);
		
		SimpleUserModel cond = new SimpleUserModel();
		simpleUserDao.addEntity(cond);
		
		return JSON.toJSONString(response);
	}
	
	/**
	 * 更新单个gts user
	 * @param pojo
	 * @return
	 */
	public String updateGtsUser(AddGtsUserRequest pojo){
		BaseResponse response = new BaseResponse(ResultType.success);
		
		SimpleUserModel cond = new SimpleUserModel();
		
		cond.setId(pojo.getId());
		cond.setUserName(pojo.getUserName());
		cond.setPassword(pojo.getPassword());
		cond.setPermission(JSON.toJSONString(pojo.getPermission()));
		cond.reset();
		
		simpleUserDao.updateEntity(cond);
		
		return JSON.toJSONString(response);
	}
	
	/**
	 * 更新单个gts user
	 * @param pojo
	 * @return
	 */
	public String updateGtsUserList(UpdateGtsUserList pojo){
		BaseResponse response = new BaseResponse(ResultType.success);
		
		for(int i=0;i<pojo.getList().size();i++){
			SimpleUserModel cond = new SimpleUserModel();
			cond.setId(pojo.getList().get(i).getId());
			cond.setUserName(pojo.getList().get(i).getUserName());
			cond.setPermissions(pojo.getList().get(i).getPermission());
			simpleUserDao.updateEntity(cond);
		}
		
		return JSON.toJSONString(response);
	}
	
	
	
}
