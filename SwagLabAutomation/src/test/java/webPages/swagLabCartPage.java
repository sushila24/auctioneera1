package webPages;

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
	public void performCheckout()
	{
		clickOnElement(checkoutButton);
	}
}
/**Elements needed on Home page
 * checkoutButton
 */