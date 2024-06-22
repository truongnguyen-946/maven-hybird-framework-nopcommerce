package com.nopcommerce.account;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.factory.CustomerPageObject;
import pageObject.factory.HomePageObject;
import pageObject.factory.LoginPageObject;
import pageObject.factory.RegisterPageObject;


public class Level_06_Register_Selenium_Page_Factory extends BaseTest {

    WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
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


        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);
        registerPage.clickToElementRegisterButton();

        Assert.assertEquals(registerPage.getTextFirstNameErrorMessage(),"First name is required.");
        Assert.assertEquals(registerPage.getTextLastNameErrorMessage(),"Last name is required.");
        Assert.assertEquals(registerPage.getTextEmailErrorMessage(),"Email is required.");
        Assert.assertEquals(registerPage.getTextPasswordErrorMessage(),"Password is required.");
        Assert.assertEquals(registerPage.getTextConfirmPasswordErrorMessage(),"Password is required.");

    }

    @Test
    public void User_02_Register_Invalid_Email() {
        registerPage.clickToNopCommerceLogo();

        homePage = new HomePageObject(driver);

        homePage.clickToRegisterLink();

        registerPage = new RegisterPageObject(driver);

        registerPage.enterToFirstNameTextBox("Automation");
        registerPage.enterToLastNameTextBox("FC");
        registerPage.enterToEmailTextBox("abcdef@abcde@abc");
        registerPage.enterToPasswordTextBox("123456");
        registerPage.enterToConfirmPasswordTextBox("123456");

        Assert.assertEquals(registerPage.getTextEmailErrorMessage(), "Wrong email");

    }

    @Test
    public void User_03_Register_Invalid_Password() {

        registerPage.clickToNopCommerceLogo();
        homePage = new HomePageObject(driver);

        homePage.clickToRegisterLink();
        registerPage = new RegisterPageObject(driver);

        registerPage.enterToFirstNameTextBox("Automation");
        registerPage.enterToLastNameTextBox("FC");
        registerPage.enterToEmailTextBox(emailAddress);
        registerPage.enterToPasswordTextBox("1234");
        registerPage.enterToConfirmPasswordTextBox("123456");

        Assert.assertEquals(registerPage.getTextPasswordErrorMessage(),"Password must meet the following rules:\nmust have at least 6 characters");

    }

    @Test
    public void User_04_Register_Incorrect_Confirm_Password() {

        registerPage.clickToNopCommerceLogo();
        homePage = new HomePageObject(driver);

        homePage.clickToRegisterLink();
        registerPage = new RegisterPageObject(driver);

        registerPage.enterToFirstNameTextBox("Automation");
        registerPage.enterToLastNameTextBox("FC");
        registerPage.enterToEmailTextBox(emailAddress);
        registerPage.enterToPasswordTextBox("123456");
        registerPage.enterToConfirmPasswordTextBox("12345678");

        registerPage.clickToElementRegisterButton();

        Assert.assertEquals(registerPage.getTextConfirmPasswordErrorMessage(),"The password and confirmation password do not match.");

    }

    @Test
    public void User_05_Register_Success() {
        registerPage.clickToNopCommerceLogo();
        homePage = new HomePageObject(driver);

        homePage.clickToRegisterLink();
        registerPage = new RegisterPageObject(driver);

        registerPage.enterToFirstNameTextBox("Automation");
        registerPage.enterToLastNameTextBox("FC");
        registerPage.enterToEmailTextBox(emailAddress);
        registerPage.enterToPasswordTextBox("123456");
        registerPage.enterToConfirmPasswordTextBox("123456");

        registerPage.clickToElementRegisterButton();

        Assert.assertEquals(registerPage.getTextRegistrationCompleted(),"Your registration completed");

    }



    @Test
    public void User_06_Login() {
        registerPage.clickToNopCommerceLogo();
        homePage = new HomePageObject(driver);

        homePage.clickToLoginLink();
        loginPage = new LoginPageObject(driver);

        loginPage.enterToEmailTextBox(emailAddress);
        loginPage.enterToPasswordTextBox("123456");

        loginPage.clickToLoginButton();

        homePage = new HomePageObject(driver);

        homePage.clickToMyAccountLink();

        customerPage = new CustomerPageObject(driver);

        Assert.assertEquals(customerPage.getFirstNameTextBoxAttributeValue(),"Automation");
        Assert.assertEquals(customerPage.getLastNameTextBoxAttributeValue(),"FC");
        Assert.assertEquals(customerPage.getEmailAddressTextBoxAttributeValue(),emailAddress);

    }



    @AfterClass
    public void AfterClass() {
        quitBrowser();
    }


}
