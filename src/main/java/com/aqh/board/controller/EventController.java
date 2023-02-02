package com.aqh.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.Criteria;
import com.aqh.board.domain.dto.BoardDTO.Category;
import com.aqh.board.domain.pagehandler.Pagination;
import com.aqh.board.service.EventService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/event")
public class EventController {

	@Autowired
	EventService eventService;

	// 이벤트 게시판 전체 조회
	@GetMapping("/menu_select_all")
	public String SelectAll(Model model, Criteria cri) {
		model.addAttribute("eventMenuSelectAll", eventService.eventMenuSelectAll(cri));
		model.addAttribute("pagination", new Pagination((int) eventService.BoardListAllCount(cri), cri));
		log.info("이벤트 게시판 전체 조회 : " + model);
		return "board/event/eventList";
	}

	// it 이벤트 게시판 전체 조회
	@GetMapping("/it_event_list")
	public String itEventList(Model model, Criteria cri) {
		model.addAttribute("eventList", eventService.eventItEventList(cri));
		model.addAttribute("pagination", new Pagination((int) eventService.BoardListAllCount(cri), cri));
		log.info("it 이벤트 게시판 전체 조회 : " + model);
		return "board/event/event_it_event_list";

	}

	// 마케팅 게시판 전체 조회
	@GetMapping("/marketing_list")
	public String marketingList(Model model, Criteria cri) {
		model.addAttribute("marketingList", eventService.eventMarketingList(cri));
		model.addAttribute("pagination", new Pagination((int) eventService.BoardListAllCount(cri), cri));
		log.info("마케팅 게시판 전체 조회 : " + model);
		return "board/event/event_marketing_list";

	}

	// 게시판 상세 조회
	@GetMapping("/select_detail")
	public String selectDetail(Model model, long bno) {
		BoardDTO boardDTO = eventService.eventSelectDetail(bno);
		model.addAttribute(boardDTO);
		log.info("게시판 상세 조회 : " + model);
		eventService.readCountUp(bno);
		log.info("게시판 조회수 : " + bno);
		return "board/event/eventListDetail";

	}

	// 게시판 글 등록
	@GetMapping("/eventInsert_view")
	public String InsertForm() {
		return "board/event/eventInsert";

	}

	// 게시판 글 등록 뷰 페이지
	@PostMapping("/eventInsert")
	public String eventInsert(Model model, BoardDTO boardDTO, Category category) {
		log.info("insert boardDTO 확인 : " + boardDTO);
		eventService.eventInsert(boardDTO);
		model.addAttribute(category);
		return "redirect:/event/menu_select_all";

	}

	// 게시판 글 수정
	@GetMapping("/eventUpdate_view")
	public String updateForm(Model model, BoardDTO boardDTO) {
		model.addAttribute("boardList", eventService.eventSelectDetail(boardDTO.getBno()));
		return "board/event/eventUpdate";

	}

	// 게시판 글 수정 뷰 페이지
	@PostMapping("/eventUpdate")
	public String eventUpdate(Model model, BoardDTO boardDTO) {
		eventService.eventUpdate(boardDTO);
		log.info("update boardDTO 확인 : " + boardDTO);
		log.info("update model 확인 : " + model);
		return "redirect:/event/menu_select_all";

	}

	// 게시판 글 삭제
	@GetMapping("/eventDelete")
	public String eventDelete(Model model, long bno) {
		eventService.eventDelete(bno);
		return "redirect:/event/menu_select_all";

	}
}