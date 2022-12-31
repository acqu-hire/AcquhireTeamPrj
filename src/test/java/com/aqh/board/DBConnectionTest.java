package com.aqh.board;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
@Slf4j
public class DBConnectionTest {

	@Autowired
	DataSource dataSource;
	
	@Test
	public void jdbcConnectionTest() throws Exception {
			Connection connection = dataSource.getConnection();
			log.info("DB 연결 성공");
			log.info("Connection >> "+ connection);
			assertTrue(connection != null);
	}
} 