package com.aqh.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.Criteria;
import com.aqh.file.domain.FileDTO;

@Repository
public class CommunityDAOImpl implements BoardDAO {

	@Autowired
	SqlSessionTemplate sessionTemplate;

	String namespace = "com.aqh.board.domain.dao.CommunityDAOImpl.";
	// ! CREATE

	@Override
	public int insertBoard(BoardDTO boardDTO) {
		return sessionTemplate.insert(namespace + "insertBoard", boardDTO);
	}

	// ! READ

	@Override
	public List<BoardDTO> getBoardList(Criteria criteria) {
		return sessionTemplate.selectList(namespace + "getList", criteria);
	}

	@Override
	public int getBoardTotal(Criteria criteria) {
		return sessionTemplate.selectOne(namespace + "getTotal", criteria);
	}

	@Override
	public int getReplyTotal(long bno) {
		// 구현 필요
		return sessionTemplate.selectOne(namespace + "getTotal", bno);
	};

	@Override
	public BoardDTO findByBoardNumber(long bno) {
		return sessionTemplate.selectOne(namespace + "findByBoardNumber", bno);
	}

	// ! UPDATE

	@Override
	public int viewCntUp(long bno) {
		return sessionTemplate.update(namespace + "viewCntUp", bno);
	}

	@Override
	public int updateBoard(BoardDTO boardDTO) {
		return sessionTemplate.update(namespace + "updateBoard", boardDTO);
	}

	// ! DELETE

	@Override
	public int deleteBoard(long bno) {
		return sessionTemplate.delete(namespace + "deleteBoard", bno);
	}

	@Override
	public List<FileDTO> getFileList(long bno) {
		return sessionTemplate.selectList(namespace + "getFileList", bno);
	}

}
