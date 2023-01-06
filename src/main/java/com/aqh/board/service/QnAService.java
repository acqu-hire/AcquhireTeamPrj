package com.aqh.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqh.board.domain.dao.QnADAO;
import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.BoardDTO.Category;

@Service
public class QnAService {

	@Autowired
	QnADAO qnaDao;
	
	public int getBoardCnt(Map map) {
		return qnaDao.boardCount(map);
	}
	
	public int getBoardCnt() {
		return qnaDao.boardCount();
	}
	
	public int readCntUp(long bNo) {
		return qnaDao.readCountUp(bNo);
	}
	
	public List<BoardDTO> selectAll(Map map) {
		return qnaDao.selectAll(map);
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
