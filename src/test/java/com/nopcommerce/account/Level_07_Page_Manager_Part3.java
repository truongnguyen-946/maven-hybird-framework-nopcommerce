package com.nopcommerce.account;

import commons.BaseTest;
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

public class Level_07_Page_Manager_Part3 extends BaseTest {

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
        registerPage = homePage.clickToRegisterLink();

        registerPage.clickToElementRegisterButton();
        registerPage.sleepInSecond(3);

        Assert.assertEquals(registerPage.getTextFirstNameErrorMessage(),"First name is required.");
        Assert.assertEquals(registerPage.getTextLastNameErrorMessage(),"Last name is required.");
        Assert.assertEquals(registerPage.getTextEmailErrorMessage(),"Email is required.");
        Assert.assertEquals(registerPage.getTextPasswordErrorMessage(),"Password is required.");
        Assert.assertEquals(registerPage.getTextConfirmPasswordErrorMessage(),"Password is required.");

    }

    @Test
    public void User_02_Register_Invalid_Email() {
        homePage = registerPage.clickToNopCommerceLogo();

        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextBox("Automation");
        registerPage.enterToLastNameTextBox("FC");
        registerPage.enterToEmailTextBox("abcdef@abcde@abc");
        registerPage.enterToPasswordTextBox("123456");
        registerPage.enterToConfirmPasswordTextBox("123456");

        Assert.assertEquals(registerPage.getTextEmailErrorMessage(), "Wrong email");

    }

    @Test
    public void User_03_Register_Invalid_Password() {
        homePage = registerPage.clickToNopCommerceLogo();

        registerPage = homePage.clickToRegisterLink();

        registerPage.enterToFirstNameTextBox("Automation");
        registerPage.enterToLastNameTextBox("FC");
        registerPage.enterToEmailTextBox(emailAddress);
        registerPage.enterToPasswordTextBox("1234");
        registerPage.enterToConfirmPasswordTextBox("123456");

        Assert.assertEquals(registerPage.getTextPasswordErrorMessage(),"Password must meet the following rules:\nmust have at least 6 characters");

    }

    @Test
    public void User_04_Register_Incorrect_Confirm_Password() {

        homePage = registerPage.clickToNopCommerceLogo();

        registerPage = homePage.clickToRegisterLink();

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
        homePage = registerPage.clickToNopCommerceLogo();

        registerPage = homePage.clickToRegisterLink();

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
        homePage = registerPage.clickToNopCommerceLogo();

        loginPage = homePage.clickToLoginLink();

        loginPage.enterToEmailTextBox(emailAddress);
        loginPage.enterToPasswordTextBox("123456");

        homePage = loginPage.clickToLoginButton();

        customerPage =  homePage.clickToMyAccountLink();

        Assert.assertEquals(customerPage.getFirstNameTextBoxAttributeValue(),"Automation");
        Assert.assertEquals(customerPage.getLastNameTextBoxAttributeValue(),"FC");
        Assert.assertEquals(customerPage.getEmailAddressTextBoxAttributeValue(),emailAddress);

    }



    @AfterClass
    public void AfterClass() {
        quitBrowser();
    }


}
