package com.aqh.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aqh.member.domain.MemberDTO;
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
	public int idCheck(@RequestParam String id) {
		int result = service.idCheck(id);
		return result;
	}
	
	@PostMapping("/pwdCheck")
	@ResponseBody
	public int pwdCheck(@ModelAttribute MemberDTO memberDTO) {
		int result = service.pwdCheck(memberDTO);
		return result;
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute MemberDTO memberDTO) {
		service.register(memberDTO);
		return "redirect:/";
	}
	
	@GetMapping("/detail")
	public String memberDetailForm(@RequestParam String id, 
								   @ModelAttribute MemberDTO memberDTO, 
								   Model model, HttpSession session) throws Exception {
		if(!session.getAttribute("id").equals(id) && !session.getAttribute("id").equals("admin")) {
			String msg = "잘못된 접근입니다.";
			model.addAttribute("msg", msg);
			return "redirect:/";
		} else {
			memberDTO = service.memberDetail(id);
			model.addAttribute(memberDTO);
			return "member/member_info";
		}
	}
	
	@PostMapping("/delete")
	public String memberDelete(@RequestParam String id, HttpSession session) {
		service.memberDelete(id);
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/update")
	public String memberUpdateForm(@RequestParam String id, Model model) {
		MemberDTO memberDTO = service.memberDetail(id);
		model.addAttribute(memberDTO);
		return "member/member_update_form";
	}
	
	@PostMapping("/update")
	public String memberUpdate(@ModelAttribute MemberDTO memberDTO, 
								Model model, HttpSession session) {
		service.memberUpdate(memberDTO);
		memberDTO = service.memberDetail(memberDTO.getId());
		session.setAttribute("name", memberDTO.getName());
		model.addAttribute(memberDTO);
		return "member/member_info";
	}
}
