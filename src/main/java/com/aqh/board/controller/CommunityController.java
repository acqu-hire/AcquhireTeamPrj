package com.aqh.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aqh.board.service.CommunityService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board/community")
public class CommunityController {

	private static final String JSP_ROOT = "board/community";

	enum Path {

		BOARD_COMMUNITY_INSERT(JSP_ROOT + "/insert"), BOARD_COMMUNITY_INSERT_VIEW(JSP_ROOT + "/insert_view"),
		BOARD_COMMUNITY_SELECT_ALL_VIEW(JSP_ROOT + "/select_all_view"),
		BOARD_COMMUNITY_SELECT_DETAIL_VIEW(JSP_ROOT + "/selectdetail_view"),
		BOARD_COMMUNITY_UPDATE(JSP_ROOT + "/update"), BOARD_COMMUNITY_UPDATE_VIEW(JSP_ROOT + "/update_view"),
		BOARD_COMMUNITY_DELETE(JSP_ROOT + "/delete"), BOARD_COMMUNITY_DELETE_VIEW(JSP_ROOT + "/delete_view");

		private String returnPath;

		Path(String returnPath) {
			this.returnPath = returnPath;
		}

		public String getPath() {
			return returnPath;
		}

	}

	@Autowired

	public CommunityService communityService;

	@GetMapping(value = "/select_all_view")
	public String getMethodName(Model model) {
		log.info("" + Path.BOARD_COMMUNITY_SELECT_ALL_VIEW);
		model.addAttribute("test", communityService.getTotal());
		log.info("testtetsetest", model);
		return "" + Path.BOARD_COMMUNITY_SELECT_ALL_VIEW;
	}

}