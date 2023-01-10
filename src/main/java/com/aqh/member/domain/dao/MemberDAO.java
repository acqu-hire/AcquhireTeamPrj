package com.aqh.member.domain.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aqh.member.domain.dto.MemberDTO;

@Repository
public class MemberDAO {

	@Autowired
	SqlSessionTemplate session;
	
	String namespace = "com.aqh.board.domain.dao.MemberMapper.";
	
	public int register(MemberDTO MemberDTO) {
		return session.insert(namespace + "register", MemberDTO); 
	}
	
	public List<MemberDTO> memberList() {
		return session.selectList(namespace + "memberList");
	}
	
	public MemberDTO memberDetail(String id) {
		return session.selectOne(namespace + "memberDetail", id);
	}
}
