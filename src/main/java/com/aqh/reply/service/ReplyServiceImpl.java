package com.aqh.reply.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aqh.board.dao.BoardDAO;
import com.aqh.reply.dao.ReplyDAO;
import com.aqh.reply.domain.ReplyCriteria;
import com.aqh.reply.domain.ReplyDTO;
import com.aqh.reply.domain.ReplyPageDTO;

@Service
public class ReplyServiceImpl implements ReplyService {

	private ReplyDAO replyDAOImpl;
	private BoardDAO qnABoardDAOImpl;
	
	public ReplyServiceImpl(ReplyDAO replyDAOImpl, BoardDAO qnABoardDAOImpl) {
		this.replyDAOImpl = replyDAOImpl;
		this.qnABoardDAOImpl = qnABoardDAOImpl;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int register(ReplyDTO replyDTO) {
		int result = 0;
		result = replyDAOImpl.register(replyDTO);
		replyDAOImpl.replyCntUpdate(replyDTO.getBno());	
		return result;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ReplyPageDTO getReplyList(Integer page, ReplyCriteria cri) {
		if(page == null) {
			page = 1;
		}
		ReplyPageDTO replyPageDTO = new ReplyPageDTO();
		replyPageDTO.setCri(new ReplyCriteria(cri.getBno(), page ,qnABoardDAOImpl.getReplyTotal(cri.getBno())));
		replyDAOImpl.replyCntUpdate(cri.getBno());
		replyPageDTO.setList(replyDAOImpl.getReplyList(replyPageDTO.getCri()));
		return replyPageDTO;
	}

	@Override
	public ReplyDTO getReply(long rno) {
		return replyDAOImpl.getReply(rno);
	}

	@Override
	public int modify(ReplyDTO replyDTO) {
		return replyDAOImpl.modify(replyDTO);
	}

	@Override
	@Transactional(noRollbackFor = Exception.class)
	public int removeReply(long rno, long bno) {
		int result = replyDAOImpl.getNestedReplyList(rno);
		if(result < 1) {
			replyDAOImpl.removeReply(rno);
			replyDAOImpl.replyCntUpdate(bno);
			return result;
		} else {
			ReplyDTO replyDTO = new ReplyDTO();
			replyDTO.setRno(rno);
			replyDTO.setContents("");
			return replyDAOImpl.modify(replyDTO);
		}
	}
	
	@Override
	public int replyCntUpdate(long bno) {
		return replyDAOImpl.replyCntUpdate(bno);
	}
	
	@Override
	public int getNestedReplyList(long rno) {
		return replyDAOImpl.getNestedReplyList(rno);
	}

}