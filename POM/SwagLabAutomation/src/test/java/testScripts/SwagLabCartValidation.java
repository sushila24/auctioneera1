package testScripts;

import java.util.Map;

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

public class SwagLabCartValidation extends SeleniumUtility{
	swagLabLoginPage getswagLabLoginPage;
	swagLabHomePage getSwagLabHomePage;
	swagLabCartPage getswagLabCartPage;
	checkoutStepOnePage getcheckoutStepOnePage;
	checkoutStepTwoPage getcheckoutStepTwoPage;
	checkoutCompletePage getcheckoutCompletePage;
	String appUrl=null;
	
	@BeforeTest
	public void precondition()
	{   appUrl=properties.getProperty("appUrl");
		driver=setUp("chrome",appUrl );
		getswagLabLoginPage=new swagLabLoginPage(driver);
		getSwagLabHomePage =new swagLabHomePage(driver);
		getswagLabCartPage =new swagLabCartPage(driver);
		getcheckoutStepOnePage = new checkoutStepOnePage(driver);
		getcheckoutStepTwoPage=new checkoutStepTwoPage(driver);
		getcheckoutCompletePage=new checkoutCompletePage(driver);
		getswagLabLoginPage.LoginSwagLab(properties.getProperty("username"),properties.getProperty("password"));
	}

	@Test(priority=1)
	public void testcart()
	{
		//add product and validate cart
        
		Map<String,String> map1=getSwagLabHomePage.getProductsOnHomePage();
		getSwagLabHomePage.addToCart();
		//Assert -validate product added (price) with the Total price
	
	Map<String,String> map2=getswagLabCartPage.getProductsOnCartPage();
	
	Assert.assertTrue(map1.equals(map2), "Purchasesd Products didn't match with the cart!!!");
	//Assert.assertEquals(map1,map2,"Purchasesd Products didn't match with the cart!!!");
		
	}
	
	@Test(priority=2)
	public void testCheckoutOverview()
	{
		//validate product price in checkout page
		getswagLabCartPage.performCheckout();
		getcheckoutStepOnePage.enterDetailsForCheckout(properties.getProperty("firstname"), properties.getProperty("lastname"),properties.getProperty( "postalCode"));
		getcheckoutStepTwoPage.purchasedHistory();
	}
	
	@Test(priority=3)
	public void testSucessMeg()
	{

		String expMsgAfterSuccessChkout ="Thank you for your order!";
		String actualMsg=getcheckoutCompletePage.getSuccessMsg();
		Assert.assertEquals(actualMsg, expMsgAfterSuccessChkout);
	}
	
	@AfterTest
	public void tearDown()
	{
		getSwagLabHomePage.logoutFromApplication();
		cleanUp();
	}
}
