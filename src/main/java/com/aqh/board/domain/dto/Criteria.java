package com.aqh.board.domain.dto;

import org.springframework.stereotype.Component;

import com.aqh.board.domain.dto.BoardDTO.Category;

import lombok.AllArgsConstructor;
import lombok.Data;

@Component
@Data
//@RequiredArgsConstructor //기본 생성자보다 우선순위가 낮다.
@AllArgsConstructor
public class Criteria {
	private Integer page; // 페이징
	private Integer limit; // 페이징 범위
	private Integer offset; // offest
	private Category category; // 카테고리
	private String type; // 검색할 카테고리
	private String keyword; // 검색 내용

	public Criteria() {
		this(1, 10);
	}

	public Criteria(Integer page, Integer limit) {
		this.page = page;
		this.limit = limit;
	}

	public String[] getTypes() {
		return type == null ? new String[] {} : type.split("");
	}

	public int getOffset() {
		return this.offset = (page - 1) * limit;
	}

}
