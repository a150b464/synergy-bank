package com.synergy.bank.base.aop.logger;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.apache.naming.factory.BeanFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.accept.ServletPathExtensionContentNegotiationStrategy;

@Component
@Aspect
public class SynergyDaoLogger {
	
	Logger logger=Logger.getLogger(SynergyDaoLogger.class);

	@Before("execution(*  com.synergy.bank.customer.dao.impl.*.*(..))")
	public void logInDao(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		String methodName = signature.getName();
		String arguments = Arrays.toString(joinPoint.getArgs());
		logger.debug("____________________________________________________________________");
		logger.debug("starting of method =  " + methodName	+ " with  arguments = " + arguments);
		logger.debug("____________________________________________________________________");
	}
	
	@Before("execution(*  com.synergy.bank.common.dao.impl.*.*(..))")
	public void logInCommonDao(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		String methodName = signature.getName();
		String arguments = Arrays.toString(joinPoint.getArgs());
		logger.debug("____________________________________________________________________");
		logger.debug("starting of method =  " + methodName	+ " with  arguments = " + arguments);
		logger.debug("____________________________________________________________________");
		
	}
}
