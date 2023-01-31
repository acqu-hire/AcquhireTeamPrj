package com.aqh.aop;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Component
//@Aspect
public class LoginCheckAspect {

	// CheckLogin 어노테이션이 붙은 메소드가 실행하기 전 해당 로직을 실행
	@Before("@annotation(com.aqh.aop.LoginCheck)")
	public void checkLogin(HttpSession httpSession) throws HttpClientErrorException {

		// 세션에 저장된 사용자의 ID를 가져온다.
		String currentUserId = (String) httpSession.getAttribute("id");
		log.info("" + currentUserId);
		// 세션에 사용자의 ID가 없는 경우, 권한이 없다는 에러 발생
		if (currentUserId == null) {
			throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
		}
	}
}
