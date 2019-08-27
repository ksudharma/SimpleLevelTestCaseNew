package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePagePOM {

	private WebDriver driver; 

	public MyProfilePagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	//login elements

	@FindBy(id="user_login")
	private WebElement userName; 

	@FindBy(id="user_pass")
	private WebElement password;

	@FindBy(name="login")
	private WebElement loginBtn; 


	//profile class elements

	@FindBy(id="agent_title")
	private WebElement AgentTitle; 

	@FindBy(id="phone")
	private WebElement phone;

	@FindBy(xpath="//button[@value='Submit']")
	private WebElement SaveChangesButton; 

	//change password elements

	@FindBy(xpath="//div[@class='my-account-nav-container']//ul[2]//li//a")
	private WebElement ChangePasswordButton; 

	@FindBy(name="current_pass")
	private WebElement CurrentPassword;	

	@FindBy(name="pass1")
	private WebElement NewPass;	

	@FindBy(name="pass2")
	private WebElement ConfirmPass;		

	@FindBy(name="wp-submit")
	private WebElement SaveChangesButton1;		


	//login methods
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}

	public void clickLoginBtn() {
		this.loginBtn.click(); 

		//Verify  My Profile page with registered credentials should get displayed
		WebElement FirstName=driver.findElement(By.name("first-name"));
		WebElement LastName=driver.findElement(By.name("last-name"));
		WebElement email=driver.findElement(By.name("email"));

		String FN = FirstName.getAttribute("value");
		String LN = LastName.getAttribute("value");				
		String EM = email.getAttribute("value");

		System.out.println("First name is :"  + FN +  "\n" + "Last name is: " + LN +  "\n" + "Email is: " + EM);
	}	

	
	//profile class methods
	public void AgentTitle(String AgentTitle) {
		this.AgentTitle.clear();
		this.AgentTitle.sendKeys(AgentTitle);

	}

	public void AgentTitleValidation(){
		//verify if title is displayed
		WebElement Agenttitle= driver.findElement(By.name("agent_title"));		
		if(Agenttitle.isDisplayed()) {
			System.out.println("Agenttitle is displayed");

		}
	}

	public void phoneValidation(){
		//verify if title is displayed
		WebElement phone= driver.findElement(By.name("phone"));		
		if(phone.isDisplayed()) {
			System.out.println("phone is displayed");
		}
	}

	public void messageValidation(){
		WebElement Message= driver.findElement(By.xpath("//div[@class='notification success closeable margin-bottom-35']//p"));
		String MessageVeribiage = Message.getText();
		System.out.println("Message is : " + MessageVeribiage);


	}


	public void phone(String phone) {
		this.phone.clear(); 
		this.phone.sendKeys(phone); 
	}

	public void SaveChangesButton() {
		this.SaveChangesButton.click(); 
	}
	

	//change password methods
	public void ChangePasswordButton() {
		this.ChangePasswordButton.click();
		String CurrentUrl= driver.getCurrentUrl();
		System.out.println(CurrentUrl);
	}

	public void CurrentPassword(String CurrentPassword) {
		this.CurrentPassword.sendKeys(CurrentPassword);
	}


	//Entered credentials in Current Password textbox should get displayed
	public void currentPassValidation(){
		WebElement CurrentPwd= driver.findElement(By.name("current_pass"));		
		if(CurrentPwd.isDisplayed()) {
			System.out.println("Current Password is displayed");
		}
	}


	//Entered credentials in New Password textbox should get displayed
	public void newPassValidation(){
		WebElement NewPwd= driver.findElement(By.name("pass1"));		
		if(NewPwd.isDisplayed()) {
			System.out.println("New Password is displayed");
		}
	}

	//Entered credentials in Confirm Password textbox should get displayed
	public void confirmpassValidation(){
		WebElement ConfirmPwd= driver.findElement(By.name("pass2"));		
		if(ConfirmPwd.isDisplayed()) {
			System.out.println("Confirm Password is displayed");
		}
	}



	public void NewPass(String NewPass) {
		this.NewPass.sendKeys(NewPass);
	}

	public void ConfirmPass(String ConfirmPass) {
		this.ConfirmPass.sendKeys(ConfirmPass);
	}


	public void SaveChangesButton1() {
		this.SaveChangesButton1.click(); 
	}

	public void MessageValidation(){
		WebElement Message= driver.findElement(By.xpath("//div[@class='notification success closeable margin-bottom-35']//p"));
		String MessageVeribiage = Message.getText();
		System.out.println(MessageVeribiage);
	}

}





