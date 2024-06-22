package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class AddressPageObject extends MyAccountSideBarPageObject {

    public AddressPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    WebDriver driver;

}
