package com.facebook.home;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.facebook.HomePageObject;
import pageObjects.facebook.PageGeneratorManager;


public class Level_20_Undisplayed_Element extends BaseTest {

	WebDriver driver;
	HomePageObject homePage;
	private String emailAddress = getRandomEmail();


	@Parameters({"browser","url"})
    @BeforeClass
    public void BeforeClass(String browserName, String url) {
        driver = getBrowserDriverWithUrl(browserName, url);
        homePage = PageGeneratorManager.getHomePageObject(driver);
    }

    @Test
    public void TC_01_Verify_All_Field_Displayed_In_Create_New_Account_Popup() {
    	log.info("Step 01 - Click to Create new account button");
    	homePage.clickToCreateNewAccountButton();
    	
    	log.info("Step 02 - Verify FirstName textbox is Displayed");
    	Assert.assertTrue(homePage.isFirstNameTextboxIsDisplayed());
    	
    	log.info("Step 03 - Verify Surname textbox is Displayed");
    	Assert.assertTrue(homePage.isSurNameTextboxIsDisplayed());
    	
    	log.info("Step 04 - Verify Email textbox is Displayed");
    	Assert.assertTrue(homePage.isEmailTextboxIsDisplayed());
    	
    	log.info("Step 05 - Enter Email textbox with value" + emailAddress);
    	homePage.inputEmailTextbox(emailAddress);
    	
    	log.info("Step 06 - Verify Confirm email textbox is Displayed");
    	Assert.assertTrue(homePage.isConfirmEmailTextboxIsDisplayed());
    	
    	log.info("Step 07 - Verify Password textbox is Displayed");
    	Assert.assertTrue(homePage.isPasswordTextboxIsDisplayed());	
    }
    
    @Test
    public void TC_02_Verify_Confirm_Email_Not_Displayed() {
    	log.info("Step 01 - Clear data Email textbox with value");
    	homePage.inputEmailTextbox("");
    	homePage.sleepInSecond(3);
    	
    	log.info("Step 02 - Verify Confirm email textbox is Displayed");
    	Assert.assertTrue(homePage.isConfirmEmailTextboxIsUndisplayed());
    }
    
    @Test
    public void TC_03_Verify_All_Field_Undisplayed_In_Create_New_Account_Popup() {
    	log.info("Step 01 - Open Home Page");
    	homePage.openPageUrl(driver, "https://www.facebook.com/");
    	homePage.sleepInSecond(3);
    	
    	log.info("Step 02 - Verify FirstName textbox is Undisplayed");
    	Assert.assertTrue(homePage.isFirstNameTextboxIsUndisplayed());
    	
    	log.info("Step 03 - Verify Surname textbox is Undisplayed");
    	Assert.assertTrue(homePage.isSurNameTextboxIsUndisplayed());
    	
    	log.info("Step 04 - Verify Email textbox is Undisplayed");
    	Assert.assertTrue(homePage.isEmailTextboxIsUndisplayed());
    	
    	log.info("Step 05 - Verify Confirm email textbox is Undisplayed");
    	Assert.assertTrue(homePage.isConfirmEmailTextboxIsUndisplayed());
    	
    	log.info("Step 06 - Verify Password textbox is Undisplayed");
    	Assert.assertTrue(homePage.isPasswordTextboxIsUndisplayed());
    }

    @AfterClass
    public void AfterClass() {
        quitBrowser();
    }


}
