package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewPropteryPOM {

	private WebDriver driver; 

	public AddNewPropteryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);

	}

	//Add new Property page elements

	@FindBy(id="title")
	private WebElement EnterTitle; 

	@FindBy(name="content")
	private WebElement Content; 

	@FindBy(name="_price")
	private WebElement PriceHere; 

	@FindBy(name="_price_per")
	private WebElement PricePerSq; 

	@FindBy(xpath="//ul[@class='ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all']//li[2]/a")
	private WebElement MainDetails; 


	@FindBy(name="_status")
	private WebElement Status; 


	@FindBy(name="_location")
	private WebElement Location; 


	@FindBy(name="_possession")
	private WebElement Possession; 

	@FindBy(xpath="//div[@class='dtheme-cmb2-tabs ui-tabs-vertical ui-tabs ui-widget ui-widget-content ui-corner-all']//ul//li[3]//a")
	private WebElement LocationTab; 

	@FindBy(name="_friendly_address")
	private WebElement Address; 


	@FindBy(name="_address")
	private WebElement GoogleMapAddress; 


	@FindBy(name="_geolocation_lat")
	private WebElement Latitude; 

	@FindBy(name="_geolocation_long")
	private WebElement Longitude;

	@FindBy(xpath="//div[@class='dtheme-cmb2-tabs ui-tabs-vertical ui-tabs ui-widget ui-widget-content ui-corner-all']//ul//li[4]//a")
	private WebElement DetailsTab; 



	//Add new User page methods

	public void UsersLink() {
		WebElement User=driver.findElement(By.xpath("//div[@class='wp-menu-image dashicons-before dashicons-admin-multisite']"));
		Actions act=new Actions(driver);
		act.moveToElement(User).build().perform();

		//Verify if "All Properties" and "Add New" links are present or not
		if(driver.getPageSource().contains("All Properties"))
		{
			System.out.println("All Properties--->Present");
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

		act.moveToElement(driver.findElement(By.linkText("Add New"))).click().build().perform(); 
	}

	//verify "Add Property" page is displayed or not

	public void ContactFormSection(){
		if(driver.getPageSource().contains("Add Property"))
		{
			System.out.println("Add Property page is displayed");
		}
		else
		{
			System.out.println("Add Property page is not displayed");
		}
	}
	public void EnterTitle(String EnterTitle) {
		this.EnterTitle.clear();
		this.EnterTitle.sendKeys(EnterTitle);

	}	

	public void Content(String Content) {
		this.Content.clear();
		this.Content.sendKeys(Content);

	}

	public void PriceHere(String PriceHere) {
		this.PriceHere.clear();
		this.PriceHere.sendKeys(PriceHere);

	}

	public void PricePerSq(String PricePerSq) {
		this.PricePerSq.clear();
		this.PricePerSq.sendKeys(PricePerSq);

	}

	public void MainDetails() {
		this.MainDetails.click(); 
		if(driver.getPageSource().contains("Status"))
		{
			System.out.println("Pass--->Status  present");
		}
		else
		{
			System.out.println("Fail");
		}

		if(driver.getPageSource().contains("Location"))
		{
			System.out.println("Pass--->Location is present");
		}
		else
		{
			System.out.println("Fail");
		}

		if(driver.getPageSource().contains("Possession "))
		{
			System.out.println("Pass--->Possession  is present");

		}	
		else
		{
			System.out.println("Fail");
		}
	}


	public void Status(String Status) {
		this.Status.clear();
		this.Status.sendKeys(Status);

	}

	public void Location(String Location) {
		this.Location.clear();
		this.Location.sendKeys(Location);

	}

	public void Possession(String Possession) {
		this.Possession.clear();
		this.Possession.sendKeys(Possession);

	}
	public void LocationTab() {
		this.LocationTab.click(); 

		WebElement Address= driver.findElement(By.name("_friendly_address"));
		WebElement GoogleMAddress= driver.findElement(By.name("_address"));
		WebElement Latitude= driver.findElement(By.name("_geolocation_lat"));
		WebElement Longitude= driver.findElement(By.name("_geolocation_long"));
		if(Address.isDisplayed()) {
			System.out.println("Address is displayed");
		}
		if(GoogleMAddress.isDisplayed()) {
			System.out.println("Google Map Address is displayed");
		}
		if(Latitude.isDisplayed()) {
			System.out.println("Lalitude is displayed");
		}
		if(Longitude.isDisplayed()) {
			System.out.println("Longitude is displayed");
		}
	}




	public void Address(String Address) {
		this.Address.clear();
		this.Address.sendKeys(Address);

	}

	public void GoogleMapAddress(String GoogleMapAddress) {
		this.GoogleMapAddress.clear();
		this.GoogleMapAddress.sendKeys(GoogleMapAddress);

	}

	public void Latitude(String Latitude) {
		this.Latitude.clear();
		this.Latitude.sendKeys(Latitude);

	}
	public void Longitude(String Longitude) {
		this.Longitude.clear();
		this.Longitude.sendKeys(Longitude);
	}


	public void DetailsTab() {
		this.DetailsTab.click(); 
		WebElement StorageRoom= driver.findElement(By.name("_storage_room"));
		if(StorageRoom.isDisplayed()) {
			System.out.println("Storage Room textbox is displayed");
		}
		StorageRoom.sendKeys("Storage1");
	}



	public void CheckBoxes(){
		//checkbox1
		WebElement checkbox1= driver.findElement(By.xpath("//input[@type ='checkbox' and @name='acf[field_5aa678b4dbea3][]']"));
		checkbox1.click();
		if(checkbox1.isSelected()){
			System.out.println("Checkbox 1 is selected");
		}

		//checkbox2
		WebElement element1 = driver.findElement(By.xpath("//*[@name='tax_input[property_feature][]' and @type='checkbox']"));
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(element1).click().build().perform();
		
		if(element1.isSelected()){
			System.out.println("Checkbox 2 is selected");
		}

		//checkbox3
		WebElement element2 = driver.findElement(By.xpath("//*[@name='tax_input[region][]' and @type='checkbox']"));
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(element2).click().build().perform();
		
		if(element2.isSelected()){
			System.out.println("Checkbox 3 is selected");
		}

	}


	public void Publish() {

		WebElement element = driver.findElement(By.xpath("//div[@id='publishing-action']//input[2]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		WebElement message = driver.findElement(By.xpath("//div[@id='message']//p"));
		String Message = message.getText();
		System.out.println("Message is : " + Message);


	}
}
