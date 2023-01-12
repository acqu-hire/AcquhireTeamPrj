package com.aqh.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
			model.addAttribute("ph", ph);
			log.info("ph = " + ph);
			
			List<BoardDTO> list = service.selectAll(sc);
			model.addAttribute("boardList", list);
			log.info("sc = " + sc);
			
			return "board/qna/qna_list";
		
	}

	@GetMapping("/listDetail")
	public String qnaListDetail(long bNo, Model model, SearchCondition sc, BoardDTO boardDTO) {
		
			service.readCntUp(bNo);
			boardDTO = service.selectDetail(bNo);
			
			model.addAttribute(boardDTO);
			log.info("boardDTO = " + boardDTO);

			model.addAttribute("sc", sc);
			log.info("sc = " + sc);
			
			return "board/qna/qna_list_detail";
	}

	@GetMapping("/write")
	public String qnaInsertForm(Model model, SearchCondition sc) {
		model.addAttribute("sc", sc);
		
		return "board/qna/qna_write_form";
	}

	@PostMapping("/write")
	public String qnaInsert(BoardDTO boardDTO, Category category, Model model) {
		log.info("boardDTO = " + boardDTO);
		log.info("category = " + category);
		
		service.insert(boardDTO);
		model.addAttribute(category);
		
		return "redirect:/QnA/list";
		
	}

	@GetMapping("/update")
	public String qnaUpdateForm(long bNo, Model model, SearchCondition sc) {
		log.info("sc = " + sc);
		model.addAttribute("sc", sc);
		
		BoardDTO boardDTO = service.selectDetail(bNo);
		model.addAttribute(boardDTO);
		log.info("boardDTO = " + boardDTO);
		
		return "board/qna/qna_update_form";
		
	}

	@PostMapping("/update")
	public String qnaUpdate(BoardDTO boardDTO, SearchCondition sc) {
		
			service.update(boardDTO);

			return "redirect:/QnA/list"+sc.getQueryString();
	}

	@PostMapping("/delete")
	public String qnaDelete(Integer bNo, RedirectAttributes rattr, SearchCondition sc) {
		log.info("sc = " + sc);
		service.delete(bNo);
		
		return "redirect:/QnA/list"+sc.getQueryString();
	}
}

