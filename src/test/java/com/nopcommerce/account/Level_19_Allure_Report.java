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

public class Level_19_Allure_Report extends BaseTest {

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
    public void User_01_Register_Validate() {
	
    	Assert.assertFalse(homePage.isRegisterLinkDisplayed());

        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextBox(firstName);
        
        registerPage.enterToLastNameTextBox(lastName);
     
    }
    
    @Test
    public void User_02_Register_Success() {
        registerPage = homePage.clickToRegisterLink();
        
        registerPage.enterToFirstNameTextBox(firstName);
        
        registerPage.enterToLastNameTextBox(lastName);
    	
        registerPage.enterToEmailTextBox(emailAddress);
        
        registerPage.enterToPasswordTextBox(password);
        
        registerPage.enterToConfirmPasswordTextBox(password);
  
        registerPage.clickToElementRegisterButton();

        Assert.assertEquals(registerPage.getTextRegistrationCompleted(), "Your registration completed");
    }

    @AfterClass
    public void AfterClass() {
        quitBrowser();
    }


}
