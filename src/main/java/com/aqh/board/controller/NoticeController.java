package com.aqh.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aqh.board.domain.dto.BoardDTO.Category;
import com.aqh.board.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(NoticeController.class);

	@Autowired
	private NoticeService noticeService;


	@GetMapping(value = "/select_all_view")
	public String menuSelectAll(Model model) {
		model.addAttribute("menuSelectAll", noticeService.menuSelectAll());
		model.addAttribute("boardAllCount", noticeService.BoardListAllCount());
		LOGGER.info("menuSelectAll", model);
		return "board/notice/noticeList";
	}

	@GetMapping(value = "/select_category_view")
	public String categorySelectAll(Model model, String category) {
		model.addAttribute("categorySelectAll", noticeService.categorySelectAll(category));
		model.addAttribute("boardCategoryCount", noticeService.CategoryListCount(category));
		return "/board/notice/noticeCategoryList";
	}


	@GetMapping(value = "/Select_Detail_view")
	public String noticeSelectDetail(Model model, Integer bNo) {
		model.addAttribute("selectDetail", noticeService.selectDetail(bNo));
		return "/board/notice/noticeListDetail";
	}

}
