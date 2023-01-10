package com.aqh.board.domain.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.BoardDTO.Category;
import com.aqh.board.domain.dto.BoardDTO.Menu;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class NoticeDAOTest {

	@Autowired
	private NoticeDAO noticeDAO;

	@Test
	public void testMenuSelectAll() {
		System.out.println(noticeDAO.menuSelectAll(0, 4));
	}

	@Test
	public void testCategorySelectAll() {
		BoardDTO boardDTO = BoardDTO.builder()
				.category(Category.NOTICE_NOTICE)
				.build();
		System.out.println(noticeDAO.categorySelectAll(boardDTO));
	}

	@Test
	public void testSelectDetail() {
		/*BoardDTO boardDTO = BoardDTO.builder()
				.bNo(1)
				.build();
		System.out.println(noticeDAO.selectDetail(boardDTO));*/
		System.out.println(noticeDAO.selectDetail(1));
	}

	@Test
	public void testBoardListAllCount() {
		System.out.println(noticeDAO.BoardListAllCount());
	}
	
	@Test
	public void testCategoryListCount() {
			BoardDTO boardDTO = BoardDTO.builder()
				.category(Category.NOTICE_EVENT)
				.build();
			System.out.println(noticeDAO.CategoryListCount(boardDTO));
	}
	
	
	@Test
	public void testInsert() {
		BoardDTO boardDTO = BoardDTO.builder()
				.id("아이디")
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
