package com.aqh.member.controller;

import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String register(MemberDTO memberDTO, String postalcode, String addressDetail, String addressExtra) {
		StringJoiner address = new StringJoiner(" ");
		address.add(postalcode);
		address.add(memberDTO.getAddress());
		address.add(addressDetail);
		address.add(addressExtra);
		
		String fullAddress = address.toString();
		memberDTO.setAddress(fullAddress);
		service.register(memberDTO);
		log.info("memberDTO = " + memberDTO);
		return "redirect:/";
	}
	
	@GetMapping("/memberDetail")
	public String memberDetail(String id, Model model) {
		MemberDTO memberDTO = service.memberDetail(id);
		model.addAttribute(memberDTO);
		return "member/member_info";
	}
}
