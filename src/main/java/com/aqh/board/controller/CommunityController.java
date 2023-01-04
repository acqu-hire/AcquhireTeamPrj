package com.aqh.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aqh.board.service.CommunityService;

@Controller
@RequestMapping("/community")
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
	public Path createCommunityPost() {
		// TODO: Business logic
		return Path.BOARD_COMMUNITY_INSERT;
	}

	@GetMapping(value = "/insert_view")
	public Path createCommunityInsertPost() {
		// TODO: Business logic
		return Path.BOARD_COMMUNITY_INSERT_VIEW;
	}

	/**
	 * READ PART
	 * 
	 * @author Devesg
	 * @param param
	 * @return
	 */
	@GetMapping(value = "/select_all_view")
	public Path readCommunityPostList() {
		// TODO: Business logic
		return Path.BOARD_COMMUNITY_SELECT_ALL_VIEW;
	}

	@GetMapping(value = "/selectdetail_view")
	public Path readCommunitPost() {
		// TODO: Business logic
		return Path.BOARD_COMMUNITY_SELECT_DETAIL_VIEW;
	}

	/**
	 * UPDATE PART
	 * 
	 * @author Devesg
	 * @return
	 */
	@GetMapping(value = "/update")
	public Path updateCommunityPost() {
		// TODO: Business logic
		return Path.BOARD_COMMUNITY_UPDATE;
	}

	@GetMapping(value = "/update_view")
	public Path updateCommunityPostView() {
		// TODO: Business logic
		return Path.BOARD_COMMUNITY_UPDATE_VIEW;
	}

	/**
	 * DELETE PART
	 * 
	 * @author Devesg
	 * @return
	 */
	@GetMapping(value = "/delete")
	public Path deleteCommunityPost() {
		// TODO: Business logic
		return Path.BOARD_COMMUNITY_DELETE;
	}

	@GetMapping(value = "/delete_view")
	public Path deleteCommunityPostView() {
		// TODO: Business logic
		return Path.BOARD_COMMUNITY_DELETE_VIEW;
	}

}