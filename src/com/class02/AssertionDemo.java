package com.class02;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class AssertionDemo extends CommonMethods{
	  @BeforeMethod
	    public void openAndNavigate() {
	        setUp("chrome", Constants.HRMS_URL);
	    }
	    @AfterMethod
	    public void closeBrowser() {
	        driver.quit();
	    }
	    @Test(enabled=true)
	    public void titleValidation() {
	        String expectedTitle = "Human Management System";
	        String actualTitle = driver.getTitle();
	        Assert.assertEquals(actualTitle, expectedTitle, "Titles are matched");
	        
	        }
	    
	    @Test(enabled=true)
	    public void logoValidation() {
	        boolean isDisplayed = driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
	        //isDisplayed=false;
	        Assert.assertTrue(isDisplayed, "Synax logo is not  displayed");
	        //using if condition we cannot make testNG test failes
	        
	    }

}
