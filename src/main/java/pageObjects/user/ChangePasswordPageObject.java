package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPageObject extends MyAccountSideBarPageObject {
    public ChangePasswordPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    WebDriver driver;
}
