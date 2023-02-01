package com.aqh.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqh.board.dao.BoardDAO;
import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.Criteria;
import com.aqh.common.domain.FileDTO;

/**
 * 커뮤니티 구현 추상화
 * 
 * @author Desvesg
 * 
 */

@Service
public class CommunityServiceImpl implements BoardService {

	@Autowired
	private BoardDAO communityDAOImpl;

	// CREATE
	@Override
	public int insertBoard(BoardDTO boardDTO) {
		return communityDAOImpl.insertBoard(boardDTO);
	}

	// READ
	@Override
	public List<BoardDTO> getBoardList(Criteria criteria) {
		return communityDAOImpl.getBoardList(criteria);
	}

	@Override
	public BoardDTO findByBoardNumber(long bno) {
		return communityDAOImpl.findByBoardNumber(bno);
	}

	@Override
	public int getBoardTotal(Criteria criteria) {
		return communityDAOImpl.getBoardTotal(criteria);
	}

	@Override
	public long getReplyTotal(long bno) {
		// 구현 필요
		return communityDAOImpl.getReplyTotal(bno);
	}

	// UPDATE
	@Override
	public int updateBoard(BoardDTO boardDTO) {
		return communityDAOImpl.updateBoard(boardDTO);

	}

	@Override
	public int viewCntUp(long bno) {
		return communityDAOImpl.viewCntUp(bno);
	}

	// DELETE
	@Override
	public int deleteBoard(long bno) {
		return communityDAOImpl.deleteBoard(bno);
	}

	@Override
	public List<FileDTO> getFileList(long bno) {
		return communityDAOImpl.getFileList(bno);
	}

}
