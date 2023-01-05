package com.aqh.board.domain.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.BoardDTO.Category;
import com.aqh.board.domain.dto.BoardDTO.Menu;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class NoticeDAOTest {

	@Autowired
	private NoticeDAO noticeDAO; 

	
	
	@Test
	public void testMenuSelectAll() {
		System.out.println(noticeDAO.menuSelectAll());
	}
	
	@Test
	public void testCategorySelectAll() {
		System.out.println(noticeDAO.categorySelectAll(Category.NOTICE_NOTICE));
	}
	
	@Test
	public void testSelectDetail() {
		
		System.out.println(noticeDAO.selectDetail(1));
	}
	
	@Test
	public void testBoardListAllCount() {
		System.out.println(noticeDAO.BoardListAllCount());
	}
	
	@Test
	public void testCategoryListCount() {
			System.out.println(noticeDAO.CategoryListCount(Category.NOTICE_EVENT));
	}
	
	
	@Test
	public void testInsert() {
		BoardDTO boardDTO = BoardDTO.builder()
				.id("아이디")
				.menu(Menu.NOTICE)
				.category(Category.NOTICE_EVENT)
				.bNo(3)
				.readCount(1113)
				.file("파일3")
				.title("제목3")
				.contents("내용3")
				.build();
		System.out.println(boardDTO);
		noticeDAO.insert(boardDTO);
	}
	
	@Test
	public void testUpdate() {
		BoardDTO boardDTO = BoardDTO.builder()
				.id("아이디1")
				.menu(Menu.NOTICE)
				.category(Category.NOTICE_EVENT)
				.bNo(2)
				.readCount(1113)
				.file("파일2_up")
				.title("제목2_up")
				.contents("내용2_up")
				.build();
		System.out.println(boardDTO);
		noticeDAO.update(boardDTO);
	}
	
	@Test
	public void testDelete() {
		noticeDAO.delete(3);
	}

}
