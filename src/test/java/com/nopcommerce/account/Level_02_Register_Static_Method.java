package com.nopcommerce.account;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_02_Register_Static_Method {

    private WebDriver driver;

    private BasePage basePage = BasePage.getBasePage();

    @BeforeClass
    public void BeforeClass() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.gecko.driver", path + "\\browserDrivers\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
       // basePage = new BasePage();
    }

    @Test
    public void Register_01_Empty_Data() {

        basePage.openPageUrl(driver,"https://demo.nopcommerce.com/");

        basePage.clickToElement(driver,"//a[@class='ico-register']");

        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getTextElement(driver, "//span[@id='FirstName-error']"),"First name is required.");
        Assert.assertEquals(basePage.getTextElement(driver, "//span[@id='LastName-error']"),"Last name is required.");
        Assert.assertEquals(basePage.getTextElement(driver, "//span[@id='Email-error']"),"Email is required.");
        Assert.assertEquals(basePage.getTextElement(driver, "//span[@id='Password-error']"),"Password is required.");
        Assert.assertEquals(basePage.getTextElement(driver, "//span[@id='ConfirmPassword-error']"),"Password is required.");

    }

    @Test
    public void Register_02_Invalid_Email() {
        basePage.openPageUrl(driver,"https://demo.nopcommerce.com/");

        basePage.clickToElement(driver,"//a[@class='ico-register']");

        basePage.sendkeyToElement(driver,"//input[@id='FirstName']","Automation");
        basePage.sendkeyToElement(driver,"//input[@id='LastName']","FC");
        basePage.sendkeyToElement(driver,"//input[@id='Email']","abcdef@abcde@abc");
        basePage.sendkeyToElement(driver,"//input[@id='Password']","123456");
        basePage.sendkeyToElement(driver,"//input[@id='ConfirmPassword']","123456");

        Assert.assertEquals(basePage.getTextElement(driver, "//span[@id='Email-error']"),"Wrong email");

    }

    @Test
    public void Register_03_Invalid_Password() {
        basePage.openPageUrl(driver,"https://demo.nopcommerce.com/");

        basePage.clickToElement(driver,"//a[@class='ico-register']");

        basePage.sendkeyToElement(driver,"//input[@id='FirstName']","Automation");
        basePage.sendkeyToElement(driver,"//input[@id='LastName']","FC");
        basePage.sendkeyToElement(driver,"//input[@id='Email']",getRandomEmail());
        basePage.sendkeyToElement(driver,"//input[@id='Password']","123");
        basePage.sendkeyToElement(driver,"//input[@id='ConfirmPassword']","123456");

        Assert.assertEquals(basePage.getTextElement(driver, "//span[@id='Password-error']"),"Password must meet the following rules:\nmust have at least 6 characters");

    }

    @Test
    public void Register_04_Incorrect_Confirm_Password() {
        basePage.openPageUrl(driver,"https://demo.nopcommerce.com/");

        basePage.clickToElement(driver,"//a[@class='ico-register']");

        basePage.sendkeyToElement(driver,"//input[@id='FirstName']","Automation");
        basePage.sendkeyToElement(driver,"//input[@id='LastName']","FC");
        basePage.sendkeyToElement(driver,"//input[@id='Email']",getRandomEmail());
        basePage.sendkeyToElement(driver,"//input[@id='Password']","12356");
        basePage.sendkeyToElement(driver,"//input[@id='ConfirmPassword']","12345678");


        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getTextElement(driver, "//span[@id='ConfirmPassword-error']"),"The password and confirmation password do not match.");

    }

    @Test
    public void Register_05_Success() {
        basePage.openPageUrl(driver,"https://demo.nopcommerce.com/");

        basePage.clickToElement(driver,"//a[@class='ico-register']");

        basePage.sendkeyToElement(driver,"//input[@id='FirstName']","Automation");
        basePage.sendkeyToElement(driver,"//input[@id='LastName']","FC");
        basePage.sendkeyToElement(driver,"//input[@id='Email']",getRandomEmail());
        basePage.sendkeyToElement(driver,"//input[@id='Password']","123456");
        basePage.sendkeyToElement(driver,"//input[@id='ConfirmPassword']","123456");

        basePage.clickToElement(driver, "//button[@id='register-button']");

        Assert.assertEquals(basePage.getTextElement(driver, "//div[@class='result']"),"Your registration completed");

    }

    public String getRandomEmail() {
        Random rand = new Random();
        return  "automation" + rand.nextInt(9999) + "@gmail.com";
    }

    @AfterClass
    public void AfterClass() {
        driver.quit();
    }


}
