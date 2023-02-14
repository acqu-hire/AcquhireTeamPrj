package com.aqh.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.Criteria;
import com.aqh.board.domain.pagehandler.Pagination;
import com.aqh.board.service.BoardService;

@Controller
@RequestMapping("/Event")
public class EventController {

	private BoardService eventServiceImpl;
	
	public EventController(BoardService eventServiceImpl) {
		this.eventServiceImpl = eventServiceImpl;
	}

	@GetMapping("/list")
	public String eventList(Model model, Criteria cri) {
		Pagination pg = new Pagination((int) eventServiceImpl.getBoardTotal(cri), cri);
		model.addAttribute("pagination", pg);
		List<BoardDTO> list = eventServiceImpl.getBoardList(cri);
		model.addAttribute("boardList", list);

		return "board/event/event_list";
	}

	@GetMapping("/listDetail")
	public String evenetListDetail(long bno, Model model, Criteria cri) {
		BoardDTO boardDTO = eventServiceImpl.findByBoardNumber(bno);
		boardDTO.setFileList(eventServiceImpl.getFileList(bno));

		model.addAttribute(boardDTO);
		model.addAttribute("cri", cri);
		return "board/event/event_list_detail";
	}

	@GetMapping("/write")
	public String eventInsertForm(Model model, Criteria cri) {
		model.addAttribute("cri", cri);

		return "board/event/event_write_form";
	}

	@PostMapping("/write")
	public String eventInsert(BoardDTO boardDTO, Model model) {
		model.addAttribute(boardDTO.getCategory());
		eventServiceImpl.insertBoard(boardDTO);

		return "redirect:/Event/list";
	}

	@GetMapping("/update")
	public String evenetUpdateForm(long bno, Model model, Criteria cri) {
		model.addAttribute("cri", cri);

		BoardDTO boardDTO = eventServiceImpl.findByBoardNumber(bno);
		boardDTO.setFileList(eventServiceImpl.getFileList(bno));
		model.addAttribute(boardDTO);

		return "board/event/event_update_form";

	}

	@PostMapping("/update")
	public String eventUpdate(BoardDTO boardDTO, Criteria cri) {
		eventServiceImpl.updateBoard(boardDTO);

		return "redirect:/Event/list" + cri.getQueryString(cri.getPage(), cri.getCategory());
	}

	@PostMapping("/delete")
	public String eventDelete(Criteria cri, long bno) {
		eventServiceImpl.deleteBoard(bno);

		return "redirect:/Event/list" + cri.getQueryString(cri.getPage(), cri.getCategory());
	}

}