package com.aqh.board.domain.dto;

public class BoardDTO {
    private enum menu {
        QNA, COMMUNITY, EVENT, NOTICE
    }

    private enum category {
        QNA_TECH,QNA_CAREER,QNA_ETC,
        COMMUNITY_LIFE,COMMUNITY_GROUP,
        EVENT_IT_EVENT,EVENT_MARKETING,
        NOTICE_NOTICE,NOTICE_EVENT
    }
    private String id; // 회원 아이디

    private Long bNo; // 게시글 번호
    private Long readCount; // 게시글 조회수
    private String file; // 게시글 파일
    private String title; // 게시글 제목
    private String writeDay; // 게시글 작성일
    private String contents; // 게시글 내용
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
		return "BoardDTO [id=" + id + ", bNo=" + bNo + ", readCount=" + readCount + ", file=" + file + ", title="
				+ title + ", writeDay=" + writeDay + ", contents=" + contents + "]";
	}

    
    
}