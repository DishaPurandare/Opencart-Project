package contactuspage_stepdefinitions_2;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import com.aventstack.extentreports.Status;
import com.pages.ContactUsPage;
import com.pages.LandingPage;
import com.pages.SuccessPage;
import com.utility.Utility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsPageSteps_2 extends Utility{


	public LandingPage ldp;
	public ContactUsPage cp;
	public SuccessPage sp;
	
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
	public void user_navigates_onto_landing_page() throws IOException, InterruptedException 
	{
	    
		objectMethod();
		Utility.implicitWait();
		
		logger=report.createTest("test02");
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
	public void user_clicks_on_resources_and_selects_contact_us() throws IOException, InterruptedException 
	{
		objectMethod();
		//Thread.sleep(2000);
		Utility.implicitWait();
		ldp.resource();
		
		logger.log(Status.INFO,"Step 2 is executed");
	}
	
	//User selects option from DropDown list
	
	@When("User clicks on contact us")
	public void user_clicks_on_contact_us() throws IOException, InterruptedException 
	{
		objectMethod();
		//Thread.sleep(2000);
		Utility.implicitWait();
		cp=ldp.contact();
		
		logger.log(Status.INFO,"Step 3 is executed");
	}
	
	//User navigates on ContactUs Page
	
	@Then("User navigates on ContactUs page")
	public void user_navigates_on_contact_us_page() throws InterruptedException, IOException 
	{
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
	public void user_selects_option_from_dropdown_list() throws IOException, InterruptedException 
	{
		objectMethod();
		Thread.sleep(2000);
		cp.dropdownList();
		Thread.sleep(2000);
		
		logger.log(Status.INFO,"Step 5 is executed");
	}
	
	//User fill details in ContactUs form
	
	@When("user enters {string} in name and {string} in Emailid")
	public void user_enters_in_name_and_in_emailid(String uname, String email) throws InterruptedException, IOException 
	{
		objectMethod();
		Thread.sleep(2000);
		cp.Name(uname);
		Thread.sleep(2000);
		cp.Email(email);
		Thread.sleep(2000);
		
		logger.log(Status.INFO,"Step 6 is executed");
		
		
	}
     
	//User fills Message in ContactUs Form
	
	@When("User enters in {string} Message")
	public void user_enters_in_message(String msg) throws InterruptedException, IOException 
	{
		
		objectMethod();
		Thread.sleep(2000);
		cp.Message(msg);
		Thread.sleep(2000);
		
		logger.log(Status.INFO,"Step 7 is executed");
		
	}

	//User click correct captcha
	
	@When("User selects the captcha")
	public void user_selects_the_captcha() throws InterruptedException 
	{
	   Thread.sleep(2000);
	   logger.log(Status.INFO,"Step 8 is executed");
	}
	
	//User clicks on Send Message button
	
	@When("User clicks on Send Message button")
	public void user_clicks_on_send_message_button() throws IOException, InterruptedException 
	{
		objectMethod();
		Thread.sleep(2000);
		cp.sendButton();
		Thread.sleep(5000);
		
		logger.log(Status.INFO,"Step 9 is executed");
		
	}
	
	//Positive scenario outline - Valid data
	
	@Then("Contact Us form should be submitted")
	public void contact_us_form_should_be_submitted() throws IOException, InterruptedException 
	{
		objectMethod();
		Thread.sleep(2000);
		
		logger.log(Status.INFO,"Validating title of page");
		
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
	
	//Negative scenario outline - Invalid data
	
	@Then("Contact Us form should not be submitted")
	public void contact_us_form_should_not_be_submitted() throws IOException, InterruptedException 
	{
		objectMethod();
		Thread.sleep(2000);
		
		logger.log(Status.INFO,"Validating title of page");
		
		String actualtitle1 = sp.validateSuccessPageTitle();
		String expectedtitle1 = "OpenCart - Contact"; 
		
		try {
			assertEquals(expectedtitle1, actualtitle1);
			logger.log(Status.PASS,"Step 10 is passed");
			System.out.println(actualtitle1);
			assert true;
			Thread.sleep(5000);
		}catch(AssertionError e) {
			e.printStackTrace();
			logger.log(Status.FAIL,"Step 10 is failed");
			captureScreenshotOnFailure();
			assert false;
		}
	}


}
