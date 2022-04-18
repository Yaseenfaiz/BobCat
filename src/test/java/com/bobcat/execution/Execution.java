package com.bobcat.execution;

import org.junit.Ignore;
import org.junit.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.bobcat.baseclass.BaseClass;
import com.bobcat.pageexecution.HomePageExecution;

public class Execution extends HomePageExecution{
	
//	@Test
//	public void method5() {
//		System.out.println("1");
//	}
//	@Test
//	public void method2() {
//		System.out.println("2");
//	}
//	@Test @Ignore
//	public void method1() {
//		System.out.println("3");
//	}
//	@Test
//	public void method4() {
//		System.out.println("4");
//	}
//	@Test
//	public void method3() {
//		System.out.println("5");
//	}
	
	@Test
	public void method1() {
		ExtentTest createTest = extend.createTest("gnanam result");
		createTest.log(Status.PASS, "Backo Loader Status");
		BaseClass.getUrl("https://www.bobcat.com/in/en/index");
		waitClose();
		backoeLoader();
		backoeLoaderProduct();
	}
	
	@Test @Ignore
	public void method2() {
		loaders();
		loadersSkid();
		loadersSkidProductList();
		loadersCompact();
		loadersCompactProductList();
	}
	
	@Test
	public void method3() {
		ExtentTest createTest = extend.createTest("bob cat executed status ");
		createTest.log(Status.FAIL, "compact status");
//		compactExcavators();
//		compactExcavatorsProduct();
		attachments();
		attachmentList();
//		quitBrowser();
	}

}
