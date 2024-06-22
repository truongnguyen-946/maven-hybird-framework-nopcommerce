package com.nopcommerce.account;

import commons.BaseTest;
import commons.PageGeneratorManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.user.*;

public class Level_15_Verify_Custom_Hard_Assert extends BaseTest {

	WebDriver driver;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	private String emailAddress = getRandomEmail();
	
	@Parameters("browser")
    @BeforeClass
    public void BeforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void User_01_Register_Success() {
        homePage = new HomePageObject(driver);
        
        verifyFalse(homePage.isRegisterLinkDisplayed());

        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextBox("Automation");
        registerPage.enterToLastNameTextBox("FC");
        registerPage.enterToEmailTextBox(emailAddress);
        registerPage.enterToPasswordTextBox("123456");
        registerPage.enterToConfirmPasswordTextBox("123456");
  
        verifyFalse(registerPage.isRegisterButtonDisplayed());
        registerPage.clickToElementRegisterButton();

        Assert.assertEquals(registerPage.getTextRegistrationCompleted(), "Your registration completed");

    }

    @AfterClass
    public void AfterClass() {
        quitBrowser();
    }


}
