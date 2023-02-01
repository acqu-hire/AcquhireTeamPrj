package com.aqh.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.aqh.member.domain.MemberDTO;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String member = (String)request.getSession().getAttribute("id");
		if(member == null) {
			response.sendRedirect("/login/login");
			return false;
		}
		return true;
	}
	
}
