package com.sethi.aayush.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.sethi.aayush.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class AfterReturningAspect {

	// Below method is used to modify the data: Post processing the data
	// Data of results(OutputFromMethod) is getting modified after the execution complete of findAccounts <<Scary but True>>
	@AfterReturning(pointcut = "execution(* com.sethi.aayush.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "results")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> results) {
		for (Account account : results) {
			account.setName("Altered!" + account.getName().toUpperCase());
		}
	}
}
