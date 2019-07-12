package com.sethi.aayush.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sethi.aayush.aopdemo.Account;

@Component
public class AccountDAO {
	private String name;
	private String serviceCode;

	public List<Account> findAccounts() {
		List<Account> accounts = new ArrayList<>();
		accounts.add(new Account("Aayush", "Primary"));
		accounts.add(new Account("Piyush", "Secondary"));
		accounts.add(new Account("Vinay", "Platinum"));
		accounts.add(new Account("Sudhir", "Gold"));
		return accounts;
	}

	public void addAccount() {
		System.out.println(this.getClass() + " : addAccount () : Doing some work");
	}

	public void addAccount(String string) {
		System.out.println(this.getClass() + " : addAccount (String string) : Doing some work");
	}

	public void addAccount(Account account) {
		System.out.println(this.getClass() + " : addAccount (Account account) : Doing some work");
	}

	public void addAccount(Account account, boolean bool) {
		System.out.println(this.getClass() + " : addAccount (Account account, boolean bool) : Doing some work");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public void throwException() throws Exception {
		System.out.println("in throw Exception method");
		throw new Exception();
	}
}
