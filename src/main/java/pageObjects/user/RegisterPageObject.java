package pageObjects.user;

import commons.BaseElement;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.user.RegisterPageUI;

public class RegisterPageObject extends BaseElement {

    public RegisterPageObject(WebDriver driver) {
    	super(driver);
        this.driver = driver;
    }

    WebDriver driver;

    public void clickToElementRegisterButton() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    public String getTextFirstNameErrorMessage() {
        waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
        return getTextElement(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
    }

    public String getTextLastNameErrorMessage() {
        waitForElementVisible(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
        return getTextElement(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);


    }

    public String getTextEmailErrorMessage() {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
        return getTextElement(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
    }

    public String getTextPasswordErrorMessage() {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
        return getTextElement(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
    }

    public String getTextConfirmPasswordErrorMessage() {
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
        return getTextElement(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
    }

    public void enterToFirstNameTextBox(String firstName) {
        waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextBox(String lastName) {
        waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
    }

    public void enterToEmailTextBox(String emailAddress) {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void enterToPasswordTextBox(String passWord) {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, passWord);
    }

    public void enterToConfirmPasswordTextBox(String confirmPassword) {
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
    }

    public String getTextRegistrationCompleted() {
        waitForElementVisible(driver, RegisterPageUI.REGISTRATION_COMPLETED_MESSAGE);
        return getTextElement(driver, RegisterPageUI.REGISTRATION_COMPLETED_MESSAGE);
    }

	public boolean isRegisterButtonDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_BUTTON);
		return isElementDisplayed(driver, RegisterPageUI.REGISTER_BUTTON);
	}

}
