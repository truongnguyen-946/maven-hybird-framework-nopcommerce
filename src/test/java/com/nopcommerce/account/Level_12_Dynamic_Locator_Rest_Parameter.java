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

public class Level_12_Dynamic_Locator_Rest_Parameter extends BaseTest {

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

        Assert.assertEquals(registerPage.getTextRegistrationCompleted(), "Your registration completed");

    }


    @Test
    public void User_02_Login() {
        homePage = registerPage.clickToNopCommerceLogo();

        loginPage = homePage.clickToLoginLink();

        loginPage.enterToEmailTextBox(emailAddress);
        loginPage.enterToPasswordTextBox("123456");

        homePage = loginPage.clickToLoginButton();

        customerPage = homePage.clickToMyAccountLink();

        Assert.assertEquals(customerPage.getFirstNameTextBoxAttributeValue(), "Automation");
        Assert.assertEquals(customerPage.getLastNameTextBoxAttributeValue(), "FC");
        Assert.assertEquals(customerPage.getEmailAddressTextBoxAttributeValue(), emailAddress);

    }

    @Test
    public void User_03_Switch_Page() {

        addressPage = (AddressPageObject) customerPage.openDynamicSideBar("Addresses");

        orderPage = (OrdersPageObject) addressPage.openDynamicSideBar("Orders");

        downloadableProducts = (DownloadableProductsPageObject) orderPage.openDynamicSideBar("Downloadable products");

        backInStockSubscriptions = (BackInStockSubscriptionsPageObject) downloadableProducts.openDynamicSideBar("Back in stock subscriptions");

        rewardPoints = (RewardPointsPageObject) backInStockSubscriptions.openDynamicSideBar("Reward points");

        changePassword = (ChangePasswordPageObject) rewardPoints.openDynamicSideBar("Change password");

        myProductReviews = (MyProductReviewsPageObject) changePassword.openDynamicSideBar("My product reviews");

        addressPage = (AddressPageObject) myProductReviews.openDynamicSideBar("Addresses");

        downloadableProducts = (DownloadableProductsPageObject) addressPage.openDynamicSideBar("Downloadable products");


    }
    @Test
    public void User_04_Switch_Page() {
        customerPage.openDynamicSideBar("Downloadable products");
        downloadableProducts = PageGeneratorManager.getDownloadableProducts(driver);

        downloadableProducts.openDynamicSideBarPage("Customer info");
        customerPage = PageGeneratorManager.getCustomerPage(driver);


        customerPage.openDynamicSideBarPage("Addresses");
        addressPage = PageGeneratorManager.getAddressPage(driver);

        addressPage.openDynamicSideBarPage("Orders");
        orderPage = PageGeneratorManager.getOrders(driver);

        orderPage.openDynamicSideBarPage("Downloadable products");
        downloadableProducts = PageGeneratorManager.getDownloadableProducts(driver);

        downloadableProducts.openDynamicSideBar("Back in stock subscriptions");
        backInStockSubscriptions = PageGeneratorManager.getBackInStockSubcriptions(driver);

        backInStockSubscriptions.openDynamicSideBarPage("Reward points");
        rewardPoints = PageGeneratorManager.getRewardPoints(driver);

        rewardPoints.openDynamicSideBarPage("Change password");
        changePassword = PageGeneratorManager.getChangePassword(driver);

        changePassword.openDynamicSideBarPage("My product reviews");
        myProductReviews = PageGeneratorManager.getMyProductsReviews(driver);

        myProductReviews.openDynamicSideBar("Customer info");
        customerPage = PageGeneratorManager.getCustomerPage(driver);

    }


    @AfterClass
    public void AfterClass() {
        quitBrowser();
    }


}
