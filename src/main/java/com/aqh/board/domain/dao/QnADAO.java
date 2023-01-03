package com.aqh.board.domain.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aqh.board.domain.dto.BoardDTO;

@Repository
public class QnADAO {

	@Autowired
	SqlSessionTemplate sessionTemplate;
	
	String namespace = "com.aqh.board.domain.dao.QnAMapper.";
	
	public List<BoardDTO> selectAll() {
		return sessionTemplate.selectList(namespace + "selectAll");
	}
	
	public BoardDTO select() {
		return sessionTemplate.selectOne(namespace + "select");
	}
}
