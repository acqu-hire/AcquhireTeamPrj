package com.aqh.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.Criteria;

@Service
public interface BoardService {

    // ! CREATE

	public int insertBoard(BoardDTO boardDTO);

	// ! READ

	public List<BoardDTO> getList(Criteria criteria);

	public int getTotal(Criteria criteria);

	public BoardDTO findByBoardNumber(long bno);

	// ! UPDATE

	public int updateBoard(BoardDTO boardDTO);

	public int viewCntUp(long bno);

	// ! DELETE

	public int deleteBoard(long bno);

}