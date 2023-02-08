package com.aqh.login.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aqh.login.domain.dto.RoleDTO;


@Repository
public class RoleDAO {

	@Autowired
	SqlSessionTemplate session;

	String namespace = "com.aqh.login.dao.RoleMapper.";

	public RoleDTO findByUserID(String id) {
		return session.selectOne(namespace+"findByUserID", id);
	}
	
}
