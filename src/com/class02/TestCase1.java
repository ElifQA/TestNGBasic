package com.class02;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constants;
	/*
	 *Login into the application
Click on Add Employee
Verify labels: Full Name, Employee Id, Photograph are displayed
Provide Employee First and Last Name
Verify Employee has been added successfully
Close the browser  
	 */
public class TestCase1 extends CommonMethods {

	@BeforeMethod
	public void openAndnavigate() throws InterruptedException {
		setUp("chrome", Constants.HRMS_URL);
	
	
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		Thread.sleep(5000);
	}	
		 @Test
		    public void verifyLabel() throws InterruptedException {
	 boolean fullNameDisp = driver.findElement(By.xpath("//label[text()='Full Name']")).isDisplayed();
     SoftAssert softAssert = new SoftAssert();
     softAssert.assertTrue(fullNameDisp, "Full name label Displayed");
     boolean employeeIdDisp = driver.findElement(By.xpath("//label[text()='Employee Id']")).isDisplayed();
     softAssert.assertTrue(employeeIdDisp, "Employee Id label Displayed");
     boolean photoDisp = driver.findElement(By.xpath("//label[text()='Photograph']")).isDisplayed();
     softAssert.assertTrue(photoDisp, "Photo label Displayed");
		Thread.sleep(5000);
		
		  // instantiating web elements and clicking (entering inputs)
        driver.findElement(By.id("firstName")).sendKeys("Aksam ");
        driver.findElement(By.id("lastName")).sendKeys("Olsun");
    
        driver.findElement(By.id("btnSave")).click();
        boolean isDisplayed = driver.findElement(By.xpath("//h1[text()='Personal Details']")).isDisplayed();
        softAssert.assertEquals(isDisplayed, true, "Employee added succesfully");
        softAssert.assertAll();
		 }
        @AfterMethod
    	public void close() {
    		driver.quit();
    		}
		
		
	
		 	
}	
		
		
		
		
		
		


