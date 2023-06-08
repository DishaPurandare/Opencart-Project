Feature: Contact Us Page

Scenario Outline: Verify Contact Us Functionality with valid data
		Given Chrome is opened and opencart app is launched
		Then User navigates onto landing page
		When User clicks on resources and selects contact us
		And  User clicks on contact us
		Then User navigates on ContactUs page
		When User selects option from dropdown list
		And user enters "<Name>" in name and "<Email>" in Emailid 
		And User enters in "<Message>" Message 
		And User selects the captcha 
		And User clicks on Send Message button 
		Then Contact Us form should be submitted

		Examples:
         |Name		|Email						|   Message                 | 
         |John    |test123@gmail.com		| Unable to login to account|
 
Scenario Outline: Verify Contact Us Functionality with Invalid data
		Given Chrome is opened and opencart app is launched
		Then User navigates onto landing page
		When User clicks on resources and selects contact us
		And  User clicks on contact us
		Then User navigates on ContactUs page
		When User selects option from dropdown list
		And user enters "<Name>" in name and "<Email>" in Emailid 
		And User enters in "<Message>" Message 
		And User selects the captcha 
		And User clicks on Send Message button 
		Then Contact Us form should not be submitted

		Examples:
         |Name		|Email						|   Message                 | 
         |John    |test@	          | 													|
         														         														