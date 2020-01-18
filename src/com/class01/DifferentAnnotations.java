package com.class01;

import org.testng.annotations.*;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class DifferentAnnotations {
	@BeforeSuite
	public void beforeSuit() {
		System.out.println("Before suite");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("After suite");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before test");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("After test");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
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
	public void test() {
		System.out.println("I am an actual test");
	}
}






