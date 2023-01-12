package com.aqh.reply.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aqh.reply.domain.dao.ReplyDAO;
import com.aqh.reply.domain.dto.ReplyDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 댓글Controller
 * 
 * @author Devesg
 * @since 23.01.11
 * 
 */
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/reply")
@Controller
public class ReplyController {

	private final ReplyDAO replyDAO;

	@PostMapping(value = "/write")
	public String getMethodName(ReplyDTO replyDTO) {
		System.out.println("12");
		System.out.println(replyDTO.toString());
		return "redirect:/community/selectdetail_view?bNo=" + replyDTO.getBNo();
	}

}
