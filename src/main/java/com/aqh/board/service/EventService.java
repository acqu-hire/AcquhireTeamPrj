package com.aqh.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqh.board.dao.EventDAO;
import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.Criteria;

@Service
public class EventService {

	@Autowired
	private EventDAO eventDAO;

	//조회
	public List<BoardDTO> eventMenuSelectAll(Criteria cri) {
		return eventDAO.eventMenuSelectAll(cri);
	}

	public List<BoardDTO> eventItEventList(Criteria cri) {
		return eventDAO.eventItEventList(cri);
	}

	public List<BoardDTO> eventMarketingList(Criteria cri) {
		return eventDAO.eventMarketingList(cri);
	}

	public BoardDTO eventSelectDetail(long bno) {
		return eventDAO.eventSelectDetail(bno);
	}

	//등록
	public void eventInsert(BoardDTO boardDTO) {
		eventDAO.eventInsert(boardDTO);
	}

	//수정
	public void eventUpdate(BoardDTO boardDTO) {
		eventDAO.eventUpdate(boardDTO);
	}

	//삭제
	public void eventDelete(long bno) {
		eventDAO.eventDelete(bno);
	}
	
	//추가 기능
	public int readCountUp(long bno) {
		return eventDAO.readCountUp(bno);		
	}
	
	public int BoardListAllCount(Criteria cri) {
		return eventDAO.BoardCount(cri);
	}
}