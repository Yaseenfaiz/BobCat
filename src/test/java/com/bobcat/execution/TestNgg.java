package com.bobcat.execution;

import org.testng.annotations.Test;

public class TestNgg {

	@Test (priority = 1)
	public void testt() {
		System.out.println("username");
	}
	@Test (priority = 2)
	public void test() {
		System.out.println("password");
	}
	@Test (priority = 3)
	public void test2() {
		System.out.println("login");
	}
	
}
