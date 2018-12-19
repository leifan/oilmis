package com.mltech.brite.shiro.security;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

import com.mltech.brite.dao.user.UserDao;
import com.mltech.brite.model.UserModel;

@Service
public class MyShiro extends AuthorizingRealm{

	@Resource
    private UserDao userDao; 
	
	/** 
     * 权限认证 
     */ 
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		//获取登录时输入的用户名  
        String loginName=(String) principalCollection.fromRealm(getName()).iterator().next();  
   
        //到数据库查是否有此对象  
        UserModel cond = new UserModel();
        cond.setUserName(loginName);
        
        List<UserModel> result = userDao.findEntityByCond(cond);
        
        if(result != null && result.size() > 0){  
            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）  
            SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();  
            //用户的角色集合  
            Set<String> roleSet = new TreeSet<String>();
            roleSet.add("admin");
            info.setRoles(roleSet);
            //用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要  
            Set<String> permissionSet = new TreeSet<String>();
            permissionSet.add("add");
            info.setStringPermissions(permissionSet);  
            return info;  
        }  
		return null;
	}

	/**
	 * 登录认证;
	 * */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		
		 UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
		 UserModel cond = new UserModel();
	     cond.setUserName(token.getUsername());
	     cond.setPassword(new String(token.getPassword()));
	     List<UserModel> result = userDao.findEntityByCond(cond);
	     if(result != null && result.size() > 0){  
	    	 return new SimpleAuthenticationInfo(result.get(0).getUserName(), result.get(0).getPassword(), getName());  
	     }
		 
		return null;
	}

}
