package com.aqh.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqh.board.domain.dao.CommunityDAO;
import com.aqh.board.domain.dto.BoardDTO;

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
	public List<BoardDTO> getAllCommunityPostList() {
		return communityBoardDAO.getAllCommunityPostList();
	};

	public List<BoardDTO> getLifePostList() {
		return communityBoardDAO.getLifePostList();
	};

	public List<BoardDTO> getGroupPostList() {
		return communityBoardDAO.getGroupPostList();
	};

	public BoardDTO getPost(long bNo) {
		return communityBoardDAO.getPost(bNo);
	};

	public long getTotal() {
		return communityBoardDAO.getTotal();
	};

	// UPDATE
	public void updatePost(BoardDTO boardDTO) {
		communityBoardDAO.updatePost(boardDTO);
	};

	// DELETE
	public void deletePost(long bNo) {
		communityBoardDAO.deletePost(bNo);
	};

}
