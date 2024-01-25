package webPages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath="//div[@class='inventory_item_name ']")
	//private WebElement addToCartBackPack;     //1st product added to cart-Sauce Labs Backpack
	private List<WebElement> productNameList;
	
	@FindBy(xpath="//div[div[a[div[@class='inventory_item_name ']]]]/div[2]/div")
	//private WebElement addToCartBackPack;     //1st product added to cart-Sauce Labs Backpack
	private List<WebElement> productPriceList;
	
	@FindBy(css="button[id^='add-to-cart']")
	//private WebElement addToCartBackPack;     //1st product added to cart-Sauce Labs Backpack
	private List<WebElement> addToCartButton;

	
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
	
	public WebElement getshoppingCartButton()
	{
		return shoppingCartButton;
	}
	//create () to do operation on HomePage
	public void addToCart()
	{
		//clickOnElement(navigatePannel);
		clickOnElement(addToCartButton.get(0));
		clickOnElement(addToCartButton.get(1));
		clickOnElement(shoppingCartButton);
	}
	public Map<String,String> getProductsOnHomePage()
	{
		//Map<String,String> m1=new HashMap<String,String>();
		Map<String,String> m2=new HashMap<String,String>();
		//items purchased list
		  List<WebElement> itemsList=driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
		//concept of Independant(Item) n dependant child(Item price)
		  List<WebElement> pricesList=driver.findElements(By.xpath("//div[div[a[div[@class='inventory_item_name ']]]]/div[2]/div"));
		  //store product name n price inside the map
		  m2.put(itemsList.get(0).getText(), pricesList.get(0).getText());
		  m2.put(itemsList.get(2).getText(), pricesList.get(2).getText());

		
		return m2;
		
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
