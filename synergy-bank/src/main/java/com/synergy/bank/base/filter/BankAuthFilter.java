package com.synergy.bank.base.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.synergy.bank.customer.web.constant.NavigationConstant;

/**
 * Servlet Filter implementation class MailFilter
 */
public class BankAuthFilter implements Filter {

	/*
	 * Initiate Logger for this class
	 */
	private static final Log logger = LogFactory.getLog(BankAuthFilter.class);

	private Set<String> allowedUrls = new HashSet<String>();

	public BankAuthFilter() {
	}

	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request2 = (HttpServletRequest) request;
		String clientIP=request2.getRemoteAddr();
		String remoteHost = request2.getRemoteHost();
		logger.debug(" clientIP = "+clientIP);
		logger.debug(" remoteHost = "+remoteHost);
		String url = request2.getServletPath();
		// logger.debug("url = "+url);
		String pathInfo = request2.getPathInfo();
		if (pathInfo != null) {
			url = url + pathInfo;
		}
		logger.debug("pathinfo = " + pathInfo);
		logger.debug("curl = " + url);
		// String username=request2.getParameter("username");
		// logger.debug("username = "+username);
		// return
		HttpSession session = request2.getSession(false);
		if (session == null
				|| session.getAttribute(NavigationConstant.USER_SESSION_DATA) == null) {
			// means user is not authenticated
			String tokens[]=url.split("[.]+");
			if(tokens!=null && tokens.length>1){
				url="."+tokens[1];
			}
			logger.debug(" after split url= " + url);
			if (allowedUrls.contains(url)) {
				chain.doFilter(request, response);
			} else {
				logger.debug("YYY= " + request2.getContextPath() + "/login.jsp");
				HttpServletResponse response2 = (HttpServletResponse) response;
				response2
						.sendRedirect(request2.getContextPath()
								+ "/bank/auth?error=Your session is time out, please login in once again");
			}
		} else {
			// go ahead
			chain.doFilter(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		 String allowAccess=fConfig.getInitParameter("allowAccess"); 
		 String aurls[]=allowAccess.split(",");
		 allowedUrls.addAll(Arrays.asList(aurls));
	}

}
