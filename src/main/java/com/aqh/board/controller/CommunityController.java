package com.aqh.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.Criteria;
import com.aqh.board.domain.pagehandler.Pagination;
import com.aqh.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/community")
@Slf4j
public class CommunityController {

	enum Path {
		JSP_PATH("board/community"), REDIRECT_PATH("redirect:/community"), UPLOAD_PATH("C:\\upload"),
		BOARD_COMMUNITY_INSERT(JSP_PATH.getPath() + "/insert"),
		BOARD_COMMUNITY_INSERT_VIEW(JSP_PATH.getPath() + "/insert_view"),
		BOARD_COMMUNITY_SELECT_ALL_VIEW(JSP_PATH.getPath() + "/select_all_view"),
		BOARD_COMMUNITY_SELECT_DETAIL_VIEW(JSP_PATH.getPath() + "/selectdetail_view"),
		BOARD_COMMUNITY_UPDATE(JSP_PATH.getPath() + "/update"),
		BOARD_COMMUNITY_UPDATE_VIEW(JSP_PATH.getPath() + "/update_view"),
		BOARD_COMMUNITY_DELETE(JSP_PATH.getPath() + "/delete"),
		BOARD_COMMUNITY_DELETE_VIEW(JSP_PATH.getPath() + "/delete_view"),
		BOARD_COMMUNITY_REDIRECT_SELECT_ALL_VIEW(REDIRECT_PATH.getPath() + "/select_all_view");

		private String returnPath;

		Path(String returnPath) {
			this.returnPath = returnPath;
		}

		public String getPath() {
			return returnPath;
		}

	}

	@Autowired
	public BoardService communityServiceImpl;

	/**
	 * CREATE PART
	 * 
	 * @author Devesg
	 * @param param
	 * @return
	 */
	// @LoginCheck
	@GetMapping(value = "/insert")
	public String createCommunityPost() {
		// TODO 아이디 확인 추가
		log.info("PATH " + Path.BOARD_COMMUNITY_INSERT);
		return Path.BOARD_COMMUNITY_INSERT.getPath();
	}

	@PostMapping(value = "/insert_view")
	public String createCommunityInsertPost(BoardDTO boardDTO, RedirectAttributes rttr) {
		log.info("PATH " + Path.BOARD_COMMUNITY_INSERT_VIEW);
		communityServiceImpl.insertBoard(boardDTO);
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
	public String readCommunityPostList(Model model, Criteria cri) {
		log.info("PATH" + Path.BOARD_COMMUNITY_SELECT_ALL_VIEW);

		model.addAttribute("boardList", communityServiceImpl.getBoardList(cri));
		model.addAttribute("pagination", new Pagination(communityServiceImpl.getBoardTotal(cri), cri));
		return Path.BOARD_COMMUNITY_SELECT_ALL_VIEW.getPath();
	}

	@GetMapping(value = "/selectdetail_view")
	public String readCommunitPost(long bno, Model model) {
		log.info("PATH " + Path.BOARD_COMMUNITY_SELECT_DETAIL_VIEW);
		int count = communityServiceImpl.viewCntUp(bno);
		log.info(">>>>>>>>>>>>>" + count);
		model.addAttribute("boardDTO", communityServiceImpl.findByBoardNumber(bno));
		return Path.BOARD_COMMUNITY_SELECT_DETAIL_VIEW.getPath();
	}

	/**
	 * UPDATE PART
	 * 
	 * @author Devesg
	 * @return
	 */

	@GetMapping(value = "/update")
	public String updateCommunityPost(Model model, long bno) {
		log.info("PATH " + Path.BOARD_COMMUNITY_UPDATE);
		// TODO 아이디 확인 추가
		model.addAttribute("boardDTO", communityServiceImpl.findByBoardNumber(bno));
		return Path.BOARD_COMMUNITY_UPDATE.getPath();
	}

	@PostMapping(value = "/update")
	public String updateCommunityPostView(BoardDTO boardDTO) {
		log.info("PATH " + Path.BOARD_COMMUNITY_UPDATE_VIEW);
		communityServiceImpl.updateBoard(boardDTO);
		return Path.BOARD_COMMUNITY_REDIRECT_SELECT_ALL_VIEW.getPath();
	}

	/**
	 * DELETE PART
	 * 
	 * @author Devesg
	 * @return
	 */
	@GetMapping(value = "/delete")
	public String deleteCommunityPost(long bno, String id, Criteria cri, RedirectAttributes rttr) {
		log.info("PATH " + Path.BOARD_COMMUNITY_DELETE);
		// TODO 아이디 확인 추가
		communityServiceImpl.deleteBoard(bno);
		return Path.BOARD_COMMUNITY_REDIRECT_SELECT_ALL_VIEW.getPath();
	}

}