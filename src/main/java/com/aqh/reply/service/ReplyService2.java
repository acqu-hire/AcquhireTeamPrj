package com.aqh.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aqh.board.domain.dao.QnADAO;
import com.aqh.reply.domain.dao.ReplyDAO2;
import com.aqh.reply.domain.dto.ReplyCriteria;
import com.aqh.reply.domain.dto.ReplyDTO;

@Service
public class ReplyService2 {

	@Autowired
	private ReplyDAO2 replyDAO2;

	@Transactional(rollbackFor = Exception.class)
	public int register(ReplyDTO replyDTO) {
		int result = 0;
		result = replyDAO2.register(replyDTO);
		if(result == 1) {
			replyDAO2.replyCntUpdate(replyDTO.getBNo());			
		}
		return result;
	}

	public List<ReplyDTO> getReplyList(ReplyCriteria cri) {
		replyDAO2.replyCntUpdate(cri.getBNo());
		return replyDAO2.getReplyList(cri);
	}

	public ReplyDTO getReply(Long rno) {
		return replyDAO2.getReply(rno);
	}

	public int modify(ReplyDTO replyDTO) {
		return replyDAO2.modify(replyDTO);
	}

	@Transactional(noRollbackFor = Exception.class)
	public int removeReply(long rno, long bNo) {
		int result = 0;
		result = replyDAO2.removeReply(rno);
		if(result == 1) {
			replyDAO2.replyCntUpdate(bNo);			
		}
		return result;
	}
	
	public int replyCntUpdate(long bNo) {
		return replyDAO2.replyCntUpdate(bNo);
	}

}
