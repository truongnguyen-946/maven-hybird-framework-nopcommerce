package com.nopcommerce.account;

import commons.BaseTest;
import commons.Log;
import commons.PageGeneratorManager;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.user.*;

public class Level_16_Log extends BaseTest {

	WebDriver driver;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	private String emailAddress = getRandomEmail();
	private String firstName = "Automation";
	private String lastName = "FC";
	private String password = "123456";

	@Parameters("browser")
    @BeforeClass
    public void BeforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void User_01_Register_Success() {
    	
    	log.error("Register - Step 01: Verify Register Link is Displayed");	
    	verifyFalse(homePage.isRegisterLinkDisplayed());

    	log.error("Register - Step 02: Click to Register Link");
        registerPage = homePage.clickToRegisterLink();

        log.info("Register - Step 06: Enter to FirstName text with value is " + firstName);
        registerPage.enterToFirstNameTextBox(firstName);
        
        log.info("Register - Step 07: Enter to LastName text with value is " + lastName);
        registerPage.enterToLastNameTextBox(lastName);
        
        log.info("Register - Step 08: Enter to Email Address text with value is " + emailAddress);
        registerPage.enterToEmailTextBox(emailAddress);
        
        log.info("Register - Step 09: Enter to Password text with value is " + password);
        registerPage.enterToPasswordTextBox(password);
        
        log.info("Register - Step 10: Enter to Password text with value is " + password);
        registerPage.enterToConfirmPasswordTextBox(password);
  
        log.info("Register - Step 11: Verify Register Button is Displayed ");
        verifyFalse(registerPage.isRegisterButtonDisplayed());
        
        log.info("Register - Step 12: Click to Register Button");
        registerPage.clickToElementRegisterButton();

        log.info("Register - Step 13: Verify success message is displayed");
        verifyEquals(registerPage.getTextRegistrationCompleted(), "Your registration completed");

    }

    @AfterClass
    public void AfterClass() {
        quitBrowser();
    }


}
