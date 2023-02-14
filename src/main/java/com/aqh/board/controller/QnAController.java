package com.aqh.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.Criteria;
import com.aqh.board.domain.pagehandler.Pagination;
import com.aqh.board.service.BoardService;
import com.aqh.file.domain.FileDTO;
import com.aqh.file.service.FileService;

@Controller
@RequestMapping("/QnA")
public class QnAController {

	private BoardService qnAServiceImpl;
	private FileService fileService;
	
	public QnAController(BoardService qnAServiceImpl, FileService fileService) {
		this.qnAServiceImpl = qnAServiceImpl;
		this.fileService = fileService;
	}

	@GetMapping("/list")
	public String qnaList(Model model, Criteria cri) {
		Pagination pg = new Pagination((int) qnAServiceImpl.getBoardTotal(cri), cri);
		model.addAttribute("pagination", pg);
		List<BoardDTO> list = qnAServiceImpl.getBoardList(cri);
		model.addAttribute("boardList", list);

		return "board/qna/qna_list";
	}

	@GetMapping("/listDetail")
	public String qnaListDetail(long bno, Model model, Criteria cri) {
		BoardDTO boardDTO = qnAServiceImpl.findByBoardNumber(bno);
		boardDTO.setFileList(qnAServiceImpl.getFileList(bno));

		model.addAttribute(boardDTO);
		model.addAttribute("cri", cri);
		return "board/qna/qna_list_detail";
	}

	@GetMapping("/write")
	public String qnaInsertForm(Model model, Criteria cri) {
		model.addAttribute("cri", cri);

		return "board/qna/qna_write_form";
	}

	@PostMapping("/write")
	public String qnaInsert(BoardDTO boardDTO, Model model, HttpServletRequest request) {
		model.addAttribute(boardDTO.getCategory());
		qnAServiceImpl.insertBoard(boardDTO);
		fileService.upload(request, boardDTO);

		return "redirect:/QnA/list";
	}

	@GetMapping("/update")
	public String qnaUpdateForm(long bno, Model model, Criteria cri) {
		model.addAttribute("cri", cri);

		BoardDTO boardDTO = qnAServiceImpl.findByBoardNumber(bno);
		boardDTO.setFileList(qnAServiceImpl.getFileList(bno));
		model.addAttribute(boardDTO);

		return "board/qna/qna_update_form";

	}

	@PostMapping("/update")
	public String qnaUpdate(BoardDTO boardDTO, Criteria cri, FileDTO fileDTO, HttpServletRequest request) {
		qnAServiceImpl.updateBoard(boardDTO);
		fileService.upload(request, boardDTO);
		fileService.delete(fileDTO);

		return "redirect:/QnA/list" + cri.getQueryString(cri.getPage(), cri.getCategory());
	}

	@PostMapping("/delete")
	public String qnaDelete(Criteria cri, FileDTO fileDTO) {
		fileService.deleteAll(fileDTO);
		qnAServiceImpl.deleteBoard(fileDTO.getBno());

		return "redirect:/QnA/list" + cri.getQueryString(cri.getPage(), cri.getCategory());
	}

}