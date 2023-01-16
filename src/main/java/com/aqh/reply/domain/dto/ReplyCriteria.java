package com.aqh.reply.domain.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Component
@Data
//@RequiredArgsConstructor //기본 생성자보다 우선순위가 낮다.
@AllArgsConstructor
public class ReplyCriteria {
	private long bno;
	private long page; // 페이징
	private long limit; // 페이징 범위
	private long offset; // offest

	public ReplyCriteria() {
		this(0,1, 10);
	}

    @Builder
	public ReplyCriteria(long bno,long page, long limit) {
        this.bno = bno;
		this.page = page;
		this.limit = limit;
	}

	public long getOffset() {
		return (this.offset = (page - 1) * limit);
	}

}
