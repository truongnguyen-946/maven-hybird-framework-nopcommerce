package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.*;

public class PageGeneratorManager {
    public static UserLoginPageObject getLoginPage(WebDriver driver) {
        return new UserLoginPageObject(driver);
    }
    public static CustomerPageObject getCustomerPage(WebDriver driver) {
        return new CustomerPageObject(driver);
    }
    public static RegisterPageObject getRegisterPage(WebDriver driver) {
        return new RegisterPageObject(driver);
    }
    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }

    public static AddressPageObject getAddressPage(WebDriver driver) {
        return new AddressPageObject(driver);
    }

    public static BackInStockSubscriptionsPageObject getBackInStockSubcriptions(WebDriver driver){
        return new BackInStockSubscriptionsPageObject(driver);
    }

    public static ChangePasswordPageObject getChangePassword(WebDriver driver) {
        return new ChangePasswordPageObject(driver);
    }
    public static DownloadableProductsPageObject getDownloadableProducts(WebDriver driver) {
        return  new DownloadableProductsPageObject(driver);
    }
    public static MyProductReviewsPageObject getMyProductsReviews(WebDriver driver) {
        return new MyProductReviewsPageObject(driver);
    }
    public static RewardPointsPageObject getRewardPoints(WebDriver driver) {
        return  new RewardPointsPageObject(driver);
    }

    public static OrdersPageObject getOrders(WebDriver driver) {
        return new OrdersPageObject(driver);
    }

    public static MyAccountSideBarPageObject getMyAccountSideBar(WebDriver driver) {
        return  new MyAccountSideBarPageObject(driver);
    }

    public static AdminLoginPageObject getAdminLogin(WebDriver driver) {
        return new AdminLoginPageObject(driver);
    }
    public static AdminDashboardPageObject getAdminDashboard(WebDriver driver) {
        return new AdminDashboardPageObject(driver);
    }
}
