package com.aqh.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aqh.board.domain.dao.QnADAO;
import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.pagehandler.SearchCondition;
import com.aqh.common.domain.dto.FileDTO;
import com.aqh.reply.domain.dao.ReplyDAO;

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
	
	public int getBoardCnt() {
		return qnaDao.boardCount();
	}
	
	public int readCntUp(long bNo) {
		return qnaDao.readCountUp(bNo);
	}
	
	public List<BoardDTO> selectAll(SearchCondition sc) {
		
		return qnaDao.selectAll(sc);
	}
	
	public List<BoardDTO> selectAll() {
//		List<BoardDTO> list = qnaDao.selectAll();
//		replyDao.getReplyCnt(getBoardCnt());
		return qnaDao.selectAll();
	}
	
	public BoardDTO selectDetail(long bNo) {
		return qnaDao.selectDetail(bNo);
	}
	
	public int insert(BoardDTO boardDTO) {
		return qnaDao.insert(boardDTO);
	}
	
	public int update(BoardDTO boardDTO) {
		return qnaDao.update(boardDTO);
	}
	
	public void delete(long bNo) {
		qnaDao.delete(bNo);
	}
	
	public List<FileDTO> getFileList(long bNo) {
		return qnaDao.getFileList(bNo);
	}
	
	public long getReplyCnt(long bNo) {
		return qnaDao.getReplyCnt(bNo);
	}
}
