package com.aqh.board.domain.pagehandler;

import org.springframework.web.util.UriComponentsBuilder;

import com.aqh.board.domain.dto.CriteriaNotice;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class PaginationNotice {
	
	//현재 페이지 번호
	private int num =1;
	
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
	
	private CriteriaNotice criteriaNotice;
	
	public PaginationNotice(CriteriaNotice criteriaNotice, int count) {
		setNum(criteriaNotice.getNum());
		this.count=count;
		dataCalc();
		//게시물 총 갯수를 알고난 시점부터 계산을 할 수 있으므로, setCount에서 메서드를 호출
		this.criteriaNotice = criteriaNotice;
		System.out.println("확인" + criteriaNotice);
	}
	
	
	//계산함수
	public void dataCalc() {
		//하단 페이징 번호 ([게시물 총 갯수 / 한페이지에 출력할 갯수]의 올림)
		pageNum = (int)Math.ceil((double)count/postNum);
	
		//출력할 게시물 ex)[1,2,3,4,5],[6,7,8,9,10]...
		//displayPost = (num-1) * postNum;
		
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
	
	
	
	
	public String getUrlLink(int num) {
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath("")
				.queryParam("num", num)
				.queryParam("category", this.criteriaNotice.getCategory())
				.queryParam("searchType", this.criteriaNotice.getSearchType())
				.queryParam("keyword", this.criteriaNotice.getKeyword());
		return uriComponentsBuilder.toUriString();
	}
	
	
	
}
