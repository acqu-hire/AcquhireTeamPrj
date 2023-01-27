package com.aqh.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;

import com.aqh.board.domain.dto.BoardDTO;
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
		return sessionTemplate.selectList("getAllCommunityPostList", criteria);

	};

	public long getTotal(Criteria criteria) {
		return sessionTemplate.selectOne("getTotal",criteria);
	}

	public BoardDTO getPost(long bno) {
		return sessionTemplate.selectOne("getPost", bno);
	};
	
	// UPDATE
	public void updatePost(BoardDTO boardDTO) {
		sessionTemplate.update("updatePost", boardDTO);
	};
	
	public void setPostCountUp(long bno) {
		sessionTemplate.selectOne("setPostCountUp", bno);
	};

	// DELETE
	public int deletePost(long bno) {
		return sessionTemplate.delete("deletePost", bno);
	};

}
