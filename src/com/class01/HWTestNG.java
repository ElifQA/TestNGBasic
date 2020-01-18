package com.class01;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class HWTestNG extends CommonMethods{
	/*
	 * using TestNG annotations automate following test cases
	TC 1: HRMS Application Login: 
	Open chrome browser
	Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
	Enter valid username and password
	Click on login button
	Then verify Syntax Logo is displayed
	Close the browser
	 */
	
	@BeforeMethod
	public void openAndnavigate() {
		setUp("chrome", Constants.HRMS_URL);

	}
	@AfterMethod
	public void close() {
		driver.quit();
		}
	@Test(enabled= true)
	public void logoisDisplayed() {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		
		boolean logo=driver.findElement(By.xpath("//div[@id='branding']/a/img")).isDisplayed();
		Assert.assertTrue(logo);
		
		
//		if(logo) {
//			System.out.println("login with valid credentials. Logo is displayed, test passed");
//		}else {
//			System.out.println("Test not passed");
//		}
	}
	/*
	 * * Enter valid username
	Leave password field empty
	Verify error message with text “Password cannot be empty” is displayed.
	 */
	@Test(enabled=true)
	public void negativeTest() {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();
		String actualmessage=driver.findElement(By.id("spanMessage")).getText();
		String expectedText="Password cannot be empty";
		Assert.assertEquals(actualmessage, expectedText );
		
		
		
//		if (message.equals("Password cannot be empty")) {
//			System.out.println("Password empty, message is displayed");
//			
//			}else {
//				System.out.println("Test not passed");
//			}
	}
	
}
