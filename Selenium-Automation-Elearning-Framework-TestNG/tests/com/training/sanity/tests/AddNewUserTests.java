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
import com.training.pom.AddNewUserPOM;
import com.training.pom.LoginPOM;
import com.training.pom.LogoutPOM;
import com.training.pom.PlotsPagePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddNewUserTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LogoutPOM LogoutPOM;
	private AddNewUserPOM AddNewUserPOM;

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
		AddNewUserPOM = new AddNewUserPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@Test
	public void validAddNewUserTest() throws InterruptedException {
		//Login
		LogoutPOM obj1 = new LogoutPOM(driver);
		obj1.LOGINorREGISTERbutton();
		obj1.sendUserName("admin");
		obj1.sendPassword("adminuser@12345");
		obj1.clickLoginBtn();

		// Hover "Users" links and Verify if "All Users", "Add New" and "	Your Profile" links are present or not

		AddNewUserPOM.UsersLink();
		//Enter Username
		AddNewUserPOM.Username("Krishnapriya S");

		//Enter email
		AddNewUserPOM.Email("kic@gmail.com");

		//Enter First Name
		AddNewUserPOM.FirstName("K P S");

		//Enter Last Name
		AddNewUserPOM.LastName("S");

		//Enter website
		AddNewUserPOM.Website("http://realestate.upskills.in/wp-admin/");

		//Verify the entered details are displayed
		AddNewUserPOM.CheckEnteredDetails();

		//click on Show Password button
		AddNewUserPOM.ShowPasswordButton();

		//Display the Random Password
		AddNewUserPOM.RandomPassword();

		//Clear and enter new password
		AddNewUserPOM.EnterPassword("Kichu@123Kichu@12");

		//click on Role dropdown,print all values and select "customer" from list
		AddNewUserPOM.RoleDropdown();

		//Click on Add New User button
		AddNewUserPOM.AddNewUserButton();

		//verify "Contact Form" section is displayed or not
		AddNewUserPOM.EditUserLink();

		//click on "All Users" link and //verify if created User is present or not
		AddNewUserPOM.AllUsersLink();


	}
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
}
