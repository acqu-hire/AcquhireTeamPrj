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

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
			log.info("ph = " + ph);
			
			List<BoardDTO> list = qnaService.selectAll(sc);
			model.addAttribute("boardList", list);
			log.info("sc = " + sc);
			
			return "board/qna/qna_list";
		
	}

	@GetMapping("/listDetail")
	public String qnaListDetail(long bNo, Model model, SearchCondition sc, BoardDTO boardDTO) {
		
			qnaService.readCntUp(bNo);
			boardDTO = qnaService.selectDetail(bNo);
			boardDTO.setFileList(qnaService.getFileList(boardDTO.getbNo()));
			
			model.addAttribute(boardDTO);
			log.info("boardDTO = " + boardDTO);

			model.addAttribute("sc", sc);
			log.info("sc = " + sc);
			
			model.addAttribute("fileList", boardDTO.getFileList());
			return "board/qna/qna_list_detail";
	}

	@GetMapping("/write")
	public String qnaInsertForm(Model model, SearchCondition sc) {
		model.addAttribute("sc", sc);
		
		return "board/qna/qna_write_form";
	}

	@PostMapping("/write")
	public String qnaInsert(BoardDTO boardDTO, Model model, 
			 HttpServletRequest request) {
		
		model.addAttribute(boardDTO.getCategory());
		qnaService.insert(boardDTO);
		log.info("boardDTO = " + boardDTO);
		fileService.upload(request, boardDTO);

		return "redirect:/QnA/list";
	}

	@GetMapping("/update")
	public String qnaUpdateForm(long bNo, Model model, SearchCondition sc) {
		log.info("sc = " + sc);
		model.addAttribute("sc", sc);
		
		BoardDTO boardDTO = qnaService.selectDetail(bNo);
		boardDTO.setFileList(qnaService.getFileList(bNo));
		model.addAttribute(boardDTO);
		log.info("boardDTO = " + boardDTO);
		
		return "board/qna/qna_update_form";
		
	}

	@PostMapping("/update")
	public String qnaUpdate(BoardDTO boardDTO, SearchCondition sc, FileDTO fileDTO, HttpServletRequest request) {
			log.info("fNo = " + fileDTO.getDelAttach());
			log.info("fileDTO = " + fileDTO);
			qnaService.update(boardDTO);
			fileService.upload(request, boardDTO);
			fileService.delete(fileDTO, boardDTO);
			log.info("update boardDTO = " + boardDTO);
			return "redirect:/QnA/list"+sc.getQueryString();
	}

	@PostMapping("/delete")
	public String qnaDelete(SearchCondition sc, FileDTO fileDTO, HttpServletRequest request, BoardDTO boardDTO) {
		log.info("sc = " + sc);
		log.info("fileDTO = " + fileDTO);
		fileService.deleteAll(fileDTO, boardDTO);
		qnaService.delete(fileDTO.getbNo());
		
		return "redirect:/QnA/list"+sc.getQueryString();
	}
	
}

