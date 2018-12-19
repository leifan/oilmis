package com.mltech.brite.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

/**
 * 登录失败相关事情操作
 * @author user
 *
 */
public class LoginAuthenticationFailHandler implements AuthenticationFailureHandler{

	/**
	 * 登录失败后跳转的url
	 */
	private String defaultFailureUrl;
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationFailure(HttpServletRequest servletRequest,
			HttpServletResponse servletResponse, AuthenticationException arg2)
			throws IOException, ServletException {
		
		redirectStrategy.sendRedirect(servletRequest, servletResponse, defaultFailureUrl);
	}

	public String getDefaultFailureUrl() {
		return defaultFailureUrl;
	}

	public void setDefaultFailureUrl(String defaultFailureUrl) {
		this.defaultFailureUrl = defaultFailureUrl;
	}

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

}
