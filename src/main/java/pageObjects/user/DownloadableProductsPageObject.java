package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class DownloadableProductsPageObject extends MyAccountSideBarPageObject {
    public DownloadableProductsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    WebDriver driver;
}
