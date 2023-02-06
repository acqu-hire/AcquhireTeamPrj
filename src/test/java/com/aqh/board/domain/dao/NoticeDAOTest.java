package com.aqh.board.domain.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aqh.board.dao.NoticeDAO;
import com.aqh.board.domain.dto.BoardDTO.Category;
import com.aqh.board.domain.dto.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class NoticeDAOTest {

	@Autowired
	private NoticeDAO noticeDAO;

	@Test
	public void testMenuSelectAll() {
		Criteria criteria = new Criteria();
		criteria.setPage(2);
		criteria.getOffset();
		criteria.setLimit(10);
		System.out.println(noticeDAO.menuSelectAll(criteria));
	}

	@Test
	public void testCategorySelectAll() {
		Criteria criteria = new Criteria();
		criteria.setPage(2);
		criteria.getOffset();
		criteria.setLimit(10);
		criteria.setCategory(Category.NOTICE_EVENT);
		System.out.println(noticeDAO.categorySelectAll(criteria));
	}

	@Test
	public void testSelectDetail() {
		System.out.println(noticeDAO.selectDetail(1));
	}

	@Test
	public void testBoardListAllCount() {
		Criteria criteria = new Criteria();
		criteria.setType("all");
		criteria.setKeyword("23");
		System.out.println(noticeDAO.BoardListAllCount(criteria));
	}
	
	@Test
	public void testCategoryListCount() {
		Criteria criteria = new Criteria();
		criteria.setCategory(Category.NOTICE_EVENT);
		System.out.println(noticeDAO.CategoryListCount(criteria));
	}
	
	/*
	@Test
	public void testInsert() {
		BoardDTO boardDTO = BoardDTO.builder()
				.id("아이디")
				.category(Category.NOTICE_EVENT)
				.bno(3)
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
				.bno(2)
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
	}*/

}
