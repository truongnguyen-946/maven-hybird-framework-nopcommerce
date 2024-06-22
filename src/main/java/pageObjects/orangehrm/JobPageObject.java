package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class JobPageObject extends BaseAction{
	WebDriver driver;

	public JobPageObject(WebDriver driver) {
        super(driver);
		this.driver = driver;
	}
}
