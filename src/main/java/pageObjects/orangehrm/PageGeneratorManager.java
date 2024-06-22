package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class PageGeneratorManager extends BasePage{
		
	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static DashboardPageObject getDashboardPageObject(WebDriver driver) {
		return new DashboardPageObject(driver);
	}
	
	public static EmployeeListPageObject getEmployeeListPageObject(WebDriver driver) {
		return new EmployeeListPageObject(driver);
	}
	
	public static AddEmployeePageObject getAddEmployeePageObject(WebDriver driver) {
		return new AddEmployeePageObject(driver);
	}
	
	public static PersonalDetailsPageObject getPersonalDetailsPageObject(WebDriver driver) {
		return new PersonalDetailsPageObject(driver);
	}
	
	public static ContactDetailsPageObject getContactDetailsPageObject(WebDriver driver) {
		return new ContactDetailsPageObject(driver);
	}
	
	public static EmergencyContactsPageObject getEmergencyContactsPageObject(WebDriver driver) {
		return new EmergencyContactsPageObject(driver);
	}
	
	public static ImmigrationPageObject getImmigrationPageObject(WebDriver driver) {
		return new ImmigrationPageObject(driver);
	}
	
	public static JobPageObject getJobPageObject(WebDriver driver) {
		return new JobPageObject(driver);
	}
	
	public static SalaryPageObject getSalaryPageObject(WebDriver driver) {
		return new SalaryPageObject(driver);
	}
	
	public static DepentdentsPageObject getDepentdentsPageObject(WebDriver driver) {
		return new DepentdentsPageObject(driver);
	}
	
	public static ReportToPageObject getReportToPageObject(WebDriver driver) {
		return new ReportToPageObject(driver);
	}

}
