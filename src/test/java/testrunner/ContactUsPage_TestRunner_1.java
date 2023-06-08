package testrunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/test/resources/features/ContactUs_1.feature"},
		glue = {"contactuspage_stepdefinitions_1", "apphooks"},
		 plugin= {"pretty" ,
				 "html:target/creport/cucumber",
				 "json:target/creport/cucumber.json",
		 		 "junit:target/creport/cucumber.xml"} 
		
		)

public class ContactUsPage_TestRunner_1 extends AbstractTestNGCucumberTests{

}
