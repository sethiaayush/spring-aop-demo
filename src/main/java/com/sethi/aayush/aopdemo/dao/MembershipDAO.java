package com.sethi.aayush.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public void addAccount() {
		System.out.println(this.getClass() + " : addAccount () : Doing some work");
	}

	public boolean addAnything() {
		System.out.println(this.getClass() + " : addAnything () : Doing some work");
		return true;
	}
}
