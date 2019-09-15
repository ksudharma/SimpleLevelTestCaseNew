package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddNewPropteryPOM;
import com.training.pom.AddPostsPOM;
import com.training.pom.LoginPOM;
import com.training.pom.LogoutPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddPostsTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LogoutPOM LogoutPOM;
	private AddPostsPOM AddPostsPOM;

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
		AddPostsPOM = new AddPostsPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@Test
	public void validAddPostsTests() throws InterruptedException {
		// Login
		LogoutPOM obj1 = new LogoutPOM(driver);
		obj1.LOGINorREGISTERbutton();
		obj1.sendUserName("admin");
		obj1.sendPassword("adminuser@12345");
		obj1.clickLoginBtn();

		// Hover "Posts" links and Verify if "All Posts", "Add New" and "Categories" links are present or not
		// click on Categories link 
		AddPostsPOM.PostLink();
		
		Thread.sleep(2000);

		// Enter Valid Credentials in Name textbox
		AddPostsPOM.nameTextBox("Name2");

		//Verify Name
		AddPostsPOM.nameTextBoxVerify();
		
		// Enter Valid Credentials in Slug textbox
		AddPostsPOM.Slug("Slug2");
		
		//Verify slug
		AddPostsPOM.SlugVerify();

		// Enter Valid Credentials in Description textbox
		AddPostsPOM.Description("description2");	
		
		//Verify description
		AddPostsPOM.DescriptionVerify();

		// Click on Add New Category button
		AddPostsPOM.AddNewCatagoryBtn();

		// Hove Post link and check the links
		// Click on Add New
		AddPostsPOM.PostLink2();

		// Enter Valid credentials in Enter title here textbox
		AddPostsPOM.Title("Title2");

		// Enter valid credentials in body textbox
		AddPostsPOM.Body("Body2");

		// Click on Checkbox beside created category name of category section
		AddPostsPOM.Checkbox();

		// Click on Publish button
		AddPostsPOM.Publish();

		// Click on Home link
		AddPostsPOM.Home();		

	}

}
