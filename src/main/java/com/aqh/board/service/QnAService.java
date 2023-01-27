package com.aqh.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aqh.board.dao.QnADAO;
import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.pagehandler.SearchCondition;
import com.aqh.common.domain.dto.FileDTO;
import com.aqh.reply.dao.ReplyDAO;

@Service
public class QnAService {
	
	QnADAO qnaDao;
	ReplyDAO replyDao;
	
	public QnAService(QnADAO qnaDao, ReplyDAO replyDao) {
		this.qnaDao = qnaDao;
		this.replyDao = replyDao;
	}
	
	public int getBoardCnt(SearchCondition sc) {
		return qnaDao.boardCount(sc);
	}
	
	public int readCntUp(long bno) {
		return qnaDao.readCountUp(bno);
	}
	
	public int getReadCnt(long bno) {
		return qnaDao.getReadCnt(bno);
	}
	
	public List<BoardDTO> selectAll(SearchCondition sc) {
		
		return qnaDao.selectAll(sc);
	}
	
	public BoardDTO selectDetail(long bno) {
		BoardDTO boardDTO = qnaDao.selectDetail(bno);
		qnaDao.readCountUp(bno);
		return boardDTO;
	}
	
	public int insert(BoardDTO boardDTO) {
		return qnaDao.insert(boardDTO);
	}
	
	public int update(BoardDTO boardDTO) {
		return qnaDao.update(boardDTO);
	}
	
	public void delete(long bno) {
		qnaDao.delete(bno);
	}
	
	public List<FileDTO> getFileList(long bno) {
		return qnaDao.getFileList(bno);
	}
	
	public long getReplyCnt(long bno) {
		return qnaDao.getReplyCnt(bno);
	}
}
