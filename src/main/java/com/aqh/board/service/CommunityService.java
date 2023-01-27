package com.aqh.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aqh.board.dao.CommunityDAOImpl;
import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.Criteria;
import com.aqh.common.dao.UploadDAO;
import com.aqh.common.domain.dto.BoardAttachVO;

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

	private final CommunityDAOImpl communityBoardDAOImpl;

	private final UploadDAO uploadDAO;
	// CREATE
	public void insertBoard(BoardDTO boardDTO) {
		communityBoardDAOImpl.insertBoard(boardDTO);
	}

	public int insert(BoardAttachVO boardAttachVO) {
		return uploadDAO.insert(boardAttachVO);
	}

	// READ
	
	public List<BoardAttachVO> getAttachList(long bNo){
		return uploadDAO.getAttachList(bNo);
	}	

	public List<BoardDTO> getList(Criteria criteria) {
		return communityBoardDAOImpl.getList(criteria);
	}

	public BoardDTO findByBoardNumber(long bNo) {
		return communityBoardDAOImpl.findByBoardNumber(bNo);
	}
	
	public int getTotal(Criteria criteria) {
		return communityBoardDAOImpl.getTotal(criteria);
	}


	// UPDATE
	public int updateBoard(BoardDTO boardDTO) {
		return communityBoardDAOImpl.updateBoard(boardDTO);

	}
	public int viewCntUp(long bno) {
		return communityBoardDAOImpl.viewCntUp(bno);
	}
	
	// DELETE
	public int deleteBoard(long bNo) {
		uploadDAO.deleteAttach(bNo);
		return communityBoardDAOImpl.deleteBoard(bNo);
	}

}
