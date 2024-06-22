package com.nopcommerce.account;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;

public class Level_18_Extent_V4 extends BaseTest {

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
        registerPage = PageGeneratorManager.getRegisterPage(driver);
    }

    @Test
    public void User_01_Register_Validate() {
	
    	log.error("Register - Step 01: Verify Register Link is Displayed");	
    	Assert.assertFalse(homePage.isRegisterLinkDisplayed());

    	log.error("Register - Step 02: Click to Register Link");
        registerPage = homePage.clickToRegisterLink();

        log.info("Register - Step 03: Enter to FirstName text with value is " + firstName);
        registerPage.enterToFirstNameTextBox(firstName);
        
        log.info("Register - Step 04: Enter to LastName text with value is " + lastName);
        registerPage.enterToLastNameTextBox(lastName);
     
    }
    
    @Test
    public void User_02_Register_Success() {
    	log.error("Register - Step 01: Click to Register Link");
        registerPage = homePage.clickToRegisterLink();
        
        log.info("Register - Step 03: Enter to FirstName text with value is " + firstName);
        registerPage.enterToFirstNameTextBox(firstName);
        
        log.info("Register - Step 04: Enter to LastName text with value is " + lastName);
        registerPage.enterToLastNameTextBox(lastName);
    	
    	log.info("Register - Step 02: Enter to Email Address text with value is " + emailAddress);
        registerPage.enterToEmailTextBox(emailAddress);
        
        log.info("Register - Step 03: Enter to Password text with value is " + password);
        registerPage.enterToPasswordTextBox(password);
        
        log.info("Register - Step 04: Enter to Password text with value is " + password);
        registerPage.enterToConfirmPasswordTextBox(password);
  
        
        log.info("Register - Step 05: Click to Register Button");
        registerPage.clickToElementRegisterButton();

        log.info("Register - Step 06: Verify success message is displayed");
        Assert.assertEquals(registerPage.getTextRegistrationCompleted(), "Your registration completed");
    }

    @AfterClass
    public void AfterClass() {
        quitBrowser();
    }


}
