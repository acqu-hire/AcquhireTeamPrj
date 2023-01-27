package com.aqh.board.domain.pagehandler;

import org.springframework.web.util.UriComponentsBuilder;

import com.aqh.board.domain.dto.CriteriaEvent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationEvent {

	// 현재 페이지 번호
	private int nowPage = 1;

	// 게시물 총 개수
	private int total;

	// 출력할 게시물의 시작 번호
	private int displayPost;

	// 한 페이지 안에 출력할 게시물 수
	private int postNum = 5;

	// 하단 페이징 번호 ([게시물 총 개수 / 한페이지에 출력할 개수]의 올림)
	private int pageNum;

	// 한번에 표시할 페이징 번호의 개수 → ex) [1][2][3][4][5]
	private int pageNumCnt = 5;

	// 표시되는 페이지 번호 중 첫번째 번호
	private int startPage;

	// 표시되는 페이지 번호 중 마지막 번호
	private int endPage;

	// 마지막 번호 재계산
	private int endPage_tmp;

	private boolean prev;
	private boolean next;

	private CriteriaEvent criteriaEvent;

	public PaginationEvent(CriteriaEvent criteriaEvent, int total) {
		setNowPage(criteriaEvent.getNum());
		this.total = total;
		dataCalc();
		// 게시물 총 개수를 알고난 시점부터 계산을 할 수 있으므로, setCount에서 메서드를 호출
		this.criteriaEvent = criteriaEvent;
		System.out.println("확인" + criteriaEvent);
	}

	/**
	 * 페이징 번호 계산 함수
	 */
	public void dataCalc() {
		// 하단 페이징 번호 ([게시물 총 개수 / 한페이지에 출력할 개수]의 올림)
		pageNum = (int) Math.ceil((double) total / postNum);

		// 출력할 게시물 → ex) [1][2][3][4][5], [6][7][8][9][10]...
		// displayPost = (NowPage-1) * postNum;

		// 표시되는 페이지 번호 중 마지막 번호
		endPage = (int) (Math.ceil((double) nowPage / (double) pageNumCnt) * pageNumCnt);

		// 표시되는 페이지 번호 중 시작 번호
		startPage = endPage - (pageNumCnt - 1);

		// 마지막 번호 계산 보정
		endPage_tmp = (int) (Math.ceil((double) total / (double) pageNumCnt));
		if (endPage > endPage_tmp) {
			endPage = endPage_tmp;
		}

		prev = startPage == 1 ? false : true;
		next = endPage * pageNumCnt >= total ? false : true;
	}

	// UriComponents는 URI를 동적으로 생성
	public String getUrlLink(int num) {
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath("").queryParam("num", num)
				.queryParam("category", this.criteriaEvent.getCategory())
				.queryParam("searchType", this.criteriaEvent.getSearchType())
				.queryParam("keyword", this.criteriaEvent.getKeyword());
		return uriComponentsBuilder.toUriString();
	}

}