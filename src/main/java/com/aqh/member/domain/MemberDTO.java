package com.aqh.member.domain;

import org.springframework.context.annotation.Primary;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Primary
public class MemberDTO {
	private String id; // 아이디
	private String password; // 비밀번호
	private String name; // 이름
	private String gender; // 성별
	private String address; // 주소
	private String phone_number; // 전화번호
	private String email; // 이메일
	private String reg_date; // 가입일
}