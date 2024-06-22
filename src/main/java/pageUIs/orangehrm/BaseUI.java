package pageUIs.orangehrm;

public class BaseUI {
	public static final String DYNAMIC_LOADER_ICON = "css=.oxd-form-loader";
	public static final String DYNAMIC_MESSAGE_SUCCESS = "xpath=//div[contains(@class,'oxd-toast-content')]/p[text()='%s']";
	
	public static final String DYNAMIC_VALUE_NAME_BY_COLUMN_NAME = "xpath=//div[contains(string(),'%s')]/ancestor::div[@class='oxd-table-header']/following-sibling::div//div[@role='cell']/div[contains(text(),'%s')]";
	public static final String DYNAMIC_ACTIONS_NAME_BY_COLUMN_NAME = "xpath=//div[contains(string(),'%s')]/ancestor::div[@class='oxd-table-header']/following-sibling::div//div[@role='cell']//i[contains(@class,'bi-pencil-fill')]";
}
