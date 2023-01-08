package com.aqh.board.domain.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.BoardDTO.Category;

@Repository
public class QnADAO {

	@Autowired
	SqlSessionTemplate sessionTemplate;
	
	String namespace = "com.aqh.board.domain.dao.QnAMapper.";
	
	public int boardCount(Map map) {
		return sessionTemplate.selectOne(namespace + "boardCount", map);
	}

	public int boardCount() {
		return sessionTemplate.selectOne(namespace + "boardCount");
	}
	
	public int readCountUp(long bNo) {
		return sessionTemplate.update(namespace + "readCountUp", bNo);
	}
	
	public List<BoardDTO> selectAll(Map map) {
		return sessionTemplate.selectList(namespace + "selectAll", map);
	}

	public List<BoardDTO> selectAll() {
		return sessionTemplate.selectList(namespace + "selectAll");
	}
	
	public BoardDTO selectDetail(long bNo) {
		return sessionTemplate.selectOne(namespace + "selectDetail", bNo);
	}
	
	public int insert(BoardDTO boardDTO) {
		return sessionTemplate.insert(namespace + "insert", boardDTO);
	}
	
	public int update(BoardDTO boardDTO) {
		return sessionTemplate.update(namespace + "update", boardDTO);
	}

	public void deleteAll() {
		sessionTemplate.delete(namespace + "deleteAll");
	}
	
	public void delete(long bNo) {
		sessionTemplate.delete(namespace + "delete", bNo);
	}
	
}
