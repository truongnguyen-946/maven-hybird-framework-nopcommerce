package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class OrdersPageObject extends MyAccountSideBarPageObject {
    public OrdersPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    WebDriver driver;
}
