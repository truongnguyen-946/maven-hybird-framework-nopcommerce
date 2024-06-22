package com.orangehrm.employee;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import pageObjects.orangehrm.AddEmployeePageObject;
import pageObjects.orangehrm.DashboardPageObject;
import pageObjects.orangehrm.EmployeeListPageObject;
import pageObjects.orangehrm.LoginPageObject;
import pageObjects.orangehrm.PageGeneratorManager;
import pageObjects.orangehrm.PersonalDetailsPageObject;
import reportConfig.ExtentTestManager;


public class Level_24_Employee extends BaseTest{
	WebDriver driver;
	public String browserName;
	private LoginPageObject loginPage;
	private DashboardPageObject dashboardPageObject;
	private EmployeeListPageObject employeeListPageObject;
	private AddEmployeePageObject addEmployeePageObject;
	private PersonalDetailsPageObject personalDetailsPageObject;
	private String username, password, employeeID, firstname, lastname;
	private String driverLicense, licenseExpiryDate, nationalityValue, matirialValue, dateOfBirth;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browser, String url) {
		username = "automationfc";
		password = "Can@922946";
		firstname = "Simon";
		lastname = "Week";
		driverLicense = "D151515";
		licenseExpiryDate = "2024-06-10";
		nationalityValue = "Vietnamese";
		matirialValue = "Single";
		dateOfBirth = "2024-06-10";
		
		driver = getBrowserDriverWithUrl(browser, url);
		this.browserName = browser;
		loginPage = PageGeneratorManager.getLoginPageObject(driver);
		loginPage.enterUsernameTextbox(username);
		loginPage.enterPasswordTextbox(password);
		loginPage.clickToLoginButton();
    	dashboardPageObject = PageGeneratorManager.getDashboardPageObject(driver);

		
	}

	@Test
	public void TC_01_Add_Employee(Method method) {
    	ExtentTestManager.startTest(method.getName() + " Run on " + this.browserName.toUpperCase() , "Add Employee");
    	ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: ");

    	employeeListPageObject = dashboardPageObject.clickToPIMMenu();
    	addEmployeePageObject = employeeListPageObject.clickToAddEmployee();
    	
    	addEmployeePageObject.enterFirstNameTextbox(firstname);
    	addEmployeePageObject.enterLastNameTextbox(lastname);
    	employeeID = addEmployeePageObject.getEmployeeID();
    	addEmployeePageObject.clickToSaveButton();
    	addEmployeePageObject.sleepInSecond(3);
    	Assert.assertTrue(addEmployeePageObject.isSuccessMessageDisplayed("Successfully Saved"));
    	addEmployeePageObject.waitToLoaderInvisible();

    	personalDetailsPageObject = PageGeneratorManager.getPersonalDetailsPageObject(driver);
    	Assert.assertTrue(personalDetailsPageObject.waitToLoaderInvisible());
    	
    	Assert.assertEquals(personalDetailsPageObject.getValueFirstNameTextbox(), firstname);
    	Assert.assertEquals(personalDetailsPageObject.getValueLastNameTextbox(), lastname);
    	Assert.assertEquals(personalDetailsPageObject.getValueEmployeeIDTextbox(), employeeID);

    	employeeListPageObject = personalDetailsPageObject.clickToEmployeeList();
    	Assert.assertTrue(personalDetailsPageObject.waitToLoaderInvisible());
    	employeeListPageObject.enterEmployeeIDTextbox(employeeID);
    	employeeListPageObject.clickToSearchButton();
    	
    	Assert.assertTrue(employeeListPageObject.isValueNameByColumnNameDisplayed("Id",employeeID));
    	Assert.assertTrue(employeeListPageObject.isValueNameByColumnNameDisplayed("First (& Middle) Name",firstname));
    	Assert.assertTrue(employeeListPageObject.isValueNameByColumnNameDisplayed("Last Name",lastname));

    	employeeListPageObject.clickToActionByColumnName("Actions");

	}
	
	@Test
	public void TC_02_Personal_Details(Method method) {
    	ExtentTestManager.startTest(method.getName() + " Run on " + this.browserName.toUpperCase() , "Personal Details");
    	personalDetailsPageObject = PageGeneratorManager.getPersonalDetailsPageObject(driver);
    	personalDetailsPageObject.waitToLoaderInvisible();

    	personalDetailsPageObject.enterDriversLicenseNumberTextbox(driverLicense);
    	personalDetailsPageObject.enterLicenseExpiryDatePicker(licenseExpiryDate);
    	personalDetailsPageObject.selectNationalityDropDown(nationalityValue);
    	personalDetailsPageObject.selectMaritalStatusDropDown(matirialValue);
    	personalDetailsPageObject.enterDateOfBirthPicker(dateOfBirth);
    	personalDetailsPageObject.selectGenderRadioButton("Male");
    	personalDetailsPageObject.clickToSaveButton();
    	personalDetailsPageObject.sleepInSecond(3);
    	Assert.assertTrue(addEmployeePageObject.isSuccessMessageDisplayed("Successfully Updated"));
    	personalDetailsPageObject.waitToLoaderInvisible();

//    	Assert.assertEquals(personalDetailsPageObject.getAttributeValueDriversLicenseNumber(), "");
//    	Assert.assertEquals(personalDetailsPageObject.getAttributeValueLicenseExpiryDatePicker(), "");
//    	Assert.assertEquals(personalDetailsPageObject.getValueSelectedNationalityDropDown(), "");
//    	Assert.assertEquals(personalDetailsPageObject.getValueSelectedMaritalStatusDropDown(), "");
//    	Assert.assertEquals(personalDetailsPageObject.getAttributeValueDateOfBirthPicker(), "");
//    	Assert.assertTrue(personalDetailsPageObject.isSelectedGenderRadioButton());

    	
	}
	
	@Test
	public void TC_03_Contact_Details(Method method) {
    	ExtentTestManager.startTest(method.getName() + " Run on " + this.browserName.toUpperCase() , "Contact Details");

	}
	
	@Test
	public void TC_04_Emergency_Contacts(Method method) {
    	ExtentTestManager.startTest(method.getName() + " Run on " + this.browserName.toUpperCase() , "Emergency Contacts");

	}
	
	@Test
	public void TC_05_Dependents(Method method) {
    	ExtentTestManager.startTest(method.getName() + " Run on " + this.browserName.toUpperCase() , "Dependents");

	}
	
	@Test
	public void TC_06_Immigration(Method method) {
    	ExtentTestManager.startTest(method.getName() + " Run on " + this.browserName.toUpperCase() , "Immigration");

	}
	
	@Test
	public void TC_07_Job(Method method) {
    	ExtentTestManager.startTest(method.getName() + " Run on " + this.browserName.toUpperCase() , "Job");

	}
	
	@Test
	public void TC_08_Salary(Method method) {
    	ExtentTestManager.startTest(method.getName() + " Run on " + this.browserName.toUpperCase() , "Salary");

	}
	
	@Test
	public void TC_09_Report_to(Method method) {
    	ExtentTestManager.startTest(method.getName() + " Run on " + this.browserName.toUpperCase() , "Report_to");

	}
	
	@AfterClass
	public void afterClass() {
		quitBrowser();
	}
}
