package com.aqh.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.Criteria;

public class QnABoardDAOImpl implements BoardDAO{

	@Autowired
	SqlSessionTemplate session;
	
	String namespace = "com.aqh.board.domain.dao.QnAMapper.";
	
	@Override
	public int insertBoard(BoardDTO boardDTO) {
		return session.insert(namespace + "insert", boardDTO);
	}
	
	@Override
	public List<BoardDTO> getList(Criteria criteria) {
		return session.selectList(namespace + "selectAll", criteria);
	}
	
	@Override
	public int getBoardTotal(Criteria criteria) {
		return session.selectOne(namespace + "boardCount", criteria);
	}
	
	@Override
	public int getReplyTotal(Criteria criteria) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public BoardDTO findByBoardNumber(long bno) {
		return session.selectOne(namespace + "selectDetail", bno);
	}
	
	@Override
	public int updateBoard(BoardDTO boardDTO) {
		return session.update(namespace + "update", boardDTO);
	}
	
	@Override
	public int viewCntUp(long bno) {
		return session.update(namespace + "readCountUp", bno);
	}
	
	@Override
	public int deleteBoard(long bno) {
		return session.delete(namespace + "delete", bno);
	}
}
