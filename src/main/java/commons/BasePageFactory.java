package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePageFactory {
    protected void openPageUrl(WebDriver driver, String urlPage) {
        driver.get(urlPage);
    }

    protected String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    protected String getCurrentPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    protected String getPageResource(WebDriver driver) {
        return driver.getPageSource();
    }

    protected void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    protected void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    protected void refreshPageCurrent(WebDriver driver) {
        driver.navigate().refresh();
    }


    protected void clickToElement(WebDriver driver, WebElement element) {
        element.click();
    }

    protected String getTextElement(WebDriver driver, WebElement element) {
        return element.getText();
    }


    protected void sendkeyToElement(WebDriver driver, WebElement element, String valueToSend) {
       element.sendKeys(valueToSend);
    }
    protected String getAttributeValue(WebDriver driver, WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }
}
