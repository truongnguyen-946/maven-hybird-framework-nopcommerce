package pageObjects.admin;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageUIs.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
    public AdminLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    public void enterEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, AdminLoginPageUI.EMAIL_ADDRESS_TEXT_BOX);
        sendkeyToElement(driver, AdminLoginPageUI.EMAIL_ADDRESS_TEXT_BOX, emailAddress);
    }

    public void enterPasswordTextbox(String passWord) {
        waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXT_BOX);
        sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXT_BOX, passWord);
    }

    public AdminDashboardPageObject clickLoginButton() {
        waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getAdminDashboard(driver);
    }
}
