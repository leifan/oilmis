package com.mltech.brite.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * <p>自定义验证服务类</p>
 * AuthenticationProvider是spring-security中非常重要的类，作用在于进行用户身份验证。
 * 用户的请求首先被拦截器拦截后，进入身份验证阶段。spring-security默认提供了多种不同的验证方式：
 * （1）配置文件身份验证，即内存验证方式
 * （2）spring-security格式数据库验证
 * （3）用户自定义验证方式
 *	Authentication类的含义是：每次一个请求经过验证之后，都会有一个结果，这个验证的结果用Authentication来表示其信息。
 * 一旦当前请求被验证成功，那么验证信息会存入到一个threadlocal中，这个threadlocal由SecurityContext管理（属性）
 * @author user
 */
public class MyAuthenticationProvider implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
//		authentication.getAuthorities() //获取权限信息
		
		//查询数据库信息验证当前用户是否合法，以及当前访问路径是否具有权限，如果验证失败，则返回为空
		
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
