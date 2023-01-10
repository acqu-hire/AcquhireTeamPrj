package com.aqh.member.controller;

import java.util.StringJoiner;

import javax.servlet.http.HttpSession;

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
	
	@GetMapping("/detail")
	public String memberDetailForm(String id, Model model, MemberDTO memberDTO) {
		memberDTO = service.memberDetail(id);
		log.info("memberDTO = " + memberDTO);
		model.addAttribute(memberDTO);
		return "member/member_info";
	}
	
	@PostMapping("/delete")
	public String memberDelete(String id, HttpSession session) {
		service.memberDelete(id);
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/update")
	public String memberUpdateForm(Model model, String id) {
		MemberDTO memberDTO = service.memberDetail(id);
		log.info("memberDTO = " + memberDTO);
		model.addAttribute(memberDTO);
		return "member/member_update_form";
	}
	
	@PostMapping("/update")
	public String memberUpdate(MemberDTO memberDTO, Model model, HttpSession session) {
		log.info("memberDTO = " + memberDTO);
		service.memberUpdate(memberDTO);
		memberDTO = service.memberDetail(memberDTO.getId());
		session.setAttribute("name", memberDTO.getName());
		model.addAttribute(memberDTO);
		return "member/member_info";
	}
}
