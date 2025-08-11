package com.spring.venu.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
public class LoggingAspect {
	
	@Before("execution(* com.spring.venu.controller.StudentController.create(..))")
	public void loggingBefore() {
		log.warn("loging something before create student endpoint");
	}

}
