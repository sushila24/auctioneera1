package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class swagLabLoginPage extends SeleniumUtility{
	
	//constructor
	public swagLabLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="user-name")//used to identify required element from webpage
	private WebElement userNameInputField;
	
	@FindBy(name="password")
	private WebElement passwordInputField;
	
	@FindBy(css=".submit-button")//cssSelector syntax for POM
	private WebElement loginButton;
	
	//private data members can be accessed using only getters method
	public WebElement getuserNameInputField()
	{
		return userNameInputField;
	}
	
	public WebElement getpasswordInputField()
	{
		return passwordInputField;
	}
	
	public WebElement getloginButton()
	{
		return loginButton;
	}
	
	//method to do operation on Login page
	public void LoginSwagLab(String username,String password)
	{
		typeInput(userNameInputField, username);
		typeInput(passwordInputField, password);
		clickOnElement(loginButton);
	}
}
/*Identify needed elements
-->usernameInputField
-->passwordInputField
-->loginButton
*/