package contactuspage_stepdefinitions_1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import com.aventstack.extentreports.Status;
import com.pages.ContactUsPage;
import com.pages.LandingPage;
import com.pages.SuccessPage;
import com.utility.Utility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsPageSteps_1 extends Utility {

	
	public LandingPage ldp;
	public ContactUsPage cp;
	public SuccessPage sp;
	
	//Objects are created for page classes
	
	public void objectMethod() throws IOException 
	{

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
	
	//Navigates to Landing Page
	
	@Then("User navigates onto landing page")
	public void user_navigates_onto_landing_page() throws IOException, InterruptedException 
	{
		objectMethod();
		Utility.implicitWait();
		
		logger=report.createTest("test01");
		logger.log(Status.INFO,"Validating landing page Title");
		
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
	
	//Validates Logo on Landing Page
	
	@Then("User navigates onto landing page and able to see logo")
	public void user_navigates_onto_landing_page_and_able_to_see_logo() throws IOException, InterruptedException 
	{
	    
		objectMethod();
		Utility.implicitWait();
		
		logger.log(Status.INFO,"Validating landing page Title");
		
		try {
		boolean checkLogo=ldp.validateLogo();
		assertTrue(checkLogo);
		logger.log(Status.PASS,"Step 2 is passed");
		}catch(AssertionError e) {
			e.printStackTrace();
			logger.log(Status.FAIL,"Step 2 is failed");
			captureScreenshotOnFailure();
			assert false;
			
		}
		
		
	}
	
	//User selects option from Dropdown list
	
	@When("User clicks on resources and selects contact us")
	public void user_clicks_on_resources_and_selects_contact_us() throws IOException, InterruptedException 
	{
		
		objectMethod();
		Utility.implicitWait();
		ldp.resource();
		
		logger.log(Status.INFO,"Step 3 is executed");
		   
	}
	
	//User selects option
	
	@When("User clicks on contact us")
	public void user_clicks_on_contact_us() throws IOException, InterruptedException {
		objectMethod();
		Utility.implicitWait();
		cp=ldp.contact();
		
		logger.log(Status.INFO,"Step 4 is executed");
		
	}
	
	//Navigates to Contact Us page
	
	@Then("User navigates on ContactUs page")
	public void user_navigates_on_contact_us_page() throws IOException, InterruptedException {
	    
		objectMethod();
		Utility.implicitWait();
		
		logger.log(Status.INFO,"Validating ContactUs page Title");
		
		String actualtitle1 = ldp.validateLandinPageTitle();
		String expectedtitle1 = "OpenCart - Contact";
		
		try {
			assertEquals(expectedtitle1, actualtitle1);
			logger.log(Status.PASS,"Step 5 is passed");
			System.out.println(actualtitle1);
			assert true;
		}catch(AssertionError e) {
			e.printStackTrace();
			logger.log(Status.FAIL,"Step 5 is failed");
			captureScreenshotOnFailure();
			assert false;
			
		}
		
	}
	
	//Validates Text
	
	@Then("User navigates on ContactUs page and see text")
	public void user_navigates_on_contact_us_page_and_see_text() throws IOException, InterruptedException {
	    
		objectMethod();
		Utility.implicitWait();
		
		logger.log(Status.INFO,"Validating Text");
		
		try {
		boolean checkText=cp.validateText();
		assertTrue(checkText);
		logger.log(Status.PASS,"Step 6 is passed");
		}catch(AssertionError e) {
			e.printStackTrace();
			logger.log(Status.FAIL,"Step 6 is failed");
			captureScreenshotOnFailure();
			assert false;
			
		}
		
		
	}

	//User fills details in ContactUs page
	
	@When("User selects option from dropdown list")
	public void user_selects_option_from_dropdown_list() throws IOException, InterruptedException 
	{
		objectMethod();
		Thread.sleep(2000);
		cp.dropdownList();
		Thread.sleep(2000);
		
		logger.log(Status.INFO,"Step 7 is executed");
		
	}
	
	//User enters Name and Email in Contactus Form
	
	@When("user enters name {string} and Emailid {string}")
	public void user_enters_name_and_emailid(String uname, String uemail) throws IOException, InterruptedException 
	{
		objectMethod();
		Thread.sleep(2000);
		cp.Name(uname);
		Thread.sleep(2000);
		cp.Email(uemail);
		Thread.sleep(2000);
		
		logger.log(Status.INFO,"Step 8 is executed");
		
		
	}
	
	//User enters Name and Email in Contactus Form
	
	@When("User enters {string} in Message")
	public void user_enters_in_message(String msg) throws IOException, InterruptedException 
	{
		objectMethod();
		Thread.sleep(2000);
		cp.Message(msg);
		Thread.sleep(2000);
		
		logger.log(Status.INFO,"Step 9 is executed");
				
	}
	
	//User selects captcha
	
	@When("User selects the captcha")
	public void user_selects_the_captcha() throws InterruptedException 
	{
		Thread.sleep(2000);	
		
		logger.log(Status.INFO,"Step 10 is executed");
		
	}
	
	//After filling form user clicks on Send Message Button
	
	@When("User clicks on Send Message button")
	public void user_clicks_on_send_message_button() throws IOException, InterruptedException 
	{
		objectMethod();
		Thread.sleep(2000);
		cp.sendButton();
		Thread.sleep(2000);
		
		logger.log(Status.INFO,"Step 11 is executed");
		
	}
	
	//User submits Contact us Form Successfully
	
	@Then("Contact Us form should be submitted")
	public void contact_us_form_should_be_submitted() throws IOException, InterruptedException 
	{
		objectMethod();
		Thread.sleep(2000);
		
		logger.log(Status.INFO,"Validating success page title");
		
		String actualtitle1 = sp.validateSuccessPageTitle();
		String expectedtitle1 = "OpenCart - Contact Support Success";
		try {
			assertEquals(expectedtitle1, actualtitle1);
			logger.log(Status.PASS,"Step 12 is passed");
			System.out.println(actualtitle1); 
			assert true;
			Thread.sleep(2000);
		}catch(AssertionError e) {
			e.printStackTrace();
			logger.log(Status.FAIL,"Step 12 is failed");
			captureScreenshotOnFailure();
			assert false;
			
		}
		
	}
}
