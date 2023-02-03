package com.aqh.board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqh.board.dao.NoticeDAO;
import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.Criteria;
import com.aqh.common.domain.FileNoticeDTO;


@Service
public class NoticeService{

	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<BoardDTO> menuSelectAll(Criteria criteria){
		return noticeDAO.menuSelectAll(criteria);
	}
	public List<BoardDTO> categorySelectAll(Criteria criteria){
		return noticeDAO.categorySelectAll(criteria);
	}
	public BoardDTO selectDetail(Integer bno) {
		return noticeDAO.selectDetail(bno);
	}
	public int BoardListAllCount(Criteria criteria) {
		return noticeDAO.BoardListAllCount(criteria);
	}
	public int CategoryListCount(Criteria criteria) {
		return noticeDAO.CategoryListCount(criteria);
	}
	public void insert(BoardDTO boardDTO) {
		noticeDAO.insert(boardDTO);
	}
	public void update(BoardDTO boardDTO) {
		noticeDAO.update(boardDTO);
	}
	public void delete(int bno) {
		noticeDAO.delete(bno);
	}
	public void noticeReadCount(int bno) {
		noticeDAO.noticeReadCount(bno);
	}
	
	public List<FileNoticeDTO> fileUpList(long bno){
		return noticeDAO.fileUpList(bno);
	}
	
	public void fileInsert(List<FileNoticeDTO> fileNoList) {
		noticeDAO.fileInsert(fileNoList);
	}
	
	public void fileDeleteAll(int bno) {
		noticeDAO.fileDeleteAll(bno);
	}
	
	public void fileSelectDelete(HashMap<String,Object> uuidList) {
		noticeDAO.fileSelectDelete(uuidList);
	}
}
