package com.aqh.reply.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aqh.board.domain.dao.QnADAO;
import com.aqh.reply.domain.dao.ReplyDAO2;
import com.aqh.reply.domain.dto.ReplyCriteria;
import com.aqh.reply.domain.dto.ReplyDTO;
import com.aqh.reply.domain.dto.ReplyPageDTO;

@Service
public class ReplyService2 {

	private ReplyDAO2 replyDAO2;
	private QnADAO qnaDao;
	
	public ReplyService2(ReplyDAO2 replyDAO2, QnADAO qnaDao) {
		this.replyDAO2 = replyDAO2;
		this.qnaDao = qnaDao;
	}

	@Transactional(rollbackFor = Exception.class)
	public int register(ReplyDTO replyDTO) {
		int result = 0;
		for (int i = 0; i < 300; i++) {
			
			result = replyDAO2.register(replyDTO);
		}
//		if(result == 1) {
			replyDAO2.replyCntUpdate(replyDTO.getBNo());			
//		}
		return result;
	}

	@Transactional(rollbackFor = Exception.class)
	public ReplyPageDTO getReplyList(Integer page, ReplyCriteria cri) {
		if(page == null) {
			page = 1;
		}
		ReplyPageDTO replyPageDTO = new ReplyPageDTO();
		replyPageDTO.setCri(new ReplyCriteria(cri.getBNo(), page ,qnaDao.getReplyCnt(cri.getBNo())));
		replyDAO2.replyCntUpdate(cri.getBNo());
		replyPageDTO.setList(replyDAO2.getReplyList(replyPageDTO.getCri()));
		return replyPageDTO;
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
