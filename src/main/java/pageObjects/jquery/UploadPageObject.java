package pageObjects.jquery;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class UploadPageObject extends BasePage {
	WebDriver driver;

	public UploadPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
