package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.AddEmployeePageUI;

public class AddEmployeePageObject extends BaseAction{
	WebDriver driver;

	public AddEmployeePageObject(WebDriver driver) {
        super(driver);
		this.driver = driver;
	}

	public void enterFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, AddEmployeePageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, AddEmployeePageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void enterLastNameTextbox(String lastname) {
		waitForElementVisible(driver, AddEmployeePageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, AddEmployeePageUI.LAST_NAME_TEXTBOX, lastname);
	}

	public String getEmployeeID() {
		waitForElementVisible(driver, AddEmployeePageUI.EMPLOYEE_ID_TEXTBOX);
		return getAttributeValue(driver, AddEmployeePageUI.EMPLOYEE_ID_TEXTBOX,"value");
	}

	public EmployeeListPageObject clickToSaveButton() {
		waitForElementClickable(driver, AddEmployeePageUI.SAVE_BUTTON);
		clickToElement(driver, AddEmployeePageUI.SAVE_BUTTON);
		return PageGeneratorManager.getEmployeeListPageObject(driver);
	}
}
