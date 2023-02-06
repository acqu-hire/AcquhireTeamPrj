package com.aqh.login.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aqh.member.domain.MemberDTO;
import com.aqh.member.service.MemberService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	MemberService service;
	
	@GetMapping("/login")
	public String loginForm() {
		return "login/login_form";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		session.invalidate();
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("id")) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(MemberDTO memberDTO, String requestURL, boolean rememberId, HttpServletRequest request, HttpServletResponse response) {
		
		if(!loginCheck(memberDTO.getId(), memberDTO.getPassword())) {
			try {
				String msg = URLEncoder.encode("ID 또는 비밀번호가 일치하지 않습니다.", "utf-8");
				return "redirect:/login/login?msg="+msg;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return "redirect:/";
			}

		}
		HttpSession session = request.getSession();
		session.setAttribute("name", service.memberDetail(memberDTO.getId()).getName());
		session.setAttribute("id", memberDTO.getId());
		
		if(rememberId) {
			Cookie cookie = new Cookie("id", memberDTO.getId());
			response.addCookie(cookie);
		} else {
			// 혹시 모를 쿠키 비워주기
			Cookie cookie = new Cookie("id", memberDTO.getId());
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		requestURL = requestURL!=null?requestURL:"";
		return "redirect:/"+requestURL;
	}

	private boolean loginCheck(String id, String password) {
		MemberDTO member = service.memberDetail(id);
		
		return member != null && member.getPassword().equals(password);
	}
}
