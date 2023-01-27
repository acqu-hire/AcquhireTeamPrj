package com.aqh.board.service;

import java.util.List;

import com.aqh.board.dao.QnADAO;
import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.Criteria;
import com.aqh.reply.dao.ReplyDAO;

public class QnABoardServiceImpl implements BoardService{
	
	QnADAO qnaDao;
	ReplyDAO replyDao;
	
	public QnABoardServiceImpl(QnADAO qnaDao, ReplyDAO replyDao) {
		this.qnaDao = qnaDao;
		this.replyDao = replyDao;
	}
	
	@Override
	public int insertBoard(BoardDTO boardDTO) {
		return 0;
	}
	
	@Override
	public List<BoardDTO> getList(Criteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public BoardDTO findByBoardNumber(long bno) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int updateBoard(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int viewCntUp(long bno) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int deleteBoard(long bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBoardTotal(Criteria criteria) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getReplyTotal(Criteria criteria) {
		// TODO Auto-generated method stub
		return 0;
	}
}
