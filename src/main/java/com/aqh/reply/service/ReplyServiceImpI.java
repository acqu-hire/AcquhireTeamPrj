package com.aqh.reply.service;

import java.util.List;

import com.aqh.reply.domain.dao.ReplyDAO;
import com.aqh.reply.domain.dto.ReplyDTO;

import lombok.RequiredArgsConstructor;

/**
 * 댓글Service
 * 
 * @author Devesg
 * @since 23.01.11
 */
//@Service
@RequiredArgsConstructor
public class ReplyServiceImpI implements ReplyService {

	private final ReplyDAO replyDAO;


	@Override
	public int register(ReplyDTO replyDTO) {
		return replyDAO.register(replyDTO);
	}

	@Override
	public List<ReplyDTO> getReplyList(long bNo) {
		return replyDAO.getReplyList(bNo);
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
