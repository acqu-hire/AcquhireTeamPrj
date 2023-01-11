package com.aqh.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqh.board.domain.dao.CommunityDAO;
import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.BoardDTO.Category;
import com.aqh.board.domain.dto.Criteria;

/**
 * 커뮤니티 구현 추상화
 * 
 * @author Desvesg
 * 
 */
@Service
public class CommunityService {

	@Autowired
	private CommunityDAO communityBoardDAO;

	// CREATE
	public void createPost(BoardDTO boardDTO) {
		communityBoardDAO.createPost(boardDTO);
	};

	// READ
	public List<BoardDTO> getAllCommunityPostList(Criteria criteria) {
		return communityBoardDAO.getAllCommunityPostList(criteria);
	};

	public long getTotal(Criteria criteria) {
		return communityBoardDAO.getTotal(criteria);
	}

	public BoardDTO getPost(long bNo) {
		return communityBoardDAO.getPost(bNo);
	};

	// UPDATE
	public void updatePost(BoardDTO boardDTO) {
		communityBoardDAO.updatePost(boardDTO);
	};
	public void setPostCountUp(long bNo) {
		communityBoardDAO.setPostCountUp(bNo);
	};
	
	// DELETE
	public void deletePost(long bNo) {
		communityBoardDAO.deletePost(bNo);
	};

}
