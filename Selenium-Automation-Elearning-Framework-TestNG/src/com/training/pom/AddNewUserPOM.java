package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewUserPOM {


	private WebDriver driver; 

	public AddNewUserPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);

	}

	//Add new User page elements

	@FindBy(xpath="//*[@id='user_login']")
	private WebElement Username; 

	@FindBy(xpath="//*[@id='email']")
	private WebElement Email; 

	@FindBy(xpath="//*[@id='first_name']")
	private WebElement FirstName; 

	@FindBy(xpath="//*[@id='last_name']")
	private WebElement LastName; 	

	@FindBy(xpath="//*[@id='url']")
	private WebElement Website;


	@FindBy(xpath="//*[@id='createuser']/table/tbody/tr[6]/td/button")
	private WebElement ShowPasswordButton; 

	@FindBy(xpath="//*[@id='pass1-text']")
	private WebElement EnterPassword; 

	@FindBy(id="createusersub")
	private WebElement AddNewUserButton; 


	//Add new User page methods

	public void UsersLink() {
		WebElement User=driver.findElement(By.xpath("//*[@id='menu-users']/a/div[2]"));
		Actions act=new Actions(driver);
		act.moveToElement(User).build().perform();

		//Verify if "All Users", "Add New" and "	Your Profile" links are present or not
		if(driver.getPageSource().contains("All Users"))
		{
			System.out.println("All Users--->Present");
		}
		else
		{
			System.out.println("Fail");
		}


		if(driver.getPageSource().contains("Add New"))
		{
			System.out.println("Add New--->Present");
		}
		else
		{
			System.out.println("Fail");
		}

		if(driver.getPageSource().contains("Your Profile"))
		{
			System.out.println("Your Profile--->Present");
		}
		else
		{
			System.out.println("Fail");
		}	

		driver.findElement(By.xpath("//*[@id='menu-users']/ul/li[3]/a")).click();
	}

	public void Username(String Username) {
		this.Username.clear();
		this.Username.sendKeys(Username);

	}

	public void Email(String Email) {
		this.Email.clear();
		this.Email.sendKeys(Email);

	}

	public void FirstName(String FirstName) {
		this.FirstName.clear();
		this.FirstName.sendKeys(FirstName);

	}

	public void LastName(String LastName) {
		this.LastName.clear();
		this.LastName.sendKeys(LastName);

	}

	public void Website(String Website) {
		this.Website.clear();
		this.Website.sendKeys(Website);

	}


	//Verify the entered details are displayed 
	public void CheckEnteredDetails(){

		String U = Username.getAttribute("value");
		String E = Email.getAttribute("value");				
		String F = FirstName.getAttribute("value");
		String L = LastName.getAttribute("value");
		String W = Website.getAttribute("value");
		System.out.println("User Name is :"  + U +  "\n" + "Email  is: " + E +  "\n" + "First Name is : " + F + "\n" + "Last Name is : " + L + "\n" + "Website is : " + W);
	}


	public void ShowPasswordButton() {
		this.ShowPasswordButton.click(); 
	}

	public void RandomPassword() {
		WebElement MessageBox=driver.findElement(By.xpath("//*[@id='pass1-text']"));
		if(MessageBox.isDisplayed()) {
			System.out.println("Random password displayed");		
			driver.findElement(By.xpath("//*[@id='pass1-text']")).clear();
		}
	}

	public void EnterPassword(String EnterPassword) {
		this.EnterPassword.clear();
		this.EnterPassword.sendKeys(EnterPassword);

	}

	public void RoleDropdown(){
		WebElement DD=driver.findElement(By.xpath("//*[@id='role']"));
		Select s1=new Select(DD);
		//get all the values from the dropdown
		List<WebElement> options = s1.getOptions();

		//printing size of the dropdown
		System.out.println("size of dropwn is " + options.size());

		//print all options
		for(int i=0;i<options.size();i++) {
			System.out.println(options.get(i).getText());
		}

		s1.selectByVisibleText("Customer");

		//selected value displayed
		String options1= driver.findElement(By.xpath("//*[@id='role']")).getAttribute("value");
		System.out.println("The selected values is " + options1);		
	}

	public void AddNewUserButton() {
		this.AddNewUserButton.click(); 
	}

	//verify "Contact Form" section is displayed or not

	public void EditUserLink(){
		if(driver.getPageSource().contains("Edit user"))
		{
			System.out.println("Pass--->Edit user link is present");
		}
		else
		{
			System.out.println("Fail--->Edit user link is not present");
		}

	}	

	//click on "All Users" link

	public void AllUsersLink(){
		WebElement User=driver.findElement(By.xpath("//*[@id='menu-users']/a/div[2]"));

		Actions act=new Actions(driver);
		act.moveToElement(User).build().perform();
		driver.findElement(By.xpath("//*[@id='menu-users']/ul/li[2]/a")).click();

		//verify if created User is present or not

		if(driver.getPageSource().contains("K P"))
		{
			System.out.println("New User is present");
		}
		else
		{
			System.out.println("New User is not present");
		}
	}


}

