package com.aqh.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.BoardDTO.Category;
import com.aqh.board.service.CommunityService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/community")
@Slf4j
public class CommunityController {

	private static final String JSP_ROOT = "board/community";
	private static final String REDIRECT_ROOT = "redirect:/community";

	enum Path {

		BOARD_COMMUNITY_INSERT(JSP_ROOT + "/insert"), BOARD_COMMUNITY_INSERT_VIEW(JSP_ROOT + "/insert_view"),
		BOARD_COMMUNITY_SELECT_ALL_VIEW(JSP_ROOT + "/select_all_view"),
		BOARD_COMMUNITY_SELECT_DETAIL_VIEW(JSP_ROOT + "/selectdetail_view"),
		BOARD_COMMUNITY_UPDATE(JSP_ROOT + "/update"), BOARD_COMMUNITY_UPDATE_VIEW(JSP_ROOT + "/update_view"),
		BOARD_COMMUNITY_DELETE(JSP_ROOT + "/delete"), BOARD_COMMUNITY_DELETE_VIEW(JSP_ROOT + "/delete_view"),
		BOARD_COMMUNITY_REDIRECT_SELECT_ALL_VIEW(REDIRECT_ROOT + "/select_all_view");

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
		// TODO 아이디 확인 추가
		log.info("PATH " + Path.BOARD_COMMUNITY_INSERT);
		return Path.BOARD_COMMUNITY_INSERT.getPath();
	}

	@PostMapping(value = "/insert_view")
	public String createCommunityInsertPost(BoardDTO boardDTO) {
		log.info("PATH " + Path.BOARD_COMMUNITY_INSERT_VIEW);
		System.out.println(boardDTO.toString());
		communityService.createPost(boardDTO);
		return Path.BOARD_COMMUNITY_REDIRECT_SELECT_ALL_VIEW.getPath();
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
		log.info("PATH" + Path.BOARD_COMMUNITY_SELECT_ALL_VIEW);
		model.addAttribute("boardList", communityService.getAllCommunityPostList());
		return Path.BOARD_COMMUNITY_SELECT_ALL_VIEW.getPath();
	}

	@PostMapping(value="/select_all_view")
	public String getCategory(Category category) {
		System.out.println(category.name());

		// ! 여기하고잇엇다람쥐
		return Path.BOARD_COMMUNITY_REDIRECT_SELECT_ALL_VIEW.getPath();
	}

	@GetMapping(value = "/selectdetail_view")
	public String readCommunitPost(long bNo, Model model) {
		log.info("PATH " + Path.BOARD_COMMUNITY_SELECT_DETAIL_VIEW);
		model.addAttribute("boardDTO", communityService.getPost(bNo));
		return Path.BOARD_COMMUNITY_SELECT_DETAIL_VIEW.getPath();
	}
	
	/**
	 * UPDATE PART
	 * 
	 * @author Devesg
	 * @return
	 */
	@GetMapping(value = "/update")
	public String updateCommunityPost(Model model, long bNo) {
		log.info("PATH " + Path.BOARD_COMMUNITY_UPDATE);
		// TODO 아이디 확인 추가
		model.addAttribute("boardDTO", communityService.getPost(bNo));
		return Path.BOARD_COMMUNITY_UPDATE.getPath();
	}

	@PostMapping(value = "/update_view")
	public String updateCommunityPostView(BoardDTO boardDTO) {
		log.info("PATH " + Path.BOARD_COMMUNITY_UPDATE_VIEW);

		communityService.updatePost(boardDTO);
		return Path.BOARD_COMMUNITY_REDIRECT_SELECT_ALL_VIEW.getPath();
	}

	/**
	 * DELETE PART
	 * 
	 * @author Devesg
	 * @return
	 */
	@GetMapping(value = "/delete")
	public String deleteCommunityPost(long bNo, String id) {
		log.info("PATH " + Path.BOARD_COMMUNITY_DELETE);
		// TODO 아이디 확인 추가
		communityService.deletePost(bNo);
		return Path.BOARD_COMMUNITY_REDIRECT_SELECT_ALL_VIEW.getPath();
	}

}