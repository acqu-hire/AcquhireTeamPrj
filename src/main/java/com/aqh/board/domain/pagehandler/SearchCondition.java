package com.aqh.board.domain.pagehandler;

import org.springframework.web.util.UriComponentsBuilder;

import com.aqh.board.domain.dto.BoardDTO.Category;

public class SearchCondition {
	private int page = 1;
	private int startRow;
	private int endRow;
	private String keyfield;
	private String keyword;
	private Category category;
	
	private final int ROW_LIMIT_SIZE = 10;
	
	public SearchCondition() {}
	
	public SearchCondition(int page, Category category) {
		this(page, category, "", "");
	}
	
	public SearchCondition(int page, Category category, String keyfield, String keyword) {
		this.page = page;
		this.category = category;
		this.keyfield = keyfield;
		this.keyword = keyword;
	}
	
	public String getQueryString() {
        return getQueryString(this.page, this.category);
    }
	public String getQueryString(Category category) {
		return getQueryString(this.page, category);
	}
	
	public String getQueryString(Integer page) {
		return getQueryString(page, this.category);
	}

    public String getQueryString(Integer page, Category category) {
        return UriComponentsBuilder.newInstance()
                .queryParam("page",page)
                .queryParam("category", category)
                .queryParam("keyfield", this.keyfield)
                .queryParam("keyword", this.keyword)
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

	public String getKeyfield() {
		return keyfield;
	}

	public void setKeyfield(String keyfield) {
		this.keyfield = keyfield;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public int getROW_LIMIT_SIZE() {
		return ROW_LIMIT_SIZE;
	}

	
	@Override
	public String toString() {
		return "SearchCondition [page=" + page + ", startRow=" + startRow + ", endRow=" + endRow + ", keyfield="
				+ keyfield + ", keyword=" + keyword + ", category=" + category + ", ROW_LIMIT_SIZE=" + ROW_LIMIT_SIZE
				+ "]";
	}
	
}
