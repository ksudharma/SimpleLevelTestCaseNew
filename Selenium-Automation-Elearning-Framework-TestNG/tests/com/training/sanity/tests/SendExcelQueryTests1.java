package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders1;
import com.training.dataproviders.LoginDataProviders2;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.LogoutPOM;
import com.training.pom.SendQueryExcelPOM2;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class SendExcelQueryTests1 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LogoutPOM logoutPOM;
	private SendQueryExcelPOM2 SendQueryExcelPOM2;
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
		SendQueryExcelPOM2 = new SendQueryExcelPOM2(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}



	
	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders2.class)
	public void loginDBTest(String YourName, String YourEmail, String YourSubject, String YourMessage) {
		//Hover Launch link and click on Prestige link
		SendQueryExcelPOM2.LaunchLink();
		// Enter valid credentials in Your Name textbox
		SendQueryExcelPOM2.YourName(YourName);
		// Enter valid credentials in Your Email textbox
		SendQueryExcelPOM2.YourEmail(YourEmail);
		// Enter valid credentials in Subject textbox
		SendQueryExcelPOM2.YourSubject(YourSubject);
		// Enter valid credentials in Your Message textbox
		SendQueryExcelPOM2.YourMessage(YourMessage);
		//Verify the entered details
		SendQueryExcelPOM2.VerifyEntry();
		// Click on Send button
		SendQueryExcelPOM2.Submit();
		//Verify the message 
		SendQueryExcelPOM2.VerifyMessage();
		//Scroll up to the required field
		SendQueryExcelPOM2.VerifyRequiredField();
		//Verify highlighted field
		screenShot.captureScreenShot("Highlighted Field");
		
		
	}
	

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	 

}
