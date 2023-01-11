package com.aqh.board.domain.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aqh.board.domain.dto.BoardDTO;

@Repository
public class EventDAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	String namespace = "com.aqh.board.domain.dao.EventMapper.";

	public List<BoardDTO> eventMenuSelectAll() {
		return sqlSessionTemplate.selectList(namespace + "eventMenuSelectAll");

	}

	public List<BoardDTO> eventItEventList() {
		return sqlSessionTemplate.selectList(namespace + "eventItEventList");
	}

	public List<BoardDTO> eventMarketingList() {
		return sqlSessionTemplate.selectList(namespace + "eventMarketingList");
	}

	public BoardDTO eventSelectDetail(long bNo) {
		return sqlSessionTemplate.selectOne(namespace + "eventSelectDetail", bNo);

	}

	public void eventInsert(BoardDTO boardDTO) {
		sqlSessionTemplate.insert(namespace + "eventInsert", boardDTO);
	}

	public void eventUpdate(BoardDTO boardDTO) {
		sqlSessionTemplate.update(namespace + "eventUpdate", boardDTO);
	}

	public void eventDelete(long bNo) {
		sqlSessionTemplate.delete(namespace + "eventDelete", bNo);
	}
}
