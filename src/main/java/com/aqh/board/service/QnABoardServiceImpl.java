package com.aqh.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqh.board.dao.BoardDAO;
import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.Criteria;
import com.aqh.file.domain.FileDTO;

@Service
public class QnABoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO qnABoardDAOImpl;

	@Override
	public int insertBoard(BoardDTO boardDTO) {
		return qnABoardDAOImpl.insertBoard(boardDTO);
	}

	@Override
	public List<BoardDTO> getBoardList(Criteria cri) {
		return qnABoardDAOImpl.getBoardList(cri);
	}

	@Override
	public int getBoardTotal(Criteria criteria) {
		return qnABoardDAOImpl.getBoardTotal(criteria);
	}

	@Override
	public BoardDTO findByBoardNumber(long bno) {
		qnABoardDAOImpl.viewCntUp(bno);
		BoardDTO boardDTO = qnABoardDAOImpl.findByBoardNumber(bno);
		return boardDTO;
	}

	@Override
	public int updateBoard(BoardDTO boardDTO) {
		return qnABoardDAOImpl.updateBoard(boardDTO);
	}

	@Override
	public int viewCntUp(long bno) {
		return qnABoardDAOImpl.viewCntUp(bno);
	}

	@Override
	public int deleteBoard(long bno) {
		return qnABoardDAOImpl.deleteBoard(bno);
	}

	@Override
	public long getReplyTotal(long bno) {
		return qnABoardDAOImpl.getReplyTotal(bno);
	}

	@Override
	public List<FileDTO> getFileList(long bno) {
		return qnABoardDAOImpl.getFileList(bno);
	}

}