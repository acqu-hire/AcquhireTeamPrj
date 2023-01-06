package com.aqh.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.BoardDTO.Category;
import com.aqh.board.domain.dto.BoardDTO.Menu;
import com.aqh.board.service.NoticeService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/notice")
@Slf4j
public class NoticeController {
	

	@Autowired
	private NoticeService noticeService;


	@GetMapping(value = "/select_all_view")
	public String menuSelectAll(Model model) {
		model.addAttribute("menuSelectAll", noticeService.menuSelectAll("NOTICE"));
		model.addAttribute("boardAllCount", noticeService.BoardListAllCount());
		log.info("게시판 전체 보기" + model);
		return "board/notice/noticeList";
	}

	@GetMapping(value = "/select_category_view")
	public String categorySelectAll(Model model, String category) {
		model.addAttribute("categorySelectAll", noticeService.categorySelectAll(category));
		model.addAttribute("boardCategoryCount", noticeService.CategoryListCount(category));
		log.info("카테고리 게시판 전체 보기" + model);
		return "/board/notice/noticeCategoryList";
	}


	@GetMapping(value = "/select_Detail_view")
	public String noticeSelectDetail(Model model, Integer bNo) {
		model.addAttribute("selectDetail", noticeService.selectDetail(bNo));
		log.info("게시판 내용 보기" + model);
		return "/board/notice/noticeListDetail";
	}
	
	@GetMapping(value = "/insert_view")
	public String insertView() {
		return "/board/notice/noticeInsert";
	}
	
	@PostMapping(value = "/insert")	
	public String insert(Model model, String id, String title, String contents, String category) {

		Category selectCategory;
		if (category.equals("NOTICE_NOTICE"))
			selectCategory = Category.NOTICE_NOTICE;
		else
			selectCategory = Category.NOTICE_EVENT;
		
		BoardDTO boardDTO = BoardDTO.builder()
				.id(id)
				.menu(Menu.NOTICE)
				.title(title)
				.contents(contents)
				.category(selectCategory)
				.build();
		
		log.info("글 등록 정보" + boardDTO);
		noticeService.insert(boardDTO);
		model.addAttribute("menuSelectAll", noticeService.menuSelectAll("NOTICE"));
		
		return "board/notice/noticeList";
	}
	
	@GetMapping(value = "/update_view")
	public String updateView(Model model,Integer bNo) {
		model.addAttribute("boardDTO", noticeService.selectDetail(bNo));
		return "/board/notice/noticeUpdate";
	}
	
	@PostMapping(value = "/update")	
	public String update(Model model,String title, String contents, String category, Integer bNo) {
		log.info("글 수정 1차 확인");
		Category selectCategory;
		if (category.equals("NOTICE_NOTICE"))
			selectCategory = Category.NOTICE_NOTICE;
		else
			selectCategory = Category.NOTICE_EVENT;
		log.info("글 수정 2차 확인" + title + contents + category + bNo);
		BoardDTO boardDTO = BoardDTO.builder()
				.bNo(bNo)
				.menu(Menu.NOTICE)
				.title(title)
				.contents(contents)
				.category(selectCategory)
				.build();
		log.info("글 수정 정보" + boardDTO);
		noticeService.update(boardDTO);
		model.addAttribute("menuSelectAll", noticeService.menuSelectAll("NOTICE"));
		return "board/notice/noticeList";
	}
	
	@GetMapping(value = "/delete")
	public String delete(Model model,Integer bNo) {
		noticeService.delete(bNo);
		model.addAttribute("menuSelectAll", noticeService.menuSelectAll("NOTICE"));
		return "board/notice/noticeList";
	}

}
