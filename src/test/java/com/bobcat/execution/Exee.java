package com.bobcat.execution;

import org.junit.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.bobcat.baseclass.BaseClass;

public class Exee extends BaseClass{
	@Test
	public void test1() {
		System.out.println("1");
	}
	@Test
	public void test2() {
		System.out.println("2");
	}
	@Test
	public void test3() {
		System.out.println("3");
	}
	@Test
	public void test4() {
		ExtentTest createTest = extend.createTest("execution file in bob cat");
		createTest.log(Status.FAIL, " test case 4 only fails");
		System.out.println("4");
	}
	@Test
	public void test5() {
		System.out.println("5");
	}
}
