package com.aqh.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.BoardDTO.Category;
import com.aqh.board.domain.pagehandler.PageHandler;
import com.aqh.board.domain.pagehandler.SearchCondition;
import com.aqh.board.service.QnAService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/QnA")
public class QnAController {

	@Autowired
	QnAService service;

	@GetMapping("/list")
	public String qnaList(Model model, SearchCondition sc) {
		
		PageHandler ph = new PageHandler(sc, service.getBoardCnt(sc));
		log.info("ph = " + ph);
		log.info("sc = " + sc);
		List<BoardDTO> list = service.selectAll(sc);
		model.addAttribute("ph", ph);
		model.addAttribute("boardList", list);
		return "board/qna/qna_list";
	}

	@GetMapping("/listDetail")
	public String qnaListDetail(long bNo, Model model, SearchCondition sc) {
		BoardDTO boardDTO = service.selectDetail(bNo);
		service.readCntUp(bNo);
		model.addAttribute(boardDTO);
		model.addAttribute("ph", new PageHandler(sc, service.getBoardCnt(sc)));
		return "board/qna/qna_list_detail";
	}

	@GetMapping("/write")
	public String qnaInsertForm() {
		return "board/qna/qna_write";
	}

	@PostMapping("/write")
	public String qnaInsert(BoardDTO boardDTO) {
		String id = "bacd"; // 임시
		boardDTO.setId(id);
		service.insert(boardDTO);
		System.out.println("boardDTO = " + boardDTO);
		return "redirect:/QnA/list";
	}

	@GetMapping("/update")
	public String qnaUpdateForm(long bNo, Model model) {
		BoardDTO boardDTO = service.selectDetail(bNo);
		Category category = service.selectDetail(bNo).getCategory();
		System.out.println("category = " + category);
		model.addAttribute("boardDTO", boardDTO);
		System.out.println("boardDTO = " + boardDTO);
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
