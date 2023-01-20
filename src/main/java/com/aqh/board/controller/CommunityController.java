package com.aqh.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.Criteria;
import com.aqh.board.domain.pagehandler.Pagination;
import com.aqh.board.service.CommunityService;
import com.aqh.common.domain.dto.BoardAttachVO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;


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
	public String createCommunityInsertPost(BoardDTO boardDTO, RedirectAttributes rttr) {
		log.info("PATH " + Path.BOARD_COMMUNITY_INSERT_VIEW);
		System.out.println(!boardDTO.getAttachList().isEmpty());
		System.out.println(boardDTO.getAttachList().size());
		System.out.println(boardDTO);
		communityService.createPost(boardDTO);
		if (!boardDTO.getAttachList().isEmpty()) {
			boardDTO.getAttachList().forEach(attach -> 
			{
				attach.setBNo(boardDTO.getbNo());
				attach.toString();
				communityService.insert(attach);
			});
		}
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

		// System.out.println("cri.getListLink() >>>>>" + cri.toString());

		model.addAttribute("boardList", communityService.getAllCommunityPostList(cri));
		model.addAttribute("pagination", new Pagination((int) communityService.getTotal(cri), cri));
		return Path.BOARD_COMMUNITY_SELECT_ALL_VIEW.getPath();
	}

	@GetMapping(value = "/selectdetail_view")
	public String readCommunitPost(long bNo, Model model) {
		log.info("PATH " + Path.BOARD_COMMUNITY_SELECT_DETAIL_VIEW);
		communityService.setPostCountUp(bNo);
		model.addAttribute("boardDTO", communityService.getPost(bNo));
		return Path.BOARD_COMMUNITY_SELECT_DETAIL_VIEW.getPath();
	}

	@GetMapping(value="/getAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<BoardAttachVO>> getAttachList(Long bNo) {
		System.out.println(bNo);
		return new ResponseEntity<>(communityService.getAttachList(bNo),HttpStatus.OK);
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

	@PostMapping(value = "/update")
	public String updateCommunityPostView(BoardDTO boardDTO) {
		log.info("PATH " + Path.BOARD_COMMUNITY_UPDATE_VIEW);
		System.out.println(boardDTO);
		if (boardDTO.getAttachList() != null) {
			boardDTO.getAttachList().forEach(attach -> log.info(attach.toString()));
		}
		//communityService.updatePost(boardDTO);
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