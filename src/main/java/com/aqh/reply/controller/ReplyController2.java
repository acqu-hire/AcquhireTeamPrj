package com.aqh.reply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<List<ReplyDTO>> selectAll(ReplyCriteria cri) {
		System.out.println("cri =====>" + cri);
		List<ReplyDTO> list = service.getReplyList(cri);
		log.info("list ======>" + list);
		if(list!=null)
			return new ResponseEntity<List<ReplyDTO>>(list, HttpStatus.OK);
		return new ResponseEntity<List<ReplyDTO>>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(value =  "/listDetail/reply", produces = "application/text; charset=utf-8")
	public ResponseEntity<String> register(@RequestBody ReplyDTO replyDTO, long bNo) {
		replyDTO.setBNo(bNo);
		System.out.println("replyDTO =====>" + replyDTO);
		int result = service.register(replyDTO);
		log.info("result = " + result);
		if(result != 0)
			return new ResponseEntity<String>("댓글등록 완료", HttpStatus.OK);
		return new ResponseEntity<String>("댓글등록 실패", HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping(value = "/listDetail/reply/{rno}", produces = "application/text; charset=utf-8")
	public ResponseEntity<String> remove(@PathVariable long rno, long bNo){
		log.info("rno =====>" + rno);
		log.info("bNo =====>" + bNo);
		int result = service.removeReply(rno);
		if(result != 0)
			return new ResponseEntity<String>("삭제 성공", HttpStatus.OK);
		return new ResponseEntity<String>("삭제 실패", HttpStatus.BAD_REQUEST);
	}


}

