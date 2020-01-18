package com.class01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task2Annotations {
	/*
	 * Task 1: Executing different test based TestNG annotations

Create class that will have:
Before and After Class annotation
Before and After Method annotation
2 methods with Test annotation

Observe the results!
	 */

	@BeforeClass
	public void beforeclass() {
		System.out.println("Before class");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before method");
	}
	@AfterMethod
	public void afterMethod() {
		
		System.out.println("After method");
}
	@Test
	public void test1() {
		System.out.println("Test 1");
	}
	@Test
	public void test2() {
		System.out.println("Test 2");
	}
	
}
