package com.aqh.reply.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aqh.reply.domain.dto.ReplyDTO;
import com.aqh.reply.service.ReplyServiceImpI;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




/**
 * 댓글Controller
 * 
 * @author Devesg
 * @since 23.01.11
 * 
 */
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/replies")
@RestController
public class ReplyController {

	private final ReplyServiceImpI replyService;

	// ! CRATE
	@PostMapping(value = "/write",
	consumes = "application/json",
	produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> register(@RequestBody ReplyDTO replyDTO) {
		System.out.println(replyDTO.getBNo());
		System.out.println(replyDTO.toString());
		int logic = replyService.register(replyDTO);
		log.info("logic Check >>>>>", logic);
		return logic == 1 ? new ResponseEntity<>("Succes",HttpStatus.OK): new ResponseEntity<>(HttpStatus.OK);
	}

	// ! READ
	@GetMapping(value="/getBoardReplyList",
	produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,
			 MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<ReplyDTO>> getReply() {
		List<ReplyDTO> list =  replyService.getReplyList(155L);
		return list != null ? ResponseEntity.status(HttpStatus.OK).body(list) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(list) ;
	}
	@GetMapping(value="/{rno}",
	produces = {MediaType.TEXT_XML_VALUE,
				MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyDTO> get(@PathVariable("rno") Long rno) {
        log.info("get : " + rno);
		return new ResponseEntity<>(replyService.getReply(rno),HttpStatus.OK);
	}
	
	// ! UPDATE
	@RequestMapping(value="/{rno}",
	method={RequestMethod.PUT,RequestMethod.PATCH},
	consumes = "application/json",
	produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@RequestBody ReplyDTO replyDTO,@PathVariable("rno") Long rno) {
		replyDTO.setRNo(rno);
		log.info("rno >>>>" + rno);
		int logic = replyService.modify(replyDTO);
		return logic == 1 ?new ResponseEntity<>("success",HttpStatus.OK): new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

	// ! DELETE
	@DeleteMapping(value="/{rno} ",produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno) {
		int logic = replyService.removeReply(rno);
		return logic == 1 ? new ResponseEntity<>("succes",HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
