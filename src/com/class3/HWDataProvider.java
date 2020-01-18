package com.class3;

	import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constants;

public class HWDataProvider extends CommonMethods{
	

	/*Open chrome browser
	 * Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
		Login into the application
		Add 5 different Employees and create login credentials by providing: 
		First Name
		Last Name
		Username
		Password
		Provide Employee First and Last Name
		Verify Employee has been added successfully and take screenshot (you must have 5 different screenshots)
		Close the browser
		Specify group for this test case, add it into specific suite and execute from xml file.
		*/
	
	@BeforeClass(alwaysRun=true)
	public void openAndLogin() throws InterruptedException {
		setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
	}
		@BeforeMethod
		    public void logIn() throws InterruptedException {
		        driver.findElement(By.id("txtUsername")).sendKeys("admin");
		        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		        driver.findElement(By.id("btnLogin")).click();
		        Thread.sleep(1000);
		        driver.findElement(By.id("menu_pim_viewPimModule")).click();
		        Thread.sleep(1000);
		        driver.findElement(By.id("menu_pim_addEmployee")).click();
		    }
		    @AfterMethod
		    public void logOut() throws InterruptedException {
		        Thread.sleep(1000);
		        driver.findElement(By.id("welcome")).click();
		        Thread.sleep(1000);
		        driver.findElement(By.linkText("Logout")).click();
		    }
	
	@AfterClass(alwaysRun=true)
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test( dataProvider="getData", groups="regression")
		public void addEmp(String firstName, String lastName, String userName, String password) throws InterruptedException{
			
			driver.findElement(By.id("firstName")).clear();
			driver.findElement(By.id("firstName")).sendKeys(firstName);
			driver.findElement(By.id("lastName")).clear();
			Thread.sleep(3000);
			driver.findElement(By.id("lastName")).sendKeys(lastName);
			
			WebDriverWait wait=new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("chkLogin")));
			
			driver.findElement(By.id("chkLogin")).click();
			driver.findElement(By.id("user_name")).sendKeys(userName);
			driver.findElement(By.id("user_password")).sendKeys(password);
			Thread.sleep(3000);
			driver.findElement(By.id("re_password")).sendKeys(password);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
			driver.findElement(By.id("btnSave")).click();
			 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='profile-pic']/h1")));
			 String  empName=driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).getText();
			 System.out.println(empName + " has been added successfully");
	        
		 Thread.sleep(1000);
	        SoftAssert softAssert = new SoftAssert();
	        softAssert.assertEquals(empName, firstName + " " + lastName, "Employee is Not Added");
	        softAssert.assertAll();
	        Thread.sleep(1000);
			
	        TakesScreenshot ts=(TakesScreenshot) driver;
			File screen=ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screen, new File("screenshots/HRMS/dataprovider"+firstName+".png"));
			} catch (IOException e) {
			
				e.printStackTrace();
			}
			
	}
			
	@DataProvider
			public Object[][] getData(){
				
				Object[][] data= {
						{"SainThomas", "Hum@nhrm123", "guvrCenn23", "/8Hum@#$124"},
						{"SynbotMM", "Suda123!", "Yalistnbl", "33S@yno/pl"},
						{"Waryemez123", "Wara123Do!", "nesunema34", "Us3%489kjh/"},
						{"AsimcanlKI", "Demirnj", "zehruzema6","/As4556h@yi"},
						{"Angelbuya25", "bugareiP", "missmycountry45", "Me4/5@456n"}
						
				};
				return data;
			}	
}
			
			
		
	
		

	
	



