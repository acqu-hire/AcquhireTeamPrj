package com.aqh.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.Criteria;

@Repository
public class CommunityDAOImpl implements BoardDAO{

	@Autowired
	SqlSessionTemplate sessionTemplate;

	// ! CREATE

	@Override
	public int insertBoard(BoardDTO boardDTO) {
		return sessionTemplate.insert("insertBoard", boardDTO);
	}

	// ! READ
	
	@Override
	public List<BoardDTO> getList(Criteria criteria) {
		return sessionTemplate.selectList("getList", criteria);
	}

	public int getTotal(Criteria criteria) {
		return sessionTemplate.selectOne("getTotal",criteria);
	}

	@Override
	public BoardDTO findByBoardNumber(long bno) {
		return sessionTemplate.selectOne("findByBoardNumber", bno);
	}

	// ! UPDATE

	@Override
	public int viewCntUp(long bno) {
		return sessionTemplate.update("viewCntUp", bno);
	}
	
	@Override
	public int updateBoard(BoardDTO boardDTO) {
		return sessionTemplate.update("updateBoard", boardDTO);
	}

	// ! DELETE
	
	@Override
	public int deleteBoard(long bno) {
		return sessionTemplate.delete("deleteBoard", bno);
	};

}
