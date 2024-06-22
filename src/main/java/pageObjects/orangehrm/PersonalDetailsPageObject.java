package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.PersonalDetailsPageUI;

public class PersonalDetailsPageObject extends BaseAction{
	WebDriver driver;

	public PersonalDetailsPageObject(WebDriver driver) {
        super(driver);
		this.driver = driver;
	}

	public String getValueFirstNameTextbox() {
		waitForElementVisible(driver, PersonalDetailsPageUI.FIRST_NAME_TEXTBOX);
		return getAttributeValue(driver, PersonalDetailsPageUI.FIRST_NAME_TEXTBOX,"value");
	}

	public String getValueLastNameTextbox() {
		waitForElementVisible(driver, PersonalDetailsPageUI.LAST_NAME_TEXTBOX);
		return getAttributeValue(driver, PersonalDetailsPageUI.LAST_NAME_TEXTBOX,"value");
	}

	public String getValueEmployeeIDTextbox() {
		waitForElementVisible(driver, PersonalDetailsPageUI.EMPLOYEE_ID_TEXTBOX);
		return getAttributeValue(driver, PersonalDetailsPageUI.EMPLOYEE_ID_TEXTBOX,"value");
	}

	public EmployeeListPageObject clickToEmployeeList() {
		waitForElementClickable(driver, PersonalDetailsPageUI.EMPLOYEE_LIST_BUTTON);
		clickToElement(driver, PersonalDetailsPageUI.EMPLOYEE_LIST_BUTTON);
		return PageGeneratorManager.getEmployeeListPageObject(driver);
	}

	public void enterDriversLicenseNumberTextbox(String DriverLicenseNumber) {
		waitForElementVisible(driver, PersonalDetailsPageUI.DRIVER_LICENSE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, PersonalDetailsPageUI.DRIVER_LICENSE_NUMBER_TEXTBOX, DriverLicenseNumber);
	}

	public void enterLicenseExpiryDatePicker(String LicenseExpiryDate) {
		waitForElementVisible(driver, PersonalDetailsPageUI.LICENSE_EXPIRY_DATE_PICKER);
		sendkeyToElement(driver, PersonalDetailsPageUI.LICENSE_EXPIRY_DATE_PICKER, LicenseExpiryDate);
	}

	public void selectNationalityDropDown(String valueExpected ) {
		waitForElementClickable(driver, PersonalDetailsPageUI.NATIONALITY_DROP_DOWN_ICON);
		selectItemInCustomDropdown(driver, PersonalDetailsPageUI.NATIONALITY_DROP_DOWN_ICON, PersonalDetailsPageUI.NATIONALITY_DROP_DOWN_CHILD, valueExpected);
		
	}

	public void selectMaritalStatusDropDown(String valueExpected) {
		waitForElementClickable(driver, PersonalDetailsPageUI.MATIRAL_STATUS_DROP_DOWN_ICON);
		selectItemInCustomDropdown(driver, PersonalDetailsPageUI.MATIRAL_STATUS_DROP_DOWN_ICON, PersonalDetailsPageUI.MATIRAL_STATUS_DROP_DOWN_CHILD, valueExpected);
		
	}

	public void enterDateOfBirthPicker(String dateOfBirth) {
		waitForElementVisible(driver, PersonalDetailsPageUI.DATE_OF_BIRTH_PICKER);
		sendkeyToElement(driver, PersonalDetailsPageUI.DATE_OF_BIRTH_PICKER, dateOfBirth);
		
	}

	public void selectGenderRadioButton(String gender) {
		clickToElementByJS(driver, PersonalDetailsPageUI.DYNAMIC_GENDER_RADIO_BUTTON, gender);
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, PersonalDetailsPageUI.SAVE_BUTTON);
		clickToElement(driver, PersonalDetailsPageUI.SAVE_BUTTON);

	}

	public String getAttributeValueDriversLicenseNumber() {
		waitForElementVisible(driver, PersonalDetailsPageUI.DRIVER_LICENSE_NUMBER_TEXTBOX);
		return getAttributeValue(driver, PersonalDetailsPageUI.DRIVER_LICENSE_NUMBER_TEXTBOX, "value");
	}

	public String getAttributeValueLicenseExpiryDatePicker() {
		waitForElementVisible(driver, PersonalDetailsPageUI.LICENSE_EXPIRY_DATE_PICKER);
		return getAttributeValue(driver, PersonalDetailsPageUI.LICENSE_EXPIRY_DATE_PICKER, "value");
	}

	public String getValueSelectedNationalityDropDown() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getValueSelectedMaritalStatusDropDown() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAttributeValueDateOfBirthPicker() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isSelectedGenderRadioButton() {
		// TODO Auto-generated method stub
		return false;
	}
}
