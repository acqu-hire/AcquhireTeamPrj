package com.aqh.board.domain.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.context.annotation.Primary;

import com.aqh.common.domain.dto.AttachFile;

import lombok.Builder;

@Primary
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
	private MultipartFile files; // 게시글 첨부파일
	private List<AttachFile> attachFile; // 파일 정보
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

	public MultipartFile getFiles() {
		return files;
	}

	public void setFiles(MultipartFile files) {
		this.files = files;
	}

	public List<AttachFile> getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(List<AttachFile> attachFile) {
		this.attachFile = attachFile;
	}

	@Override
	public String toString() {
		return "BoardDTO [id=" + id + ", menu=" + menu + ", category=" + category + ", bNo=" + bNo + ", readCount="
				+ readCount + ", files=" + files + ", attachFile=" + attachFile + ", title=" + title + ", writeDay="
				+ writeDay + ", contents=" + contents + "]";
	}

}