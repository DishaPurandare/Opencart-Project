package contactuspage_stepdefinitions_3;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import com.aventstack.extentreports.Status;
import java.util.List;
import java.util.Map;
 
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
 
import com.pages.ContactUsPage;
import com.pages.LandingPage;
import com.pages.SuccessPage;
import com.utility.Config;
import com.utility.ExcelReader;
import com.utility.Utility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsPageSteps_3 extends Utility {
	
	public LandingPage ldp;
	public ContactUsPage cp;
	public SuccessPage sp;
	ExcelReader reader;
	
	//Objects are created for page class 
	
	public void objectMethod() throws IOException {

		ldp = new LandingPage();
		cp=new ContactUsPage();
		sp=new SuccessPage();
	}	
	
	@Given("Chrome is opened and opencart app is launched")
	public void chrome_is_opened_and_opencart_app_is_launched() throws IOException, InterruptedException 
	{
		objectMethod();
		Utility.implicitWait();
		String actualtitle= ldp.validateLandinPageTitle();
		System.out.println(actualtitle); 
		
	}
	
	//User Navigates on Landing page
	
	@Then("User navigates onto landing page")
	public void user_navigates_onto_landing_page() throws IOException, InterruptedException {
		objectMethod();
		Utility.implicitWait();
		
		logger=report.createTest("test03");
		logger.log(Status.INFO,"Validating Landing page title");
		
		String actualtitle1 = ldp.validateLandinPageTitle();
		String expectedtitle1 = "OpenCart - Open Source Shopping Cart Solution"; 
		
		try {
			assertEquals(expectedtitle1, actualtitle1);
			logger.log(Status.PASS,"Step 1 is passed");
			System.out.println(actualtitle1); 
			assert true;
		}catch(AssertionError e) {
			e.printStackTrace();
			logger.log(Status.FAIL,"Step 1 is failed");
			captureScreenshotOnFailure();
			assert false;
		}
	}
	
	//User selects option from DropDown list
	
	@When("User clicks on resources and selects contact us")
	public void user_clicks_on_resources_and_selects_contact_us() throws IOException, InterruptedException {
		objectMethod();
		Utility.implicitWait();
		ldp.resource();
		
		logger.log(Status.INFO,"Step 2 is executed");
		
	}
	
	//User selects option from DropDown list
	
	@When("User clicks on contact us")
	public void user_clicks_on_contact_us() throws IOException, InterruptedException {
		objectMethod();
		Utility.implicitWait();
		cp=ldp.contact();
		
		logger.log(Status.INFO,"Step 3 is executed");
		
	}
	
	//User navigates on ContactUs page
	
	@Then("User navigates on ContactUs page")
	public void user_navigates_on_contact_us_page() throws IOException, InterruptedException {
		objectMethod();
		Utility.implicitWait();
		
		logger.log(Status.INFO,"Validating ContactUs page title");
		
		String actualtitle1 = ldp.validateLandinPageTitle();
		String expectedtitle1 = "OpenCart - Contact"; 
		
		try {
			assertEquals(expectedtitle1, actualtitle1);
			logger.log(Status.PASS,"Step 4 is passed");
			System.out.println(actualtitle1); 
			assert true;
		}catch(AssertionError e) {
			e.printStackTrace();
			logger.log(Status.FAIL,"Step 4 is failed");
			captureScreenshotOnFailure();
			assert false;
		}
	}
	
	//User selects option from list
	
	@When("User selects option from dropdown list")
	public void user_selects_option_from_dropdown_list() throws IOException, InterruptedException {
		objectMethod();
		Thread.sleep(2000);
		cp.dropdownList();
		Thread.sleep(2000);
		
		logger.log(Status.INFO,"Step 5 is executed");
	}
	
	//Data fills from Excel file
	
	@When("user enters fills the form from given sheetname {string} and {int}")
	public void user_enters_fills_the_form_from_given_sheetname_and(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException {
		
		Thread.sleep(2000);
        objectMethod();
        reader = new ExcelReader();
        List<Map<String,String>> testData = reader.getData(Config.excelPath, sheetName);

        String name = testData.get(rowNumber).get("Name");
        String email = testData.get(rowNumber).get("Email");
        String message = testData.get(rowNumber).get("Message");
       
        cp.Name(name);
        cp.Email(email);
        cp.Message(message);
        
        Thread.sleep(5000);
        
        logger.log(Status.INFO,"Step 6 is executed");
		
	}
	
	//User selects correct captcha
	
	@When("User selects the captcha")
	public void user_selects_the_captcha() throws InterruptedException {
		Thread.sleep(2000);
		
		logger.log(Status.INFO,"Step 7 is executed");
	}
	
	//User clicks on Send Message Button
	
	@When("User clicks on Send Message button")
	public void user_clicks_on_send_message_button() throws IOException, InterruptedException {
		objectMethod();
		Thread.sleep(2000);
		cp.sendButton();
		Thread.sleep(5000);
		
		logger.log(Status.INFO,"Step 8 is executed");
		
	}
	
	//Form is submitted successfully
	
	@Then("Contact Us form should be submitted")
	public void contact_us_form_should_be_submitted() throws IOException, InterruptedException {
		objectMethod();
		Thread.sleep(2000);
		
		logger.log(Status.INFO,"Validating Success page title");
		
		String actualtitle1 = sp.validateSuccessPageTitle();
		String expectedtitle1 = "OpenCart - Contact Support Success"; 
		
		try {
			assertEquals(expectedtitle1, actualtitle1);
			logger.log(Status.PASS,"Step 9 is passed");
			System.out.println(actualtitle1); 
			assert true;
			Thread.sleep(2000);
		}catch(AssertionError e) {
			e.printStackTrace();
			logger.log(Status.FAIL,"Step 9 is failed");
			captureScreenshotOnFailure();
			assert false;
		}
	}


}
