package com.aqh.board.domain.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.aqh.common.domain.dto.AttachFileDTO;
import com.aqh.common.domain.dto.BoardAttachVO;
import com.aqh.common.domain.dto.FileDTO;
import com.aqh.common.domain.dto.FileNoticeDTO;

import lombok.Builder;

public class BoardDTO {

	public enum Menu {
		QNA, COMMUNITY, EVENT, NOTICE
	}

	public enum Category {
		QNA_TECH, QNA_CAREER, QNA_ETC,
		COMMUNITY_LIFE, COMMUNITY_GROUP,
		EVENT_IT_EVENT, EVENT_MARKETING,
		NOTICE_NOTICE, NOTICE_EVENT
	}

	private String id; // 회원 아이디

	private Menu menu; // 메뉴
	private Category category; // 카테고리
	private long bNo; // 게시글 번호
	private long readCount; // 게시글 조회수

	/**
	 * @author makemegrowup
	 */
	private List<MultipartFile> files; // 게시글 첨부파일
	private List<FileDTO> fileList; // 파일정보 리스트

	/**
	 * @author kimdoyeon12
	 */
	private List<FileNoticeDTO> fileNoList;// 공지사항 파일정보 리스트
	private MultipartFile uploadFile;// 공지사항 게시글

	/**
	 * @author Devesg
	 */
	private List<BoardAttachVO> attachList;

	private String title; // 게시글 제목
	private String writeDay; // 게시글 작성일
	private String contents; // 게시글 내용

	public BoardDTO() {
	}

	public BoardDTO(String id, String title, String contents, Menu menu) {
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.menu = menu;
	}

	@Builder
	public BoardDTO(String id, Menu menu, Category category, long bNo, long readCount,
			String title, String writeDay, String contents) {
		this.id = id;
		this.menu = menu;
		this.category = category;
		this.bNo = bNo;
		this.readCount = readCount;
		this.title = title;
		this.writeDay = writeDay;
		this.contents = contents;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public long getbNo() {
		return bNo;
	}

	public void setbNo(long bNo) {
		this.bNo = bNo;
	}

	public long getReadCount() {
		return readCount;
	}

	public void setReadCount(long readCount) {
		this.readCount = readCount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriteDay() {
		return writeDay;
	}

	public void setWriteDay(String writeDay) {
		this.writeDay = writeDay;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	public List<FileDTO> getFileList() {
		return fileList;
	}

	public void setFileList(List<FileDTO> fileList) {
		this.fileList = fileList;
	}

	public List<FileNoticeDTO> getFileNoList() {
		return fileNoList;
	}

	public void setFileNoList(List<FileNoticeDTO> fileNoList) {
		this.fileNoList = fileNoList;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public List<BoardAttachVO> getAttachList() {
		return attachList;
	}

	public void setAttachList(List<BoardAttachVO> attachList) {
		this.attachList = attachList;
	}

	@Override
	public String toString() {
		return "BoardDTO [id=" + id + ", menu=" + menu + ", category=" + category + ", bNo=" + bNo + ", readCount="
				+ readCount + ", files=" + files + ", fileList=" + fileList + ", fileNoList=" + fileNoList
				+ ", uploadFile=" + uploadFile + ", attachList=" + attachList + ", title=" + title + ", writeDay="
				+ writeDay + ", contents=" + contents + "]";
	}

}