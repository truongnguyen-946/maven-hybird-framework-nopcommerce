package com.nopcommerce.account;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.RegisterPageObject;

public class Level_21_Pattern_Object extends BaseTest {

    WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private CustomerPageObject customerPage;
    private String emailAddress = getRandomEmail();


    @Parameters("browser")
    @BeforeClass
    public void BeforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = new HomePageObject(driver);

    }

    @Test
    public void User_01_Register_Empty_Data() {
        homePage.clickToHeaderLinkByName("Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        registerPage.clickToButtonByText("Register");
        registerPage.sleepInSecond(3);
        
        Assert.assertEquals(registerPage.getTextErrorMessageByID("FirstName"),"First name is required.");
        Assert.assertEquals(registerPage.getTextErrorMessageByID("LastName"),"Last name is required.");
        Assert.assertEquals(registerPage.getTextErrorMessageByID("Email"),"Email is required.");
        Assert.assertEquals(registerPage.getTextErrorMessageByID("ConfirmPassword"),"Password is required.");

    }

    @Test
    public void User_02_Register_Invalid_Email() {
//        homePage = registerPage.clickToNopCommerceLogo();

        homePage.clickToHeaderLinkByName("Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);
        
        registerPage.enterTextboxByID("FirstName", "Automation");
        registerPage.enterTextboxByID("LastName", "FC");
        registerPage.enterTextboxByID("Email", "abcdef@abcde@abc");
        registerPage.enterTextboxByID("Password", "123456");
        registerPage.enterTextboxByID("ConfirmPassword", "123456");

        Assert.assertEquals(registerPage.getTextErrorMessageByID("Email"), "Please enter a valid email address.");
    }

    
    public void User_03_Register_Invalid_Password() {
        homePage = registerPage.clickToNopCommerceLogo();

        homePage.clickToHeaderLinkByName("Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);
        
        registerPage.enterTextboxByID("FirstName", "Automation");
        registerPage.enterTextboxByID("LastName", "FC");
        registerPage.enterTextboxByID("Email", emailAddress);
        registerPage.enterTextboxByID("Password", "1234");
        registerPage.enterTextboxByID("ConfirmPassword", "123456");

        Assert.assertEquals(registerPage.getTextErrorMessageByID("Password"),"Password must meet the following rules:\nmust have at least 6 characters");

    }

    
    public void User_04_Register_Incorrect_Confirm_Password() {

        homePage = registerPage.clickToNopCommerceLogo();

        homePage.clickToHeaderLinkByName("Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);
        
        registerPage.enterTextboxByID("FirstName", "Automation");
        registerPage.enterTextboxByID("LastName", "FC");
        registerPage.enterTextboxByID("Email", emailAddress);
        registerPage.enterTextboxByID("Password", "123456");
        registerPage.enterTextboxByID("ConfirmPassword", "12345678");

        registerPage.clickToButtonByText("Register");

        Assert.assertEquals(registerPage.getTextErrorMessageByID("ConfirmPassword"),"The password and confirmation password do not match.");

    }

    @Test
    public void User_05_Register_Success() {
        homePage = registerPage.clickToNopCommerceLogo();

        registerPage = homePage.clickToRegisterLink();
        
        registerPage.enterTextboxByID("FirstName", "Automation");
        registerPage.enterTextboxByID("LastName", "FC");
        registerPage.enterTextboxByID("Email", emailAddress);
        registerPage.enterTextboxByID("Password", "123456");
        registerPage.enterTextboxByID("ConfirmPassword", "123456");

        registerPage.clickToButtonByText("Register");

        Assert.assertEquals(registerPage.getTextRegistrationCompleted(),"Your registration completed");

    }



    @Test
    public void User_06_Login() {
        homePage = registerPage.clickToNopCommerceLogo();

        loginPage = homePage.clickToLoginLink();
        homePage.clickToHeaderLinkByName("Log in");

        loginPage.enterTextboxByID("Email",emailAddress);
        loginPage.enterTextboxByID("Password","123456");

        loginPage.clickToButtonByText("Log in");
        homePage = PageGeneratorManager.getHomePage(driver);
 
        homePage.clickToHeaderLinkByName("My account");
        customerPage = PageGeneratorManager.getCustomerPage(driver);

        Assert.assertEquals(customerPage.getTextAttributeByID("FirstName"),"Automation");
        Assert.assertEquals(customerPage.getTextAttributeByID("LastName"),"FC");
        Assert.assertEquals(customerPage.getTextAttributeByID("Email"),emailAddress);

    }



    @AfterClass
    public void AfterClass() {
        quitBrowser();
    }


}
