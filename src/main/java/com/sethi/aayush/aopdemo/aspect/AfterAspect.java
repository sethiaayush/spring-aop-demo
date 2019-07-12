package com.sethi.aayush.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class AfterAspect {

	@After("execution(* com.sethi.aayush.aopdemo.dao.AccountDAO.throwException(..))")
	public void afterFinallyAdvice(JoinPoint theJoinPoint) {
		System.out.println("afterFinallyAdvice");
	}
}
