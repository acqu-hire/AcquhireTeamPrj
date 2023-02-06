package com.aqh.common.exception;

import java.nio.file.AccessDeniedException;
import java.security.InvalidParameterException;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class CommonExceptionAdvice {
	
	public static final String FONT_CYAN = "\u001B[36m";
	public static final String RESET = "\u001B[0m";
	public static final String FONT_GREEN = "\u001B[32m";
	
	
	@ExceptionHandler({NoHandlerFoundException.class,InvalidParameterException.class})
//	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="BAD REQUEST")
	public String error400(Exception ex ,Model m) {
		String exception = ex.toString().contains("NoHandlerFoundException")?"NoHandlerFoundException(404)":"InvalidParameterException(400)";
		String code = exception=="NoHandlerFoundException(404)"?"404":"400";
		log.info(FONT_GREEN + exception + " : {}", ex.toString() + RESET);
		printExceptionStackTrace(ex);
		m.addAttribute("ex", ex);
		m.addAttribute("code", code);
		m.addAttribute("msg", "요청하신 페이지나 파일을 찾을 수 없습니다.");
		return "exception/errorPage";
	}
	
	@ExceptionHandler({SQLException.class, DataAccessException.class})
//	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "SERVER ERROR")
	public String error500(Exception ex, Model m) {
		String exception = ex.toString().contains("SQLException")?"SQLException(500)":"DataAccessException(500)";
		String code = "500";
		log.info(FONT_GREEN + exception + " : {}", ex.toString() + RESET);
		printExceptionStackTrace(ex);
		m.addAttribute("ex", ex);
		m.addAttribute("code", code);
		m.addAttribute("msg", "죄송합니다. 잠시 후 다시 시도해주세요.");
		return "exception/errorPage";
	}
	
	@ExceptionHandler(AccessDeniedException.class)
//	@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "has no authority")
	public String noAuthority(Exception ex, Model m) {
		log.info(FONT_GREEN + "AccessDeniedException : {}", ex.toString() + RESET);
		printExceptionStackTrace(ex);
		m.addAttribute("ex", ex);
		m.addAttribute("code", "403");
		m.addAttribute("msg", "접근 권한이 없습니다.");
		return "exception/errorPage";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public void NullPointerException(NullPointerException ex, Model m) {
		log.info("NullPointerException : {}", ex.toString());
		printExceptionStackTrace(ex);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public void rentimeException(RuntimeException ex) {
		log.info("RunTimeException : {}", ex.toString());
		printExceptionStackTrace(ex);
	}
	
	@ExceptionHandler(Exception.class)
	public void exception(Exception ex) {
		log.info("Exception : {}", ex.toString());
		printExceptionStackTrace(ex);
	}
	
	private void printExceptionStackTrace(Exception ex) {
		for(StackTraceElement exLog : ex.getStackTrace())
			log.info(FONT_CYAN + "stack trace : {}",exLog + RESET);
	}
	
}
