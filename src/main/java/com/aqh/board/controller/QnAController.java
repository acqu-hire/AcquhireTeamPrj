package com.aqh.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.service.QnAService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/QnA")
public class QnAController {

	@Autowired
	QnAService service;

	@GetMapping("/list")
	public String qnaList(Model model) {
		List<BoardDTO> list = service.selectAll();
		int boardListCount = service.getBoardCnt();
		log.info("boardListCount = " + boardListCount);
		model.addAttribute("boardListCount", boardListCount);
		model.addAttribute("boardList", list);
		return "board/qna/qna_list";

	}

	@GetMapping("/listDetail")
	public String qnaListDetail(long bNo, Model model) {
		service.readCntUp(bNo);
		BoardDTO boardDTO = service.selectDetail(bNo);
		log.info("boardDTO = " + boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		return "board/qna/qna_list_detail";
	}
	
	@GetMapping("/write")
	public String qnaInsertForm() {
		return "board/qna/qna_write";
	}
	
	@PostMapping("/write")
	public String qnaInsert(BoardDTO boardDTO) {
		String id = "aaaa"; // 임시
		boardDTO.setId(id);
		service.insert(boardDTO);
		return "redirect:/QnA/list";
	}
	
	@GetMapping("/update")
	public String qnaUpdateForm(long bNo, Model model) {
		BoardDTO boardDTO = service.selectDetail(bNo);
		model.addAttribute("boardDTO", boardDTO);
		return "board/qna/qna_update_form";
	}
	
	@PostMapping("/update")
	public String qnaUpdate(BoardDTO boardDTO) {
		service.update(boardDTO);
		return "redirect:/QnA/list";
	}
	
	@GetMapping("/delete")
	public String qnaDelete(long bNo) {
		service.delete(bNo);
		return "redirect:/QnA/list";
	}
}
