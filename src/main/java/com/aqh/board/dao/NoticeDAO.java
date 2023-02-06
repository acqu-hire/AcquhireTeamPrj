package com.aqh.board.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.Criteria;
import com.aqh.file.domain.FileNoticeDTO;

@Repository
public class NoticeDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<BoardDTO> menuSelectAll(Criteria criteria){
		return sqlSessionTemplate.selectList("menuSelectAll",criteria);
	}
	public List<BoardDTO> categorySelectAll(Criteria criteria) {
		return sqlSessionTemplate.selectList("categorySelectAll", criteria);
	}

	public BoardDTO selectDetail(Integer bNo) {
		return sqlSessionTemplate.selectOne("noticeSelectDetail", bNo);
	}
	public int BoardListAllCount(Criteria criteria) {
		return sqlSessionTemplate.selectOne("BoardListAllCount",criteria);
	}
	public int CategoryListCount(Criteria criteria) {
		return sqlSessionTemplate.selectOne("CategoryListCount", criteria);
	}

	public void insert(BoardDTO boardDTO) {
		sqlSessionTemplate.insert("noticeInsert", boardDTO);
	}

	public void update(BoardDTO boardDTO) {
		sqlSessionTemplate.update("noticeUpdate", boardDTO);
	}

	public void delete(int bNo) {
		sqlSessionTemplate.delete("noticeDelete", bNo);
	}

	public void noticeReadCount(int bNo) {
		sqlSessionTemplate.delete("noticeReadCount", bNo);
	}

	public List<FileNoticeDTO> fileUpList(long bNo) {
		return sqlSessionTemplate.selectList("fileUploadList", bNo);
	}

	public void fileInsert(List<FileNoticeDTO> fileNoList) {
		sqlSessionTemplate.insert("fileInsert", fileNoList);
	}

	public void fileDeleteAll(int bNo) {
		sqlSessionTemplate.delete("fileDeleteAll", bNo);
	}
	public void fileSelectDelete(HashMap<String, Object> uuidList) {
		sqlSessionTemplate.delete("fileSelectDelete", uuidList);
	}

}
