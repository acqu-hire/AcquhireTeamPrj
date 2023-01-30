package com.aqh.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqh.board.dao.NoticeDAO;
import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.CriteriaNotice;
import com.aqh.common.domain.FileNoticeDTO;


@Service
public class NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<BoardDTO> menuSelectAll(CriteriaNotice criteriaNotice){
		return noticeDAO.menuSelectAll(criteriaNotice);
	}
	public List<BoardDTO> categorySelectAll(CriteriaNotice criteriaNotice){
		return noticeDAO.categorySelectAll(criteriaNotice);
	}
	public BoardDTO selectDetail(Integer bno) {
		return noticeDAO.selectDetail(bno);
	}
	public int BoardListAllCount(CriteriaNotice criteriaNotice) {
		return noticeDAO.BoardListAllCount(criteriaNotice);
	}
	public int CategoryListCount(CriteriaNotice criteriaNotice) {
		return noticeDAO.CategoryListCount(criteriaNotice);
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
	public void fileSelectDelete(String uuid) {
		noticeDAO.fileSelectDelete(uuid);
	}
}
