package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LamdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {

	protected HomePage hp; //instance variables
	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	private boolean isLambdaTest;
	
	//private boolean isHeadless = true;
	
	
	@Parameters({"browser","isLambdaTest","isHeadless"})
	
	@BeforeMethod(description = "Load the Home Page of the website") 
	public void setup(
			
		@Optional("chrome") String browser, 
		@Optional("false")boolean isLambdaTest, 
		@Optional("true")boolean isHeadless, ITestResult result) {
	
		
		this.isLambdaTest =  isLambdaTest;
		
		WebDriver lambdaDriver;
		
		if(isLambdaTest) {
			
		lambdaDriver= LamdaTestUtility.intializeLamdaTestSession(browser, result.getMethod().getMethodName());
		hp= new HomePage(lambdaDriver);	
			
		}else {
			
		//Running the test on local machine!!!
		
		logger.info("Load the Home Page of the website");
		hp = new HomePage(Browser.valueOf(browser.toUpperCase()),isHeadless);
		
	}

	}
	
	
	public BrowserUtility getInstance() {
		
		return hp;
		
		
	}
	
	
	@AfterMethod(description="Tear Down the browser")
	public void tearDown() {
		
		if(isLambdaTest) {
			
			LamdaTestUtility.quitSession();//quit or close browsersession on LT
		}
		else {
			
			hp.getDriver().quit();//local
		}
		
		
	}
}
