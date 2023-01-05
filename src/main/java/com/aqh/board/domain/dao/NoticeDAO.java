package com.aqh.board.domain.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.BoardDTO.Category;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<BoardDTO> menuSelectAll(){
		return sqlSessionTemplate.selectList("menuSelectAll");
	}
	public List<BoardDTO> categorySelectAll(String category) {
		return sqlSessionTemplate.selectList("categorySelectAll", category);
	}
	public BoardDTO selectDetail(long bNo) {
		return sqlSessionTemplate.selectOne("noticeSelectDetail", bNo);
	}
	public int BoardListAllCount() {
		return sqlSessionTemplate.selectOne("BoardListAllCount");
	}
	public int CategoryListCount(String category) {
		return sqlSessionTemplate.selectOne("CategoryListCount", category);
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

}
