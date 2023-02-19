package com.aqh.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqh.member.dao.MemberDAO;
import com.aqh.member.domain.MemberDTO;

@Service
public class MemberService {

	@Autowired
	MemberDAO memberDAO;
	
	public int register(MemberDTO memberDTO) {
		return memberDAO.register(memberDTO); 
	}
	
	public List<MemberDTO> memberList() {
		return memberDAO.memberList();
	}
	
	public MemberDTO memberDetail(String id) {
		return memberDAO.memberDetail(id);
	}
	
	public int memberDelete(String id) {
		return memberDAO.memberDelete(id);
	}
	
	public int memberUpdate(MemberDTO memberDTO) {
		return memberDAO.memberUpdate(memberDTO);
	}
	
	public int idCheck(String id) {
		return memberDAO.idCheck(id);
	}

	public int pwdCheck(MemberDTO memberDTO) {
		return memberDAO.pwdCheck(memberDTO);
	}
}
