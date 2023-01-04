package com.aqh.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.service.QnAService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/QnA")
@Slf4j
public class QnAController {

	@Autowired
	QnAService service;

	@GetMapping("/list")
	public String qnaBoardList(Model model) {
		List<BoardDTO> list = service.selectAll();
		int boardListCount = service.getBoardCnt();
		model.addAttribute("boardListCount", boardListCount);
		model.addAttribute("boardList", list);
		return "board/qna/qnaList";
	}

	@GetMapping("/listDetail")
	public String boardListDetail(long bNo, Model model) {
		service.readCntUp(bNo);
		BoardDTO boardDTO = service.selectDetail(bNo);
		model.addAttribute("boardDTO", boardDTO);
		return "board/qna/qnaListDetail";
	}
}
