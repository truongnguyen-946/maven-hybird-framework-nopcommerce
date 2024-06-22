package com.nopcommerce.account;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.*;

public class Level_08_Switch_Page extends BaseTest {

    WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private UserLoginPageObject loginPage;
    private CustomerPageObject customerPage;
    private String emailAddress = getRandomEmail();

    private AddressPageObject addressPage;
    private OrdersPageObject orderPage;
    private BackInStockSubscriptionsPageObject backInStockSubscriptions;
    private ChangePasswordPageObject changePassword;
    private DownloadableProductsPageObject downloadableProducts;
    private MyProductReviewsPageObject myProductReviews;
    private RewardPointsPageObject rewardPoints;

    private MyAccountSideBarPageObject myAccountSideBar;


    @Parameters("browser")
    @BeforeClass
    public void BeforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
    }

    @Test
    public void User_01_Register_Success() {
        homePage = new HomePageObject(driver);

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
    public void User_02_Login() {
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

    @Test
    public void User_03_Switch_Page() {
        addressPage = customerPage.openAddressPage(driver);

        orderPage = addressPage.openOrdersPage(driver);

        downloadableProducts = orderPage.openDownloadableProductsPage(driver);

        backInStockSubscriptions = downloadableProducts.openBackInStockSubscriptionsPage(driver);

        rewardPoints = backInStockSubscriptions.openRewardPointsPage(driver);

        changePassword = rewardPoints.openChangePasswordPage(driver);

        myProductReviews = changePassword.openMyProductReviewsPage(driver);

        addressPage = myProductReviews.openAddressPage(driver);

        downloadableProducts = addressPage.openDownloadableProductsPage(driver);


    }



    @AfterClass
    public void AfterClass() {
        quitBrowser();
    }


}
