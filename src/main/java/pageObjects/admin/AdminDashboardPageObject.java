package pageObjects.admin;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageUIs.admin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage {
    public AdminDashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    public AdminLoginPageObject clickToLogoutLink() {
        waitForElementClickable(driver, AdminDashboardPageUI.LOG_OUT_LINK_TEXT);
        clickToElement(driver, AdminDashboardPageUI.LOG_OUT_LINK_TEXT);
        return PageGeneratorManager.getAdminLogin(driver);
    }
}
