package com.aqh.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqh.board.domain.dao.QnADAO;
import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.pagehandler.SearchCondition;

@Service
public class QnAService {

	@Autowired
	QnADAO qnaDao;
	
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
