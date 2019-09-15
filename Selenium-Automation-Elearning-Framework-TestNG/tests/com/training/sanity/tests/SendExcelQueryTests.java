package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.dataproviders.LoginDataProviders1;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.LogoutPOM;
import com.training.pom.SendQueryExcelPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class SendExcelQueryTests {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LogoutPOM logoutPOM;
	private SendQueryExcelPOM SendQueryExcelPOM;
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
		SendQueryExcelPOM = new SendQueryExcelPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}



	
	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders1.class)
	public void loginDBTest(String YourName, String YourEmail, String YourSubject, String YourMessage) {
		//Hover Launch link and click on Prestige link
		SendQueryExcelPOM.LaunchLink();
		// Enter valid credentials in Your Name textbox
		SendQueryExcelPOM.YourName(YourName);
		// Enter valid credentials in Your Email textbox
		SendQueryExcelPOM.YourEmail(YourEmail);
		// Enter valid credentials in Subject textbox
		SendQueryExcelPOM.YourSubject(YourSubject);
		// Enter valid credentials in Your Message textbox
		SendQueryExcelPOM.YourMessage(YourMessage);
		//Verify the entered details
		SendQueryExcelPOM.VerifyEntry();
		// Click on Send button
		SendQueryExcelPOM.Submit();
		//Verify the message 
		SendQueryExcelPOM.VerifyMessage();
		
		
	}
	

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	 

}
