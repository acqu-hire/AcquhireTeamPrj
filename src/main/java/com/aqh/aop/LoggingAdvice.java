package com.aqh.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class LoggingAdvice {

	public static final String FONT_YELLOW = "\u001B[33m";
	public static final String FONT_CYAN = "\u001B[36m";
	public static final String FONT_RED_BACKGROUND = "\u001B[41m";
	public static final String START_END_FONT ="\037 \u001B[43m"; // Font-WHITE("\u001B[36m"),Font-Background-YELLOW("\u001B[43m")
	public static final String FONT_BLUE_BACKGROUND = "\u001B[44m";
	public static final String FONT_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String FONT_GREEN = "\u001B[32m";
	public static final String RESET = "\u001B[0m";
	
	@Around("execution(* com.aqh..*ServiceImpl.*(..))") // PointCut 명시
	public Object logging(ProceedingJoinPoint jp) throws Throwable {
		long start = System.currentTimeMillis();
		log.info(START_END_FONT + "<<□■□■□■□■□■□■□■□■ [start] □■□■□■□■□■□■□■□■" + RESET);
		log.info(FONT_CYAN + "<========= Method Name =========> {}", jp.getSignature().toShortString() + RESET);
        log.info(FONT_CYAN + "<=========  Signature  =========> {}",jp.getSignature() + RESET);
        Object[] params = jp.getArgs();
        for(Object param : params) {
        	log.info(FONT_GREEN + "◎ Param Type  : {}", param.getClass().getSimpleName() + RESET);
        	log.info(FONT_GREEN + "◎ Param Value : {}", param + RESET);
        }
        
		Object result = jp.proceed();
		
		log.info(FONT_GREEN + "◎ result = {}", result + RESET);
		log.info(START_END_FONT + "□■□■□■□■□■□■□■□■ [end] □■□■□■□■□■□■□■□■>> " + (double)(System.currentTimeMillis()-start)/1000.0 + "초" + RESET);
		return result;
	}
	
}
