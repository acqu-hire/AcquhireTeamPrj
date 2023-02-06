package com.aqh.board.domain.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.aqh.file.domain.FileDTO;
import com.aqh.file.domain.FileNoticeDTO;

import lombok.Data;

@Data
public class BoardDTO {

	public enum Menu {
		QNA, COMMUNITY, EVENT, NOTICE
	}

	public enum Category {
		QNA_TECH, QNA_CAREER, QNA_ETC, COMMUNITY_LIFE, COMMUNITY_GROUP, EVENT_IT_EVENT, EVENT_MARKETING, NOTICE_NOTICE,
		NOTICE_EVENT
	}

	private String id; // 회원 아이디

	private Menu menu; // 메뉴
	private Category category; // 카테고리
	private long bno; // 게시글 번호
	private long readCount; // 게시글 조회수
	private long replyCnt; // 게시글 댓글수

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

	private String title; // 게시글 제목
	private String writeDay; // 게시글 작성일
	private String contents; // 게시글 내용

}