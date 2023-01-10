package com.aqh.board.domain.pagehandler;

import org.springframework.web.util.UriComponentsBuilder;

import com.aqh.board.domain.dto.BoardDTO.Category;

public class PageHandler {
	private SearchCondition sc;
	private int totalPage;		// 총 페이지 수 
	private int endPage;		// 페이지네이션에 보여줄 마지막 페이지
	private int startPage;		// 페이지네이션에 보여줄 시작 페이지
	private int boardListCount;	// 게시물 수 
	
	private final int NAV_SIZE = 10;	// 페이지네이션 사이즈
	
	public PageHandler() {}
	
	public PageHandler(SearchCondition sc, int boardListCount) {
		this.sc = sc;
		this.boardListCount = boardListCount;
		
		doPaging(sc, boardListCount);
	}
	
	public void doPaging(SearchCondition sc, int boardListCount) {
		sc.setStartRow((sc.getPage()-1)*sc.getROW_LIMIT_SIZE()+1);
		sc.setEndRow(sc.getStartRow()+sc.getROW_LIMIT_SIZE()-1);
		this.totalPage = (boardListCount/sc.getROW_LIMIT_SIZE() + (boardListCount%sc.getROW_LIMIT_SIZE()!=0?1:0));
		this.endPage = (int)(Math.ceil(sc.getPage()/(float)NAV_SIZE)*NAV_SIZE);
		this.startPage = endPage-NAV_SIZE+1;
		if(endPage > totalPage) {
			this.endPage = totalPage;
		}
	}
	
	public String getQueryString() {
        return getQueryString(this.sc.getPage(), this.sc.getCategory());
    }
	public String getQueryString(Category category) {
		return getQueryString(this.sc.getPage(), category);
	}
	
	public String getQuerString(Integer page) {
		return getQueryString(page, this.sc.getCategory());
	}

    public String getQueryString(Integer page, Category category) {
        return UriComponentsBuilder.newInstance()
                .queryParam("page",page)
                .queryParam("category", category)
                .queryParam("keyfield", this.sc.getKeyfield())
                .queryParam("keyword", this.sc.getKeyword())
                .build().toString();
    }

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getBoardListCount() {
		return boardListCount;
	}

	public void setBoardListCount(int boardListCount) {
		this.boardListCount = boardListCount;
	}

	public int getNAV_SIZE() {
		return NAV_SIZE;
	}
	
	public SearchCondition getSc() {
		return sc;
	}

	public void setSc(SearchCondition sc) {
		this.sc = sc;
	}

	@Override
	public String toString() {
		return "PageHandler [sc=" + sc + ", totalPage=" + totalPage + ", endPage=" + endPage + ", startPage=" + startPage
				+ ", boardListCount=" + boardListCount + ", NAV_SIZE=" + NAV_SIZE + "]";
	}

	
}
