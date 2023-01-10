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

import com.aqh.member.domain.dto.MemberDTO;
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
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(String id, String password, boolean rememberId, HttpServletRequest request, HttpServletResponse response) {
		
		if(!loginCheck(id, password)) {
			String msg;
			try {
				msg = URLEncoder.encode("ID 또는 비밀번호가 일치하지 않습니다.", "utf-8");
				return "redirect:/login/login?msg="+msg;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return "redirect:/exception/error404";
			}

		}
		HttpSession session = request.getSession();
		session.setAttribute("name", service.memberDetail(id).getName());
		session.setAttribute("id", id);
		
		if(rememberId) {
			Cookie cookie = new Cookie("id", id);
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		return "redirect:/";
	}

	private boolean loginCheck(String id, String password) {
		MemberDTO member = service.memberDetail(id);
		
		return member != null && member.getPassword().equals(password);
	}
}
