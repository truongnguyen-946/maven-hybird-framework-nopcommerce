package com.nopcommerce.account;

import com.aventstack.extentreports.Status;
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
import pageObjects.user.RegisterPageObject;
import pageObjects.user.UserLoginPageObject;
import reportConfig.ExtentTestManager;
import utilities.DataFakerConfig;

import java.lang.reflect.Method;

public class Level_23_Data_Faker extends BaseTest {

	WebDriver driver;
	RegisterPageObject registerPage;
	HomePageObject homePage;
    private UserLoginPageObject loginPage;
    private CustomerPageObject customerPage;
	private String browserName;
    private DataFakerConfig fakerConfig;
	private String emailAddress, firstName, lastName,password;

	@Parameters("browser")
    @BeforeClass
    public void BeforeClass(String browserName) {
		this.browserName = browserName;
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);
        registerPage = PageGeneratorManager.getRegisterPage(driver);
        fakerConfig = DataFakerConfig.getFakerConfig();
        firstName = fakerConfig.getFirstName();
        lastName = fakerConfig.getLastName();
        password = fakerConfig.getPassword();
        emailAddress = fakerConfig.getEmail();
    }

    @Test
    public void User_01_Register_Success(Method method) {
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

    @Test
    public void User_02_Login() {
        homePage = registerPage.clickToNopCommerceLogo();

        loginPage = homePage.clickToLoginLink();

        loginPage.enterToEmailTextBox(emailAddress);
        loginPage.enterToPasswordTextBox(password);

        homePage = loginPage.clickToLoginButton();

        customerPage = homePage.clickToMyAccountLink();

        Assert.assertEquals(customerPage.getFirstNameTextBoxAttributeValue(), firstName);
        Assert.assertEquals(customerPage.getLastNameTextBoxAttributeValue(), lastName);
        Assert.assertEquals(customerPage.getEmailAddressTextBoxAttributeValue(), emailAddress);

    }

    @AfterClass
    public void AfterClass() {
        quitBrowser();
    }


}
