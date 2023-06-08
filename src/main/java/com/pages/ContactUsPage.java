package com.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Utility;

public class ContactUsPage extends Utility {
	
	//XMLPaths for various webElements
	
	@FindBy(xpath="//select[@name='reason']")
	WebElement dropdown;  
	
	@FindBy(xpath="//option[@value='account']")
	WebElement account;  
	
	@FindBy(xpath="//input[@name='name']")
	WebElement name;  
	
	
	@FindBy(xpath="//input[@name='email']")
	WebElement email;  
	
	@FindBy(xpath="//textarea[@name='enquiry']")
	WebElement message;  
	
	@FindBy(xpath="//button[@id='button-send']")
	WebElement send;  
	
	
	
	public ContactUsPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	
	} 
	
	public String validateLandinPageTitle()
	{
		return driver.getTitle(); 
	}
	
	public boolean validateText()
	{
		boolean text = driver.findElement(By.xpath("//h1")).isDisplayed();
        return text;

	} 
	
	public void dropdownList() throws IOException, InterruptedException 
	{
		
		dropdown.click();
		Thread.sleep(5000);
		account.click();
		Thread.sleep(5000);
		   
	}
	
	//Entering data into ContactUs Form
	
	public void Name(String nm) 
	{
		name.sendKeys(nm);               //Entering name in Name field
	}	


	public void Email(String em) 
	{
		email.sendKeys(em); 			//Entering email in Email field 
	}	

	public void Message(String ms) 
	{
		message.sendKeys(ms);           //Entering message in Message field
	}	


	public void sendButton() throws IOException 
	{
	
		send.click();                   //Clicking on Send Message Button
	
	}	

}
