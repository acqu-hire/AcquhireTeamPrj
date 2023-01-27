package com.aqh.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.CriteriaEvent;

@Repository
public class EventDAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	String namespace = "com.aqh.board.domain.dao.EventMapper.";

	public List<BoardDTO> eventMenuSelectAll(CriteriaEvent criteriaEvent) {
		return sqlSessionTemplate.selectList(namespace + "eventMenuSelectAll", criteriaEvent);

	}

	public List<BoardDTO> eventItEventList(CriteriaEvent criteriaEvent) {
		return sqlSessionTemplate.selectList(namespace + "eventItEventList", criteriaEvent);
	}

	public List<BoardDTO> eventMarketingList(CriteriaEvent criteriaEvent) {
		return sqlSessionTemplate.selectList(namespace + "eventMarketingList", criteriaEvent);
	}

	public BoardDTO eventSelectDetail(long bno) {
		return sqlSessionTemplate.selectOne(namespace + "eventSelectDetail", bno);

	}

	public void eventInsert(BoardDTO boardDTO) {
		sqlSessionTemplate.insert(namespace + "eventInsert", boardDTO);
	}

	public void eventUpdate(BoardDTO boardDTO) {
		sqlSessionTemplate.update(namespace + "eventUpdate", boardDTO);
	}

	public void eventDelete(long bno) {
		sqlSessionTemplate.delete(namespace + "eventDelete", bno);
	}
	
	public int readCountUp(long bno) {
		return sqlSessionTemplate.update(namespace + "readCountUp", bno);
		
	}
	
	public int BoardCount(CriteriaEvent criteriaEvent) {
		return sqlSessionTemplate.selectOne(namespace + "BoardCount",criteriaEvent);
	}
	
	public int CategoryCount(CriteriaEvent criteriaEvent) {
		return sqlSessionTemplate.selectOne(namespace + "CategoryCount", criteriaEvent);
	}
}