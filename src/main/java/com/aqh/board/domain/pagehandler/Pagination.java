 package com.aqh.board.domain.pagehandler;

import org.springframework.web.util.UriComponentsBuilder;

import com.aqh.board.domain.dto.Criteria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pagination {
     /** 한 페이지당 게시글 수 **/
     private int pageSize = 10;
    
     /** 한 블럭(range)당 페이지 수 **/
     private int rangeSize = 10;
     
     /** 현재 페이지 **/
     private int page = 1;
     
     /** 현재 블럭(range) **/
     private int curRange = 1;
     
     /** 총 게시글 수 **/
     private int listCnt;
     
     /** 총 페이지 수 **/
     private int pageCnt;
     
     /** 총 블럭(range) 수 **/
     private int rangeCnt;
     
     /** 시작 페이지 **/
     private int startPage = 1;
     
     /** 끝 페이지 **/
     private int endPage = 1;
     
     /** 시작 index **/
     private int startIndex = 0;
     
     /** 이전 페이지 **/
     private int prevPage;
     
     /** 다음 페이지 **/
     private int nextPage;

     private Criteria criteria;

     public Pagination(int listCnt,Criteria criteria){
        
        /**
         * 페이징 처리 순서
         * 1. 총 페이지수
         * 2. 총 블럭(range)수
         * 3. range setting
         */
        
        // 총 게시물 수와 현재 페이지를 Controller로 부터 받아온다.
        /** 현재페이지 **/
        setPage(criteria.getPage());
        /** 총 게시물 수 **/
        setListCnt(listCnt);
        
        /** 1. 총 페이지 수 **/
        setPageCnt(listCnt);
        /** 2. 총 블럭(range)수 **/
        setRangeCnt(pageCnt);
        /** 3. 블럭(range) setting **/
        rangeSetting(page);
        
        /** DB 질의를 위한 startIndex 설정 **/
        setStartIndex(page);
        
        this.criteria = criteria;
    }
 
    public void setPageCnt(int listCnt) {
        this.pageCnt = (int) Math.ceil(listCnt*1.0/pageSize);
        // 페이지가 몇개인지?
    }
    public void setRangeCnt(int pageCnt) {
        this.rangeCnt = (int) Math.ceil(pageCnt*1.0/rangeSize);
        // 10 ~ 기준 ~ 10을 할것인지?
    }
    public void rangeSetting(int Page){
        
        setCurRange(Page);        
        this.startPage = (curRange - 1) * rangeSize + 1;
        this.endPage = startPage + rangeSize - 1;
        
        if(endPage > pageCnt){
            this.endPage = pageCnt;
        }
        
        this.prevPage = Page - 1;
        this.nextPage = Page + 1;
    }
    public void setCurRange(int Page) {
        this.curRange = (int)((Page-1)/rangeSize) + 1;
    }
    public void setStartIndex(int Page) {
        this.startIndex = (Page-1) * pageSize;
    }

	public String getListLink(int _page) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
        .queryParam("page", _page)
		.queryParam("category", this.criteria.getCategory())
        .queryParam("type", this.criteria.getType())
		.queryParam("keyword", this.criteria.getKeyword());
		return builder.toUriString();

	}
}
