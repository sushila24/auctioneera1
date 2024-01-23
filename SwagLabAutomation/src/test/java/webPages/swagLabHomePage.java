package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class swagLabHomePage extends SeleniumUtility{
	//constructor
	public swagLabHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="react-burger-menu-btn")
	private WebElement navigatePannel;
	
	@FindBy(id="logout_sidebar_link")  //@FindBy(linkText="Logout")
	private WebElement logoutButton;
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	private WebElement addToCartBackPack;     //1st product added to cart-Sauce Labs Backpack
	
	@FindBy(id="add-to-cart-sauce-labs-bike-light")
	private WebElement addToCartBikeLight;    //2nd product added to cart-Sauce Labs Bike Light
	
	@FindBy(id="shopping_cart_container")
	private WebElement shoppingCartButton;
	
	//create getters() for all private WEbElements
	public WebElement getnavigatePannel()
	{
		return navigatePannel;
	}
	
	public WebElement getlogoutButton()
	{
		return logoutButton;
	}
	public WebElement getaddToCartBackPack()
	{
		return addToCartBackPack;
	}
	
	public WebElement getaddToCartBikeLight()
	{
		return addToCartBikeLight;
	}
	public WebElement getshoppingCartButton()
	{
		return shoppingCartButton;
	}
	//create () to do operation on HomePage
	public void addToCart()
	{
		//clickOnElement(navigatePannel);
		clickOnElement(addToCartBackPack);
		clickOnElement(addToCartBikeLight);
		clickOnElement(shoppingCartButton);
	}
	
	public void logoutFromApplication()
	{
		clickOnElement(navigatePannel);
		clickOnElement(logoutButton);
	}
}
/**Elements needed on Home page
 * navigationPanel
 * AddToCart(forProduct1)
 * AddToCartButton(forProduct2)
 * CartButton
 * 
 * logoutButton
 */
