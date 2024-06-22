package com.nopcommerce.account;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;
import reportConfig.ExtentTestManager;

public class Level_18_Extent_V5 extends BaseTest {

	WebDriver driver;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	private String browserName;
	private String emailAddress = getRandomEmail();
	private String firstName = "Automation";
	private String lastName = "FC";
	private String password = "123456";

	@Parameters("browser")
    @BeforeClass
    public void BeforeClass(String browserName) {
		this.browserName = browserName;
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);
        registerPage = PageGeneratorManager.getRegisterPage(driver);
    }

    @Test
    public void User_01_Register_Validate(Method method) {
	
    	ExtentTestManager.startTest(method.getName() + " Run on " + this.browserName.toUpperCase() , "Register to system with Validate");
    	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Verify the register is displayed");
    	Assert.assertTrue(homePage.isRegisterLinkDisplayed());

    	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Click to Register Link");
        registerPage = homePage.clickToRegisterLink();

    	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Enter to FirstName text with value is " + firstName);
        registerPage.enterToFirstNameTextBox(firstName);
        
    	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter to LastName text with value is " + lastName);
        registerPage.enterToLastNameTextBox(lastName);
     
    }
    
    @Test
    public void User_02_Register_Success(Method method) {
    	ExtentTestManager.startTest(method.getName() + " Run on " + this.browserName.toUpperCase() , "Register to system success");
    	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Click to Register Link");
        registerPage = homePage.clickToRegisterLink();
        
    	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Enter to FirstName text with value is " + firstName + "");
        registerPage.enterToFirstNameTextBox(firstName);
        
    	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Enter to LastName text with value is " + lastName + "");
        registerPage.enterToLastNameTextBox(lastName);
    	
    	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter to Email Address text with value is " + emailAddress + "");
        registerPage.enterToEmailTextBox(emailAddress);
        
    	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter to Password text with value is " + password + "");
        registerPage.enterToPasswordTextBox(password);
        
    	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Enter to Password text with value is " + password + "");
        registerPage.enterToConfirmPasswordTextBox(password);
  
    	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to Register Button");
        registerPage.clickToElementRegisterButton();

    	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08: Verify success message is displayed");
        Assert.assertEquals(registerPage.getTextRegistrationCompleted(), "Your registration completed");
    }

    @AfterClass
    public void AfterClass() {
        quitBrowser();
    }


}
