package com.aqh.board.dao;

import java.util.List;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.Criteria;
import com.aqh.common.domain.FileDTO;

public interface BoardDAO {

	// ! CREATE

	public int insertBoard(BoardDTO boardDTO);

	// ! READ

	public List<BoardDTO> getBoardList(Criteria criteria);
	
	public List<FileDTO> getFileList(long bno);

	public int getBoardTotal(Criteria criteria);
	
	public long getReplyTotal(long bno);

	public BoardDTO findByBoardNumber(long bno);

	// ! UPDATE

	public int updateBoard(BoardDTO boardDTO);

	public int viewCntUp(long bno);

	// ! DELETE

	public int deleteBoard(long bno);

}