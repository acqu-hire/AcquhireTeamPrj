package com.aqh.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqh.board.domain.dao.NoticeDAO;
import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.BoardDTO.Category;
import com.aqh.board.domain.pagehandler.PagenationNotice;

@Service
public class NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<BoardDTO> menuSelectAll(int displayPost, int postNum){
		return noticeDAO.menuSelectAll(displayPost, postNum);
	}
	public List<BoardDTO> categorySelectAll(BoardDTO boardDTO){
		return noticeDAO.categorySelectAll(boardDTO);
	}
	public BoardDTO selectDetail(Integer bNo) {
		return noticeDAO.selectDetail(bNo);
	}
	public int BoardListAllCount() {
		return noticeDAO.BoardListAllCount();
	}
	public int CategoryListCount(BoardDTO boardDTO) {
		return noticeDAO.CategoryListCount(boardDTO);
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
