package com.jquery.upload;

import commons.BaseTest;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;
import pageObjects.jquery.UploadPageObject;
import pageUIs.user.BasePageUI;

public class Level_14_Upload_File extends BaseTest {

    WebDriver driver;
    private UploadPageObject uploadPage;
    private String halongCity = "Ha Long.jpg";
    private String hoianCity = "Hoi An.jpg";
    private String ninhbinhCity = "Ninh Binh.jpg";
    private String japan = "ookunoshima.jpg";


    @Parameters({"browser", "url"})
    @BeforeClass
    public void BeforeClass(String browserName, String url) {
        driver = getBrowserDriverWithUrl(browserName, url);
        uploadPage = PageGeneratorManager.getUploadPageObject(driver);
    }
    
    @Test
    public void TC_01_Upload_Single_File() {
    	uploadPage.getWebElement(driver, BasePageUI.UPLOAD_FILE_TYPE).sendKeys("C:\\Users\\t002404\\Downloads\\LearnAuto\\hybird-framework-nopcommerce\\image\\ookunoshima.jpg");
    	uploadPage.sleepInSecond(2);
    	
    	

    	uploadPage.uploadMultipleFiles(driver, "Ha Long.jpg");
    	uploadPage.sleepInSecond(2);
//    	
//    	uploadPage.uploadMultipleFiles(driver, hoianCity);
//    	uploadPage.sleepInSecond(2);
//
//    	uploadPage.uploadMultipleFiles(driver, ninhbinhCity);
//    	uploadPage.sleepInSecond(2);

    }
    
    @AfterClass
    public void AfterClass() {
        quitBrowser();
    }


}
