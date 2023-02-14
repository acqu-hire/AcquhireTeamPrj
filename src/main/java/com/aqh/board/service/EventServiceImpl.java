package com.aqh.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqh.board.dao.BoardDAO;
import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.Criteria;
import com.aqh.file.domain.FileDTO;

@Service
public class EventServiceImpl implements BoardService{

	@Autowired
	BoardDAO eventDAOImpl;

	@Override
	public int insertBoard(BoardDTO boardDTO) {
		return eventDAOImpl.insertBoard(boardDTO);
	}

	@Override
	public List<BoardDTO> getBoardList(Criteria cri) {
		return eventDAOImpl.getBoardList(cri);
	}

	@Override
	public int getBoardTotal(Criteria criteria) {
		return eventDAOImpl.getBoardTotal(criteria);
	}

	@Override
	public BoardDTO findByBoardNumber(long bno) {
		eventDAOImpl.viewCntUp(bno);
		BoardDTO boardDTO = eventDAOImpl.findByBoardNumber(bno);
		return boardDTO;
	}

	@Override
	public int updateBoard(BoardDTO boardDTO) {
		return eventDAOImpl.updateBoard(boardDTO);
	}

	@Override
	public int viewCntUp(long bno) {
		return eventDAOImpl.viewCntUp(bno);
	}

	@Override
	public int deleteBoard(long bno) {
		return eventDAOImpl.deleteBoard(bno);
	}

	@Override
	public long getReplyTotal(long bno) {
		return eventDAOImpl.getReplyTotal(bno);
	}

	@Override
	public List<FileDTO> getFileList(long bno) {
		return eventDAOImpl.getFileList(bno);
	}
}