package com.aqh.board.domain.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aqh.board.domain.dto.BoardDTO;
import com.aqh.board.domain.dto.BoardDTO.Category;
import com.aqh.board.domain.dto.BoardDTO.Menu;

/**
 * @author Devesg
 *         mybatis CRUD JUNIT TEST CODE
 */
@Repository
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class CommunityDAOTest {

    @Autowired
    SqlSessionTemplate sessionTemplate;

    @Test
    public void 커뮤니티_포스트_수정() {
        BoardDTO boardDTO = BoardDTO.builder()
                .id("admin")
                .bNo(12)
                .menu(Menu.COMMUNITY)
                .category(Category.COMMUNITY_LIFE)
                .file("엄")
                .title("준")
                .contents("식")
                .build();
        System.out.println(boardDTO);
        sessionTemplate.update("updatePost", boardDTO);
    }

    @Test
    public void 커뮤니티_포스트_생성() {
        BoardDTO boardDTO = BoardDTO.builder()
                .id("admin")
                .menu(Menu.COMMUNITY)
                .category(Category.COMMUNITY_LIFE)
                .file("12")
                .title("123")
                .contents("1234")
                .build();
        System.out.println(boardDTO);
        sessionTemplate.insert("createPost", boardDTO);
    }

    @Test
    public void 커뮤니티_포스트_조회() {
        BoardDTO boardDTO = sessionTemplate.selectOne("getPost", 1);
        System.out.println(boardDTO);
    }

    @Test
    public void 커뮤니티_포스트_전체조회() {
        List<BoardDTO> list = sessionTemplate.selectList("getAllCommunityPostList");
        System.out.println(list);
    }

    @Test
    public void 커뮤니티_포스트_개수() {
        long count = (int) sessionTemplate.selectOne("getTotal");
        System.out.println(count);
    }

    @Test
    public void 커뮤니티_포스트_삭제() {
        int bNo = 12;
        sessionTemplate.delete("deletePost", bNo);

    }

}
