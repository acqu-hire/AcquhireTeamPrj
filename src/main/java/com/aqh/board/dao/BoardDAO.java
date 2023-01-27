package com.aqh.board.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.Criteria;

@Repository
public interface BoardDAO {

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