package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class DepentdentsPageObject extends BaseAction{
	WebDriver driver;

	public DepentdentsPageObject(WebDriver driver) {
        super(driver);
		this.driver = driver;
	}
}
