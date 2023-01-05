package com.aqh.board.domain.pagination;

public class Pagination {
	private int currentPage;
	private int startRow;
	private int endRow;
	private int maxPage;
	private int endPage;
	private int startPage;
	private int boardListCount;
	
	private final int NAV_SIZE = 10;
	private final int ROW_LIMIT_SIZE = 10;
	
	public Pagination() {}
	
	public Pagination(int boardListCount) {
		this(1, boardListCount);
	}
	
	public Pagination(int currentPage, int boardListCount) {
		this.currentPage = currentPage;
		this.boardListCount = boardListCount;
		this.startRow = (currentPage-1)*10+1;
		this.endRow = startRow+ROW_LIMIT_SIZE-1;
		this.maxPage = (boardListCount%ROW_LIMIT_SIZE == 0)?(boardListCount/ROW_LIMIT_SIZE):(boardListCount/ROW_LIMIT_SIZE)+1;
		this.endPage = (int)(Math.ceil(currentPage/(float)NAV_SIZE)*NAV_SIZE);
		this.startPage = endPage-9;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
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

	public int getNAV_SIZE() {
		return NAV_SIZE;
	}

	public int getROW_LIMIT_SIZE() {
		return ROW_LIMIT_SIZE;
	}

	@Override
	public String toString() {
		return "Pagination [currentPage=" + currentPage + ", startRow=" + startRow + ", endRow=" + endRow + ", maxPage="
				+ maxPage + ", endPage=" + endPage + ", startPage=" + startPage + ", boardListCount=" + boardListCount
				+ ", NAV_SIZE=" + NAV_SIZE + ", ROW_LIMIT_SIZE=" + ROW_LIMIT_SIZE + "]";
	}
	
	
}
