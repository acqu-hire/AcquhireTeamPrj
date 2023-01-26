package com.aqh.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aqh.board.dao.CommunityDAO;
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

	private final CommunityDAO communityBoardDAO;

	private final UploadDAO uploadDAO;
	// CREATE
	public void createPost(BoardDTO boardDTO) {
		communityBoardDAO.createPost(boardDTO);
	};

	public int insert(BoardAttachVO boardAttachVO) {
		return uploadDAO.insert(boardAttachVO);
	}
	// READ
	public List<BoardAttachVO> getAttachList(long bno){
		return uploadDAO.getAttachList(bno);
	}	
	public List<BoardDTO> getAllCommunityPostList(Criteria criteria) {
		return communityBoardDAO.getAllCommunityPostList(criteria);
	};

	public long getTotal(Criteria criteria) {
		return communityBoardDAO.getTotal(criteria);
	}

	public BoardDTO getPost(long bno) {
		return communityBoardDAO.getPost(bno);
	};

	// UPDATE
	public void updatePost(BoardDTO boardDTO) {
		communityBoardDAO.updatePost(boardDTO);
	};
	public void setPostCountUp(long bno) {
		communityBoardDAO.setPostCountUp(bno);
	};
	
	// DELETE
	public boolean deletePost(long bno) {
		uploadDAO.deleteAttach(bno);
		return communityBoardDAO.deletePost(bno) == 1;
	};

}
