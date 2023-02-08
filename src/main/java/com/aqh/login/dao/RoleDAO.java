package com.aqh.login.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDAO {

	@Autowired
	SqlSessionTemplate session;

	String namespace = "com.aqh.login.dao.RoleMapper.";

//	public void findByUserID(String id) {
//		return session.select("", id);
//	}
}
