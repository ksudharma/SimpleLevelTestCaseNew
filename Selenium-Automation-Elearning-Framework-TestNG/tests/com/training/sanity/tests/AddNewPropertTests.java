package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddNewPropteryPOM;
import com.training.pom.LoginPOM;
import com.training.pom.LogoutPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddNewPropertTests {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LogoutPOM LogoutPOM;
	private AddNewPropteryPOM AddNewPropteryPOM;

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
		AddNewPropteryPOM = new AddNewPropteryPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@Test
	public void validAddNewPropertTests() throws InterruptedException {
		//Login
		LogoutPOM obj1 = new LogoutPOM(driver);
		obj1.LOGINorREGISTERbutton();
		obj1.sendUserName("admin");
		obj1.sendPassword("adminuser@12345");
		obj1.clickLoginBtn();
		
		// Hover "Users" links and Verify if  "Add New" and "All Properties" links are present or not
		AddNewPropteryPOM.UsersLink();
		
		//verify "Add Property" page is displayed or not
		AddNewPropteryPOM.ContactFormSection();
		
		//Enter title
		AddNewPropteryPOM.EnterTitle("title5");
		
		//Enter content
		AddNewPropteryPOM.Content("Entering content 6");
		
		//Enter Price
		AddNewPropteryPOM.PriceHere("2000");
		
		//Enter Price per sq. meter/sq. ft 
		AddNewPropteryPOM.PricePerSq("200");
		
		//Click on Main Details tab and verify the fields present
		AddNewPropteryPOM.MainDetails();
		
		//Enter Status
		AddNewPropteryPOM.Status("Status2");
		
		//Enter location
		AddNewPropteryPOM.Location("Location2");
		
		//Enter possession
		AddNewPropteryPOM.Possession("Possession2");
		
		//Click on Location tab and verify the fields present
		AddNewPropteryPOM.LocationTab();
		
		//Enter Address
		AddNewPropteryPOM.Address("Address12");
		
		//Enter Google map Adrees
		AddNewPropteryPOM.GoogleMapAddress("GoogleMA1");
		
		//Enter latitude
		AddNewPropteryPOM.Latitude("1.2");
		
		//Enter Longitude
		AddNewPropteryPOM.Longitude("1.3");
		
		//Click on Details tab , verify Storage room is displayed and enter Storage room
		AddNewPropteryPOM.DetailsTab();
		
		Thread.sleep(2000);
		//Click on Central Bangalore Checkbox
		AddNewPropteryPOM.CheckBoxes();		
		
		//Click on Publish button
		Thread.sleep(2000);
		AddNewPropteryPOM.Publish();
	}
		
		@AfterMethod
		public void tearDown() throws Exception {
			Thread.sleep(1000);
			driver.quit();
		}
}

	
