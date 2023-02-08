package com.aqh.aop;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.aqh.login.service.RoleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Component
//@Aspect
public class LoginCheckAspect {

	@Autowired
	private RoleService roleService;

	@AfterThrowing("@annotation(com.aqh.aop.LoginCheck)")
	public void loginCheck(JoinPoint jp) throws Throwable {
		log.info("AOP - Login Check Started");

		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes()))
				.getRequest().getSession();
		String id = (String) session.getAttribute("id");
		log.info("\037 \u001B[43m" + id + "\u001B[0m");

		if (id == null) {
			log.debug("AOP - Owner Login Check Result - NO_LOGIN");
			throw new HttpStatusCodeException(HttpStatus.UNAUTHORIZED, "NO_LOGIN") {
			};
		}
	}
}
//		switch (loginCheck.type()) {
//
//		case ADMIN:
//			AdminLogin(jp);
//			break;
//
//		case MEMBER:
//			memberLogin(jp);
//			break;
//
//		default:
//			UnknownLogin(jp);
//			break;
//		}

//
//	@Before("@annotation(com.aqh.aop.MemberLogin)")
//	public void memberLogin(JoinPoint jp) throws Throwable {
//		log.debug("AOP - Member Login Started");
//
//		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes()))
//				.getRequest().getSession();
//		String memberId = (String) session.getAttribute("id");
//
//	}
//
//	@Before("@annotation(com.aqh.aop.UnknownLogin)")
//	public void UnknownLogin(JoinPoint jp) throws Throwable {
//		log.debug("AOP - UnknownLogin");
//
//		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes()))
//				.getRequest().getSession();
//		String memberId = (String) session.getAttribute("id");
//
//	}
//
//	@Before("@annotation(com.aqh.aop.AdminLogin)")
//	public void AdminLogin(JoinPoint jp) throws Throwable {
//		log.debug("AOP - AdminLogin");
//
//		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes()))
//				.getRequest().getSession();
//		String memberId = (String) session.getAttribute("id");
//
//	}