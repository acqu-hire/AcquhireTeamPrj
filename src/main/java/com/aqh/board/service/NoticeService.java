package com.aqh.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqh.board.domain.dao.NoticeDAO;
import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.BoardDTO.Category;

@Service
public class NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<BoardDTO> menuSelectAll(){
		return noticeDAO.menuSelectAll();
	}
	public List<BoardDTO> categorySelectAll(Category category){
		return noticeDAO.categorySelectAll(category);
	}
	public BoardDTO selectDetail(long bNo) {
		return noticeDAO.selectDetail(bNo);
	}
	public void insert(BoardDTO boardDTO) {
		noticeDAO.insert(boardDTO);
	}
	public void update(BoardDTO boardDTO) {
		noticeDAO.update(boardDTO);
	}
	public void delete(int bNo) {
		noticeDAO.delete(bNo);
	}
}
