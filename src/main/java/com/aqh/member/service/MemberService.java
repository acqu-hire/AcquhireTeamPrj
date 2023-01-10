package com.aqh.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqh.member.domain.dao.MemberDAO;
import com.aqh.member.domain.dto.MemberDTO;

@Service
public class MemberService {

	@Autowired
	MemberDAO memberDAO;
	
	public int register(MemberDTO memberDTO) {
		return memberDAO.register(memberDTO); 
	}
}
