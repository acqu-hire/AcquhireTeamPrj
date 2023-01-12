package com.aqh.reply.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aqh.reply.domain.dao.ReplyDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyServiceImpITest {

	@Autowired
	private ReplyDAO replyDAO;

	@Test
	public void nullcheck() {
		System.out.println(">>>>>>>>>>" +replyDAO.getClass());
	}

}
