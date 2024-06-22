package pageObject.factory;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CustomerPageObject extends BasePage {

    @FindBy(xpath = "//input[@id='FirstName']")
    @CacheLookup
    private WebElement FIRST_NAME_TEXTBOX;

    @FindBy(xpath = "//input[@id='LastName']")
    @CacheLookup
    private WebElement LAST_NAME_TEXTBOX;
    @FindBy(xpath = "//input[@id='Email']")
    @CacheLookup
    private WebElement EMAIL_ADDRESS_TEXTBOX;

    WebDriver driver;

    public CustomerPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String getFirstNameTextBoxAttributeValue() {
        return FIRST_NAME_TEXTBOX.getAttribute("value");
    }

    public String getLastNameTextBoxAttributeValue() {
        return LAST_NAME_TEXTBOX.getAttribute("value");
    }

    public String getEmailAddressTextBoxAttributeValue() {
        return EMAIL_ADDRESS_TEXTBOX.getAttribute("value");

    }
}
