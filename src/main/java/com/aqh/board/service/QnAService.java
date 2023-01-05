package com.aqh.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqh.board.domain.dao.QnADAO;
import com.aqh.board.domain.dto.BoardDTO;

@Service
public class QnAService {

	@Autowired
	QnADAO qnaDao;
	
	public int getBoardCnt(BoardDTO boardDTO) {
		return qnaDao.boardCount(boardDTO);
	}
	
	public int getBoardCnt() {
		return qnaDao.boardCount();
	}
	
	public int readCntUp(long bNo) {
		return qnaDao.readCountUp(bNo);
	}
	
	public List<BoardDTO> selectAll(BoardDTO boardDTO) {
		return qnaDao.selectAll(boardDTO);
	}

	public List<BoardDTO> selectAll() {
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
}
