package com.aqh.board.domain.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.BoardDTO.Category;
import com.aqh.board.domain.dto.Criteria;

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

	public List<BoardDTO> getAllCommunityPostList(Criteria criteria) {
		return sessionTemplate.selectList("getAllCommunityPostList",criteria);

	};

	public List<BoardDTO> getCategoryPostList(Category category) {
		return sessionTemplate.selectList("getCategoryPostList",category);
	};

	public BoardDTO getPost(long bNo) {
		return sessionTemplate.selectOne("getPost", bNo);
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
