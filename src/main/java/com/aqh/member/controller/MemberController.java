package com.aqh.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aqh.member.domain.dto.MemberDTO;
import com.aqh.member.service.MemberService;


@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService service;
	
	@GetMapping("/register")
	public String registerForm() {
		return "member/register_form";
	}
	
	@PostMapping("/idCheck")
	@ResponseBody
	public int idCheck(String id) {
		int result = service.idCheck(id);
		return result;
	}
	
	@PostMapping("/register")
	public String register(MemberDTO memberDTO) {
		service.register(memberDTO);
		return "redirect:/";
	}
	
	@GetMapping("/detail")
	public String memberDetailForm(String id, Model model, MemberDTO memberDTO) {
		memberDTO = service.memberDetail(id);
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
		model.addAttribute(memberDTO);
		return "member/member_update_form";
	}
	
	@PostMapping("/update")
	public String memberUpdate(MemberDTO memberDTO, Model model, HttpSession session) {
		service.memberUpdate(memberDTO);
		memberDTO = service.memberDetail(memberDTO.getId());
		session.setAttribute("name", memberDTO.getName());
		model.addAttribute(memberDTO);
		return "member/member_info";
	}
}
