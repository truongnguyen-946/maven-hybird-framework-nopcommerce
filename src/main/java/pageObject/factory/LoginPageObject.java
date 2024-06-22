package pageObject.factory;

import commons.BasePage;
import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPageObject extends BasePageFactory {

    @FindBy(xpath = "//input[@id='Email']")
    @CacheLookup
    private WebElement EMAIL_ADDRESS_TEXTBOX;
    @FindBy(xpath = "//input[@id='Password']")
    @CacheLookup
    private WebElement PASSWORD_TEXTBOX;

    @FindBy(xpath = "//button[contains(@class,'login-button')]")
    @CacheLookup
    private WebElement LOGIN_BUTTON;

    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    public void enterToEmailTextBox(String emailAddress) {
        sendkeyToElement(driver, EMAIL_ADDRESS_TEXTBOX, emailAddress);
    }

    public void enterToPasswordTextBox(String passWord) {
        sendkeyToElement(driver, PASSWORD_TEXTBOX, passWord);
    }

    public void clickToLoginButton() {
        clickToElement(driver, LOGIN_BUTTON);
    }
}
