package com.aqh.board.domain.dto;

import org.springframework.stereotype.Component;

import lombok.Builder;

@Component
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
	private String file; // 게시글 파일
	private String title; // 게시글 제목
	private String writeDay; // 게시글 작성일
	private String contents; // 게시글 내용

	@Builder
	public BoardDTO(String id, Menu menu, Category category, long bNo, long readCount, String file, String title,
			String writeDay, String contents) {
		this.id = id;
		this.menu = menu;
		this.category = category;
		this.bNo = bNo;
		this.readCount = readCount;
		this.file = file;
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

	public Long getbNo() {
		return bNo;
	}

	public void setbNo(Long bNo) {
		this.bNo = bNo;
	}

	public Long getReadCount() {
		return readCount;
	}

	public void setReadCount(Long readCount) {
		this.readCount = readCount;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
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

	@Override
	public String toString() {
		return "BoardDTO [id=" + id + ", menu=" + menu + ", category=" + category + ", bNo=" + bNo + ", readCount="
				+ readCount + ", file=" + file + ", title=" + title + ", writeDay=" + writeDay + ", contents="
				+ contents + "]";
	}

}