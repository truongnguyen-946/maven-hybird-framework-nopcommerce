package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.EmployeeListPageUI;

public class EmployeeListPageObject extends BaseAction{
	WebDriver driver;

	public EmployeeListPageObject(WebDriver driver) {
        super(driver);
		this.driver = driver;
	}

	public AddEmployeePageObject clickToAddEmployee() {
		waitForElementClickable(driver, EmployeeListPageUI.ADD_EMPLOYEE_BUTTON);
		clickToElement(driver, EmployeeListPageUI.ADD_EMPLOYEE_BUTTON);
		waitToLoaderInvisible();
		return PageGeneratorManager.getAddEmployeePageObject(driver);
	}



	public void enterEmployeeIDTextbox(String employeeID) {
		waitForElementVisible(driver, EmployeeListPageUI.EMPLOYEE_ID_TEXTBOX);
		sendkeyToElement(driver, EmployeeListPageUI.EMPLOYEE_ID_TEXTBOX, employeeID);
	}

	public void clickToSearchButton() {
		waitForElementVisible(driver, EmployeeListPageUI.SEARCH_BUTTON);
		clickToElement(driver, EmployeeListPageUI.SEARCH_BUTTON);
		waitToLoaderInvisible();
	}

}
