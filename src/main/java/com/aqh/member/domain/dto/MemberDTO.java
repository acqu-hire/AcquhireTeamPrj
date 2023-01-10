package com.aqh.member.domain.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberDTO {
	private String id; // 아이디
	private String password; // 비밀번호
	private String name; // 이름
	private String gender; // 성별
	private String address; // 주소
	private String phoneNumber; // 전화번호
	private String email; // 이메일
	private String regDate; // 가입일
}