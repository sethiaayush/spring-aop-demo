package com.sethi.aayush.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sethi.aayush.aopdemo.dao.AccountDAO;
import com.sethi.aayush.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO accountDao = context.getBean("accountDAO", AccountDAO.class);
		// call the business method
		accountDao.addAccount();
		accountDao.addAccount(new Account());
		accountDao.addAccount("blabla");
		accountDao.addAccount(new Account(), true);
		for (Account account : accountDao.findAccounts()) {
			System.out.println(account.toString());
		}
		try {
			accountDao.throwException();
			//Open com.sethi.aayush.aopdemo.aspect.AfterThrowingAspect.afterThrowingExceptionAdvice(JoinPoint, Throwable)
		} catch (Exception e) {
			//e.printStackTrace();
		}
		//Open com.sethi.aayush.aopdemo.aspect.AfterAspect.afterFinallyAdvice(JoinPoint)
		// get the bean from spring container
		MembershipDAO memebershipDao = context.getBean("membershipDAO", MembershipDAO.class);
		// call the business method
		memebershipDao.addAccount();
		memebershipDao.addAnything();

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println(
				"There will be print for only one method doNothingExceptBlabla because of the the expression wrote for all methods excluding getter and setters");
		Account account1 = context.getBean("account", Account.class);
		account1.setLevel("Primary");
		account1.setName("Jimmy");
		//com.sethi.aayush.aopdemo.aspect.MyDemoLoggingAspect: runThisForAllExceptGetterAndSetter
		account1.doNothingExceptBlabla();
		//com.sethi.aayush.aopdemo.aspect.MyDemoLoggingAspect: runThisForAllExceptGetterAndSetter
		account1.doNothingWithArguments("blabla", 5);
		account1.getLevel();
		account1.getName();
		System.out.println("--------------------------------------------------------------------------------");
		// close the context
		context.close();
	}

}
