package com.nopcommerce.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class Level_01_Register {

    WebDriver driver;

    @BeforeClass
    public void BeforeClass() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.gecko.driver", path + "\\browserDrivers\\geckodriver.exe");

        driver = new FirefoxDriver();
    }

    @Test
    public void Register_01_Empty_Data() {
        driver.get("https://demo.nopcommerce.com/");

        driver.findElement(By.cssSelector("a.ico-register")).click();

        driver.findElement(By.cssSelector("button#register-button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getText(), "First name is required.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#LastName-error")).getText(), "Last name is required.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Email is required.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "Password is required.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "Password is required.");


    }

    @Test
    public void Register_02_Invalid_Email() {
        driver.get("https://demo.nopcommerce.com/");

        driver.findElement(By.cssSelector("a.ico-register")).click();

        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Automation");
        driver.findElement(By.cssSelector("input#LastName")).sendKeys("FC");
        driver.findElement(By.cssSelector("input#Email")).sendKeys("abcdef@abcde@abc");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");

        Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Wrong email");


    }

    @Test
    public void Register_03_Invalid_Password() {
        driver.get("https://demo.nopcommerce.com/");

        driver.findElement(By.cssSelector("a.ico-register")).click();

        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Automation");
        driver.findElement(By.cssSelector("input#LastName")).sendKeys("FC");
        driver.findElement(By.cssSelector("input#Email")).sendKeys("automation" + getRandom() + "@gmail.com");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("123");
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");

        Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "Password must meet the following rules:\nmust have at least 6 characters");

    }

    @Test
    public void Register_04_Incorrect_Confirm_Password() {
        driver.get("https://demo.nopcommerce.com/");

        driver.findElement(By.cssSelector("a.ico-register")).click();

        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Automation");
        driver.findElement(By.cssSelector("input#LastName")).sendKeys("FC");
        driver.findElement(By.cssSelector("input#Email")).sendKeys("automation" + getRandom() + "@gmail.com");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("12345678");

        driver.findElement(By.cssSelector("button#register-button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "The password and confirmation password do not match.");


    }

    @Test
    public void Register_05_Success() {
        driver.get("https://demo.nopcommerce.com/");

        driver.findElement(By.cssSelector("a.ico-register")).click();

        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Automation");
        driver.findElement(By.cssSelector("input#LastName")).sendKeys("FC");
        driver.findElement(By.cssSelector("input#Email")).sendKeys("automation" + getRandom() + "@gmail.com");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
        driver.findElement(By.cssSelector("button#register-button")).click();


        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");

    }

    public long getRandom() {
        Random rand = new Random();
        return rand.nextInt(9999);
    }

    @AfterClass
    public void AfterClass() {
        driver.quit();
    }


}
