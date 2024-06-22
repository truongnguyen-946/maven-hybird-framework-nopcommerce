package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.orangehrm.DashboardPageUI;

public class DashboardPageObject extends BaseAction{
	WebDriver driver;

	public DashboardPageObject(WebDriver driver) {
        super(driver);
		this.driver = driver;
	}

	public EmployeeListPageObject clickToPIMMenu() {
		waitForElementClickable(driver, DashboardPageUI.PIM_MEMU_MODULE);
		clickToElement(driver, DashboardPageUI.PIM_MEMU_MODULE);
		return PageGeneratorManager.getEmployeeListPageObject(driver);
	}
}
	