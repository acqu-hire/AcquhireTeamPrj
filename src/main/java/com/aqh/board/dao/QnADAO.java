package com.aqh.board.dao;

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
	
	public int readCountUp(long bno) {
		return session.update(namespace + "readCountUp", bno);
	}
	
	public List<BoardDTO> selectAll(SearchCondition sc) {
		return session.selectList(namespace + "selectAll", sc);
	}
	
	public BoardDTO selectDetail(long bno) {
		return session.selectOne(namespace + "selectDetail", bno);
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
	
	public void delete(long bno) {
		session.delete(namespace + "delete", bno);
	}
	
	public List<FileDTO> getFileList(long bno) {
		return session.selectList(namespace + "fileList", bno);
	}
	
	public long getReplyCnt(long bno) {
		return session.selectOne(namespace + "getReplyCnt", bno);
	}

	public int getReadCnt(long bno) {
		return session.selectOne(namespace + "getReadCnt", bno);
	}
}
