package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPostsPOM {
	private WebDriver driver; 

	public AddPostsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	//Elements
	@FindBy(name="tag-name")
	private WebElement nameTextBox; 

	@FindBy(name="slug")
	private WebElement Slug; 

	@FindBy(name="description")
	private WebElement Description; 

	@FindBy(name="submit")
	private WebElement AddNewCatagoryBtn; 

	@FindBy(id="title")
	private WebElement Title;

	@FindBy(id="content")
	private WebElement Body;


	//Methods

	public void PostLink() {
		WebElement User=driver.findElement(By.xpath("//div[@class='wp-menu-image dashicons-before dashicons-admin-post']"));
		Actions act=new Actions(driver);
		act.moveToElement(User).build().perform();
		if(driver.getPageSource().contains("All Posts"))
		{
			System.out.println("All Posts--->Present");
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



		if(driver.getPageSource().contains("Categories"))
		{
			System.out.println("Categories--->Present");
		}
		else
		{
			System.out.println("Fail");
		}



		if(driver.getPageSource().contains("Tags"))
		{
			System.out.println("Tags--->Present");
		}
		else
		{
			System.out.println("Fail");
		}

		//clicking catagories link
		act.moveToElement(driver.findElement(By.linkText("Categories"))).click().build().perform();


	}


	public void nameTextBox(String nameTextBox) {
		this.nameTextBox.clear(); 
		this.nameTextBox.sendKeys(nameTextBox); 

	}

	public void nameTextBoxVerify() {

		WebElement a1 =  driver.findElement(By.name("tag-name"));
		String name=a1.getAttribute("value");
		System.out.println("Entered credentials in Name textbox is: " + name);

	}

	public void Slug(String Slug) {
		this.Slug.clear(); 
		this.Slug.sendKeys(Slug); 
	}

	public void SlugVerify() {
		WebElement a2 =  driver.findElement(By.name("slug"));
		String slug=a2.getAttribute("value");
		System.out.println("Entered credentials in slug textbox is: " + slug);

	}

	public void Description(String Description) {
		this.Description.clear(); 
		this.Description.sendKeys(Description); 
	}

		public void DescriptionVerify() {
			WebElement a3 =  driver.findElement(By.name("description"));
			String description=a3.getAttribute("value");
			System.out.println("Entered credentials in description textbox is: " + description);

		}

		public void AddNewCatagoryBtn() {
			this.AddNewCatagoryBtn.click(); 
			if(driver.getPageSource().contains("New Launches3")){
				System.out.println("Add New Post page should get displayed");
			}else{
				System.out.println("Text is absent");
			}
		}

		public void PostLink2() {	

			WebElement User1=driver.findElement(By.xpath("//div[@class='wp-menu-image dashicons-before dashicons-admin-post']"));
			Actions act1=new Actions(driver);
			act1.moveToElement(User1).build().perform();
			act1.moveToElement(driver.findElement(By.linkText("Add New"))).click().build().perform();
		}

		public void Title(String Title) {
			this.Title.clear();
			this.Title.sendKeys(Title);
		}

		public void Body(String Body) {
			this.Body.clear();
			this.Body.sendKeys(Body);
		}


		public void Checkbox() {

			WebElement element1 = driver.findElement(By.xpath("//*[@name='post_category[]' and @type='checkbox']"));
			Actions actions1 = new Actions(driver);
			actions1.moveToElement(element1).click().build().perform();

			if(element1.isSelected()){
				System.out.println("Checkbox is selected");
			}
		}

		public void Publish() throws InterruptedException{
			WebElement publish = driver.findElement(By.xpath("//div[@id='publishing-action']//input[2]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(publish).click().build().perform();

			Thread.sleep(4000);

		}


		public void Home() throws InterruptedException{

			WebElement home = driver.findElement(By.xpath("//div[@class='quicklinks']//ul[1]//li[2]//a"));
			Actions actions2= new Actions(driver);
			actions2.moveToElement(home).click().build().perform();	

			driver.switchTo().alert().accept();

			Thread.sleep(4000);
			//blog
			driver.findElement(By.xpath("//div[@class='container']//ul//li[5]")).click();



			if(driver.getPageSource().contains("Title2")){
				System.out.println("post published by admin is displayed");
			}else{
				System.out.println("Text is present");
			}		

		}
	}