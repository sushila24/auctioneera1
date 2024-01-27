package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;
import webPages.HRMHomePage;
import webPages.HRMLoginPage;
import webPages.PIMAddEmployeePage;
import webPages.PIMHomePage;
import webPages.PersonalDetailsPage;

public class TestOrangeHrmPim extends SeleniumUtility{

	HRMLoginPage getHRMLoginPage;
    HRMHomePage getHRMHomePage;
    PIMHomePage getPIMHomePage;
    PIMAddEmployeePage getPIMAddEmployeePage;
    PersonalDetailsPage getPersonalDetailsPage;
    
	
	@BeforeMethod
	public void precondition()
	{
		WebDriver driver=setUp("chrome", "https://opensource-demo.orangehrmlive.com/");
		getHRMLoginPage=new HRMLoginPage(driver);
		getHRMHomePage=new HRMHomePage(driver);
		getPIMHomePage=new PIMHomePage(driver);
		getPIMAddEmployeePage=new PIMAddEmployeePage(driver);
		getPersonalDetailsPage=new PersonalDetailsPage(driver);
		getHRMLoginPage.loginToHRM("Admin", "admin123");
		getHRMHomePage.clickOnPIM();
	}
	
	@Test
	public void testPimCreation()
	{
		getPIMHomePage.clickOnAddButton();
		getPIMAddEmployeePage.createEmployee("Soham", "Lead", 12345);
		getHRMHomePage.clickOnPIM();
		getPIMHomePage.searchCreatedEmployee(12345);
		String actualMsg=getPIMHomePage.getSearchResultMsg();
		String expectedMsg="(1) Record Found";
		Assert.assertEquals(actualMsg, expectedMsg);
		
	}
//	@Test(dependsOnMethods="testPimCreation")
//	public void testPimEdit()
//	{
//		
//	}
	@Test(dependsOnMethods="testPimCreation")
	public void testPimDeletion()
	{
		getHRMHomePage.clickOnPIM();
		getPIMHomePage.searchCreatedEmployee(12345);
		getPIMHomePage.searchCreatedEmployee(12345);
		getPIMHomePage.deleteCreatedEmployee();
		String actMsg=getPIMHomePage.getSearchResultMsg();
		String expMsg="No Records Found";
		Assert.assertEquals(actMsg, expMsg);
		
	}
	@AfterMethod
	public void postcondition()
	{
		getHRMHomePage.logoutFromHRM();
		//cleanUp();
		driver.close();
	}
}
