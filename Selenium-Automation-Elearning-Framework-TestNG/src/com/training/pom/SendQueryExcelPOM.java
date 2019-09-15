package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendQueryExcelPOM {
	private WebDriver driver; 

	public SendQueryExcelPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}


	//Elements
	@FindBy(name="your-name")
	private WebElement YourName; 

	@FindBy(name="your-email")
	private WebElement YourEmail; 

	@FindBy(name="your-subject")
	private WebElement YourSubject; 

	@FindBy(name="your-message")
	private WebElement YourMessage; 

	@FindBy(xpath="//input[@type='submit']")
	private WebElement Submit; 

	//methods
	public void LaunchLink() {
		//this.LaunchLink1.click();

		WebElement NewLaunch=driver.findElement(By.xpath("//ul[@id='responsive']//li[2]"));
		Actions act=new Actions(driver);
		act.moveToElement(NewLaunch).build().perform();

		WebElement Prestige=driver.findElement(By.xpath("//*[@id='wpmm-megamenu']/div/div[2]/div[1]/a/img"));
		Prestige.click();

	}

	public void YourName(String YourName) {
		this.YourName.clear();
		this.YourName.sendKeys(YourName);
	}

	public void YourEmail(String YourEmail) {
		this.YourEmail.clear();
		this.YourEmail.sendKeys(YourEmail);
	}

	public void YourSubject(String YourSubject) {
		this.YourSubject.clear();
		this.YourSubject.sendKeys(YourSubject);
	}

	public void YourMessage(String YourMessage) {
		this.YourMessage.clear();
		this.YourMessage.sendKeys(YourMessage);
	}

	//Verify  all the entered values are getting displayed
	public void VerifyEntry() {
		WebElement Yourname=driver.findElement(By.name("your-name"));
		WebElement YourEmail=driver.findElement(By.name("your-email"));
		WebElement YourSubject=driver.findElement(By.name("your-subject"));
		WebElement YourMessage=driver.findElement(By.name("your-message"));

		String YN = Yourname.getAttribute("value");
		String YE = YourEmail.getAttribute("value");				
		String YS = YourSubject.getAttribute("value");
		String YM = YourMessage.getAttribute("value");

		System.out.println("Your Name is :"  + YN +  "\n" + "Your Email is: " + YE +  "\n" + "Your Subject is : " + YS + "\n" + "Your Message is :" + YM);
	}	

	public void Submit() {
		this.Submit.click(); 
	}
	public void VerifyMessage() {
		WebElement Message= driver.findElement(By.xpath("//*[@id='wpcf7-f4-o1']/form/div[2]"));
		String MessageVeribiage = Message.getText();
		System.out.println(MessageVeribiage);

	}


}
