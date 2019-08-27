package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.LogoutPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class logoutTests {

	private WebDriver driver;
	private String baseUrl;
	private LogoutPOM LogoutPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		LogoutPOM = new LogoutPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}


	@Test
	public void validLogoutTest() throws InterruptedException {

		//Object creation
		LoginPOM obj1 = new LoginPOM(driver);
		LogoutPOM obj2 = new LogoutPOM(driver);

		//Login to application and verify Login screen is displayed
		LogoutPOM.LOGINorREGISTERbutton();

		//sending Username
		obj1.sendUserName("kitchu.nitc@gmail.com");
		//isDisplayed() to Verify
		LogoutPOM.UsernameDisplayed();

		//sending Password
		obj1.sendPassword("Kichu@1234");

		//Assert to verify
		WebElement password=driver.findElement(By.name("pwd"));		
		LogoutPOM.sendPassword("Kichu@1234");
		String Pass=password.getAttribute("value");				
		String ExpectedValue= "Kichu@1234";
		Assert.assertEquals(Pass,ExpectedValue);
		System.out.println("password is displayed");

		//Click on Login button
		obj1.clickLoginBtn();
		
		//Verify profile page is displayed after clicking login button
		String CurrentUrl= driver.getCurrentUrl();
		System.out.println("Profile page url is: " + CurrentUrl);

		Thread.sleep(2000);	

		//Click on Log Out button and verify login screen is displayed back
		LogoutPOM.logoutBtn();
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}



}
