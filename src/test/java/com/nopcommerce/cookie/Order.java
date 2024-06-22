package com.nopcommerce.cookie;

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

public class Order extends BaseTest {

    WebDriver driver;
    private HomePageObject homePage;
    private UserLoginPageObject loginPage;
    private CustomerPageObject customerPage;


    @Parameters("browser")
    @BeforeClass
    public void BeforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = new HomePageObject(driver);
        
        loginPage = homePage.clickToLoginLink();

        loginPage.setCookies(driver, Common_Register_Cookie.cookies);
        loginPage.sleepInSecond(5);
        loginPage.refreshPageCurrent(driver);

        loginPage.clickToNopCommerceLogo();
        homePage = PageGeneratorManager.getHomePage(driver);
 
        homePage.clickToHeaderLinkByName("My account");
        customerPage = PageGeneratorManager.getCustomerPage(driver);

        Assert.assertEquals(customerPage.getTextAttributeByID("FirstName"),Common_Register_Cookie.firstName);
        Assert.assertEquals(customerPage.getTextAttributeByID("LastName"),Common_Register_Cookie.lastName);
        Assert.assertEquals(customerPage.getTextAttributeByID("Email"),Common_Register_Cookie.emailAddress);

    }

    @Test
    public void Order_Invalid_Address() {

    }
    
    @Test
    public void Order_Invalid_Phone() {

    }
    
    @Test
    public void Order_Success() {

    }

   


    @AfterClass
    public void AfterClass() {
        quitBrowser();
    }


}
