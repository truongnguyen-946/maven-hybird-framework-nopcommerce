package pageObjects.jquery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
		
	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static UploadPageObject getUploadPageObject(WebDriver driver) {
		return new UploadPageObject(driver);
	}

}
