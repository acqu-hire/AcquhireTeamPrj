package com.aqh.board.domain.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;

import com.aqh.board.domain.dto.BoardDTO;

@Repository
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class CommunityDAO {

	@Autowired
	SqlSessionTemplate sessionTemplate;

	// CREATE

	public void createPost(BoardDTO boardDTO) {
		sessionTemplate.insert("createPost", boardDTO);
	};

	// READ

	public List<BoardDTO> getAllCommunityPostList() {
		return sessionTemplate.selectList("getAllCommunityPostList");

	};

	public List<BoardDTO> getLifePostList() {
		return sessionTemplate.selectList("getLifePostList");
	};

	public List<BoardDTO> getGroupPostList() {
		return sessionTemplate.selectList("getGroupPostList");
	};

	public BoardDTO getPost(long bNo) {
		return sessionTemplate.selectOne("getPost", bNo);
	};

	public long getTotal() {
		return sessionTemplate.selectList("getAllCommunityPostList").size();
	};

	// UPDATE
	public void updatePost(BoardDTO boardDTO) {
		sessionTemplate.update("updatePost", boardDTO);
	};

	// DELETE
	public void deletePost(long bNo) {
		sessionTemplate.delete("deletePost", bNo);
	};

}
