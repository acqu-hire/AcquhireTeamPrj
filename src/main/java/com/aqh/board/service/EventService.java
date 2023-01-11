package com.aqh.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqh.board.domain.dao.EventDAO;
import com.aqh.board.domain.dto.BoardDTO;

@Service
public class EventService {

	@Autowired
	private EventDAO eventDAO;

	public List<BoardDTO> eventMenuSelectAll() {
		return eventDAO.eventMenuSelectAll();

	}

	public List<BoardDTO> eventItEventList() {
		return eventDAO.eventItEventList();

	}

	public List<BoardDTO> eventMarketingList() {
		return eventDAO.eventMarketingList();

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
}
