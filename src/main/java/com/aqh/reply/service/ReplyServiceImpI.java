package com.aqh.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqh.reply.dao.ReplyDAO;
import com.aqh.reply.domain.dto.ReplyCriteria;
import com.aqh.reply.domain.dto.ReplyDTO;

/**
 * 댓글Service
 * 
 * @author Devesg
 * @since 23.01.11
 */
@Service
public class ReplyServiceImpI implements ReplyService {

	@Autowired
	private ReplyDAO replyDAO;

	@Override
	public int register(ReplyDTO replyDTO) {
		return replyDAO.register(replyDTO);
	}

	@Override
	public List<ReplyDTO> getReplyList(ReplyCriteria cri) {
		return replyDAO.getReplyList(cri);
	}

	@Override
	public ReplyDTO getReply(Long rno) {
		return replyDAO.getReply(rno);
	}

	@Override
	public int modify(ReplyDTO replyDTO) {
		return replyDAO.modify(replyDTO);
	}

	@Override
	public int removeReply(long rno) {
		return replyDAO.removeReply(rno);
	}

}
