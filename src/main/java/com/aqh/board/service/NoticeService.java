package com.aqh.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqh.board.domain.dao.NoticeDAO;
import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.CriteriaNotice;
import com.aqh.common.domain.dto.FileNoticeDTO;


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
	public BoardDTO selectDetail(Integer bNo) {
		return noticeDAO.selectDetail(bNo);
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
	public void delete(int bNo) {
		noticeDAO.delete(bNo);
	}
	public void noticeReadCount(int bNo) {
		noticeDAO.noticeReadCount(bNo);
	}
	
	public List<FileNoticeDTO> fileUpList(long bNo){
		return noticeDAO.fileUpList(bNo);
	}
	public void fileInsert(List<FileNoticeDTO> fileNoList) {
		noticeDAO.fileInsert(fileNoList);
	}
	public void fileDeleteAll(int bNo) {
		noticeDAO.fileDeleteAll(bNo);
	}
	public void fileSelectDelete(String uuid) {
		noticeDAO.fileSelectDelete(uuid);
	}
}
