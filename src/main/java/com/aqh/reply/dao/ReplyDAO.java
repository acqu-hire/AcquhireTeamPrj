package com.aqh.reply.dao;

import java.util.List;

import com.aqh.reply.domain.ReplyCriteria;
import com.aqh.reply.domain.ReplyDTO;

public interface ReplyDAO {

	int register(ReplyDTO replyDTO);

	List<ReplyDTO> getReplyList(ReplyCriteria cri);

	ReplyDTO getReply(long rno);

	int modify(ReplyDTO replyDTO);

	int removeReply(long rno);

	int replyCntUpdate(long bno);
	
	int getNestedReplyList(long rno);

}