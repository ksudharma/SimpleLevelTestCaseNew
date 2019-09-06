package com.training.pom;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlotsPagePOM {

	private WebDriver driver; 

	public PlotsPagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);

	}

	//Plots page elements

	@FindBy(xpath="//ul[@id='responsive']//li[4]//a")
	private WebElement PlotsLink; 

	@FindBy(xpath="//aside[@id='secondary']//section[2]//div//div//p[2]/a")
	private WebElement DropUsALineButton; 

	@FindBy(name="name")
	private WebElement NameTextBox;

	@FindBy(xpath="//input[@type='email']")
	private WebElement EmailTextBox; 

	@FindBy(name="subject")
	private WebElement SubjectTextBox;

	@FindBy(name="id:comments")
	private WebElement MessageTextBox;

	@FindBy(xpath="	//input[@type='submit']")
	private WebElement SendButton; 		


	//Plots page methods


	public void PlotsLink() {
		this.PlotsLink.click(); 
	}


	//verify if DropUsALine Button Is Displayed is displayed
	public void DropUsALineButtonIsDisplayed(){

		WebElement Link= driver.findElement(By.xpath("//aside[@id='secondary']//section[2]//div//div//p[2]/a"));		
		if(Link.isDisplayed()) {
			System.out.println("Drop Us a Line link is displayed");
			System.out.println("Hense 'Plots' page is opened to the user");

		}
	}

	public void DropUsALineButton() {
		this.DropUsALineButton.click(); 
	}

	//verify "Contact Form" section is displayed or not

	public void ContactFormSection(){
		if(driver.getPageSource().contains("Contact Form"))
		{
			System.out.println("Pass-Contact Form section is present");
		}
		else
		{
			System.out.println("Fail-Contact Form section is not present");
		}
	}

	//verify if Our Office wording is displayed or not
	public void OurOfficeWord(){

		WebElement OurOfficeWordLink= driver.findElement(By.className("office-address"));		
		if(OurOfficeWordLink.isDisplayed()) {
			System.out.println("Our Office Word is displayed");

		}
	}

	public void NameTextBox(String NameTextBox) {
		this.NameTextBox.clear();
		this.NameTextBox.sendKeys(NameTextBox);

	}	


	public void EmailTextBox(String EmailTextBox) {
		this.EmailTextBox.clear();
		this.EmailTextBox.sendKeys(EmailTextBox);

	}

	public void SubjectTextBox(String SubjectTextBox) {
		this.SubjectTextBox.clear();
		this.SubjectTextBox.sendKeys(SubjectTextBox);

	}

	public void MessageTextBox(String MessageTextBox) {
		this.MessageTextBox.clear();
		this.MessageTextBox.sendKeys(MessageTextBox);

	}

	//Verify if the entered values are displayed or not

	public void CheckEnteredDetails(){
		WebElement Name=driver.findElement(By.name("name"));
		WebElement EmailAddress=driver.findElement(By.xpath("//input[@type='email']"));
		WebElement subject=driver.findElement(By.name("subject"));
		WebElement MessageBox=driver.findElement(By.name("id:comments"));

		String N = Name.getAttribute("value");
		String E = EmailAddress.getAttribute("value");				
		String S = subject.getAttribute("value");
		String M = MessageBox.getAttribute("value");

		System.out.println("Name is :"  + N +  "\n" + "Email Address is: " + E +  "\n" + "Subject is : " + S + "\n" + "Message is : " + M);
	}


	public void SendButton() {
		this.SendButton.click(); 

		WebElement message = driver.findElement(By.xpath("//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']"));
		String M= message.getText();
		System.out.println("The message is " + M);

	}




}

