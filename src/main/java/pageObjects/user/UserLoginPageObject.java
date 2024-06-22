package pageObjects.user;

import commons.BaseElement;
import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.user.LoginPageUI;

public class UserLoginPageObject extends BaseElement {

    public UserLoginPageObject(WebDriver driver) {
    	super(driver);
        this.driver = driver;
    }

    WebDriver driver;
    public void enterToEmailTextBox(String emailAddress) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
    }

    public void enterToPasswordTextBox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public HomePageObject clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
       return PageGeneratorManager.getHomePage(driver);
    }
}
