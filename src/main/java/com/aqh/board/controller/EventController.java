package com.aqh.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.BoardDTO.Category;
import com.aqh.board.domain.dto.CriteriaEvent;
import com.aqh.board.domain.pagehandler.PaginationEvent;
import com.aqh.board.service.EventService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/event")
public class EventController {

	@Autowired
	EventService eventService;

	@GetMapping("/menu_select_all") // 이벤트 게시판 전체 조회
	public String SelectAll(Model model, CriteriaEvent criteriaEvent) {
		model.addAttribute("eventMenuSelectAll", eventService.eventMenuSelectAll(criteriaEvent));
		model.addAttribute("PaginationEvent", new PaginationEvent(criteriaEvent, (int) eventService.BoardListAllCount(criteriaEvent)));
		log.info("이벤트 게시판 전체 조회 : " + model);
		return "board/event/eventList";
	}

	@GetMapping("/it_event_list") // it 이벤트 게시판 전체 조회
	public String itEventList(Model model, CriteriaEvent criteriaEvent) {
		model.addAttribute("eventList", eventService.eventItEventList(criteriaEvent));
		model.addAttribute("PaginationEvent", new PaginationEvent(criteriaEvent, (int) eventService.BoardListAllCount(criteriaEvent)));
		log.info("it 이벤트 게시판 전체 조회 : " + model);
		return "board/event/event_it_event_list";

	}

	@GetMapping("/marketing_list") // 마케팅 게시판 전체 조회
	public String marketingList(Model model, CriteriaEvent criteriaEvent) {
		model.addAttribute("eventMarketingList", eventService.eventMarketingList(criteriaEvent));
		return "board/event/event_marketing_list";

	}

	@GetMapping("/select_detail") // 게시판 상세 조회
	public String selectDetail(Model model, long bno) {
		BoardDTO boardDTO = eventService.eventSelectDetail(bno);
		model.addAttribute(boardDTO);
		log.info("게시판 상세 조회 : " + model);
		eventService.readCountUp(bno);
		log.info("게시판 조회수 : " + bno);
		return "board/event/eventListDetail";

	}

	@GetMapping("/eventInsert_view")
	public String InsertForm() {
		return "board/event/eventInsert";

	}

	@PostMapping("/eventInsert")
	public String eventInsert(Model model, BoardDTO boardDTO, Category category) {
		log.info("insert boardDTO 확인 : " + boardDTO);
		eventService.eventInsert(boardDTO);
		model.addAttribute(category);
		return "redirect:/event/menu_select_all";

	}

	@GetMapping("/eventUpdate_view")
	public String updateForm(Model model, BoardDTO boardDTO) {
		model.addAttribute("boardList", eventService.eventSelectDetail(boardDTO.getbno()));
		return "board/event/eventUpdate";

	}

	@PostMapping("/eventUpdate")
	public String eventUpdate(Model model, BoardDTO boardDTO) {
		eventService.eventUpdate(boardDTO);
		log.info("update boardDTO 확인 : " + boardDTO);
		log.info("update model 확인 : " + model);
		return "redirect:/event/menu_select_all";

	}
	
	@GetMapping("/eventDelete")
	public String eventDelete(Model model, long bno) {
		eventService.eventDelete(bno);
		return "redirect:/event/menu_select_all";

	}
}