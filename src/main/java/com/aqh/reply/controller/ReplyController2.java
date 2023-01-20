package com.aqh.reply.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aqh.board.service.QnAService;
import com.aqh.reply.domain.dto.ReplyCriteria;
import com.aqh.reply.domain.dto.ReplyDTO;
import com.aqh.reply.service.ReplyService2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ReplyController2 {

	ReplyService2 service;
	QnAService QnaService;
	
	public ReplyController2(ReplyService2 service, QnAService QnaService) {
		this.service = service;
		this.QnaService = QnaService;
	}
	
	@GetMapping(value = "/listDetail/reply")
	public ResponseEntity<List<ReplyDTO>> selectAll(ReplyCriteria cri) {
		System.out.println("cri =====>" + cri);
		List<ReplyDTO> list = service.getReplyList(cri);
		log.info("list ======>" + list);
		if(list!=null)
			return new ResponseEntity<List<ReplyDTO>>(list, HttpStatus.OK);
		return new ResponseEntity<List<ReplyDTO>>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(value =  "/listDetail/reply")
	public ResponseEntity<Long> register(@RequestBody ReplyDTO replyDTO, long bNo) {
		System.out.println("replyDTO =====>" + replyDTO);
		replyDTO.setBNo(bNo);
		int result = service.register(replyDTO);
		long replyCnt = QnaService.getReplyCnt(bNo);
		log.info("result = " + result);
		log.info("replyCnt =====>" + replyCnt);
		if(result != 0)
			return new ResponseEntity<Long>(replyCnt, HttpStatus.OK);
		return new ResponseEntity<Long>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping(value = "/listDetail/reply/{rno}")
	public ResponseEntity<Long> remove(@PathVariable long rno, long bNo){
		log.info("rno =====>" + rno);
		log.info("bNo =====>" + bNo);
		int result = service.removeReply(rno, bNo);
		log.info("result =====>" + result);
		long replyCnt = QnaService.getReplyCnt(bNo);
		log.info("replyCnt =====>" + replyCnt);
		if(result != 0)
			return new ResponseEntity<Long>(replyCnt, HttpStatus.OK);
		return new ResponseEntity<Long>(HttpStatus.BAD_REQUEST);
	}
	
	@PatchMapping(value = "/listDetail/reply/{rno}")
	public ResponseEntity<Long> update(@PathVariable long rno, @RequestBody ReplyDTO replyDTO){
		log.info("replyDTO =====>" + replyDTO);
		replyDTO.setRno(rno);
		long result = service.modify(replyDTO);
		if(result != 0 )
			return new ResponseEntity<Long>(result, HttpStatus.OK);			
		return new ResponseEntity<Long>(HttpStatus.BAD_REQUEST);
	}
}

