package pageObjects.user;

import commons.BaseElement;
import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.user.HomePageUI;

public class HomePageObject extends BaseElement {

    public HomePageObject(WebDriver driver) {
    	super(driver);
        this.driver = driver;
    }

    WebDriver driver;
    public RegisterPageObject clickToRegisterLink() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver,HomePageUI.REGISTER_LINK);
       return PageGeneratorManager.getRegisterPage(driver);
    }

    public UserLoginPageObject clickToLoginLink() {
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver,HomePageUI.LOGIN_LINK);
       return PageGeneratorManager.getLoginPage(driver);
    }

    public CustomerPageObject clickToMyAccountLink() {
        waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver,HomePageUI.MY_ACCOUNT_LINK);
       return PageGeneratorManager.getCustomerPage(driver);
    }

    public void clickToLogoutLink() {
        waitForElementClickable(driver, HomePageUI.LOGOUT_LINK);
        clickToElement(driver, HomePageUI.LOGOUT_LINK);
    }

	public boolean isRegisterLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.REGISTER_LINK);
		return isElementDisplayed(driver, HomePageUI.REGISTER_LINK);
	}

}
