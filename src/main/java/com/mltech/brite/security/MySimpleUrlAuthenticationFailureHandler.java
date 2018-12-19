package com.mltech.brite.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

/**
 * spring-security验证失败处理逻辑
 * 
 * @author user
 *
 */
public class MySimpleUrlAuthenticationFailureHandler implements
		AuthenticationFailureHandler {

	protected final Log logger = LogFactory.getLog(getClass());

	private String defaultFailureUrl = "/cloudAdmin/login.html";
	private boolean forwardToDestination = false;
	private boolean allowSessionCreation = true;
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	private String LOCAL_SERVER_URL="";

	public MySimpleUrlAuthenticationFailureHandler() {
	}

	public MySimpleUrlAuthenticationFailureHandler(String defaultFailureUrl) {
		setDefaultFailureUrl(defaultFailureUrl);
	}

	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		// 认证失败区别前后台：LOGIN URL
		if (request.getParameter("spring-security-redirect") != null) {
			request.getSession().setAttribute("callUrlFailure",
					request.getParameter("spring-security-redirect"));
		}
		// 若有loginUrl 则重定向到后台登录界面
		if (request.getParameter("loginUrl") != null
				&& !"".equals(request.getParameter("loginUrl"))) {
			defaultFailureUrl = LOCAL_SERVER_URL
					+ "/cloudAdmin/login.html";
		}
		// defaultFailureUrl 默认的认证失败回调URL
		if (defaultFailureUrl == null) {
			logger.debug("No failure URL set, sending 401 Unauthorized error");
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
					"Authentication Failed: " + exception.getMessage());
		} else {
			saveException(request, exception);
			if (forwardToDestination) {
				logger.debug("Forwarding to " + defaultFailureUrl);
				request.getRequestDispatcher(defaultFailureUrl).forward(
						request, response);
			} else {
				logger.debug("Redirecting to " + defaultFailureUrl);
				redirectStrategy.sendRedirect(request, response,
						defaultFailureUrl);
			}
		}
	}
	
	protected final void saveException(HttpServletRequest request, AuthenticationException exception) {  
        if (forwardToDestination) {  
            request.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception);  
        } else {  
            HttpSession session = request.getSession(false);  
  
            if (session != null || allowSessionCreation) {  
                request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception);  
            }  
        }  
    }

	public String getDefaultFailureUrl() {
		return defaultFailureUrl;
	}

	public void setDefaultFailureUrl(String defaultFailureUrl) {
		this.defaultFailureUrl = defaultFailureUrl;
	}

	public boolean isForwardToDestination() {
		return forwardToDestination;
	}

	public void setForwardToDestination(boolean forwardToDestination) {
		this.forwardToDestination = forwardToDestination;
	}

	public boolean isAllowSessionCreation() {
		return allowSessionCreation;
	}

	public void setAllowSessionCreation(boolean allowSessionCreation) {
		this.allowSessionCreation = allowSessionCreation;
	}

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	public String getLOCAL_SERVER_URL() {
		return LOCAL_SERVER_URL;
	}

	public void setLOCAL_SERVER_URL(String lOCAL_SERVER_URL) {
		LOCAL_SERVER_URL = lOCAL_SERVER_URL;
	}

	public Log getLogger() {
		return logger;
	}  

}
