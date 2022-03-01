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

	//runs before and after method execution
	//Preprocessing and post processing of data
	//Log method running time-Profiling code
	//Manage exception, swallow, handle, stop exception, rethrow exception can be done as well.
	//ProceedingJoinPoint - handler to targetMethod
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
