package com.mltech.brite.security;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mltech.brite.dao.user.UserDao;
import com.mltech.brite.model.UserModel;
import com.mysql.jdbc.StringUtils;

/**
 * 该类是AuthenticationProvider的实现类DaoAuthenticationProvider中进行验证的依赖类，DaoAuthenticationProvider实现了AuthenticationProvider
 * 的authenticate方法，并且在该方法中通过UserDetailsService来获取用户的信息进行验证，authenticate中使用UserDetails对象来验证，
 * 而UserDetails的获取是通过UserDetailsService来提供的。即DaoAuthenticationProvider已经通过UserDetailsService类把整个验证逻辑对开发者进行了一些简化，减轻了开发者的负担。
 * 开发者只需要去实现UserDetailsService的接口即可。
 * @author user
 *
 */

public class MyUserDetailService implements UserDetailsService{

	@Resource
	UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		if(StringUtils.isNullOrEmpty(username)){
			return null;
		}
		
		//根据用户名获取数据库中用户的用户名和密码信息，数据库中密码以密文存储
		UserModel cond = new UserModel();
		cond.setUserName(username);
		List<UserModel> list = userDao.findEntityByCond(cond);
		if (list ==null || list.size() == 0){
			return null;
		}else{
			//查询获取该用户对应的权限信息
			List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			
			org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(
					list.get(0).getUserName(),
					list.get(0).getPassword(),
					true,
					true,
					true,
					true,
					grantedAuthorities
					);
			return userDetails;
		}
		
	}
	
}
