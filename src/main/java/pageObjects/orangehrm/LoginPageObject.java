package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.LoginPageUI;

public class LoginPageObject extends BaseAction{
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
        super(driver);
		this.driver = driver;
	}

	public void enterUsernameTextbox(String username) {
		waitForElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX, username);
	}

	public void enterPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);		
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);		
	}

}
