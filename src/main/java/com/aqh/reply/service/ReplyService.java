package com.aqh.reply.service;

import com.aqh.reply.domain.ReplyCriteria;
import com.aqh.reply.domain.ReplyDTO;
import com.aqh.reply.domain.ReplyPageDTO;

public interface ReplyService {

	int register(ReplyDTO replyDTO);

	ReplyPageDTO getReplyList(Integer page, ReplyCriteria cri);

	ReplyDTO getReply(long rno);

	int modify(ReplyDTO replyDTO);

	int removeReply(long rno, long bno);

	int replyCntUpdate(long bno);
	
	int getNestedReplyList(long rno);

}