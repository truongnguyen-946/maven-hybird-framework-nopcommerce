package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.user.HomePageObject;
import pageUIs.user.BaseElementUI;
import pageUIs.user.RegisterPageUI;

public class BaseElement extends BasePage{
	WebDriver driver;

	public BaseElement(WebDriver driver) {
		this.driver = driver;
	}
	
    public HomePageObject clickToNopCommerceLogo() {
        waitForElementClickable(driver, RegisterPageUI.NOP_COMMERCE_LOGO);
        clickToElement(driver, RegisterPageUI.NOP_COMMERCE_LOGO);
        return new HomePageObject(driver);
    }
	
	public void clickToHeaderLinkByName(String nameLink) {
		waitForElementVisible(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, nameLink);
		clickToElement(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, nameLink);
	}
	
	public void clickToButtonByText(String buttonText) {
		waitForElementVisible(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
		clickToElement(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);	
	}
	

	public String getTextErrorMessageByID(String textID) {
		waitForElementVisible(driver, BaseElementUI.DYNAMIC_ERROR_MESSAGE_BY_ID, textID);
		return getTextElement(driver, BaseElementUI.DYNAMIC_ERROR_MESSAGE_BY_ID, textID);
	}
	
	public void enterTextboxByID(String textID, String valueToSendKey) {
		waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, textID);
		sendkeyToElement(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, valueToSendKey, textID);
	}
	
	public String getTextAttributeByID(String textID) {
		waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, textID);
		return getAttributeValue(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID,"value", textID);
	}
}
