package com.aqh.board.service;

import java.util.List;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.Criteria;

public interface BoardService {

	// ! CREATE

	public int insertBoard(BoardDTO boardDTO);

	// ! READ

	public List<BoardDTO> getList(Criteria criteria);

	public int getBoardTotal(Criteria criteria);

	public int getReplyTotal(Criteria criteria);

	public BoardDTO findByBoardNumber(long bno);

	// ! UPDATE

	public int updateBoard(BoardDTO boardDTO);

	public int viewCntUp(long bno);

	// ! DELETE

	public int deleteBoard(long bno);

}