package com.aqh.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aqh.board.service.NoticeService;

@Controller
public class NoticeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="notice/menu_select_all_view" , method = RequestMethod.GET)
	public String menuSelectAll(Model model) {
		model.addAttribute("menuSelectAll", noticeService.menuSelectAll());
		LOGGER.info("menuSelectAll",model);
		return "board/notice/noticeList";
	}
	

}
