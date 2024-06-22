package pageObject.factory;

import commons.BasePage;
import commons.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePageObject extends BasePageFactory {
    
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }
    @FindBy(xpath = "//a[@class='ico-register']")
    @CacheLookup
    private WebElement REGISTER_LINK;
    @FindBy(xpath = "//a[@class='ico-login']")
    @CacheLookup
    private WebElement LOGIN_LINK;
    @FindBy(xpath = "//a[@class='ico-account']")
    @CacheLookup
    private WebElement MY_ACCOUNT_LINK;

    public void clickToRegisterLink() {
        clickToElement(driver, REGISTER_LINK);
    }

    public void clickToLoginLink() {
        clickToElement(driver, LOGIN_LINK);
    }

    public void clickToMyAccountLink() {
        clickToElement(driver, MY_ACCOUNT_LINK);
    }
}
