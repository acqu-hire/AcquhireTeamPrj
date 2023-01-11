package com.aqh.board.domain.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.BoardDTO.Category;
import com.aqh.board.domain.pagehandler.PagenationNotice;

@Repository
public class NoticeDAO {
	
	private static final int String = 0;
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<BoardDTO> menuSelectAll(int displayPost, int postNum){
		HashMap<String, Integer> data = new HashMap<String, Integer>();
		
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		
		return sqlSessionTemplate.selectList("menuSelectAll",data);
	}
	public List<BoardDTO> categorySelectAll(String category, int displayPost, int postNum ) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		data.put("category", category);
		
		
		return sqlSessionTemplate.selectList("categorySelectAll", data);
	}
	public BoardDTO selectDetail(Integer bNo) {
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
