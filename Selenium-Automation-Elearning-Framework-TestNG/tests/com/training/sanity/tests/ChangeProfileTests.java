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
import com.training.pom.MyProfilePagePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ChangeProfileTests {

	private WebDriver driver;
	private String baseUrl;
	private LogoutPOM LogoutPOM;
	private LoginPOM loginPOM;
	private MyProfilePagePOM MyProfilePagePOM;

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
		MyProfilePagePOM = new MyProfilePagePOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}


	@Test
	public void validChangeProfileTest() {

		//Login to application and navigation to profile screen
		MyProfilePagePOM.sendUserName("kitchu.nitc@gmail.com");
		MyProfilePagePOM.sendPassword("Kichu@1234");

		//Verify  "My Profile page" with registered credentials gets displayed
		MyProfilePagePOM.clickLoginBtn();

		//Enter Agent Title
		MyProfilePagePOM.AgentTitle("KrishnapriyaTitle");
		//verify if title is displayed
		MyProfilePagePOM.AgentTitleValidation();		

		//Enter phone
		MyProfilePagePOM.phone("1234567890");
		//Verify if phone is displayed
		MyProfilePagePOM.phoneValidation();

		//Click on Save Changes Button
		MyProfilePagePOM.SaveChangesButton();
		//Verify the message
		MyProfilePagePOM.messageValidation();

	}
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}


}