package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class RewardPointsPageObject extends MyAccountSideBarPageObject {
    public RewardPointsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    WebDriver driver;
}
