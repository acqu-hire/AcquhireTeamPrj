package com.aqh.board.domain.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component
public class CriteriaEvent {

	// 현재 페이징 번호
	private int num;

	// 시작 번호
	private int displayPost;

	// 게시물 범위
	private int postNum;

	// 카테고리
	private String category;

	// 검색 타입
	private String searchType;

	// 키워드
	private String keyword;

	public CriteriaEvent() {
		this(1, 5);
	}

	public CriteriaEvent(int num, int postNum) {
		this.num = num;
		this.postNum = postNum;
	}

	public int getDisplayPost() {
		return this.displayPost = (num - 1) * postNum;
	}

}