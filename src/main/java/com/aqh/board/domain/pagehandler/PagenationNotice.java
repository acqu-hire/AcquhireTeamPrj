package com.aqh.board.domain.pagehandler;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PagenationNotice {
	
	//현재 페이지 번호
	private int num;
	
	//게시물 총 갯수
	private int count;
	
	//한 페이지 안에 출력할 게시물 수
	private int postNum=5;
	
	//하단 페이징 번호 ([게시물 총 갯수 / 한페이지에 출력할 갯수]의 올림)
	private int pageNum;
	
	//출력할 게시물의 시작 번호
	private int displayPost;
	
	//한번에 표시할 페이징 번호의 갯수
	private int pageNumCnt = 5;
	
	//표시되는 페이지 번호 중 마지막 번호
	private int endPageNum;
	
	//표시되는 페이지 번호 중 첫밴째 번호
	private int startPageNum;
	
	//마지막 번호 재계산
	private int endPageNum_tmp;
	
	
	private boolean prev;
	private boolean next;
	
	
	
	public PagenationNotice() {
		this(1);
	}
	
	public PagenationNotice(int num) {
		this.num = num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	public int getNum() {
		return num;
	}
	public void setCount(int count) {
		this.count = count;
		dataCalc();
		//게시물 총 갯수를 알고난 시점부터 계산을 할 수 있으므로, setCount에서 메서드를 호출
	}
	public int getCount() {
		return count;
	}
	
	
	public int getPostNum() {
		return postNum;
	}
	public int getPageNum() {
		return pageNum;
	}
	public int getDisplayPost() {
		return displayPost;
	}
	public int getPageNumCnt() {
		return pageNumCnt;
	}
	public int getEndPageNum() {
		return endPageNum;
	}
	public int getStartPageNum() {
		return startPageNum;
	}
	public int getEndPageNum_tmp() {
		return endPageNum_tmp;
	}
	public boolean isPrev() {
		return prev;
	}
	public boolean isNext() {
		return next;
	}
	
	//계산함수
	public void dataCalc() {
		//하단 페이징 번호 ([게시물 총 갯수 / 한페이지에 출력할 갯수]의 올림)
		pageNum = (int)Math.ceil((double)count/postNum);
	
		//출력할 게시물 ex)[1,2,3,4,5],[6,7,8,9,10]...
		displayPost = (num-1) * postNum;
		
		//표시되는 페이지 번호 중 마지막 번호
		endPageNum = (int)(Math.ceil((double)num / (double)pageNumCnt)*pageNumCnt);
		
		//표시되는 페이지 번호 중 시작 번호
		startPageNum = endPageNum - (pageNumCnt -1);
		
		//마지막번호 재계산
		endPageNum_tmp = (int)(Math.ceil((double)count / (double)pageNumCnt));
		if(endPageNum > endPageNum_tmp) {
			endPageNum = endPageNum_tmp;
		}
		
		prev = startPageNum == 1 ? false : true;
		next = endPageNum * pageNumCnt >= count ? false : true;
	}
	
	
	
	
	
	
	
	
}
