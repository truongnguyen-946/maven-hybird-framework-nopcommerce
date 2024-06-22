package com.nopcommerce.account;

import commons.BaseTest;
import commons.GlobalContants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.*;

public class Level_11_Global_Contants extends BaseTest {

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

    private AdminLoginPageObject adminLoginPage;

    private AdminDashboardPageObject adminDashboard;

    String userUrlPage = GlobalContants.END_USER_URL;
    String adminUrlPage =  GlobalContants.ADMIN_PAGE_URL;


    @Parameters("browser")
    @BeforeClass
    public void BeforeClass(String browserName) {
        driver = getBrowserDriverWithUrl(browserName, userUrlPage);
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
    public void User_02_Switch_User_To_Admin() {
        homePage = registerPage.clickToNopCommerceLogo();

        loginPage = homePage.clickToLoginLink();

        loginPage.enterToEmailTextBox(emailAddress);
        loginPage.enterToPasswordTextBox("123456");

        homePage = loginPage.clickToLoginButton();

        homePage.clickToLogoutLink();

        homePage.openPageUrl(driver, adminUrlPage);

        adminLoginPage = PageGeneratorManager.getAdminLogin(driver);

        adminLoginPage.enterEmailTextbox(GlobalContants.EMAIL_ADDRESS_ADMIN);
        adminLoginPage.enterPasswordTextbox(GlobalContants.PASSWORD_ADMIN);
        adminDashboard = adminLoginPage.clickLoginButton();
        Assert.assertTrue(adminLoginPage.isPageLoadedSuccess(driver));


    }

    @Test
    public void User_03_Switch_Admin_To_User() {
        adminLoginPage = adminDashboard.clickToLogoutLink();

       Assert.assertTrue(adminDashboard.isPageLoadedSuccess(driver));


        adminLoginPage.openPageUrl(driver, userUrlPage);

        homePage = PageGeneratorManager.getHomePage(driver);

        loginPage = homePage.clickToLoginLink();

        loginPage.enterToEmailTextBox(emailAddress);
        loginPage.enterToPasswordTextBox("123456");
        homePage = loginPage.clickToLoginButton();
        homePage.clickToLogoutLink();


    }


    @AfterClass
    public void AfterClass() {
        quitBrowser();
    }


}
