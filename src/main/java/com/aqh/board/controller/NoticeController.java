package com.aqh.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.BoardDTO.Category;
import com.aqh.board.domain.dto.CriteriaNotice;
import com.aqh.board.domain.pagehandler.PaginationNotice;
import com.aqh.board.service.NoticeService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/notice")
@Slf4j
public class NoticeController {
	

	@Autowired
	private NoticeService noticeService;


	@GetMapping(value = "/select_all_view")
	public String menuSelectAll(Model model, CriteriaNotice criteriaNotice) {
		
		
		model.addAttribute("menuSelectAll", noticeService.menuSelectAll(criteriaNotice));
		model.addAttribute("PaginationNotice", new PaginationNotice( criteriaNotice, (int) noticeService.BoardListAllCount(criteriaNotice)));
		log.info("전체조회 카운트"+noticeService.BoardListAllCount(criteriaNotice));
		log.info("전체조회"+model);
		
		
		/*model.addAttribute("selectbt", num);
		PagenationNotice pagenationNotice = new PagenationNotice();
		pagenationNotice.setNum(num);
		pagenationNotice.setCount(noticeService.BoardListAllCount());
		model.addAttribute("pagenationNotice", pagenationNotice);
		
		List<BoardDTO> list = null;
		
		model.addAttribute("menuSelectAll", list);*/

		return "board/notice/noticeList";
	}

	@GetMapping(value = "/select_category_view")
	public String categorySelectAll(Model model, CriteriaNotice criteriaNotice) {
		
		model.addAttribute("categorySelectAll", noticeService.categorySelectAll(criteriaNotice));
		model.addAttribute("PaginationNotice", new PaginationNotice(criteriaNotice, (int) noticeService.CategoryListCount(criteriaNotice)));
		
		return "board/notice/noticeCategoryList";
	}


	@GetMapping(value = "/select_Detail_view")
	public String noticeSelectDetail(Model model, Integer bNo) {
		log.info("게시판 내용 1차 확인");
		noticeService.noticeReadCount(bNo);
		model.addAttribute("selectDetail", noticeService.selectDetail(bNo));
		log.info("게시판 내용 보기" + model);
		return "board/notice/noticeListDetail";
	}
	
	
	@GetMapping(value = "/insert_view")
	public String insertView() {
		return "board/notice/noticeInsert";
	}
	
	
	@PostMapping(value = "/insert")	
	public String insert(Model model, BoardDTO boardDTO) {	
			
			Category selectCategory;
			if (boardDTO.getCategory().toString().equals("NOTICE_NOTICE"))
				selectCategory = Category.NOTICE_NOTICE;
			else
				selectCategory = Category.NOTICE_EVENT;
			
			boardDTO.setCategory(selectCategory);
			
			log.info("글 등록 정보" + boardDTO);
			noticeService.insert(boardDTO);

		
		return "redirect:/notice/select_all_view";
	}
	
	
	@GetMapping(value = "/update_view")
	public String updateView(Model model,Integer bNo) {
		model.addAttribute("boardDTO", noticeService.selectDetail(bNo));
		return "board/notice/noticeUpdate";
	}
	
	@PostMapping(value = "/update")	
	public String update(Model model, BoardDTO boardDTO) {
		
		log.info("글 수정 1차 확인" + boardDTO);
		Category selectCategory;
		if (boardDTO.getCategory().toString().equals("NOTICE_NOTICE"))
			selectCategory = Category.NOTICE_NOTICE;
		else
			selectCategory = Category.NOTICE_EVENT;
		log.info("글 수정 2차 확인" + boardDTO);
		boardDTO.setCategory(selectCategory);
		log.info("글 수정 정보" + boardDTO);
		noticeService.update(boardDTO);
		
		return "redirect:/notice/select_all_view";
	}
	
	@GetMapping(value = "/delete")
	public String delete(Model model,Integer bNo) {
		noticeService.delete(bNo);

		return "redirect:/notice/select_all_view";
	}
	

}
