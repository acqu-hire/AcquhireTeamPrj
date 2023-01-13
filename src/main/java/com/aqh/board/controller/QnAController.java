package com.aqh.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.pagehandler.PageHandler;
import com.aqh.board.domain.pagehandler.SearchCondition;
import com.aqh.board.service.QnAService;
import com.aqh.common.domain.dto.AttachFile;
import com.aqh.common.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/QnA")
public class QnAController {

	@Autowired
	QnAService service;
	
	@Autowired
	FileService fileService;

	@GetMapping("/list")
	public String qnaList(Model model, SearchCondition sc) {
			PageHandler ph = new PageHandler(sc, service.getBoardCnt(sc));
			model.addAttribute("ph", ph);
			log.info("ph = " + ph);
			
			List<BoardDTO> list = service.selectAll(sc);
			model.addAttribute("boardList", list);
			log.info("sc = " + sc);
			
			return "board/qna/qna_list";
		
	}

	@GetMapping("/listDetail")
	public String qnaListDetail(long bNo, Model model, SearchCondition sc, BoardDTO boardDTO) {
		
			service.readCntUp(bNo);
			boardDTO = service.selectDetail(bNo);
			boardDTO.setAttachFile(fileService.getFileName(boardDTO.getbNo()));
			
			model.addAttribute(boardDTO);
			log.info("boardDTO = " + boardDTO);

			model.addAttribute("sc", sc);
			log.info("sc = " + sc);
			
			return "board/qna/qna_list_detail";
	}

	@GetMapping("/write")
	public String qnaInsertForm(Model model, SearchCondition sc) {
		model.addAttribute("sc", sc);
		
		return "board/qna/qna_write_form";
	}

	@PostMapping("/write")
	public String qnaInsert(BoardDTO boardDTO, Model model, 
			MultipartFile[] files, HttpServletRequest request) {
		model.addAttribute(boardDTO.getCategory());
		service.insert(boardDTO);
		log.info("boardDTO = " + boardDTO);
		
		String uploadPath = request.getServletContext().getRealPath("resources")+"\\upload\\";
		File fileDir = new File(uploadPath);
		if(!fileDir.exists()) fileDir.mkdirs();
		List<AttachFile> list = new ArrayList<>();
		
		for(MultipartFile file : files) {
			if(!file.isEmpty()) {
				AttachFile attach = new AttachFile(boardDTO.getbNo(),
												   UUID.randomUUID().toString(),
												   file.getOriginalFilename(),
												   uploadPath,
												   file.getSize());
				list.add(attach);
				File saveFile = new File(uploadPath + attach.getUuid() + "-" + attach.getOriginName());
				try {
					file.transferTo(saveFile);
					boardDTO.setAttachFile(list);
					fileService.upload(attach);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		return "redirect:/QnA/list";
	}

	@GetMapping("/update")
	public String qnaUpdateForm(long bNo, Model model, SearchCondition sc) {
		log.info("sc = " + sc);
		model.addAttribute("sc", sc);
		
		BoardDTO boardDTO = service.selectDetail(bNo);
		model.addAttribute(boardDTO);
		log.info("boardDTO = " + boardDTO);
		
		return "board/qna/qna_update_form";
		
	}

	@PostMapping("/update")
	public String qnaUpdate(BoardDTO boardDTO, SearchCondition sc) {
		
			service.update(boardDTO);

			return "redirect:/QnA/list"+sc.getQueryString();
	}

	@PostMapping("/delete")
	public String qnaDelete(Integer bNo, RedirectAttributes rattr, SearchCondition sc) {
		log.info("sc = " + sc);
		service.delete(bNo);
		
		return "redirect:/QnA/list"+sc.getQueryString();
	}
	
}

