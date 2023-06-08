package com.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Utility;

public class LandingPage extends Utility 
{
	
	//Xpath for DropDown list
	
	@FindBy(xpath="//a[@data-toggle='dropdown']")
	WebElement resources;  
	
	//Xpath for the DropDown list element
	
	@FindBy(xpath="(//*[text()='Contact Us'])[1]")
	WebElement contactus;  
	
	public LandingPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	
	} 
	
	public String validateLandinPageTitle()
	{
		return driver.getTitle(); 
	} 
	
	//Validating Logo on Landing page
	
	public boolean validateLogo()
	{
		boolean logo = driver.findElement(By.xpath("//img[@title='OpenCart - Open Source Shopping Cart Solution']")).isDisplayed();
        return logo;

	} 
	
	//DropDown List
	
	public void resource() throws IOException, InterruptedException 
	{
		
		resources.click();
		Thread.sleep(2000);
		contactus.click();
		Thread.sleep(2000);
	 
	}
	
     //returns  contact page
	
	public ContactUsPage contact() throws IOException 
	{

		return new ContactUsPage();
	}	
}
	