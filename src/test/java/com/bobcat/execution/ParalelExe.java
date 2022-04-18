package com.bobcat.execution;

import org.testng.annotations.Test;

public class ParalelExe {
	
	public static long threadId() {
		return Thread.currentThread().getId();
	}
	
	@Test
	public void test8() {
		System.out.println(threadId());
		System.out.println("test8");
	}
	
	@Test
	public void test9() {
		System.out.println(threadId());
		System.out.println("test9");
	}
	
	
	@Test
	public void test10() {
		System.out.println(threadId());
		System.out.println("test10");
	}
	
	@Test
	public void test11() {
		System.out.println(threadId());
		System.out.println("test11");
	}
	
	@Test
	public void test12() {
		System.out.println(threadId());
		System.out.println("test12");
	}

	
	@Test
	public void test13() {
		System.out.println(threadId());
		System.out.println("test13");
	}

	
	@Test
	public void test14() {
		System.out.println(threadId());
		System.out.println("test44");
	}

}
