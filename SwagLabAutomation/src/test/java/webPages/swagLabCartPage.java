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

public class swagLabCartPage extends SeleniumUtility{
	
	public swagLabCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//button[@name='checkout']")
	private WebElement checkoutButton;
	
	public WebElement getcheckoutButton()
	{
		return checkoutButton;
	}
	//() to do operation on page
	
	public Map<String,String> getProductsOnCartPage()
	{
		Map<String,String> m3=new HashMap<String,String>();
		//items purchased list
		  List<WebElement> items=driver.findElements(By.cssSelector(".inventory_item_name"));
		//concept of Independant(Item) n dependant child(Item price)
		  List<WebElement> prices=driver.findElements(By.xpath("//div[a[div[@class='inventory_item_name']]]/div[2]/div"));
		  //store product name n price inside the map
		  
		  for(int i=0;i<items.size();i++)
		  {
			  m3.put(items.get(i).getText(), prices.get(i).getText());
		  }
//		  System.out.println("map elements"+m2);
//		  for(Entry pair:m2.entrySet())
//		  {
//			  System.out.println(pair.getKey()+":"+pair.getValue());
//		  }
		
		return m3;
		
	}
	
	public void performCheckout()
	{
		clickOnElement(checkoutButton);
	}
}
/**Elements needed on Home page
 * checkoutButton
 */