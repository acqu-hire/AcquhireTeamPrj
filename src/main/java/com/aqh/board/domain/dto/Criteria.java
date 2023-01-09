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
	private Integer amount; //  페이징 범위
    private Category category;  // 카테고리
	private String type; // 검색할 카테고리
	private String keyword; // 검색 내용

	public Criteria() {
		this(1, 10);
	}

	public Criteria(Integer page, Integer amount) {
		this.page = page;
		this.amount = amount;
	}

	public String[] getTypes() {
		return type == null ? new String[] {} : type.split("");
	}
}
