package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class HRMLoginPage extends SeleniumUtility{
	//initialise all the elements of webpage
	public HRMLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
@FindBy(name="username")
private WebElement usernameInputField;

@FindBy(name="password")
private WebElement passwordInputField;

@FindBy(css=".oxd-button--main.orangehrm-login-button")
private WebElement loginBtn;

public WebElement getusername ()
{
	return usernameInputField;
}
public WebElement getpassword()
{
	return passwordInputField;
}
public WebElement getloginBtn()
{
	return loginBtn;
}

//method to do login
public void loginToHRM(String username,String pass)
{
	
	typeInput(usernameInputField, username);
	typeInput(passwordInputField, pass);
	clickOnElement(loginBtn);
	
	
}
}
