package com.aqh.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.Criteria;
import com.aqh.board.domain.pagehandler.Pagination;
import com.aqh.board.service.BoardService;
import com.aqh.common.domain.FileDTO;
import com.aqh.common.service.FileService;

@Controller
@RequestMapping("/QnA")
public class QnAController {

	@Autowired
	private BoardService qnABoardServiceImpl;

	@Autowired
	private FileService fileService;

	@GetMapping("/list")
	public String qnaList(Model model, Criteria cri) {
		model.addAttribute("pagination", new Pagination((int) qnABoardServiceImpl.getBoardTotal(cri), cri));
		List<BoardDTO> list = qnABoardServiceImpl.getBoardList(cri);
		model.addAttribute("boardList", list);

		return "board/qna/qna_list";
	}

	@GetMapping("/listDetail")
	public String qnaListDetail(long bno, Model model, Criteria cri, BoardDTO boardDTO) {

		boardDTO = qnABoardServiceImpl.findByBoardNumber(bno);
		boardDTO.setFileList(qnABoardServiceImpl.getFileList(boardDTO.getBno()));

		model.addAttribute(boardDTO);
		model.addAttribute("cri", cri);
		model.addAttribute("fileList", boardDTO.getFileList());
		return "board/qna/qna_list_detail";
	}

	@GetMapping("/write")
	public String qnaInsertForm(Model model, Criteria cri) {
		model.addAttribute("cri", cri);

		return "board/qna/qna_write_form";
	}

	@PostMapping("/write")
	public String qnaInsert(BoardDTO boardDTO, Model model, HttpServletRequest request) {
		System.out.println("boardDTO = " + boardDTO.getFiles());
		model.addAttribute(boardDTO.getCategory());
		qnABoardServiceImpl.insertBoard(boardDTO);
		fileService.upload(request, boardDTO);

		return "redirect:/QnA/list";
	}

	@GetMapping("/update")
	public String qnaUpdateForm(long bno, Model model, Criteria cri) {
		model.addAttribute("cri", cri);

		BoardDTO boardDTO = qnABoardServiceImpl.findByBoardNumber(bno);
		boardDTO.setFileList(qnABoardServiceImpl.getFileList(bno));
		model.addAttribute(boardDTO);

		return "board/qna/qna_update_form";

	}

	@PostMapping("/update")
	public String qnaUpdate(BoardDTO boardDTO, Criteria cri, FileDTO fileDTO, HttpServletRequest request) {
		qnABoardServiceImpl.updateBoard(boardDTO);
		fileService.upload(request, boardDTO);
		fileService.delete(fileDTO);

		return "redirect:/QnA/list" + cri.getQueryString(cri.getPage(), cri.getCategory());
	}

	@PostMapping("/delete")
	public String qnaDelete(Criteria cri, FileDTO fileDTO, HttpServletRequest request) {
		fileService.deleteAll(fileDTO);
		qnABoardServiceImpl.deleteBoard(fileDTO.getBno());

		return "redirect:/QnA/list" + cri.getQueryString(cri.getPage(), cri.getCategory());
	}

}