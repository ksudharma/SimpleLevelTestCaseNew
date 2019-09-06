package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.LogoutPOM;
import com.training.pom.MyProfilePagePOM;
import com.training.pom.PlotsPagePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class PlotsPageTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private PlotsPagePOM PlotsPagePOM;

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
		PlotsPagePOM = new PlotsPagePOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}


	@Test
	public void PlotPage () {

		//click on "Plots" link
		PlotsPagePOM.PlotsLink();

		//verify if DropUsALine Button Is Displayed is displayed
		PlotsPagePOM.DropUsALineButtonIsDisplayed();

		//click on Drop Us a Line button
		PlotsPagePOM.DropUsALineButton();

		//verify "Contact Form" section is displayed or not
		PlotsPagePOM.ContactFormSection();

		//verify if Our Office wording is displayed or not
		PlotsPagePOM.OurOfficeWord();

		//Enter Name
		PlotsPagePOM.NameTextBox("Krishnapriya");

		//Enter email address
		PlotsPagePOM.EmailTextBox("kitchu.nitc@gmail.com");

		//Enter subject
		PlotsPagePOM.SubjectTextBox("Apartments");

		//Enter message
		PlotsPagePOM.MessageTextBox("Looking for apartment");

		//Hit on Send button
		PlotsPagePOM.SendButton();

	}
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
}

