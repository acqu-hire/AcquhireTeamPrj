package com.aqh.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.pagehandler.PageHandler;
import com.aqh.board.domain.pagehandler.SearchCondition;
import com.aqh.board.service.QnAService;
import com.aqh.common.domain.dto.FileDTO;
import com.aqh.common.service.FileService;

@Controller
@RequestMapping("/QnA")
public class QnAController {

	QnAService qnaService;
	FileService fileService;
	
	public QnAController(QnAService qnaService, FileService fileService){
		this.qnaService = qnaService;
		this.fileService = fileService;
	}
	
	@GetMapping("/list")
	public String qnaList(Model model, SearchCondition sc) {
			PageHandler ph = new PageHandler(sc, qnaService.getBoardCnt(sc));
			model.addAttribute("ph", ph);
			
			List<BoardDTO> list = qnaService.selectAll(sc);
			model.addAttribute("boardList", list);
			
			return "board/qna/qna_list";
	}

	@GetMapping("/listDetail")
	public String qnaListDetail(long bno, Model model, SearchCondition sc, BoardDTO boardDTO) {
		
			boardDTO = qnaService.selectDetail(bno);
			boardDTO.setFileList(qnaService.getFileList(boardDTO.getBno()));
			
			model.addAttribute(boardDTO);
			model.addAttribute("sc", sc);
			model.addAttribute("fileList", boardDTO.getFileList());
			return "board/qna/qna_list_detail";
	}

	@GetMapping("/write")
	public String qnaInsertForm(Model model, SearchCondition sc) {
		model.addAttribute("sc", sc);
		
		return "board/qna/qna_write_form";
	}

	@PostMapping("/write")
	public String qnaInsert(BoardDTO boardDTO, Model model, HttpServletRequest request) {
		System.out.println("boardDTO = " + boardDTO.getFiles());
		model.addAttribute(boardDTO.getCategory());
		qnaService.insert(boardDTO);
		fileService.upload(request, boardDTO);

		return "redirect:/QnA/list";
	}

	@GetMapping("/update")
	public String qnaUpdateForm(long bno, Model model, SearchCondition sc) {
		model.addAttribute("sc", sc);
		
		BoardDTO boardDTO = qnaService.selectDetail(bno);
		boardDTO.setFileList(qnaService.getFileList(bno));
		model.addAttribute(boardDTO);
		
		return "board/qna/qna_update_form";
		
	}

	@PostMapping("/update")
	public String qnaUpdate(BoardDTO boardDTO, SearchCondition sc, FileDTO fileDTO, HttpServletRequest request) {
		qnaService.update(boardDTO);
		fileService.upload(request, boardDTO);
		fileService.delete(fileDTO, boardDTO);
		
		return "redirect:/QnA/list"+sc.getQueryString();
	}

	@PostMapping("/delete")
	public String qnaDelete(SearchCondition sc, FileDTO fileDTO, HttpServletRequest request, BoardDTO boardDTO) {
		fileService.deleteAll(fileDTO, boardDTO);
		qnaService.delete(fileDTO.getBno());
		
		return "redirect:/QnA/list"+sc.getQueryString();
	}
	
}

