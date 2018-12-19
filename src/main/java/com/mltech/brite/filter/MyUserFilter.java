package com.mltech.brite.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.mltech.brite.constant.Constant;

public class MyUserFilter implements Filter {

	/**
	 * 如果用户未登录，则重定向到指定的页面，URL不包括 ContextPath
	 */

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("htmllanjie");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("htmllanjie");
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;

		// 获得Session
		HttpSession session = servletRequest.getSession();
		// 判断sessionKey 是否为空
		servletResponse.sendRedirect(Constant.redirectUrl);
		return;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
