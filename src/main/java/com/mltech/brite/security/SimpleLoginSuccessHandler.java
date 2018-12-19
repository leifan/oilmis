package com.mltech.brite.security;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.mltech.brite.dao.user.UserDao;
import com.mltech.brite.model.UserModel;
import com.mltech.brite.util.DateUtil;
import com.mltech.brite.util.IPUtil;

/**
 * 登录成功后后续处理，记录用户ip登录时间等信息
 * @author user
 *
 */
public class SimpleLoginSuccessHandler implements AuthenticationSuccessHandler,InitializingBean{

	@Resource
	UserDao  userDao;
	
	protected Log logger = LogFactory.getLog(getClass());

	/**
	 * 默认跳转页面
	 */
	private String defaultTargetUrl;

	private boolean forwardToDestination = false;

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void afterPropertiesSet() throws Exception {
		if(StringUtils.isEmpty(defaultTargetUrl))  
            throw new Exception("You must configure defaultTargetUrl");  
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest httpRequest,
			HttpServletResponse httpResponse, Authentication authentication) throws IOException,
			ServletException {

		//记录登录IP和时间信息
		UserModel userModel = new UserModel();
		userModel.setUserName((String)authentication.getPrincipal());
		String ipString = IPUtil.getIpAddress(httpRequest);
		userModel.setLastLoginIp(ipString);
		userModel.setLastLoginTime(DateUtil.convertToYYYYMMDDHHMMSS(System.currentTimeMillis()));
		userDao.updateEntity(userModel);
		
		if(this.forwardToDestination){  
            logger.info("Login success,Forwarding to "+this.defaultTargetUrl);  
              
            httpRequest.getRequestDispatcher(this.defaultTargetUrl).forward(httpRequest, httpResponse);  
        }else{  
            logger.info("Login success,Redirecting to "+this.defaultTargetUrl);  
              
            this.redirectStrategy.sendRedirect(httpRequest, httpResponse, this.defaultTargetUrl);  
        }  
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public Log getLogger() {
		return logger;
	}

	public void setLogger(Log logger) {
		this.logger = logger;
	}

	public String getDefaultTargetUrl() {
		return defaultTargetUrl;
	}

	public void setDefaultTargetUrl(String defaultTargetUrl) {
		this.defaultTargetUrl = defaultTargetUrl;
	}

	public boolean isForwardToDestination() {
		return forwardToDestination;
	}

	public void setForwardToDestination(boolean forwardToDestination) {
		this.forwardToDestination = forwardToDestination;
	}

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}
	
}
