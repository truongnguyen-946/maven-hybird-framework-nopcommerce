package com.nopcommerce.cookie;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;

public class Common_Register_Cookie extends BaseTest{
	
	WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPageObject;
    public static String firstName, lastName, emailAddress, password;
    public static Set<Cookie> cookies;
	
	@Parameters("browser")
    @BeforeTest
    public void BeforeTest(String browserName) {
		
		firstName = "Automation";
		lastName = "FC";
		emailAddress = getRandomEmail();
		password = "123456";
		
        driver = getBrowserDriver(browserName);
        homePage = new HomePageObject(driver);

        registerPageObject = homePage.clickToRegisterLink();
        
        registerPageObject.enterTextboxByID("FirstName", firstName);
        registerPageObject.enterTextboxByID("LastName", lastName);
        registerPageObject.enterTextboxByID("Email", emailAddress);
        registerPageObject.enterTextboxByID("Password", password);
        registerPageObject.enterTextboxByID("ConfirmPassword", password);

        registerPageObject.clickToButtonByText("Register");

        Assert.assertEquals(registerPageObject.getTextRegistrationCompleted(),"Your registration completed");
        
        cookies = registerPageObject.getBrowserCookies(driver);
        
        quitBrowser();
    }

}
