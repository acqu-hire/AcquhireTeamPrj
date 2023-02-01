package com.aqh.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String member = (String)request.getSession().getAttribute("id");
		String requestURL = request.getRequestURI();
		String contextPath = request.getContextPath();
		requestURL = requestURL.substring(contextPath.length()+1);
		if(request.getQueryString()!=null) {
			requestURL += "?" + request.getQueryString();
		}
		if(member == null) {
			request.getSession().setAttribute("requestURL", requestURL);
			response.sendRedirect("/login/login");
			return false;
		}
		return true;
	}
	
}
