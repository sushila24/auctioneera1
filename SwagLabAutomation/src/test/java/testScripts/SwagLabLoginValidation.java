package testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;
import webPages.checkoutCompletePage;
import webPages.checkoutStepOnePage;
import webPages.checkoutStepTwoPage;
import webPages.swagLabCartPage;
import webPages.swagLabHomePage;
import webPages.swagLabLoginPage;

public class SwagLabLoginValidation extends SeleniumUtility{
	
	swagLabLoginPage getswagLabLoginPage;
	swagLabHomePage getSwagLabHomePage;
	swagLabCartPage getswagLabCartPage;
	checkoutStepOnePage getcheckoutStepOnePage;
	checkoutStepTwoPage getcheckoutStepTwoPage;
	checkoutCompletePage getcheckoutCompletePage;
	String app_Url=null;
	
	@BeforeMethod
	public void precondition()
	{   
		app_Url=properties.getProperty("appUrl");
		driver=setUp("chrome",app_Url);
		getswagLabLoginPage=new swagLabLoginPage(driver);
		getSwagLabHomePage =new swagLabHomePage(driver);
		
	}
	
	@Test
	public void testLoginLogout()
	{
		getswagLabLoginPage.LoginSwagLab(properties.getProperty("username"),properties.getProperty("password"));
		//getSwagLabHomePage.addToCart();
		getSwagLabHomePage.logoutFromApplication();
		String actUrl=getCurrentUrlOfApplication();
		Assert.assertEquals(actUrl,app_Url,"LoginLogOut Unsuccessful or URL CHANGED!");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		//cleanUp();
	}
	
	

}
