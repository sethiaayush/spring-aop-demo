package com.sethi.aayush.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging

	// Pointcut declaration
	@Pointcut("execution(public void add*())")
	private void forDaoPackage() {
	}
	// @Before("forDaoPackage()")
	// Declare once and use anywhere, and be used to combine more than one
	// expression as well

	// let's start with an @Before advice
	// execution(public void addAccount()) they are referred as point cut expression
	// Language is know as pointcut expression language
	@Before("forDaoPackage()")
	// @Before("execution(public void addAccount())")
	// @Before("execution(public void
	// com.sethi.aayush.aopdemo.dao.AccountDAO.addAccount())")
	// Above will only work for addAccount method from AccountDAO Class only, so
	// specified fully qualified name
	public void beforeAddAccountAdvice() {
		System.out.println("Custom code run before addAcount using AOP");
	}

	@Before("execution(void *())")
	public void beforeAnyMethodWithVoidAdvice() {
		System.out.println("Custom code run before any method with void return type using AOP");
	}

	@Before("execution(* com.sethi.aayush.aopdemo.*.*(..))") // Any class-Any method-Any no of parameter within
																// specified package
	// @Before("execution(* add*(com.sethi.aayush.aopdemo.Account))")
	// @Before("execution(* add*(..))")
	// @Before("execution(* add*(com.sethi.aayush.aopdemo.Account, ..))")
	public void beforeAnyMethodWithAccountParameter() {
		System.out.println("Custom code run before Any Method With Account Parameter using AOP");
	}
	// -------------------------------------------------------------------------------------------------------------------------------------------//

	// create pointcut for all methods in aopdemo
	@Pointcut("execution(* com.sethi.aayush.aopdemo.*.*(..))")
	private void allMethodsInAOPDemo() {
	}

	// create pointcut for all getter methods in aopdemo
	@Pointcut("execution(* com.sethi.aayush.aopdemo.*.get*(..))")
	private void allGetterMethodsInAOPDemo() {
	}

	// create pointcut for all setter methods in aopdemo
	@Pointcut("execution(* com.sethi.aayush.aopdemo.*.set*(..))")
	private void allSetterMethodsInAOPDemo() {
	}

	@Before("allMethodsInAOPDemo() && !(allGetterMethodsInAOPDemo() || allSetterMethodsInAOPDemo())")
	// @Before("allMethodsInAOPDemo()")
	// @Before("execution(void *())")
	public void runThisForAllExceptGetterAndSetter(JoinPoint theJoinPoint) {
		System.out.println(this.getClass()
				+ ": runThisForAllExceptGetterAndSetter :Being called for all methods except getter and setters");
		// display the method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSignature);
		// display method arguments

		for (Object argument : theJoinPoint.getArgs()) {
			System.out.println(" ");
			System.out.print(argument + "            ");
		}
	}

}
