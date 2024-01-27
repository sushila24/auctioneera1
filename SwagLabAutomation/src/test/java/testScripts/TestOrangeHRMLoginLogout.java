package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;
import webPages.HRMHomePage;
import webPages.HRMLoginPage;

public class TestOrangeHRMLoginLogout extends SeleniumUtility {
WebDriver driver;
HRMLoginPage getHRMLoginPage;
HRMHomePage getHRMHomePage;
@BeforeTest
public void precondition()
{
	driver=setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	getHRMLoginPage=new HRMLoginPage(driver);
	getHRMHomePage=new HRMHomePage(driver);
}

@Test
public void testWithValiddata()
{
	getHRMLoginPage.loginToHRM("Admin", "admin123");
	Assert.assertTrue(isElementExist(getHRMHomePage.getUserProfileIcon()),"login Failed");
}

@Test
public void testWithInvalidData()
{
	getHRMLoginPage.loginToHRM("dummy", "adm3");
	Assert.assertTrue(isElementExist(getHRMLoginPage.getloginBtn()),"login Failed");
}
@AfterTest
public void postCondition()
{
	getHRMHomePage.logoutFromHRM();
	cleanUp();
	
}
}
