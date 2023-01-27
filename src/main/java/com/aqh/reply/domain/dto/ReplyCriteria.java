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
	private Integer page; 		// 페이징
	private long limit; 		// 페이징 범위
	private long offset; 		// offest
	private long totalPage; 	// 전체 페이지 수
	private long endPage;		// 마지막 페이지
	private long startPage;		// 시작 페이지
	private long replyCnt;		// 댓글 수
	private int navSize = 5;	// 네비 사이즈

	public ReplyCriteria() {}
	
	public ReplyCriteria(long bno, Integer page, long replyCnt) {
		this(bno ,page, replyCnt, 30);
	}

    @Builder
	public ReplyCriteria(long bno, Integer page,long replyCnt, long limit) {
        this.bno = bno;
		this.page = page;
		this.replyCnt = replyCnt;
		this.limit = limit;
		
		paging();
	}
    
    public void paging() {
    	this.totalPage = (replyCnt/limit) + (replyCnt%limit != 0?1:0);
    	this.endPage = (int)(Math.ceil(page/(float)navSize) * navSize);
    	this.startPage = endPage-navSize+1;
    	if(endPage > totalPage) {
    		this.endPage = totalPage;
    	}
    }

	public long getOffset() {
		return (this.offset = (page - 1) * limit);
	}

}
