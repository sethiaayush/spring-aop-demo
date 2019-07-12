package com.sethi.aayush.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(4)
public class AfterThrowingAspect {

	@AfterThrowing(pointcut = "execution(* com.sethi.aayush.aopdemo.dao.AccountDAO.throwException(..))", throwing = "theExc")
	public void afterThrowingExceptionAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		System.out.println("afterThrowingExceptionAdvice");
		theExc.printStackTrace();
	}
}
