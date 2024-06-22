package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class BackInStockSubscriptionsPageObject extends MyAccountSideBarPageObject {
    public BackInStockSubscriptionsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    WebDriver driver;
}
