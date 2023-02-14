package com.aqh.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqh.board.dao.BoardDAO;
import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.Criteria;
import com.aqh.file.domain.FileDTO;

@Service
public class QnAServiceImpl implements BoardService {

	@Autowired
	BoardDAO qnADAOImpl;

	@Override
	public int insertBoard(BoardDTO boardDTO) {
		return qnADAOImpl.insertBoard(boardDTO);
	}

	@Override
	public List<BoardDTO> getBoardList(Criteria cri) {
		return qnADAOImpl.getBoardList(cri);
	}

	@Override
	public int getBoardTotal(Criteria criteria) {
		return qnADAOImpl.getBoardTotal(criteria);
	}

	@Override
	public BoardDTO findByBoardNumber(long bno) {
		qnADAOImpl.viewCntUp(bno);
		BoardDTO boardDTO = qnADAOImpl.findByBoardNumber(bno);
		return boardDTO;
	}

	@Override
	public int updateBoard(BoardDTO boardDTO) {
		return qnADAOImpl.updateBoard(boardDTO);
	}

	@Override
	public int viewCntUp(long bno) {
		return qnADAOImpl.viewCntUp(bno);
	}

	@Override
	public int deleteBoard(long bno) {
		return qnADAOImpl.deleteBoard(bno);
	}

	@Override
	public long getReplyTotal(long bno) {
		return qnADAOImpl.getReplyTotal(bno);
	}

	@Override
	public List<FileDTO> getFileList(long bno) {
		return qnADAOImpl.getFileList(bno);
	}

}