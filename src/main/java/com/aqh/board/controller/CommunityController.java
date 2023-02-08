package com.aqh.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aqh.aop.LoginCheck;
import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.Criteria;
import com.aqh.board.domain.pagehandler.Pagination;
import com.aqh.board.service.BoardService;
import com.aqh.file.domain.FileDTO;
import com.aqh.file.service.FileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/community")
@RequiredArgsConstructor
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
		BOARD_COMMUNITY_REDIRECT_SELECT_ALL_VIEW(REDIRECT_PATH.getPath() + "/list");

		private String returnPath;

		Path(String returnPath) {
			this.returnPath = returnPath;
		}

		public String getPath() {
			return returnPath;
		}

	}

	private final BoardService communityServiceImpl;

	private final FileService fileService;

	@GetMapping(value = "/write")
	public String createCommunityPost() {
		log.info("PATH " + Path.BOARD_COMMUNITY_INSERT);
		return Path.BOARD_COMMUNITY_INSERT.getPath();
	}

	@PostMapping(value = "/write")
	public String createCommunityInsertPost(BoardDTO boardDTO, HttpServletRequest request) {
		log.info("PATH " + Path.BOARD_COMMUNITY_INSERT_VIEW);
		communityServiceImpl.insertBoard(boardDTO);
		fileService.upload(request, boardDTO);
		return Path.BOARD_COMMUNITY_REDIRECT_SELECT_ALL_VIEW.getPath();
	}

	@LoginCheck
	@GetMapping(value = "/list")
	public String readCommunityPostList(Model model, Criteria cri) {
		log.info("PATH" + Path.BOARD_COMMUNITY_SELECT_ALL_VIEW);

		model.addAttribute("boardList", communityServiceImpl.getBoardList(cri));
		model.addAttribute("pagination", new Pagination(communityServiceImpl.getBoardTotal(cri), cri));
		return Path.BOARD_COMMUNITY_SELECT_ALL_VIEW.getPath();
	}

	@GetMapping(value = "/selectdetail_view")
	public String readCommunitPost(long bno, Model model, Criteria cri) {
		log.info("PATH " + Path.BOARD_COMMUNITY_SELECT_DETAIL_VIEW);
		BoardDTO boardDTO = new BoardDTO();

		communityServiceImpl.viewCntUp(bno);
		boardDTO = communityServiceImpl.findByBoardNumber(bno);
		boardDTO.setFileList(communityServiceImpl.getFileList(bno));

		model.addAttribute("boardDTO", boardDTO);
		model.addAttribute("cri", cri);

		return Path.BOARD_COMMUNITY_SELECT_DETAIL_VIEW.getPath();
	}

	@GetMapping(value = "/update")
	public String updateCommunityPost(Model model, long bno, Criteria cri) {
		log.info("PATH " + Path.BOARD_COMMUNITY_UPDATE);

		BoardDTO boardDTO = communityServiceImpl.findByBoardNumber(bno);
		boardDTO.setFileList(communityServiceImpl.getFileList(bno));

		model.addAttribute("cri", cri);
		model.addAttribute("boardDTO", boardDTO);

		return Path.BOARD_COMMUNITY_UPDATE.getPath();
	}

	@PostMapping(value = "/update")
	public String updateCommunityPostView(BoardDTO boardDTO, FileDTO fileDTO, HttpServletRequest request,
			Criteria cri) {
		log.info("PATH " + Path.BOARD_COMMUNITY_UPDATE_VIEW);
		communityServiceImpl.updateBoard(boardDTO);
		fileService.upload(request, boardDTO);
		fileService.delete(fileDTO);

		return Path.BOARD_COMMUNITY_REDIRECT_SELECT_ALL_VIEW.getPath()
				+ cri.getQueryString(cri.getPage(), cri.getCategory());
	}

	@PostMapping(value = "/delete")
	public String deleteCommunityPost(Criteria cri, FileDTO fileDTO, HttpServletRequest request) {
		log.info("PATH " + Path.BOARD_COMMUNITY_DELETE);
		
		fileService.deleteAll(fileDTO);
		communityServiceImpl.deleteBoard(fileDTO.getBno());
		return Path.BOARD_COMMUNITY_REDIRECT_SELECT_ALL_VIEW.getPath()
				+ cri.getQueryString(cri.getPage(), cri.getCategory());
	}

}