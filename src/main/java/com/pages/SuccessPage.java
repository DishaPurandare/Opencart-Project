package com.pages;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;

import com.utility.Utility;

public class SuccessPage extends Utility {
	
	
	 public SuccessPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	} 
	
	
	 public  String validateSuccessPageTitle()
	{
		return driver.getTitle(); 
	}  
	
	
}
