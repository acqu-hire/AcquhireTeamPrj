package com.aqh.board.domain.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.pagehandler.SearchCondition;
import com.aqh.common.domain.dto.FileDTO;

@Repository
public class QnADAO {

	@Autowired
	SqlSessionTemplate session;
	
	String namespace = "com.aqh.board.domain.dao.QnAMapper.";
	
	public int boardCount(SearchCondition sc) {
		return session.selectOne(namespace + "boardCount", sc);
	}

	public int boardCount() {
		return session.selectOne(namespace + "boardCount");
	}
	
	public int readCountUp(long bNo) {
		return session.update(namespace + "readCountUp", bNo);
	}
	
	public List<BoardDTO> selectAll(SearchCondition sc) {
		return session.selectList(namespace + "selectAll", sc);
	}

	public List<BoardDTO> selectAll() {
		return session.selectList(namespace + "selectAll");
	}
	
	public BoardDTO selectDetail(long bNo) {
		return session.selectOne(namespace + "selectDetail", bNo);
	}
	
	public int insert(BoardDTO boardDTO) {
		return session.insert(namespace + "insert", boardDTO);
	}
	
	public int update(BoardDTO boardDTO) {
		return session.update(namespace + "update", boardDTO);
	}

	public void deleteAll() {
		session.delete(namespace + "deleteAll");
	}
	
	public void delete(long bNo) {
		session.delete(namespace + "delete", bNo);
	}
	
	public List<FileDTO> getFileList(long bNo) {
		return session.selectList(namespace + "fileList", bNo);
	}
}
