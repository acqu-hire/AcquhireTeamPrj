package com.aqh.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aqh.board.dao.CommunityDAOImpl;
import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.Criteria;

import lombok.RequiredArgsConstructor;

/**
 * 커뮤니티 구현 추상화
 * 
 * @author Desvesg
 * 
 */

@RequiredArgsConstructor
@Service
public class CommunityService {

	private final CommunityDAOImpl communityDAOImpl;

	// CREATE
	public int insertBoard(BoardDTO boardDTO) {
		return communityDAOImpl.insertBoard(boardDTO);
	}

	// READ
	public List<BoardDTO> getBoardList(Criteria criteria) {
		return communityDAOImpl.getBoardList(criteria);
	}

	public BoardDTO findByBoardNumber(long bno) {
		return communityDAOImpl.findByBoardNumber(bno);
	}

	public int getBoardTotal(Criteria criteria) {
		return communityDAOImpl.getBoardTotal(criteria);
	}

	public int getReplyTotal(long bno) {
		// 구현 필요
		return communityDAOImpl.getReplyTotal(bno);
	}

	// UPDATE
	public int updateBoard(BoardDTO boardDTO) {
		return communityDAOImpl.updateBoard(boardDTO);

	}

	public int viewCntUp(long bno) {
		return communityDAOImpl.viewCntUp(bno);
	}

	// DELETE
	public int deleteBoard(long bno) {
		return communityDAOImpl.deleteBoard(bno);
	}

}
