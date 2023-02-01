package com.aqh.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.Criteria;

@Repository
public class EventDAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	String namespace = "com.aqh.board.domain.dao.EventMapper.";

	//조회
	public List<BoardDTO> eventMenuSelectAll(Criteria cri) {
		return sqlSessionTemplate.selectList(namespace + "eventMenuSelectAll", cri);

	}

	public List<BoardDTO> eventItEventList(Criteria cri) {
		return sqlSessionTemplate.selectList(namespace + "eventItEventList", cri);
	}

	public List<BoardDTO> eventMarketingList(Criteria cri) {
		return sqlSessionTemplate.selectList(namespace + "eventMarketingList", cri);
	}

	public BoardDTO eventSelectDetail(long bno) {
		return sqlSessionTemplate.selectOne(namespace + "eventSelectDetail", bno);

	}

	//등록
	public void eventInsert(BoardDTO boardDTO) {
		sqlSessionTemplate.insert(namespace + "eventInsert", boardDTO);
	}

	//수정
	public void eventUpdate(BoardDTO boardDTO) {
		sqlSessionTemplate.update(namespace + "eventUpdate", boardDTO);
	}

	//삭제
	public void eventDelete(long bno) {
		sqlSessionTemplate.delete(namespace + "eventDelete", bno);
	}
	
	//추가 기능
	public int readCountUp(long bno) {
		return sqlSessionTemplate.update(namespace + "readCountUp", bno);
	}
	
	public int BoardCount(Criteria cri) {
		return sqlSessionTemplate.selectOne(namespace + "BoardCount", cri);
	}
}