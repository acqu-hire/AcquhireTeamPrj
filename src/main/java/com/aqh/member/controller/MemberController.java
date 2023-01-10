package com.aqh.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aqh.member.domain.dto.MemberDTO;
import com.aqh.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService service;
	
	@GetMapping("/register")
	public String registerForm() {
		return "member/register_form";
	}
	
	@PostMapping("/register")
	public String register(MemberDTO memberDTO) {
		service.register(memberDTO);
		return "redirect:/";
	}
}
