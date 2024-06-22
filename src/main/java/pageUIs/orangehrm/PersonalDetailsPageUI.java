package pageUIs.orangehrm;

public class PersonalDetailsPageUI {

	public static final String FIRST_NAME_TEXTBOX = "css=input[name='firstName']";
	public static final String LAST_NAME_TEXTBOX = "css=input[name='lastName']";
	public static final String EMPLOYEE_ID_TEXTBOX = "xpath=//label[text()='Employee Id']/parent::div/following-sibling::div/input";
	public static final String SAVE_BUTTON = "xpath=//h6[text()='Personal Details']/parent::div//button[contains(string(),'Save')]";
	
	public static final String EMPLOYEE_LIST_BUTTON = "xpath=//a[text()='Employee List']";
	
	public static final String DRIVER_LICENSE_NUMBER_TEXTBOX = "xpath=//label[text()=\"Driver's License Number\"]/parent::div/following-sibling::div/input";
	public static final String LICENSE_EXPIRY_DATE_PICKER = "xpath=//label[text()=\"License Expiry Date\"]/parent::div/following-sibling::div//input";
	public static final String NATIONALITY_DROP_DOWN_ICON = "xpath=//label[text()='Nationality']/parent::div/following-sibling::div//i";
	public static final String NATIONALITY_DROP_DOWN_CHILD = "xpath=//label[text()='Nationality']/parent::div/following-sibling::div//div[@class='oxd-select-option']";
	
	public static final String MATIRAL_STATUS_DROP_DOWN_ICON = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//i";
	public static final String MATIRAL_STATUS_DROP_DOWN_CHILD = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//div[@class='oxd-select-option']";

	public static final String DATE_OF_BIRTH_PICKER = "xpath=//label[text()='Date of Birth']/parent::div/following-sibling::div//input";
	public static final String DYNAMIC_GENDER_RADIO_BUTTON = "xpath=//label[string()='%s']/input";
	
	
}
