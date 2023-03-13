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
     
     /** 총 게시글 수 **/
     private int listCnt; 
     
     /** 총 페이지 수 **/
     private int pageCnt; 
     
     /** 시작 페이지 **/
     private int startPage = 1;
     
     /** 끝 페이지 **/
     private int endPage = 1; 
     

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
        
        /** 2. 블럭(range) setting **/
        rangeSetting(page);
        
        
        this.criteria = criteria;
    }
 
    public void setPageCnt(int listCnt) {
        this.pageCnt = (int) Math.ceil(listCnt*1.0/pageSize);
        // 페이지가 몇개인지?
    }
  
    public void rangeSetting(int page){
    	
    	this.endPage = (int)(Math.ceil(page/(float)rangeSize) * rangeSize);
        this.startPage = endPage-rangeSize+1;
        
        if(endPage > pageCnt){
            this.endPage = pageCnt;
        }
        
    }

	public String getListLink(int page) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
        .queryParam("page", page)
		.queryParam("category", this.criteria.getCategory())
        .queryParam("type", this.criteria.getType())
		.queryParam("keyword", this.criteria.getKeyword());
		return builder.toUriString();

	}
}
