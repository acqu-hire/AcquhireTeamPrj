package com.aqh.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.service.QnAService;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;


@Controller
@RequestMapping("/QnA")
public class QnAController {

	@Autowired
	QnAService service;
	
	@GetMapping("/list")
	public String qnaBoardList() {
		return "board/qnaList";
	}
	
	@GetMapping("/listDetail")
	public String boardListDetail(long bNo, Model model) {
		BoardDTO boardDTO = service.selectDetail(bNo);
		model.addAttribute("boardDTO", boardDTO);
		return "board/qna/qnaListDetail";
	}
}
