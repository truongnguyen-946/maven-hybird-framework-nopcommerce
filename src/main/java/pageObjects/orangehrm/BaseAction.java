package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.BaseUI;

public class BaseAction extends BasePage{
	WebDriver driver;

	public BaseAction(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean waitToLoaderInvisible() {
		waitForElementInvisible(driver, BaseUI.DYNAMIC_LOADER_ICON);
		return true;
	}
	
	public boolean isSuccessMessageDisplayed(String message) {
		return isElementDisplayed(driver, BaseUI.DYNAMIC_MESSAGE_SUCCESS, message);
	}
	
	public boolean isValueNameByColumnNameDisplayed(String columnName, String valueName) {
		return isElementDisplayed(driver, BaseUI.DYNAMIC_VALUE_NAME_BY_COLUMN_NAME, columnName,valueName);
	}

	public void clickToActionByColumnName(String columnName) {
		waitForElementClickable(driver, BaseUI.DYNAMIC_ACTIONS_NAME_BY_COLUMN_NAME,columnName);
		clickToElement(driver, BaseUI.DYNAMIC_ACTIONS_NAME_BY_COLUMN_NAME, columnName);
	}

}
