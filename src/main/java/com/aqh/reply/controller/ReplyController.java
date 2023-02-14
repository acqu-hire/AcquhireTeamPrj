package com.aqh.reply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aqh.board.service.BoardService;
import com.aqh.reply.domain.ReplyCriteria;
import com.aqh.reply.domain.ReplyDTO;
import com.aqh.reply.domain.ReplyPageDTO;
import com.aqh.reply.service.ReplyService;

@RestController
public class ReplyController {
	ReplyService replySerivceImpl;
	BoardService qnAServiceImpl;

	@Autowired
	public ReplyController(ReplyService replySerivceImpl, BoardService qnAServiceImpl) {
		this.replySerivceImpl = replySerivceImpl;
		this.qnAServiceImpl = qnAServiceImpl;
	}

	@GetMapping(value = "/reply/{page}")
	public ResponseEntity<ReplyPageDTO> selectAll(@PathVariable Integer page, ReplyCriteria cri) {
		return new ResponseEntity<ReplyPageDTO>(replySerivceImpl.getReplyList(page, cri), HttpStatus.OK);
	}

	@PostMapping(value = "/reply")
	public ResponseEntity<Long> register(@RequestBody ReplyDTO replyDTO, long bno) {
		replyDTO.setBno(bno);
		int result = replySerivceImpl.register(replyDTO);
		long replyCnt = qnAServiceImpl.getReplyTotal(bno);
		if (result != 0)
			return new ResponseEntity<Long>(replyCnt, HttpStatus.OK);
		return new ResponseEntity<Long>(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping(value = "/reply/{rno}")
	public ResponseEntity<Long> remove(@PathVariable long rno, long bno) {
		long result = replySerivceImpl.removeReply(rno, bno);
		long replyCnt = qnAServiceImpl.getReplyTotal(bno);
		if (result < 1) {
			return new ResponseEntity<Long>(replyCnt, HttpStatus.OK);
		} else {
			return new ResponseEntity<Long>(result, HttpStatus.OK);
		}
	}

	@PatchMapping(value = "/reply/{rno}")
	public ResponseEntity<Long> update(@PathVariable long rno, @RequestBody ReplyDTO replyDTO) {
		replyDTO.setRno(rno);
		long result = replySerivceImpl.modify(replyDTO);
		if (result != 0)
			return new ResponseEntity<Long>(result, HttpStatus.OK);
		return new ResponseEntity<Long>(HttpStatus.BAD_REQUEST);
	}
}