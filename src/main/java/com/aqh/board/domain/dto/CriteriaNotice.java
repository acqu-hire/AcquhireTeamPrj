package com.aqh.board.domain.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component
public class CriteriaNotice {

	private int num; //현재 페이징 번호 page
	private int displayPost; //시작번호 offest
	private int postNum; //게시물범위 limit
	private String category;
	private String searchType;
	private String keyword;
	
	public CriteriaNotice() {
		this(1, 5);
	}
	
	public CriteriaNotice(int num, int postNum) {
		this.num=num;
		this.postNum=postNum;
	}
	

	public int getDisplayPost() {
		return this.displayPost = (num-1) * postNum;
	}



	
	
	
}
