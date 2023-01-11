package com.aqh.board.domain.dto;

import org.springframework.stereotype.Component;

@Component
public class CriteriaNotice {

	private int num;
	private int displayPost; //시작번호
	private int postNum; //게시물범위
	
	public CriteriaNotice() {
		this(1, 5);
	}
	
	public CriteriaNotice(int num, int postNum) {
		this.num=num;
		this.postNum=postNum;
	}
	
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getDisplayPost() {
		return this.displayPost = (num-1) * postNum;
	}
	public void setDisplayPost(int displayPost) {
		this.displayPost = displayPost;
	}
	
	public int getPostNum() {
		return postNum;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}

	@Override
	public String toString() {
		return "CriteriaNotice [num=" + num + ", displayPost=" + displayPost + ", postNum=" + postNum + "]";
	}
	
	
}
