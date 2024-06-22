package pageObject.factory;

import commons.BasePage;
import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegisterPageObject extends BasePageFactory {

    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//input[@id='FirstName']")
    @CacheLookup
    private WebElement FIRSTNAME_TEXTBOX;

    @FindBy(xpath = "//input[@id='LastName']")
    @CacheLookup
    private WebElement LASTNAME_TEXTBOX;
    @FindBy(xpath = "//input[@id='Email']")
    @CacheLookup
    private WebElement EMAIL_TEXTBOX;
    @FindBy(xpath = "//input[@id='Password']")
    @CacheLookup
    private WebElement PASSWORD_TEXTBOX;
    @FindBy(xpath = "//input[@id='ConfirmPassword']")
    @CacheLookup
    private WebElement CONFIRM_PASSWORD_TEXTBOX;
    @FindBy(xpath = "//button[@id='register-button']")
    @CacheLookup
    private WebElement REGISTER_BUTTON;
    @FindBy(xpath = "//span[@id='FirstName-error']")
    @CacheLookup
    private WebElement FIRSTNAME_ERROR_MESSAGE;
    @FindBy(xpath = "//span[@id='LastName-error']")
    @CacheLookup
    private WebElement LASTNAME_ERROR_MESSAGE;
    @FindBy(xpath = "//span[@id='Email-error']")
    @CacheLookup
    private WebElement EMAIL_ERROR_MESSAGE;
    @FindBy(xpath = "//span[@id='Password-error']")
    @CacheLookup
    private WebElement PASSWORD_ERROR_MESSAGE;
    @FindBy(xpath = "//span[@id='ConfirmPassword-error']")
    @CacheLookup
    private WebElement CONFIRM_PASSWORD_ERROR_MESSAGE;
    @FindBy(xpath = "//div[@class='result']")
    @CacheLookup
    private WebElement REGISTRATION_COMPLETED_MESSAGE;
    @FindBy(xpath = "//div[@class='header-logo']//img")
    @CacheLookup
    private WebElement NOP_COMMERCE_LOGO;

    public void clickToElementRegisterButton() {
        clickToElement(driver,REGISTER_BUTTON);
    }

    public String getTextFirstNameErrorMessage() {
        return getTextElement(driver, FIRSTNAME_ERROR_MESSAGE);
    }

    public String getTextLastNameErrorMessage() {
        return getTextElement(driver, LASTNAME_ERROR_MESSAGE);
    }

    public String getTextEmailErrorMessage() {
        return getTextElement(driver, EMAIL_ERROR_MESSAGE);
    }

    public String getTextPasswordErrorMessage() {
        return getTextElement(driver, PASSWORD_ERROR_MESSAGE);
    }

    public String getTextConfirmPasswordErrorMessage() {
        return getTextElement(driver, CONFIRM_PASSWORD_ERROR_MESSAGE);
    }

    public void clickToNopCommerceLogo() {
        clickToElement(driver,NOP_COMMERCE_LOGO);
    }

    public void enterToFirstNameTextBox(String firstName) {
        sendkeyToElement(driver, FIRSTNAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextBox(String lastName) {
        sendkeyToElement(driver, LASTNAME_TEXTBOX, lastName);
    }

    public void enterToEmailTextBox(String emailAddress) {
        sendkeyToElement(driver, EMAIL_TEXTBOX, emailAddress);
    }

    public void enterToPasswordTextBox(String passWord) {
        sendkeyToElement(driver, PASSWORD_TEXTBOX, passWord);
    }

    public void enterToConfirmPasswordTextBox(String confirmPassword) {
        sendkeyToElement(driver, CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
    }

    public String getTextRegistrationCompleted() {
        return getTextElement(driver, REGISTRATION_COMPLETED_MESSAGE);
    }
}
