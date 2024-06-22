package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class MyProductReviewsPageObject extends MyAccountSideBarPageObject {
    public MyProductReviewsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    WebDriver driver;
}
