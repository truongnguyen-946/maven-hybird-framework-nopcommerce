package pageObjects.jquery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jquery.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToColumnTextboxByName(String columnName, String valueToSend) {
		waitForElementVisible(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME, columnName);
		sendkeyToElement(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME, valueToSend, columnName);
	}
	
	public void clickToPageLinkByNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGE_LINK_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGE_LINK_BY_NUMBER, pageNumber);
	}
	
	public boolean isPageActiveByNumber(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGE_ACTIVE_BY_NUMBER, pageNumber);
		return	isElementDisplayed(driver, HomePageUI.PAGE_ACTIVE_BY_NUMBER, pageNumber);
	}
	
	public boolean isRowValuesDisplayed(String female, String country, String male, String total) {
		waitForElementVisible(driver, HomePageUI.DYNAMIC_ROW_VALUE, female, country, male, total );
		return isElementDisplayed(driver, HomePageUI.DYNAMIC_ROW_VALUE, female, country, male, total);
	}
	
	public void clickToRowActionByCountryName(String country, String action) {

		waitForElementClickable(driver, HomePageUI.DYNAMIC_ACTION_ROW, country, action);
		clickToElement(driver, HomePageUI.DYNAMIC_ACTION_ROW, country, action);
	}


	public List<String> getAllPageValuesByColumnName(String columnName) {

		List<String> allPageValues = new ArrayList<String>();
		List<WebElement> allPageLinks = getListWebElement(driver, HomePageUI.ALL_PAGES_LINKS);

		int indexColumn = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;

		for (WebElement page : allPageLinks) {
			page.click();

			List<WebElement> allValues = getListWebElement(driver, HomePageUI.ALL_VALUES_BY_COLUMN_INDEX,
					String.valueOf(indexColumn));
			for (WebElement value : allValues) {
				value.getText();

				allPageValues.add(value.getText());

			}
		}
		System.out.println(allPageValues);
		return allPageValues;
	}

	public void inputToTextBoxByColumnNameAndRowIndex(String columnName, String rowIndex, String valueToSend) {
		
		int indexColumn = getListElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;

		waitForElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_NAME, rowIndex, String.valueOf(indexColumn));
		sendkeyToElement(driver,HomePageUI.DYNAMIC_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_NAME,valueToSend, rowIndex, String.valueOf(indexColumn));
	}

	public void selectDropDownByColumnNameAndRowIndex(String columnName, String rowIndex, String dropDownValue) {
		int indexColumn = getListElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;

		waitForElementClickable(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_NAME, rowIndex, String.valueOf(indexColumn));
		selectItemInDropdown(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_NAME,dropDownValue, rowIndex, String.valueOf(indexColumn));
	}

	public void clickCheckboxByColumnNameAndRowIndex(String columnName, String rowIndex) {
		int indexColumn = getListElementSize(driver, HomePageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;

		waitForElementClickable(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_NAME, rowIndex, String.valueOf(indexColumn));
		checkTheCheckBoxOrRadio(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_NAME, rowIndex, String.valueOf(indexColumn));
	}

	
	
	

}
