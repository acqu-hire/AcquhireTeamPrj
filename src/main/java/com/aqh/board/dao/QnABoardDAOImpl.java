package com.aqh.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.Criteria;
import com.aqh.common.domain.FileDTO;

@Repository
public class QnABoardDAOImpl implements BoardDAO{

	@Autowired
	SqlSessionTemplate session;
	
	String namespace = "com.aqh.board.dao.QnAMapper.";
	
	@Override
	public int insertBoard(BoardDTO boardDTO) {
		return session.insert(namespace + "insertBoard", boardDTO);
	}
	
	@Override
	public List<BoardDTO> getBoardList(Criteria cri) {
		return session.selectList(namespace + "getBoardList", cri);
	}
	
	@Override
	public int getBoardTotal(Criteria criteria) {
		return session.selectOne(namespace + "getBoardTotal", criteria);
	}
	
	@Override
	public BoardDTO findByBoardNumber(long bno) {
		return session.selectOne(namespace + "findByBoardNumber", bno);
	}
	
	@Override
	public int updateBoard(BoardDTO boardDTO) {
		return session.update(namespace + "updateBoard", boardDTO);
	}
	
	@Override
	public int viewCntUp(long bno) {
		return session.update(namespace + "viewCntUp", bno);
	}
	
	@Override
	public int deleteBoard(long bno) {
		return session.delete(namespace + "deleteBoard", bno);
	}
	
	@Override
	public int getReplyTotal(long bno) {
		return session.selectOne(namespace + "getReplyTotal", bno);
	}
	
	@Override
	public List<FileDTO> getFileList(long bno) {
		return session.selectList(namespace + "getFileList", bno);
	}
	
}