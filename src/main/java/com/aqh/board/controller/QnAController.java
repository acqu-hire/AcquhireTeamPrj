package com.aqh.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/QnA")
public class QnAController {

	@GetMapping("/QnAList")
	public String qnaBoardList() {
		return "board/qnaBoardList";
	}
}
