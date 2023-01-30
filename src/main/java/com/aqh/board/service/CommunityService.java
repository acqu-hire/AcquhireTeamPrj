package com.aqh.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aqh.board.dao.CommunityDAOImpl;
import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.Criteria;
import com.aqh.common.dao.UploadDAO;
import com.aqh.common.domain.BoardAttachVO;

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

	private final UploadDAO uploadDAO;

	// CREATE
	public int insertBoard(BoardDTO boardDTO) {
		return communityDAOImpl.insertBoard(boardDTO);
	}

	public int insert(BoardAttachVO boardAttachVO) {
		return uploadDAO.insert(boardAttachVO);
	}

	// READ

	public List<BoardAttachVO> getAttachList(long bno) {
		return uploadDAO.getAttachList(bno);
	}

	public List<BoardDTO> getList(Criteria criteria) {
		return communityDAOImpl.getList(criteria);
	}

	public BoardDTO findByBoardNumber(long bno) {
		return communityDAOImpl.findByBoardNumber(bno);
	}

	public int getBoardTotal(Criteria criteria) {
		return communityDAOImpl.getBoardTotal(criteria);
	}

	public int getReplyTotal(Criteria criteria) {
		// 구현 필요
		return communityDAOImpl.getReplyTotal(criteria);
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
		uploadDAO.deleteAttach(bno);
		return communityDAOImpl.deleteBoard(bno);
	}

}
