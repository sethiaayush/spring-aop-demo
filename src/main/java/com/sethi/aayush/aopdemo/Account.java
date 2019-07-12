package com.sethi.aayush.aopdemo;

import org.springframework.stereotype.Component;

@Component
public class Account {

	private String name;
	private String level;

	public String getName() {
		System.out.println(this.getClass() + ": Getter - Get Name");
		return name;
	}

	public Account() {
	}

	public void setName(String name) {
		System.out.println(this.getClass() + ": Setter - Set Name");
		this.name = name;
	}

	public Account(String name, String level) {
		this.name = name;
		this.level = level;
	}

	public String getLevel() {
		System.out.println(this.getClass() + ": Getter- Get Level");
		return level;
	}

	public void setLevel(String level) {
		System.out.println(this.getClass() + ": Setter - Set Level");
		this.level = level;
	}

	public void doNothingExceptBlabla() {
		System.out.println(this.getClass() + " : do Nothing Except Blabla");
	}

	public void doNothingWithArguments(String string, int in) {
		System.out.println(this.getClass() + " : do Nothing With Arguments");
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", level=" + level + "]";
	}
}
