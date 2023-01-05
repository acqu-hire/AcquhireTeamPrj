package com.aqh.board.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.BoardDTO.Category;
import com.aqh.board.service.QnAService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/QnA")
public class QnAController {

	@Autowired
	QnAService service;
	
	@GetMapping("/list")
	public String qnaList(Model model, BoardDTO boardDTO,@RequestParam(required = false) Category category) {
		boardDTO.setCategory(category);
		List<BoardDTO> list = service.selectAll(boardDTO);
		int boardListCount = service.getBoardCnt(boardDTO);
		log.info("boardListCount = " + boardListCount);
		model.addAttribute("boardListCount", boardListCount);
		model.addAttribute("boardList", list);
		return "board/qna/qna_list";
	}

	@GetMapping("/listDetail")
	public String qnaListDetail(long bNo, Model model) {
		BoardDTO boardDTO = service.selectDetail(bNo);
		log.info("boardDTO = " + boardDTO);
		log.info("before readCount = " + boardDTO.getReadCount());
		service.readCntUp(bNo);
		log.info("after readCount = " + boardDTO.getReadCount());
		model.addAttribute("boardDTO", boardDTO);
		return "board/qna/qna_list_detail";
	}
	
	@GetMapping("/write")
	public String qnaInsertForm() {
		log.info("게시글 작성 폼 이동");
		return "board/qna/qna_write";
	}
	
	@PostMapping("/write")
	public String qnaInsert(BoardDTO boardDTO, @RequestParam(required = false) Category category) {
		boardDTO.setCategory(category);
		String id = "aaaa"; // 임시
		boardDTO.setId(id);
		log.info("폼 입력값 = " + boardDTO);
		service.insert(boardDTO);
		return "redirect:/QnA/list";
	}
	
	@GetMapping("/update")
	public String qnaUpdateForm(long bNo, Model model) {
		BoardDTO boardDTO = service.selectDetail(bNo);
		log.info("boardDTO = " + boardDTO);
		log.info("게시글 수정 폼 이동");
		model.addAttribute("boardDTO", boardDTO);
		return "board/qna/qna_update_form";
	}
	
	@PostMapping("/update")
	public String qnaUpdate(BoardDTO boardDTO) {
		log.info("수정 내용 = " + boardDTO);
		service.update(boardDTO);
		return "redirect:/QnA/list";
	}
	
	@GetMapping("/delete")
	public String qnaDelete(long bNo) {
		service.delete(bNo);
		log.info("게시글 삭제 완료");
		return "redirect:/QnA/list";
	}
}
