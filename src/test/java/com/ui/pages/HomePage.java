package com.ui.pages;

import static com.constants.Env.QA;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

public final class HomePage extends BrowserUtility {
	
	Logger logger = LoggerUtility.getLogger(this.getClass());

	private static final By SIGN_IN_LINK_LOCATOR=By.xpath("//a[contains(text(),\"Sign in\")]");
	
	public HomePage(Browser browserName,boolean isHeadless) {
		super(browserName, isHeadless);//Super keyword job is to call parent class constructor from the child class constructor	
		//goToWebsite(readProperty(QA, "URL"));//To read from Properites file
		goToWebsite(JSONUtility.readJSON(QA).getUrl());//To read from JSON file
		
	}
	
	public HomePage(WebDriver driver) {
		
		super(driver);// to call the parent class constructor from child class constructor
		
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
		
	}

		
	public LoginPage goToLoginPage() {//Page Functions--->
		logger.info("Trying to perform click to go to Sign in page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage lp = new LoginPage(getDriver());
		return lp;
	}
	
	
	
}
