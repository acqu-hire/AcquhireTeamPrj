package com.aqh.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqh.board.dao.EventDAO;
import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.CriteriaEvent;

@Service
public class EventService {

	@Autowired
	private EventDAO eventDAO;

	public List<BoardDTO> eventMenuSelectAll(CriteriaEvent criteriaEvent) {
		return eventDAO.eventMenuSelectAll(criteriaEvent);
	}

	public List<BoardDTO> eventItEventList(CriteriaEvent criteriaEvent) {
		return eventDAO.eventItEventList(criteriaEvent);
	}

	public List<BoardDTO> eventMarketingList(CriteriaEvent criteriaEvent) {
		return eventDAO.eventMarketingList(criteriaEvent);
	}

	public BoardDTO eventSelectDetail(long bNo) {
		return eventDAO.eventSelectDetail(bNo);
	}

	public void eventInsert(BoardDTO boardDTO) {
		eventDAO.eventInsert(boardDTO);
	}

	public void eventUpdate(BoardDTO boardDTO) {
		eventDAO.eventUpdate(boardDTO);
	}

	public void eventDelete(long bNo) {
		eventDAO.eventDelete(bNo);
	}
	
	public int BoardListAllCount(CriteriaEvent criteriaEvent) {
		return eventDAO.BoardCount(criteriaEvent);
	}
	
	public int CategoryListCount(CriteriaEvent criteriaEvent) {
		return eventDAO.CategoryCount(criteriaEvent);
	}
	
	public int readCountUp(long bNo) {
		return eventDAO.readCountUp(bNo);		
	}

}