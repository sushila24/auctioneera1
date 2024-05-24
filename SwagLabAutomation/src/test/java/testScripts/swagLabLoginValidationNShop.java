package testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;
import webPages.checkoutCompletePage;
import webPages.checkoutStepOnePage;
import webPages.checkoutStepTwoPage;
import webPages.swagLabCartPage;
import webPages.swagLabHomePage;
import webPages.swagLabLoginPage;

public class swagLabLoginValidationNShop extends SeleniumUtility{
	
	swagLabLoginPage getswagLabLoginPage;
	swagLabHomePage getSwagLabHomePage;
	swagLabCartPage getswagLabCartPage;
	checkoutStepOnePage getcheckoutStepOnePage;
	checkoutStepTwoPage getcheckoutStepTwoPage;
	checkoutCompletePage getcheckoutCompletePage;
	
	@BeforeTest
	public void precondition()
	{
		driver=setUp("chrome", "https://www.saucedemo.com/");
		getswagLabLoginPage=new swagLabLoginPage(driver);
		getSwagLabHomePage =new swagLabHomePage(driver);
		getswagLabCartPage =new swagLabCartPage(driver);
		getcheckoutStepOnePage = new checkoutStepOnePage(driver);
		getcheckoutStepTwoPage=new checkoutStepTwoPage(driver);
		getcheckoutCompletePage=new checkoutCompletePage(driver);
		
	}
	
	@Test(priority=1)
	public void testLoginLogout()
	{
		getswagLabLoginPage.LoginSwagLab("standard_user", "secret_sauce");
		//getSwagLabHomePage.addToCart();
		getSwagLabHomePage.logoutFromApplication();
		String expUrl="https://www.saucedemo.com/";
		String actUrl=getCurrentUrlOfApplication();
		Assert.assertEquals(actUrl,expUrl,"LoginLogOut Unsuccessful or URL CHANGED!");
	}
	
	@Test(priority=2)
	public void testShoppingOnSwagLab()
	{
		getswagLabLoginPage.LoginSwagLab("standard_user", "secret_sauce");
		
		getSwagLabHomePage.addToCart();
		getswagLabCartPage.performCheckout();
		getcheckoutStepOnePage.enterDetailsForCheckout("soham", "khunte", "411022");
		getcheckoutStepTwoPage.purchasedHistory();
		getcheckoutCompletePage.validateThankYouMsg();
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		getSwagLabHomePage.logoutFromApplication();
		cleanUp();
	}
	
	

}
