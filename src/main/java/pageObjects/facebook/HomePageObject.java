package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.HomePageUI;

public class HomePageObject extends BasePage{
	
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateNewAccountButton() {
		waitForElementVisible(driver, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}

	public boolean isFirstNameTextboxIsDisplayed() {
		waitForElementVisible(driver, HomePageUI.FIRST_NAME_TEXTBOX);
		return isElementDisplayed(driver, HomePageUI.FIRST_NAME_TEXTBOX);
	}

	public boolean isSurNameTextboxIsDisplayed() {
		waitForElementVisible(driver, HomePageUI.SURNAME_TEXTBOX);
		return isElementDisplayed(driver, HomePageUI.SURNAME_TEXTBOX);
	}

	public boolean isEmailTextboxIsDisplayed() {
		waitForElementVisible(driver, HomePageUI.EMAIL_TEXTBOX);
		return isElementDisplayed(driver, HomePageUI.EMAIL_TEXTBOX);
	}

	public void inputEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, HomePageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, HomePageUI.EMAIL_TEXTBOX, emailAddress);
		
	}

	public boolean isConfirmEmailTextboxIsDisplayed() {
		waitForElementVisible(driver, HomePageUI.CONFIRM_EMAIL_TEXTBOX);
		return isElementDisplayed(driver, HomePageUI.CONFIRM_EMAIL_TEXTBOX);
	}

	public boolean isPasswordTextboxIsDisplayed() {
		waitForElementVisible(driver, HomePageUI.PASSWORD_TEXTBOX);
		return isElementDisplayed(driver, HomePageUI.PASSWORD_TEXTBOX);
	}

	public void clickToCloseSignUpPopup() {
		waitForElementVisible(driver, HomePageUI.CLOSE_SIGN_UP_BUTTON);
		clickToElement(driver, HomePageUI.CLOSE_SIGN_UP_BUTTON);
	}

	public boolean isFirstNameTextboxIsUndisplayed() {
		return isElementUndisplayed(driver, HomePageUI.FIRST_NAME_TEXTBOX);
	}

	public boolean isSurNameTextboxIsUndisplayed() {
		return isElementUndisplayed(driver, HomePageUI.SURNAME_TEXTBOX);
	}

	public boolean isEmailTextboxIsUndisplayed() {
		return isElementUndisplayed(driver, HomePageUI.EMAIL_TEXTBOX);
	}

	public boolean isConfirmEmailTextboxIsUndisplayed() {
		return isElementUndisplayed(driver, HomePageUI.CONFIRM_EMAIL_TEXTBOX);
	}

	public boolean isPasswordTextboxIsUndisplayed() {
		return isElementUndisplayed(driver, HomePageUI.PASSWORD_TEXTBOX);
	}
	

}
