package com.aqh.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.service.EventService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/event")
public class EventController {

	@Autowired
	EventService eventService;
	
	@GetMapping("/menu_select_all")
	public String menuSelectAll(Model model) {
		model.addAttribute("boardList", eventService.eventMenuSelectAll());
		return "board/event/eventList";
	}
	
	@GetMapping("/it_event_list")
	public String itEventList(Model model) {
		model.addAttribute("boardList", eventService.eventItEventList());
		return "board/event/event_it_event_list";
		
	}
	
	@GetMapping("/marketing_list")
	public String marketingList(Model model) {
		model.addAttribute("boardList", eventService.eventMarketingList());
		return "board/event/event_marketing_list";
		
	}

}
