Feature: Contact Us

Scenario: Validate user navigates to contact us page
Given Chrome is opened and opencart app is launched
Then User navigates onto landing page
When User clicks on resources and selects contact us
And  User clicks on contact us
Then User navigates on ContactUs page

Scenario: Validate  contact us page GUI
Given Chrome is opened and opencart app is launched
Then User navigates onto landing page and able to see logo
When User clicks on resources and selects contact us
And  User clicks on contact us
Then User navigates on ContactUs page and see text

Scenario: Validate  contact us page Functionality
Given Chrome is opened and opencart app is launched
Then User navigates onto landing page
When User clicks on resources and selects contact us
And  User clicks on contact us
Then User navigates on ContactUs page
When User selects option from dropdown list
And user enters name "John" and Emailid "test123@gmail.com"
And User enters "Unable to login to account" in Message 
And User selects the captcha 
And User clicks on Send Message button 
Then Contact Us form should be submitted
