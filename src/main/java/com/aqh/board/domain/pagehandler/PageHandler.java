package com.aqh.board.domain.pagehandler;

import org.springframework.web.util.UriComponentsBuilder;

import com.aqh.board.domain.dto.BoardDTO.Category;

public class PageHandler {
	private int page;
	private int startRow;
	private int endRow;
	private int maxPage;
	private int endPage;
	private int startPage;
	private int boardListCount;
	private Category category;
	
	private final int NAV_SIZE = 5;
	private final int ROW_LIMIT_SIZE = 10;
	
	public PageHandler() {}
	
	public PageHandler(int boardListCount) {
		this(1, boardListCount);
	}
	
	public PageHandler(int page, int boardListCount) {
		this.page = page;
		this.boardListCount = boardListCount;
		this.startRow = (page-1)*10+1;
		this.endRow = startRow+ROW_LIMIT_SIZE-1;
		this.maxPage = (boardListCount%ROW_LIMIT_SIZE == 0)?(boardListCount/ROW_LIMIT_SIZE):(boardListCount/ROW_LIMIT_SIZE)+1;
		this.endPage = (int)(Math.ceil(page/(float)NAV_SIZE)*NAV_SIZE);
		this.startPage = endPage-NAV_SIZE+1;
		if(endPage > maxPage) {
			this.endPage = maxPage;
		}
	}
	
	public String getQueryString() {
        return getQueryString(this.getPage(), this.getCategory());
    }
	public String getQueryString(Category category) {
		return getQueryString(this.page, category);
	}

    public String getQueryString(Integer page, Category category) {
        return UriComponentsBuilder.newInstance()
                .queryParam("page",page)
                .queryParam("category", category)
                .build().toString();
    }

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
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
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getNAV_SIZE() {
		return NAV_SIZE;
	}

	public int getROW_LIMIT_SIZE() {
		return ROW_LIMIT_SIZE;
	}

	@Override
	public String toString() {
		return "PageHandler [page=" + page + ", startRow=" + startRow + ", endRow=" + endRow + ", maxPage=" + maxPage
				+ ", endPage=" + endPage + ", startPage=" + startPage + ", boardListCount=" + boardListCount
				+ ", category=" + category + ", NAV_SIZE=" + NAV_SIZE + ", ROW_LIMIT_SIZE=" + ROW_LIMIT_SIZE + "]";
	}
	
}
