package com.aqh.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.BoardDTO.Category;
import com.aqh.board.domain.dto.BoardDTO.Menu;
import com.aqh.board.service.CommunityService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/community")
@Slf4j
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

	/**
	 * CREATE PART
	 * 
	 * @author Devesg
	 * @param param
	 * @return
	 */
	@GetMapping(value = "/insert")
	public String createCommunityPost() {
		// TODO: Business logic
		log.info("PATH " + Path.BOARD_COMMUNITY_INSERT);
		return Path.BOARD_COMMUNITY_INSERT.getPath();
	}

	@GetMapping(value = "/insert_view")
	public String createCommunityInsertPost() {
		// BoardDTO boardDTO =
		// BoardDTO.builder().id("admin").bNo(0).menu(Menu.COMMUNITY).category(Category.COMMUNITY_LIFE)
		// .file("널").title("12123231널").contents("3213").build();
		// log.info("" + boardDTO);
		// communityService.createPost(boardDTO);
		log.info("PATH " + Path.BOARD_COMMUNITY_INSERT_VIEW);
		return Path.BOARD_COMMUNITY_INSERT_VIEW.getPath();
	}

	/**
	 * READ PART
	 * 
	 * @author Devesg
	 * @param param
	 * @return
	 */
	@GetMapping(value = "/select_all_view")
	public String readCommunityPostList(Model model) {
		model.addAttribute("boardList", communityService.getAllCommunityPostList());
		log.info("PATH" + Path.BOARD_COMMUNITY_SELECT_ALL_VIEW);
		return Path.BOARD_COMMUNITY_SELECT_ALL_VIEW.getPath();
	}

	@GetMapping(value = "/selectdetail_view")
	public String readCommunitPost(int bNo, Model model) {
		model.addAttribute("boardDTO", communityService.getPost(bNo));
		log.info("PATH " + Path.BOARD_COMMUNITY_SELECT_DETAIL_VIEW);
		return Path.BOARD_COMMUNITY_SELECT_DETAIL_VIEW.getPath();
	}

	/**
	 * UPDATE PART
	 * 
	 * @author Devesg
	 * @return
	 */
	@GetMapping(value = "/update")
	public String updateCommunityPost() {
		// TODO: Business logic
		log.info("PATH " + Path.BOARD_COMMUNITY_UPDATE);
		return Path.BOARD_COMMUNITY_UPDATE.getPath();
	}

	@GetMapping(value = "/update_view")
	public String updateCommunityPostView() {
		// TODO: Business logic
		log.info("PATH " + Path.BOARD_COMMUNITY_UPDATE_VIEW);
		return Path.BOARD_COMMUNITY_UPDATE_VIEW.getPath();
	}

	/**
	 * DELETE PART
	 * 
	 * @author Devesg
	 * @return
	 */
	@GetMapping(value = "/delete")
	public String deleteCommunityPost() {
		// TODO: Business logic
		log.info("PATH " + Path.BOARD_COMMUNITY_DELETE);
		return Path.BOARD_COMMUNITY_DELETE.getPath();
	}

	@GetMapping(value = "/delete_view")
	public String deleteCommunityPostView() {
		// TODO: Business logic
		log.info("PATH " + Path.BOARD_COMMUNITY_DELETE_VIEW);
		return Path.BOARD_COMMUNITY_DELETE_VIEW.getPath();
	}

}