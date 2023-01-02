package com.aqh.board.domain.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.aqh.board.domain.dto.BoardDTO;

@Repository
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/mybatis-config.xml")
public class CommunityDAOTest {

    @Autowired
    SqlSessionTemplate sessionTemplate;

    @Test
    public void testCreatePost() {

    }

    @Test
    public void testGetPost() {
        BoardDTO boardDTO = sessionTemplate.selectOne("getPost", 3);
        System.out.println(boardDTO);
    }

    @Test
    public void testGetTotal() {
        sessionTemplate.getConnection();
    }

}
