package com.sethi.aayush.aopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(5)
public class AroundAspect {

	@Around("execution(* com.sethi.aayush.aopdemo.dao.AccountDAO.findAccounts(..))")
	public Object aroundFindAccountsAdvice(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Object object = theProceedingJoinPoint.proceed();
		long end = System.currentTimeMillis();
		long duration = end - start;
		System.out.println("Time take to execute findAccounts" + duration / 1000.0 + " seconds ");
		return object;
	}
}
