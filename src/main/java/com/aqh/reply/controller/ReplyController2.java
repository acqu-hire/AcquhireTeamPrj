package com.aqh.reply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aqh.reply.domain.dto.ReplyCriteria;
import com.aqh.reply.domain.dto.ReplyDTO;
import com.aqh.reply.service.ReplyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ReplyController2 {

	@Autowired
	ReplyService service;
	
	@GetMapping("/listDetail/reply")
	public List<ReplyDTO> selectAll(ReplyCriteria cri) {
		System.out.println("cri =====>" + cri);
		List<ReplyDTO> list = service.getReplyList(cri);
		log.info("list ======>" + list);
		if(list!=null) {
			return list;
		}
		return list; 
	}
}