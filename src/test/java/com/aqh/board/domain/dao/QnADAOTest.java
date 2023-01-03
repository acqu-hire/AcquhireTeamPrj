package com.aqh.board.domain.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.BoardDTO.Menu;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class QnADAOTest {

	@Autowired
	QnADAO qnaDao;
	
	@Test
	public void selectAllTest() throws Exception{
		qnaDao.deleteAll();
		assertTrue(qnaDao.boardCount() == 0);
		
		List<BoardDTO> list = qnaDao.selectAll();
		assertTrue(list.size() == 0);
		
		BoardDTO boardDTO = new BoardDTO("asdf", "하이", "안녕하세요", Menu.QNA);
		assertTrue(qnaDao.insert(boardDTO) == 1);
		list = qnaDao.selectAll();
		System.out.println("list.size() = " + list.size());
		assertTrue(list.size() == 1);
		
		boardDTO = new BoardDTO("aaaa", "제목입니다", "컨텐츠 내용 부분입니다.", Menu.QNA);
		assertTrue(qnaDao.insert(boardDTO) == 1);
		list = qnaDao.selectAll();
		assertTrue(list.size() == 2);
	}
	
	@Test
	public void selectDetailTest() throws Exception {
		qnaDao.deleteAll();
		assertTrue(qnaDao.boardCount() == 0);
		
		BoardDTO boardDTO = new BoardDTO("asdf", "하이", "안녕하세요", Menu.QNA);
		assertTrue(qnaDao.insert(boardDTO) == 1);
		
		long bNo = qnaDao.selectAll().get(0).getbNo();
		boardDTO.setbNo(bNo);
		BoardDTO boardDTO2 = qnaDao.selectDetail(bNo);
		assertTrue(boardDTO2.getId().equals(boardDTO.getId()));
	}
	
	@Test
	public void insertTest() throws Exception {
		qnaDao.deleteAll();
		assertTrue(qnaDao.boardCount() == 0);
		
		BoardDTO boardDTO = new BoardDTO("asdf", "하이", "안녕하세요", Menu.QNA);
		assertTrue(qnaDao.insert(boardDTO) == 1);
		
		BoardDTO boardDTO2 = new BoardDTO("aaaa", "insert 테스트", "insert 테스트 중입니다.", Menu.QNA);
		assertTrue(qnaDao.insert(boardDTO2) == 1);
		
		List<BoardDTO> list = qnaDao.selectAll();
		assertTrue(list.size() == 2);
	}
	
	@Test
	public void deleteAllTest() throws Exception {
		qnaDao.deleteAll();
		assertTrue(qnaDao.boardCount() == 0);
		
		BoardDTO boardDTO = new BoardDTO("asdf", "하이", "안녕하세요", Menu.QNA);
		BoardDTO boardDTO2 = new BoardDTO("aaaa", "insert 테스트", "insert 테스트 중입니다.", Menu.QNA);
		qnaDao.insert(boardDTO);
		qnaDao.insert(boardDTO2);
		List<BoardDTO> list = qnaDao.selectAll();
		assertTrue(list.size() == 2);
		
		qnaDao.deleteAll();
		List<BoardDTO> list2 = qnaDao.selectAll();
		assertTrue(list2.size() == 0);
	}
	
	@Test
	public void deleteTest() throws Exception {
		qnaDao.deleteAll();
		assertTrue(qnaDao.boardCount() == 0);
		
		BoardDTO boardDTO = new BoardDTO("asdf", "하이", "안녕하세요", Menu.QNA);
		BoardDTO boardDTO2 = new BoardDTO("aaaa", "insert 테스트", "insert 테스트 중입니다.", Menu.QNA);
		qnaDao.insert(boardDTO);
		qnaDao.insert(boardDTO2);
		List<BoardDTO> list = qnaDao.selectAll();
		assertTrue(list.size() == 2);
		
		long bNo = qnaDao.selectAll().get(0).getbNo();
		qnaDao.delete(bNo);
		list = qnaDao.selectAll();
		assertTrue(list.size() == 1);
	}
}
